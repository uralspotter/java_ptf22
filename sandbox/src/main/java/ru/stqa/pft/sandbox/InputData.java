package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class InputData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        double price = a + (b/100.0);
        double cost = c + (d/100.0);
        double delta = Math.abs(cost - price);
        int e = (int) delta/100;
        int f = (int) delta % 100;
        int result;
        if (a < c) {
            result = 1;
        } else if (a == c && b == d) {
            result = 2;
        } else {
            result = 0;
        }
        switch(result) {
            case 1:
                System.out.println(e + " " + f);
                break;
            case 2:
                System.out.println("0 0");
                break;
            default:
                System.out.println("мало");
        }
    }
}
