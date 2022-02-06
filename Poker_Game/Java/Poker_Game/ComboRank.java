package Poker_Game;

public class ComboRank {

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

        public int handvalue;

        Rank (int handvalue){
            this.handvalue = handvalue;
        }

        public int getHandvalue() {
            return handvalue;
        }
    }
    int highcard;
    int rankMax;
    int[] counts = {0, 0, 0, 0};
    int[] nums = {0, 0, 0, 0};
    int ci = 0;
    int rank;

    ComboRank(int[] N1, char[] S1) {

        IsRoyalFlush(S1, N1);
        if (rank == 0) {
            HasRepetition(N1);
            Is4Kind();
            if (rank == 0) {
                IsFullHouse();
                if (rank == 0) {
                    Is3Kind();
                    if (rank == 0) {
                        Is2Pair();
                        if (rank == 0) {
                            IsPair();
                            if (rank == 0) {
                                IsHighCard(N1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void IsHighCard(int[] N1) {
        highcard = N1[4];
        Rank myrank = Rank.HIGHCARD;
        rank = myrank.getHandvalue();
    }

    public void HasRepetition(int[] N1) {
        for (int i = 0; i < 4; i++) {
            if (N1[i + 1] - N1[i] == 0) {
                counts[ci]++;
                nums[ci] = N1[i];
            } else {
                ci++;
            }
        }
    }

    public void Is4Kind() {
        for (int i = 0; i < 2; i++) {
            if (counts[i] == 3) {
                Rank myrank = Rank.FOURKIND;
                rank = myrank.getHandvalue();
                rankMax = nums[i];
            }
        }
    }

    public void IsFullHouse() {
        int sumOfcounts = 0;
        for (int i = 0; i < 2; i++) {
            sumOfcounts += counts[i];
        }
        if (sumOfcounts == 3) {
            Rank myrank = Rank.FULLHOUSE;
            rank = myrank.getHandvalue();
            if (counts[0] == 2) {
                rankMax = nums[0];
            } else rankMax = nums[1];
        }
    }

    public void Is3Kind() {
        for (int i = 0; i < 3; i++) {
            if (counts[i] == 2) {
                Rank myrank = Rank.THREEKIND;
                rank = myrank.getHandvalue();
                rankMax = nums[i];
            }
        }
    }

    public void Is2Pair() {
        int sumOfcounts = 0;
        for (int i = 0; i < 3; i++) {
            sumOfcounts += counts[i];
        }
        if (sumOfcounts == 2) {
            Rank myrank = Rank.TWOPAIR;
            rank = myrank.getHandvalue();
            if (nums[1] > nums[0]) {
                rankMax = nums[1];
            } else if (nums[2] > nums[0] || nums[2] > nums[1]) {
                rankMax = nums[2];
            }
        }
    }

    public void IsPair() {
        for (int i = 0; i < 4; i++) {
            if (counts[i] == 1) {
                Rank myrank = Rank.PAIR;
                rank = myrank.getHandvalue();
                rankMax = nums[i];
            }
        }
    }

    public void IsStraight(int[] N1) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (N1[i + 1] - N1[i] != 1) {
                count++;
            }
        }
        if (count == 0) {
            Rank myrank = Rank.STRAIGHT;
            rank = myrank.getHandvalue();
        }
    }

    public void IsFlush(char[] S1) {
        int count = 0;
        for (int i = 1; i < 5; i++) {
            if (S1[0] == S1[i]) {
                count++;
            }
        }
        if (count == 4) {
            Rank myRank = Rank.FLUSH;
            rank = myRank.getHandvalue();
        }
    }

    public void IsRoyalFlush(char[] S1, int[] N1) {
        IsFlush(S1);
        if (rank == 6) {
            IsStraight(N1);
            if (rank == 5) {
                if (N1[0] == 10 && N1[1] == 11 && N1[2] == 12 && N1[3] == 13 && N1[4] == 14) {
                    Rank myrank = Rank.ROYALFLUSH;
                    rank = myrank.getHandvalue();
                } else {
                    Rank myrank = Rank.STRAIGHTFLUSH;
                    rank = myrank.getHandvalue();
                }
            } else {
                Rank myrank = Rank.FLUSH;
                rank = myrank.getHandvalue();
            }
        }
    }
}