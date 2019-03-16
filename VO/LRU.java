class LRUCache {
    class doubleLinkedList {
        int key;
        int value;
        doubleLinkedList pre;
        doubleLinkedList next;
    }
    int size;
    int capacity;
    doubleLinkedList head, tail;
    HashMap<Integer, doubleLinkedList> map;
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<Integer, doubleLinkedList>();
        head = new doubleLinkedList();
        tail = new doubleLinkedList();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        doubleLinkedList node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        doubleLinkedList node = map.get(key);
        if (node == null) {
            node = new doubleLinkedList();
            node.key = key;
            node.value = value;
            map.put(key, node);
            addAfterHead(node);
            size++;
            if (size > capacity) {
                doubleLinkedList tail = popTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void moveToHead(doubleLinkedList node) {
        remove(node);
        addAfterHead(node);
    }
    
    private void remove(doubleLinkedList node) {
        doubleLinkedList pre = node.pre;
        doubleLinkedList next = node.next;
        pre.next = node.next;
        next.pre = pre;
    }
    
    private void addAfterHead(doubleLinkedList node) {
        doubleLinkedList next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }
    
    private doubleLinkedList popTail() {
        doubleLinkedList node = tail.pre;
        remove(node);
        return node;
    }
}