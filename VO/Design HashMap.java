class MyHashMap {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    class ResultType {
        ListNode pre;
        ListNode cur;
        public ResultType(ListNode pre, ListNode cur) {
            this.pre = pre;
            this.cur = cur;
        }
    }
    /** Initialize your data structure here. */
    ListNode[] arr = new ListNode[10000];
    public MyHashMap() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ListNode(-1, -1);
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // int index = Integer.hashCode(key);
        int index = key % arr.length;
        ListNode node = search(key, arr[index]).cur;
        if (node != null) {
            node.value = value;
        } else {
            ListNode pre = search(key, arr[index]).pre;
            ListNode end = new ListNode(key, value);
            pre.next = end;
        }
    }
    
    private ResultType search(int key, ListNode node) {
        ListNode pre = null;
        while (node != null) {
            if (node.key == key) {
                return new ResultType(pre, node);
            } else {
                pre = node;
                node = node.next;
            }
        }
        return new ResultType(pre, node);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = Integer.hashCode(key) % arr.length;
        ListNode node = search(key, arr[index]).cur;
        if (node == null) {
            return -1;
        }
        return node.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) % arr.length;
        ResultType node = search(key, arr[index]);
        if (node.cur == null) {
            return;
        }
        node.pre.next = node.cur.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */