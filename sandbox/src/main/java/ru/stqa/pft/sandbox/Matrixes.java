package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class Matrixes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int[][] matrixres = new int[m][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            System.out.println("i = " + i);
            for (int j = m - 1; j >= 0; j--) {
                System.out.println("j = " + j);
                matrixres[j][i] = matrix[i][j];
                System.out.println("matrixres[" + i + "][" + j + "] = " + matrixres[j][i]);
            }
        }
        for(int i = 0; i < m; i++) {
            System.out.println();
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(matrixres[i][j] + " ");
            }
        }
    }
}
