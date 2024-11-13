public class Card {
    private String suit;
    private int value; // 0 = Ace, 1-9 = Numbers 2-10, 10 = Jack, 11 = Queen, 12 = King

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String[] faceNames = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return faceNames[value] + " of " + suit;
    }
}
