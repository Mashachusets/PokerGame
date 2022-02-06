package Poker_Game;

import java.util.Arrays;

public class Split {
    public int[] Number = new int[5];
    public char[] Symbol = new char[5];

    public Split(String[] Player) {
        for (int i = 0; i < Player.length; i++) {
            char[] card = Player[i].toCharArray();

            if (Character.isLetter(card[0])) {
                switch (card[0]) {
                    case 'T':
                        Number[i] = 10;
                        Symbol[i] = card[1];

                        break;
                    case 'J':
                        Number[i] = 11;
                        Symbol[i] = card[1];

                        break;
                    case 'Q':
                        Number[i] = 12;
                        Symbol[i] = card[1];

                        break;
                    case 'K':
                        Number[i] = 13;
                        Symbol[i] = card[1];

                        break;
                    default:
                        Number[i] = 14;
                        Symbol[i] = card[1];

                        break;
                }
            }
            else {
                Symbol[i] = card[1];
                Number[i] = Integer.parseInt(String.valueOf(card[0]));
            }
        }

        Arrays.sort(Number);
        Arrays.sort(Symbol);
    }
}
