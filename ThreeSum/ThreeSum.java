import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyonglai
 * @date 2019/9/12
 * @description leetcode 15 给一个数组（元素个数大于3），找出数组中能组成a+b+c=0的三个数
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int lo = i+1;
            int hi = size - 1;
            int twoSum = -nums[i];
            while (lo < hi) {
                if(nums[lo] + nums[hi] > twoSum){
                    hi--;
                }
                if(nums[lo] + nums[hi] < twoSum) {
                    lo++;
                }
                if(nums[lo++] + nums[hi--] == twoSum){
                    list.add(Arrays.asList(twoSum, nums[lo], nums[hi]));
                    // 两个循环判断是因为怕得出的结果有重复子集
                    while(lo < hi && nums[lo] == nums[lo+1]){
                        lo++;
                    }
                    while(lo < hi && nums[hi] == nums[hi-1]){
                        hi--;
                    }
                }
            }
            // 这步的操作也是为了防止出现重复元素，重复执行计数
            while (i+1 < size && nums[i+1] == nums[i]){
                i++;
            }
        }
        return list;
    }

    public List<List> three2Sum(int[] nums) {
        List<List> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int twoSum = 0-nums[i];
            int left = i+1, right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]<twoSum){
                    left++;
                }
                else if(nums[left]+nums[right]>twoSum){
                    right--;
                }
                else{
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<nums.length&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right>=0&&nums[right]==nums[right+1]){
                        right--;
                    }

                }
            }
            while(i<(nums.length-1)&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return list;
    }
}
