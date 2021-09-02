package ch7pro.HDU2041;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++) {
            int k = scanner.nextInt();
            if(k == 1) {
                System.out.println(0);
                continue;
            }
            if(k == 2) {
                System.out.println(1);
                continue;
            }
            if(k == 3) {
                System.out.println(2);
                continue;
            }
            int[] dp = new int[k+1];
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 2;
            for(int j=4;j<=k;j++) {
                dp[j] = dp[j- 2] + dp[j-1];
            }
            System.out.println(dp[k]);
        }
    }
}
