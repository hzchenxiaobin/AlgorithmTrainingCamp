package ch7advance.HDU2602;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(int i=0;i<count;i++) {
            int n = scanner.nextInt();
            int W = scanner.nextInt();
            int[] w = new int[n+1];
            int[] v = new int[n+1];
            //价值
            for(int j=1;j<=n;j++) {
                w[j] = scanner.nextInt();
            }
            //体积
            for(int j=1;j<=n;j++) {
                v[j] = scanner.nextInt();
            }

            int[] dp = new int[W+1];
            for(int j=1;j<=n;j++) {
                for(int k=W;k>=v[j];k--) {
                    dp[k] = Math.max(dp[k], dp[k - v[j]] + w[j]);
                }
            }
            System.out.println(dp[W]);
        }
    }
}
