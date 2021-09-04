package ch7pro.POJ2955;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.equals("end")) break;
            int n = str.length();
            int[][] dp = new int[n][n];
            for (int d = 1; d < n; d++) {
                for (int i = 0; i + d < n; i++) {
                    int j = i + d;
                    if (check(str, i, j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                    for(int k=i;k<j;k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
            System.out.println(dp[0][n - 1]);
        }
    }

    private static boolean check(String s, int i, int j) {
        char c1 = s.charAt(i), c2 = s.charAt(j);
        return (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')');
    }
}
