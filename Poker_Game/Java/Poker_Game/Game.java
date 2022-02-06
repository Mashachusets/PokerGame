package Poker_Game;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {
    private Scanner Sc;

    public Game(String name) throws IOException {
        Sc = new Scanner(new FileReader(name)).useDelimiter("/n");
    }

    public int PlayGame() {
        Compare compare = new Compare();

        int winCount = 0;

        while (Sc.hasNext()) {
            String str = Sc.nextLine();
            String[] line = str.split(" ");

            String[] P1 = Arrays.copyOfRange(line, 0, 5);
            String[] P2 = Arrays.copyOfRange(line, 5, 10);

            Split splitP1 = new Split(P1);
            Split splitP2 = new Split(P2);
            HandRank comboRank1 = new HandRank(splitP1.Number, splitP1.Symbol);
            HandRank comboRank2 = new HandRank(splitP2.Number, splitP2.Symbol);

            if(compare.HasPlayer1Won(comboRank1, comboRank2)){
                winCount++;
            }
        }

        return winCount;
    }
}