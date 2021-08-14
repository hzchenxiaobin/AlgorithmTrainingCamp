package ch7advance.zeroOneBag;

/**
 * 01背包问题
 */
public class Main {
    /**
     * 常规的dp解法，用二维数组解决
     *
     * @param v 每个物品的体积
     * @param w 每个物品的价值
     * @param W 背包总体积
     * @return 最大价值
     */
    public int solute(int[] v, int[] w, int W) {
        int[][] dp = new int[v.length][W];
        int result = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j <= W; j++) {
                //不选取当前背包
                dp[i][j] = dp[i-1][j];
                if(j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - w[i]] + v[i]);
                }
                result = Math.max(dp[i][j], result);
            }
        }

        return result;
    }
}
