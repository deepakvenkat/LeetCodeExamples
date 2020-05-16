package com.company;
import com.company.ds.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        int carry = 0;
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null || l2 != null || carry > 0) {
            result.setNext(new ListNode());
            result = result.getNext();
            sum = 0;
            if (l1 != null) {
                sum += l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                sum += l2.getVal();
                l2 = l2.getNext();
            }
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
                result.setVal(sum);
        }
        return head.getNext();
    }
}
