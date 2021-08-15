package ch7advance.分组背包;

public class Main {
    public int solute(int[][] w, int[][] v,  int W) {
        int n = w.length;
        int[] dp = new int[W+1];
        for(int i=1;i<=n;i++) {
            for(int j=W;j>=0;j--) {
                for(int k=1;k<=w[i].length;k++) {
                    dp[j] = Math.max(dp[j], dp[j - w[i][k]] + v[i][k]);
                }
            }
        }

        return dp[W];
    }
}
