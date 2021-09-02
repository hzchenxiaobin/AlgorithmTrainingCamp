package ch7pro.POJ2533;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}
