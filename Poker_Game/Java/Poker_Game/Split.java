package Poker_Game;

import java.util.Arrays;

public class Split {
    public int [] Number1 = new int[5];
    public char[] Symbol1 = new char[5];
    public char[] s = new char[5];

    Split(String[] Player) {
        for (int i = 0; i < Player.length; i++) {
            char[] s = Player[i].toCharArray();
            if(Character.isLetter(s[0])){
                switch(s[0]) {
                    case 'T':
                        Number1[i] = 10;
                        Symbol1[i] = s[1];
                        break;
                    case 'J':
                        Number1[i] = 11;
                        Symbol1[i] = s[1];
                        break;
                    case 'Q':
                        Number1[i] = 12;
                        Symbol1[i] = s[1];
                        break;
                    case 'K':
                        Number1[i] = 13;
                        Symbol1[i] = s[1];
                        break;
                    case 'A':
                        Number1[i] = 14;
                        Symbol1[i] = s[1];
                        break;
                }
            }
            else {
                Symbol1[i] = s[1];
                Number1[i] = Integer.parseInt(String.valueOf(s[0]));
            }
        }
        Arrays.sort(Number1);
        Arrays.sort(Symbol1);
    }
}
