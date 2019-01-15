public class IntToRoman {
    /**
     * 将整形数字转成对应的罗马字符
     * 解题思路：将罗马数字的个十百千位的字符一一形成数组，在通过整除和求余得出每个位上的数字，将数组的下标与数字对应即可
     * @param num
     * @return
     */
    public static String intToRoman(int num){
        String[] unitDigit = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tenDigit = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundredDigit = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousandDigit = {"", "M", "MM", "MMM"};
        return thousandDigit[num/1000] + hundredDigit[(num/100) % 10] + tenDigit[(num % 100) / 10] + unitDigit[num % 10];
    }
}
