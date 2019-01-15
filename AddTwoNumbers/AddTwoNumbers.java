public class AddTwoNumbers {
    public static ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp1 = l1, temp2 = l2, curr = head;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int x = (temp1 != null) ? temp1.val : 0;
            int y = (temp2 != null) ? temp2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        //最高为的进位
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}
