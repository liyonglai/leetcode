/**
 * 记忆搜索法求硬币面值组合总数
 */
public class CountCoinWays {

    public static int coins(int[] coins, int total){
        if (coins == null || coins.length == 0 || total < 0) {
            return 0;
        }
        int[][] map = new int[coins.length + 1][total + 1];
        return process(coins, 0, total, map);
    }

    private static int process(int[] coins, int index, int total, int[][] map){
        int res = 0;
        if (index == coins.length) {
            res = total == 0 ? 1 : 0;
        }else{
            int mapValue = 0;
            for (int i = 0; coins[index]*i <= total; i++) {
                mapValue = map[index+1][total-coins[index]*i];
                if (mapValue != 0) {
                    res += mapValue==-1 ? 0 : mapValue;
                }else {
                    res += process(coins, index + 1, total-coins[index]*i, map);
                }
            }
        }
        map[index][total] = res == 0 ? -1 : res;
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5, 10, 25};
        int total = 25;
        System.out.println(coins(coins, total));
    }
}
