import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parentheses {
    private Map<Character, Character> map;
    public Parentheses(){
        this.map = new HashMap<>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');
    }

    /**
     * 解题思路：运用栈的思路，每当遇到一个闭合字符，将栈顶元素弹出，对比栈顶元素是否和闭合配对,最终要达到栈为空
     * 表示所有匹配
     * @param str
     * @return
     */
    public boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        if(str == null || str.length() == 0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (this.map.containsKey(current)){
                char c = stack.empty() ? '#' : stack.pop();
                if(c != this.map.get(current)) {
                    return false;
                }
            }else{
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        System.out.println(parentheses.isValid("()()[][]{}"));
    }
}
