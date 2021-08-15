package ch7advance.HDU1712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n == 0 && m == 0) break;

            int[][] a = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            int[] dp = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = m; j >= 0;j--) {
                    for(int k=1;k<=j;k++) {
                        dp[j] = Math.max(dp[j], dp[j - k] + a[i][k]);
                    }
                }
            }

            System.out.println(dp[m]);
        }
    }
}
