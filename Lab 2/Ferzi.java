package com.company;

public class Ferzi {

    static int[] chessboard = {0,0,0,0,0,0,0,0};
    static int index = 0;
    static int version = 1;

    public static void startFerzi(){

        do {
            if (checking()){
                if (index == 7) {
                    System.out.println(version++ + " [a]=" + chessboard[0] + " [b]=" + chessboard[1] + " [c]=" + chessboard[2] + " [d]=" + chessboard[3] + " [e]=" + chessboard[4] + " [f]=" + chessboard[5] + " [g]=" + chessboard[6] + " [h]=" + chessboard[7]);
                    chessboard[index]++;
                }
                else {
                    index++;
                }
            }
            else {
                chessboard[index]++;
            }
        } while (chessboard[0]<8);
    }

    static boolean checking() {
        int i;

        if (index == 0) {
            return true;
        }

        if (chessboard[index]>7){
            chessboard[index] = 0;
            index--;
            return false;
        }

        for (i = 0; i < index; i++){
            if ((chessboard[index] == chessboard[i])|((Math.abs(chessboard[index] - chessboard[i])) == (index-i))){
                return false;
            }
        }

        return true;
    }
}
