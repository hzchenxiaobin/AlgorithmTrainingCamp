package ch7pro.POJ3280;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        String str = scanner.next();

        Map<Character, Integer> costMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            costMap.put(scanner.next().charAt(0), Math.min(scanner.nextInt(), scanner.nextInt()));
        }
        for (Map.Entry<Character, Integer> entry : costMap.entrySet()) {
            System.out.println(entry.getKey() +":" + entry.getValue());
        }

        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j] + costMap.get(str.charAt(i)), dp[i][j-1] + costMap.get(str.charAt(j)));
                }
            }
        }

        System.out.println(dp[0][m-1]);
    }
}
