class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    // DLL
    Node head= new Node(-1,-1);
    Node tail= new Node(-1,-1);
    int cap;
    HashMap<Integer, Node> m= new HashMap<>();

    private void add(Node newNode){
        Node temp=head.next;

        newNode.next=temp;
        newNode.prev=head;

        head.next=newNode;
        temp.prev=newNode;
    }
    private void delete(Node delNode){
        Node prevv=delNode.prev;
        Node nextt=delNode.next;

        prevv.next=nextt;
        nextt.prev=prevv;
    }
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(m.containsKey(key)){
            Node res=m.get(key);
            int ans=res.val;

            m.remove(key);
            delete(res);
            add(res);
            
            m.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node curr=m.get(key);
            m.remove(key);
            delete(curr);
        }
        if(m.size()==cap){
            m.remove(tail.prev.key);
            delete(tail.prev);
        }
        add(new Node(key, value));
        m.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
