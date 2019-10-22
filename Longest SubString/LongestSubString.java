import java.util.HashSet;
import java.util.Set;

/**
 * @author liyonglai
 * @date 2019/9/10
 * @description 给定一个字符串abcdaaabcd,求字符串的最长不重复子序列，即abcds
 */
public class LongestSubString {
    public static void main(String[] args) {
        String str = "abcdaaabcd";
        System.out.println(longestSubString(str));
    }

    public static int longestSubString(String str){
        int size = str.length();
        int res = 0, left = 0, right = 0;
        // 定义一个hashset作为滑动窗口
        Set<Character> set = new HashSet<>();
        while (left < size && right < size) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(str.charAt(left++));
            }
        }
        return res;
    }
}
