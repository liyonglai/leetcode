public class LongestCommonPrefix {
    /**
     * 找出字符串的公共前缀，如“hashmap, hashset, hashtable”, 返回hash
     * @param args
     * @return
     */
    public static String findLongestCommonPrefix(String[] args){
        if(args == null || args.length == 0) {
            return "";
        }
        for (int i = 0; i < args[0].length() ; i++) {
            char c = args[0].charAt(i);
            for (int j = 1; j < args.length; j++) {
                //第一个判断条件保证其余的字符串不会超出比较的长度，第二个判断对应位置的字符是否相等
                if (i == args[j].length() || args[j].charAt(i) != c) {
                    return args[0].substring(0, i);
                }
            }
        }
        return args[0];
    }

    public static void main(String[] args) {
        String strs[] = {"hasmap", "hashtable", "hashset"};
        System.out.println(findLongestCommonPrefix(strs));
    }
}
