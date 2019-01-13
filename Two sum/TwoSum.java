import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 1.暴力枚举，普通思维，不考虑任何算法复杂度，只是为了完成解题
     */
    public int[] twoSum(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }

    /**
     * 2.利用hashmap将时间复杂度降低到O(n)
     * @return
     */
    public static int[] twoSum2(int nums[], int target){
        Map<Integer, Integer> map = new HashMap<>(8);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int minusResult = target - nums[i];
            if(map.containsKey(minusResult)){
                return new int[]{i, map.get(minusResult)};
            }
        }
        throw new IllegalArgumentException("no result");
    }

    public static void main(String[] args) {
        int[] array = {1,5,7, 8,9};
        int[] result = twoSum2(array, 17);
        for (int res : result) {
            System.out.println(res);
        }
    }
}

