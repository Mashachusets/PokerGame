package Poker_Game;

public class Compare {
    public boolean HasPlayer1Won(HandRank h1, HandRank h2) {
        boolean toReturn = false;

        if (h1.RankValue > h2.RankValue) {
            toReturn = true;
        }
        else {
            if (h1.RankValue == h2.RankValue) {
                switch (h1.RankValue) {
                    case 1:
                    case 5:
                    case 6:
                    case 9:
                        toReturn = CompareHighCards(h1.HighCard, h2.HighCard);

                        break;
                    default:
                        toReturn = CompareHighCards(h1.RankMax, h2.RankMax);

                        if (!toReturn) {
                            toReturn = CompareHighCards(h1.HighCard, h2.HighCard);
                        }

                        break;
                }
            }
        }

        return toReturn;
    }

    public boolean CompareHighCards(int value1, int value2) {
        return value1 > value2;
    }
}