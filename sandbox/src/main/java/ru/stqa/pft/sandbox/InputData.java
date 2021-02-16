package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class InputData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String s1 = sc.nextLine();

        System.out.println("Введно: " + s1);
        int a = sc.nextInt();
        if (a > 0) {
            System.out.println("Ваше число положительное");
        } else if (a < 0) {
            System.out.println("Ваше число отрицательное");
        } else {
            System.out.println("Ваше число ноль");
        }
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(a * b * c);

        if (c > a && c > b) {
            System.out.println(c);
        } else if (b > a && b > c) {
            System.out.println(b);
        } else {
            System.out.println(a);
        }

        int year = sc.nextInt();
        if ((year % 4 == 0) && (year % 400 == 0) || (year % 100 != 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
