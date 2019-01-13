public class ReverseInteger {
    /**
     * 整形数字的翻转，将1234翻转成4321， -234翻转成-432， 120翻转成21
     * 解题思路：合理利用整除和求余，将上一次求余的数乘以10再加上本次求余的数
     * @param rev
     * @return
     */
    public static int reverse(int rev){
        int temp = 0;
        while(rev != 0){
            int tail = rev % 10;
            rev = rev / 10;
            if(rev > Integer.MAX_VALUE || (rev == Integer.MAX_VALUE && tail > 7)){
                throw new IllegalArgumentException("number too big");
            }
            if(rev < Integer.MIN_VALUE || (rev == Integer.MIN_VALUE && tail < -8)){
                throw new IllegalArgumentException("number is too small");
            }
            temp = temp * 10 + tail;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-89765));
    }
}
