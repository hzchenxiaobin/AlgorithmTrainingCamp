package ch7pro.POJ1651;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int d = 2; d <= n; d++) {
            for (int i = 1; i <= n - d + 1; i++) {
                int j = i + d - 1;
                dp[i][j] = dp[i + 1][j] + p[i - 1] * p[i] * p[j];
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
