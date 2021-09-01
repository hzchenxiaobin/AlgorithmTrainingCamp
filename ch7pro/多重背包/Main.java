package ch7pro.多重背包;

public class Main {
    public int solute(int[] v, int[] w, int[] c, int W) {
        int n = v.length;
        int[] dp = new int[W+1];
        for(int i=1;i<=n;i++) {
            int[] num = new int[W+1];
            for(int j=w[i];i<=W;j++) {
                if(dp[j] < dp[j - w[i]] + v[i] && num[j-w[i]] < c[i]) {
                    dp[j] = dp[j - w[i]] + v[i];
                    num[j] = num[j - w[i]] + 1;
                }
            }
        }

        return dp[W];
    }
}
