package LeetCode;

public class DoubleIt {
    public static void main(String[] args) {

        ListNode listNode9 = new ListNode(9, null);
        ListNode listNode8 = new ListNode(8, listNode9);
        ListNode listNode1 = new ListNode(9, listNode8);
        System.out.println(doubleIt(listNode1));
    }
    public static ListNode doubleIt(ListNode head) {
        StringBuilder val = new StringBuilder();
        ListNode temp = head;
        while (temp != null){
            val.append(temp.val);
            temp = temp.next;
        }
        String result = String.valueOf(Integer.parseInt(val.toString()) * 2);
        int i = 0;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode curr = head;
        while(i < result.length()){
            int num = result.charAt(i++)-'0';
            if(prev.next != null){
                curr.val = num;
                prev = curr;
                curr = curr.next;
            }else {
                ListNode newNode = new ListNode(num);
                prev.next = newNode;
                curr = newNode;
            }
        }
        return head;
    }
}
