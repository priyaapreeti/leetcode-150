/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode s=head;
        ListNode f=head;
        ListNode newHead=null;
        ListNode prevTail=null;

        while(f!=null){
            f=s;
            for(int i=1; i< k && f!=null; i++){
                f=f.next;
            }

            if(f==null) break;

            ListNode nextNode=f.next;
            f.next=null;
            ListNode x= reverse(s);

            if(s==head){
                newHead=x;
            }
            else prevTail.next=x;
            
            prevTail=s;
            s.next=nextNode;
            s=nextNode;
        }
        return newHead;
        
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode t1=temp.next;
            temp.next=prev;
            prev=temp;
            temp=t1;
        }
        return prev;
    }
}
