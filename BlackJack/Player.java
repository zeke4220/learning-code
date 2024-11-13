import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<List<Card>> hands = new ArrayList<>();
    private double balance;
    private double bet;

    public Player(double balance) {
        this.balance = balance;
        clearHands(); // Start with a clear set of hands
    }

    public void addCard(Card card) {
        if (!hands.isEmpty()) {
            hands.get(0).add(card); // Typically, we add to the first hand
        }
    }

    public void placeBet(double amount) {
        if (amount <= balance) {
            bet = amount;
            balance -= amount;
        }
    }

    public void payout(double multiplier) {
        balance += bet * multiplier;
        bet = 0;
    }

    public boolean doubleBet() {
    if (balance >= bet) { // Check if the player has enough balance to double the bet
        balance -= bet; // Deduct the additional bet amount
        bet *= 2; // Double the bet
        return true; // Return true indicating the bet was successfully doubled
    }
    return false; // Return false if the player does not have enough balance
	}


    public void clearHands() {
        hands.clear();
        hands.add(new ArrayList<>());
    }

    public List<List<Card>> getHands() {
        return hands;
    }

    public double getBalance() {
        return balance;
    }

    public double getLastBet() {
        return bet;
    }

	public void addToBalance(double amount) {
		balance += amount;
	}

	public void subtractFromBalance(double amount) {
		balance -= amount;
	}


    public int getHandTotal() {
        int total = 0;
        boolean hasAce = false;
        for (Card card : hands.get(0)) {
            int value = card.getValue();
            if (value >= 10) { // Face cards
                total += 10;
            } else if (value == 0) { // Ace
                total += (total + 11 > 21) ? 1 : 11;
            } else {
                total += value + 1;
            }
        }
        return total;
    }

    public String getHand() {
        StringBuilder sb = new StringBuilder();
        for (List<Card> hand : hands) {
            for (Card card : hand) {
                sb.append(card).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
