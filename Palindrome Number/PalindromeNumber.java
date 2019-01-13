public class PalindromeNumber {

    /**
     * 判断是否回文数：如121， 1221,1223221是回文数，-121就不是
     * 解题的思路是根据数字翻转的思路，判断最后翻转后的数字是否和输入的数字相等即可（不是最优解）
     * @param n
     * @return
     */
    public static boolean isPalindromeNumber(int n){
        if(n < 0) {
            return false;
        }
        int rev = 0;
        int temp = n;
        while(n != 0){
            int tail = n % 10;
            n = n / 10;
            if(n > Integer.MAX_VALUE || (rev == Integer.MAX_VALUE / 10 && tail > 7)){
                throw  new IllegalArgumentException("argument is error");
            }
            rev = rev * 10 + tail;
        }

        return rev == temp;
    }


    /**
     * 与第一个方法相比，循环次数减半，判断对称的整数是否相等
     * @param x
     * @return
     */
    public static boolean isPalindromeNumber2(int x){
        //先判断为负数或者末尾数为0的结果
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int revNum = 0;
        while(x > revNum){
            revNum = revNum * 10 + x % 10;
            x /= 10;
        }
        return x == revNum || x == revNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber2(1223221));
        System.out.println(Integer.MAX_VALUE);
    }
}
