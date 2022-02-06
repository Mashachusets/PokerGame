package Poker_Game;

import java.io.IOException;

public class Poker {
    public static void main(String[] args) throws IOException {
        Game game = new Game("Poker_Game/Java/File/poker.txt");
        int player1Wins = game.PlayGame();

        System.out.println("Player 1 won " + player1Wins + " matches.");
    }
}
