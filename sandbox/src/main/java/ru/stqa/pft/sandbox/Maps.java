package ru.stqa.pft.sandbox;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Map<Integer, String> words = new HashMap<Integer, String>();
        for(int i = 0; i < count; i++) {
            words.put(i, sc.nextLine());
        }
        String word = sc.nextLine();
        for(int i = 1; i <= count; i++) {
            if(words.get(i).equals(word) && i % 2 == 0) {
                System.out.println(words.get(i - 1));
            } else if(words.get(i).equals(word) && i % 2 == 0) {
                System.out.println(words.get(i + 1));
            }
        }
    }
}
