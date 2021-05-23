package com.company.Lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        ArrayDeque<String> lines = new ArrayDeque<>();
        EnterText(lines);
        String[] text = lines.toArray(new String[0]);
        Arrays.sort(text);
        lines.clear();
        lines.addAll(Arrays.asList(text));
        System.out.println("\nРезультат: " + lines);
    }

    public static void EnterText(ArrayDeque<String> lin1) {
        try {
            File file = new File("C:\\Users\\Егор\\IdeaProjects\\Lab 2\\src\\com\\company\\Lab4\\input\\input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                lin1.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}