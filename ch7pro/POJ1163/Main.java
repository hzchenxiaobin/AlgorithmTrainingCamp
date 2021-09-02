package ch7pro.POJ1163;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(j > 0) dp[j] = Math.max(dp[j], dp[j - 1]) + arr[i][j];
                else dp[j] = dp[j] + arr[i][j];
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
