/**
 * @author liyonglai
 * @date 2019/9/11
 * @description leetcode 11, 给定一个随机数组，数组的大小必须大于2，数组中的每个数字在y轴上代表了高度，
 *              所有的数字在x轴上以步长为1相加，这些数字代表的高度形成的容器能容纳水的最大面积
 *              解题思路：最大值的状态转移以及滑动窗口的思想，类似求最字符串的最长不重复子序列
 */
public class ContainsWithMostWater {
    public static int maxArea(int[] nums){
        int max = 0, left = 0, right = nums.length - 1;
        while(left < right) {
            int currentArea = Math.min(nums[left], nums[right]) * (right - left);
            // 关键步骤：求出当前最大值和以往最大值的较大者，并将较大的数存入max，状态转移
            max = Math.max(currentArea, max);

            if(nums[left] < nums[right]) {
                // 如果左边的高度小于右边的高度，则左边的指针向右移动
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 8};
        System.out.println(maxArea(nums));
    }

}
