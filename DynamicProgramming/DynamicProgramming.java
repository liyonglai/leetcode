/**
 * 动态规划算法：求硬币面值组合数量
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] coins = {5, 10, 25};
        System.out.println(count(25, coins));
    }

    public static int count(int n, int[] coins){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=n ; j++) {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[n];
    }
}
