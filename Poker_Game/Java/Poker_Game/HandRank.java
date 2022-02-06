package Poker_Game;

public class HandRank {
    public int HighCard = 0;
    public int RankMax = 0;
    public int RankValue = 0;

    private int[] Counts = { 0, 0, 0, 0 };
    private int[] Nums = { 0, 0, 0, 0 };
    private int CardNumberRepetition = 0;

    public HandRank(int[] n1, char[] s1) {
        IsRoyalFlush(s1, n1);

        if (RankValue == 0) {
            IsStraight(n1);

            if (RankValue == 0) {
                HasRepetition(n1);
                Is4Kind();

                if (RankValue == 0) {
                    IsFullHouse();

                    if (RankValue == 0) {
                        Is3Kind();

                        if (RankValue == 0) {
                            Is2Pair();

                            if (RankValue == 0) {
                                IsPair();

                                if (RankValue == 0) {
                                    IsHighCard(n1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void IsHighCard(int[] n1) {
        HighCard = n1[4];

        Rank rank = Rank.HIGHCARD;
        RankValue = rank.GetHandValue();
    }

    public void HasRepetition(int[] n1) {
        for (int i = 0; i < 4; i++) {
            if (n1[i + 1] - n1[i] == 0) {
                Counts[CardNumberRepetition]++;
                Nums[CardNumberRepetition] = n1[i];
            } else {
                CardNumberRepetition++;
            }
        }
    }

    public void Is4Kind() {
        for (int i = 0; i < 2; i++) {
            if (Counts[i] == 3) {
                Rank rank = Rank.FOURKIND;
                RankValue = rank.GetHandValue();

                RankMax = Nums[i];
            }
        }
    }

    public void IsFullHouse() {
        int sumOfCounts = 0;

        for (int i = 0; i < 2; i++) {
            sumOfCounts += Counts[i];
        }

        if (sumOfCounts == 3) {
            Rank rank = Rank.FULLHOUSE;
            RankValue = rank.GetHandValue();

            if (Counts[0] == 2) {
                RankMax = Nums[0];
            }
            else {
                RankMax = Nums[1];
            }
        }
    }

    public void Is3Kind() {
        for (int i = 0; i < 3; i++) {
            if (Counts[i] == 2) {
                Rank rank = Rank.THREEKIND;
                RankValue = rank.GetHandValue();

                RankMax = Nums[i];
            }
        }
    }

    public void Is2Pair() {
        int sumOfCounts = 0;

        for (int i = 0; i < 3; i++) {
            sumOfCounts += Counts[i];
        }

        if (sumOfCounts == 2) {
            Rank rank = Rank.TWOPAIR;
            RankValue = rank.GetHandValue();

            if (Nums[1] > Nums[0]) {
                RankMax = Nums[1];
            }
            else if (Nums[2] > Nums[0] || Nums[2] > Nums[1]) {
                RankMax = Nums[2];
            }
        }
    }

    public void IsPair() {
        for (int i = 0; i < 4; i++) {
            if (Counts[i] == 1) {
                Rank rank = Rank.PAIR;
                RankValue = rank.GetHandValue();

                RankMax = Nums[i];
            }
        }
    }

    public void IsStraight(int[] n1) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (n1[i + 1] - n1[i] != 1) {
                count++;
            }
        }

        if (count == 0) {
            Rank rank = Rank.STRAIGHT;
            RankValue = rank.GetHandValue();
        }
    }

    public void IsFlush(char[] s1) {
        int count = 0;

        for (int i = 1; i < 5; i++) {
            if (s1[0] == s1[i]) {
                count++;
            }
        }

        if (count == 4) {
            Rank rank = Rank.FLUSH;
            RankValue = rank.GetHandValue();
        }
    }

    public void IsRoyalFlush(char[] s1, int[] n1) {
        IsFlush(s1);

        if (RankValue == 6) {
            IsStraight(n1);

            if (RankValue == 5) {
                if (n1[0] == 10 && n1[1] == 11 && n1[2] == 12 && n1[3] == 13 && n1[4] == 14) {
                    Rank rank = Rank.ROYALFLUSH;
                    RankValue = rank.GetHandValue();
                } else {
                    Rank rank = Rank.STRAIGHTFLUSH;
                    RankValue = rank.GetHandValue();
                }
            } else {
                Rank rank = Rank.FLUSH;
                RankValue = rank.GetHandValue();
            }
        }
    }
}