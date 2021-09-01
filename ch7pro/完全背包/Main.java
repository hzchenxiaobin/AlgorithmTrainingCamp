package ch7pro.完全背包;

/**
 * 完全背包问题
 */
public class Main {
    /**
     *
     * @param v 价值
     * @param w 体积
     * @param W 总体积
     * @return
     */
    private int solute(int[] v, int[] w, int W) {
        int n = v.length + 1;
        int[] dp = new int[W+1];
        for(int i=1;i<=n;i++) {
            for(int j=w[i];j<=W;j++) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }

        return dp[W];
    }
}
