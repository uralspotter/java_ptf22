package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class StepikTraining {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        numberCounter(a, b);
        avgStream();
        sumSqaurs(a);
        factorial(a);
        sumNumber(a);
    }

    public static void numberCounter(int a, int b) {
        int count = 0;
        while (a <= b) {
            if (a % 3 == 0 && a % 5 != 0) {
                count++;
            }
            a++;
        }
        System.out.println(count);
    }

    public static void avgStream() {
        int in = sc.nextInt();
        int count = 1;
        double sum = in;
        while (in != 0) {
            in = sc.nextInt();
            if (in != 0) {
                count++;
                sum += in;
            }
        }
        System.out.println(sum / count);
    }

    public static void sumSqaurs(int a) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i * i;
        }
        System.out.println(sum);
    }

    public static void factorial(int a) {
        int factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }

    public static void sumNumber(int a) {
        int sum = 0;
        while (a / 10 != 0) {
            sum += a % 10;
            a /= 10;
        }
        sum += a;
        System.out.println(sum);
    }
}
