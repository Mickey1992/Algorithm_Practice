package leetcode;

public class AddTwoNumbers {
    public static void main (String args[]){
        ListNode l1= new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2= new ListNode(5, new ListNode(6, new ListNode(4)));
        printListNode(addTwoNumbersWithoutDummyNode(l1, l2));
        printListNode(addTwoNumbersWithDummyNode(l1, l2));

        ListNode l3= new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9)))))));
        ListNode l4= new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        printListNode(addTwoNumbersWithoutDummyNode(l3, l4));
        printListNode(addTwoNumbersWithDummyNode(l3, l4));

    }
    public static ListNode addTwoNumbersWithoutDummyNode(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cur = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int flag = 0;
        while(cur1!=null || cur2!=null || flag > 0){
            if(result == null) {
                result = new ListNode();
                cur = result;
            }
            else{
                cur.next = new ListNode();
                cur = cur.next;
            }
            int sum = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + flag;
            cur.val = sum % 10;
            flag = sum / 10;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }
        return result;
    }

    public static ListNode addTwoNumbersWithDummyNode(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int flag = 0;
        while(cur1!=null || cur2!=null || flag > 0){
            cur.next = new ListNode();
            cur = cur.next;
            int sum = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + flag;
            cur.val = sum % 10;
            flag = sum / 10;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }
        return result.next;
    }

    public static void printListNode(ListNode head){
        ListNode cur = head;
        System.out.print("[");
        while(cur.next != null){
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
        System.out.println(cur.val + "]");
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
