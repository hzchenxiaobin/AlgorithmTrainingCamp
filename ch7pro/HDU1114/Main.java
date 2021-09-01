package ch7pro.HDU1114;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (; count > 0; count--) {
            int emptyWeight = scanner.nextInt();
            int fullWeight = scanner.nextInt();
            int W = fullWeight - emptyWeight;

            int n = scanner.nextInt();
            int[] v = new int[n];
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
                w[i] = scanner.nextInt();
            }

            int[] dp = new int[W+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = w[i]; j <= W; j++) {
                    if(dp[j - w[i]] == Integer.MAX_VALUE) continue;
                    dp[j] = Math.min(dp[j], dp[j - w[i]] + v[i]);
                }
            }

            if(dp[W] == Integer.MAX_VALUE) {
                System.out.println("This is impossible");
            } else {
                System.out.println("The minimun amount of money in the piggy-bank is " + dp[W]);
            }
        }
    }
}
