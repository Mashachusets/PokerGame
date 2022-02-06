package Poker_Game;

public class Compare {

    int P1wins;

    Compare(int h1, int h2){
        Compare(h1,h2);
    }

    public void Compare(int h1, int h2){
        if (h1 > h2){
            P1wins++;
            System.out.println("Player 1 won " + P1wins + " matches.");
        }
        if (h1 < h2){
            System.out.println("Player 1 won " + P1wins + " matches.");
        }

    }
    public void compareHighCards(int hc1, int hc2){
        if(hc1>hc2) P1wins++;
    }
}