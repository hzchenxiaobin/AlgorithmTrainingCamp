package ch7pro.POJ1458;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int result= 0;
            String str1 = scanner.next(), str2 = scanner.next();
            int length1 = str1.length(), length2 = str2.length();
            int[][] dp = new int[length1 + 1][length2 + 1];
            for (int i = 1; i <= length1; i++) {
                for (int j = 1; j <= length2; j++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    result = Math.max(dp[i][j], result);
                }
            }
            System.out.println(result);
        }
    }
}
