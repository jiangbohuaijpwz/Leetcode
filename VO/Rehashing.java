public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }
        int n = hashTable.length;
        int newN = 2 * n;
        ListNode[] res = new ListNode[newN];
        for (int i = 0; i < n; i++) {
            ListNode head = hashTable[i];
            while (head != null) {
                int value = head.val;
                int remainder = -1;
                if (value >= 0) {
                    remainder = value % newN;
                } else {
                    remainder = (value % newN + newN) % newN;
                }
                insert(remainder, res, value);
                head = head.next;
            }
        }
        return res;
    }
    
    private void insert(int remainder, ListNode[] res, int value) {
        if (res[remainder] == null) {
            res[remainder] = new ListNode(value);
        } else {
            ListNode head = res[remainder];
            while (head.next != null) {
                head = head.next;
            }
            head.next = new ListNode(value);
        }
    }
}