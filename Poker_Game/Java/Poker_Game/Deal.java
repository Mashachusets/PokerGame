package Poker_Game;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Deal {
    public String[] P1 = new String[5];
    public String[] P2 = new String[5];
    public String[] line = new String[10];

    Deal(String name) throws IOException {

        Scanner sc = new Scanner(new FileReader(name)).useDelimiter("/n");

        String str;

        while (sc.hasNext()) {
            str = sc.nextLine();
            String line []= str.split(" ");

            String[] P1 = Arrays.copyOfRange(line, 0, 5);
            String[] P2 = Arrays.copyOfRange(line, 5, 10);

            deal(P1,P2);

            Split splitP1 = new Split(P1);
            ComboRank check1 = new ComboRank(splitP1.Number1, splitP1.Symbol1);
            Split splitP2 = new Split(P2);
            ComboRank check2 = new ComboRank(splitP2.Number1, splitP2.Symbol1);
            Compare winner = new Compare(check1.rank , check2.rank);
            if(winner == null){
                switch(check1.rank) {
                    case 1: case 5: case 6: case 9:
                        winner.compareHighCards(check1.highcard, check2.highcard);
                        break;
                    case 2: case 3: case 4 : case 7: case 8:
                        winner.compareHighCards(check1.rankMax, check2.rankMax);
                        if(winner == null) winner.compareHighCards(check1.highcard, check2.highcard);
                        break;
                }
            }
        }

    }
    public void deal (String[] P1, String[] P2) {
        this.P1 = P1;
        this.P2 = P2;
    }
}