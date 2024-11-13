import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Player> players = new ArrayList<>();
    private static Dealer dealer = new Dealer();
    private static Deck deck = new Deck();

    public static void main(String[] args) {
        System.out.print("Enter the number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter initial balance for player " + (i + 1) + ": ");
            double balance = Double.parseDouble(scanner.nextLine());
            players.add(new Player(balance));
        }

        while (true) {
            deck = new Deck(); // New shuffled deck each round
            collectBets(); // Collect bets before dealing cards
            for (Player player : players) {
                player.clearHands();
                player.addCard(deck.drawCard());
                player.addCard(deck.drawCard());
            }
            dealer.clearHands();
            dealer.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());

            // Player turns
            for (Player player : players) {
                System.out.println("Player " + (players.indexOf(player) + 1) + "'s turn:");
                playerTurn(player);
            }

            // Dealer turn
            System.out.println("Dealer's turn:");
            dealerTurn();

            // Determine winners
            determineWinners();

            // Ask if players want to continue
            System.out.print("Play another round? (y/n): ");
            if ("n".equals(scanner.nextLine())) {
                break;
            }
        }
        scanner.close();
    }

    private static void playerTurn(Player player) {
    boolean turnActive = true;
    while (turnActive) {
        System.out.println(player.getHand() + " Total: " + player.getHandTotal());
        System.out.print("Choose action: Hit (h), Stand (s), Double Down (d): ");
        String action = scanner.nextLine();
        if (action.equalsIgnoreCase("h")) {
            Card newCard = deck.drawCard();
            player.addCard(newCard);
            System.out.println("Hit: " + newCard + ", New Total: " + player.getHandTotal());
            if (player.getHandTotal() > 21) {
                System.out.println("Bust!");
                turnActive = false;
            }
        } else if (action.equalsIgnoreCase("d") && player.getHands().get(0).size() == 2) {
            if (player.doubleBet()) {
                Card newCard = deck.drawCard();
                player.addCard(newCard);
                System.out.println("Double Down: " + newCard + ", New Total: " + player.getHandTotal());
                turnActive = false;
            } else {
                System.out.println("Not enough balance to double down.");
            }
        } else {
            System.out.println("Stands.");
            turnActive = false;
        }
    }
}


    private static void dealerTurn() {
    // Initially display the dealer's hand before any actions are taken
    System.out.println("Dealer's initial hand: " + dealer.getHand() + " Total: " + dealer.getHandTotal());
    
    // Dealer makes decisions based on their hand total
    while (dealer.shouldHit()) {
        Card newCard = deck.drawCard(); // Dealer draws a card
        dealer.addCard(newCard); // Add the new card to the dealer's hand
        // Display the new card and updated hand total after each draw
        System.out.println("Dealer hits: " + newCard);
        System.out.println("Dealer's updated hand: " + dealer.getHand() + " Total: " + dealer.getHandTotal());
        
        // Check if the dealer busts
        if (dealer.getHandTotal() > 21) {
            System.out.println("Dealer busts!");
            break;
        }
    }
    // Final display of the dealer's hand at the end of their turn
    System.out.println("Dealer's final hand: " + dealer.getHand() + " Total: " + dealer.getHandTotal());
}


    private static void determineWinners() {
    int dealerTotal = dealer.getHandTotal();


    for (Player player : players) {
        int playerTotal = player.getHandTotal();
        double playerBet = player.getLastBet();
        double outcome;

        if (playerTotal > 21) {
            System.out.printf("Player %d busts and loses $%.2f.\n", players.indexOf(player) + 1, playerBet);
            outcome = 0;  // Player loses the bet, which is already deducted
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            player.payout(2);
            outcome = playerBet;  // Player gains their bet back plus equivalent amount
            System.out.printf("Player %d wins and gains $%.2f.\n", players.indexOf(player) + 1, playerBet);
        } else if (playerTotal == dealerTotal) {
            player.payout(1);
            outcome = 0;  // No win or loss, just a push
            System.out.printf("Player %d ties and pushes. No money won or lost.\n", players.indexOf(player) + 1);
        } else {
            System.out.printf("Player %d loses and forfeits $%.2f.\n", players.indexOf(player) + 1, playerBet);
            outcome = 0;  // No additional deduction as the bet is already deducted
        }

        // Correctly display the updated balance
        System.out.printf("Player %d new balance: $%.2f.\n", players.indexOf(player) + 1, player.getBalance());
    }
}



    private static void collectBets() {
        for (Player player : players) {
            System.out.printf("Player %d, your current balance is $%.2f.\n", players.indexOf(player) + 1, player.getBalance());
            System.out.print("Enter your bet: ");
            double bet = Double.parseDouble(scanner.nextLine());
            while (bet > player.getBalance() || bet <= 0) {
                System.out.println("Invalid bet amount. Please enter a valid bet.");
                bet = Double.parseDouble(scanner.nextLine());
            }
            player.placeBet(bet);
        }
    }
}
