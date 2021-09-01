package ch7pro.HDU2844;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if(n == 0 && m == 0) break;

            int[] a = new int[n+1];
            for(int i=1;i<=n;i++) {
                a[i] = scanner.nextInt();
            }
            int[] c = new int[n+1];
            for(int i=1;i<=n;i++) {
                c[i] = scanner.nextInt();
            }
            boolean[] dp = new boolean[m + 1];
            dp[0] = true;
            int result = 0;
            for(int i=1;i<=n;i++) {
                int[] nums = new int[m + 1];
                for(int j=a[i];j<=m;j++) {
                    if(!dp[j] && dp[j - a[i]] && nums[j - a[i]] < c[i]) {
                        dp[j] = true;
                        result++;
                        nums[j] = nums[j - a[i]] + 1;
                    }
                }
            }

            System.out.println(result);
        }

    }
}
