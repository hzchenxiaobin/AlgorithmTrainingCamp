package ch7pro.HDU1003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = scanner.nextInt();
            }

            int[] dp = new int[m];
            dp[0] = arr[0];
            int result = dp[0], start = 0, end = 0;
            int l = 1, r = 1;
            for (int j = 1; j < m; j++) {
                if(dp[j - 1] >= 0) {
                    dp[j] = dp[j - 1] + arr[j];
                } else {
                    dp[j] = arr[j];
                    start = j;
                }

                if(dp[j] > result) {
                    result = dp[j];
                    l = start + 1;
                    r = j + 1;
                }
            }
            System.out.println("Case " + (i+1));
            System.out.println(result +" " + l +" " + r);
        }
    }
}
