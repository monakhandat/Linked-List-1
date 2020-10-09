public class Solution {
    public ListNode detectCycle(ListNode head) {
        //Base case
        
        if(head == null || head.next==null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        //Finding the cycle
        
        while(fast!= null && fast.next != null)
        {
            slow = slow.next;
            fast= fast.next.next;
            if(slow == fast)
            {
                // Finding the exact node/entrance for the cycle
                ListNode p1 = head;
                while(p1 !=slow)
                {// Using X = B part
                    p1 = p1.next; 
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// TC- O(N*N)
// SC- O(1)
/* The part where slow and fast are equal is not necessarily the beginning of the cycle. 
But the number nodes traveled between head and beginning of cycle is equal 
to the number of nodes the slow pointer will travel to reach start of the cycle.*/
