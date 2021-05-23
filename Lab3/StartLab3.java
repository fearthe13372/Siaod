package com.company.Lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StartLab3
{
    public static void main(String[] args) {

        String slovo="abcdsawdwfsdqw";
        String textForFind="dw";

        System.out.println("Кнут-Морр-Прт ="+ (Arrays.toString(KNUT_MOR_PRAT(slovo, textForFind).toArray())));
        System.out.println("Боер-Мур = "+ Boer_Mur(slovo,textForFind));


        int[][] blocks = new int[][]{{1, 2, 3, 0}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 4}};
        Board initial = new Board(blocks);
        Solver solver = new Solver(initial);
        System.out.println("Minimum number of moves = " + solver.moves());
        for (Board board : solver.solution())
            System.out.println(board);
    }
    //Кнута-Морриса-Пратта
    static int[] prefFunc(String textForFind) {
        int [] values = new int[textForFind.length()];
        for (int i = 1; i < textForFind.length(); i++) {
            int j = 0;
            while (i + j < textForFind.length() && textForFind.charAt(j) == textForFind.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }
    public static ArrayList<Integer> KNUT_MOR_PRAT(String slovo, String textForFind) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefFunc = prefFunc(textForFind);
        int i = 0;
        int d = 0;
        while (i < slovo.length()) {
            if (textForFind.charAt(d) == slovo.charAt(i)) {
                d++;
                i++;
            }
            if (d == textForFind.length()) {
                found.add(i - d);
                d = prefFunc[d - 1];
            } else if (i < slovo.length() && textForFind.charAt(d) != slovo.charAt(i)) {
                if (d != 0) {
                    d = prefFunc[d - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }


    /**
     * Возвращает индекс первого вхождения строки textForFind в строку Slovo, или
     * -1, в случае если вхождение не найдено.
     *
     * @param Slovo
     *            исходная строка, в которой ищется вхождение шаблона.
     * @param textForFind
     *            шаблон строки, которая ищется в строке Slovo.
     * @return индекс первого вхождения строки textForFind в строку Slovo, или -1,
     *         в случае если вхождение не найдено.
     */
    public static int Boer_Mur(String Slovo, String textForFind) {
        int sourceLen = Slovo.length();
        int templateLen = textForFind.length();
        if (templateLen > sourceLen) {
            return -1;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, templateLen);
        }
        for (int i = 0; i < templateLen - 1; i++) {
            offsetTable.put(textForFind.charAt(i), templateLen - i - 1);
        }
        int i = templateLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            while (j >= 0 && Slovo.charAt(k) == textForFind.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(Slovo.charAt(i));
        }
        if (k >= sourceLen - templateLen) {
            return -1;
        } else {
            return k + 1;
        }
    }





}


















//Кнута-Морриса-Пратта
//https://ru.wikibooks.org/wiki/Реализации_алгоритмов/Алгоритм_Бойера_—_Мура
//https://www.youtube.com/watch?v=7g-WEBj3igk&t=1256s


///https://www.pvsm.ru/java/16174


//боер
//https://habr.com/ru/post/116725/