package com.company;

import com.company.ds.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = new ListNode();
        head = result;
        while (l1 != null || l2 != null) {
            result.setNext(new ListNode());
            result = result.getNext();
            if (l1 == null) {
                result.setVal(l2.getVal());
                l2 = l2.getNext();
            } else if (l2 == null) {
                result.setVal(l1.getVal());
                l1 = l1.getNext();
            } else if (l1.getVal() > l2.getVal()) {
                result.setVal(l2.getVal());
                l2 = l2.getNext();
            } else if (l1.getVal() < l2.getVal()) {
                result.setVal(l1.getVal());
                l1 = l1.getNext();
            } else {
                result.setVal(l1.getVal());
                result.setNext(new ListNode(l1.getVal()));
                result = result.getNext();
                l1 = l1.getNext();
                l2 = l2.getNext();
            }
        }
        return head.getNext();
    }
}
