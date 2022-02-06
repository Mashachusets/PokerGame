package Poker_Game;

public enum Rank {
    HIGHCARD(1),
    PAIR(2),
    TWOPAIR(3),
    THREEKIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULLHOUSE(7),
    FOURKIND(8),
    STRAIGHTFLUSH(9),
    ROYALFLUSH(10);

    private int handValue;

    Rank(int handValue) {
        this.handValue = handValue;
    }

    public int GetHandValue() {
        return handValue;
    }
}
