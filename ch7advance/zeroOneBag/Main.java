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
        int n = v.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                //不选取当前背包
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        return dp[n][W];
    }

    /**
     * 求最优解
     *
     * @param w  每个物品的重量
     * @param dp 最优解
     * @return
     */
    public int[] getOptimumSolution(int[] w, int[][] dp, int W) {
        int j = W;
        int n = w.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                result[i] = 1;
                j -= w[i];
            }
        }

        return result;
    }

    /**
     * 01背包问题优化解法1
     *
     * @param v
     * @param w
     * @param W
     * @return
     */
    private int promotionSolute(int[] v, int[] w, int W) {
        int n = v.length;
        int[] arrPre = new int[W + 1];
        int[] dp = new int[W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j] = Math.max(arrPre[j], arrPre[j - w[i]] + v[i]);
            }
            arrPre = dp;
            for (int j = 1; j <= W; j++) {
                arrPre[j] = dp[j];
                dp[j] = 0;
            }
        }

        return dp[W];
    }

    /**
     * 01背包问题优化解法2
     *
     * @param v
     * @param w
     * @param W
     * @return
     */
    private int promotionSolute2(int[] v, int[] w, int W) {
        int n = v.length;
        int[] dp = new int[W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = W; j >= w[i]; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        return dp[W];
    }
}
