public class LinkedListDeque<T> implements Deque<T>{
    private final TNode head;
    private final TNode tail;
    private int size;

    private class TNode {
        public T val;
        public TNode prev;
        public TNode next;

        public TNode(T v, TNode p, TNode n) {
            val = v;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        head = new TNode(null, null, null);
        tail = new TNode(null, null, null);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(T item) {
        size++;
        head.next.prev = new TNode(item, head, head.next);
        head.next = head.next.prev;
    }

    public void addLast(T item) {
        size++;
        tail.prev.next = new TNode(item, tail.prev, tail);
        tail.prev = tail.prev.next;
    }

    public boolean isEmpty() {
        return (size==0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode p = head.next;
        while(p.next != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }

        size--;
        T v = head.next.val;
        head.next.next.prev = head;
        head.next = head.next.next;
        return v;
    }

    public T removeLast() {
        if(isEmpty()){
            return null;
        }

        size--;
        T v = tail.prev.val;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return v;
    }

    public T get(int index) {
        if(isEmpty() || index >= size || index<0) {
            return null;
        }

        TNode p = head.next;
        for(; index>0; --index) {
            p = p.next;
        }
        return p.val;
    }

    private T getRecursive(int index, TNode np) {
        if(index == 0){
            return np.val;
        }

        return getRecursive(index-1, np.next);
    }

    public T getRecursive(int index) {
        if(isEmpty() || index >= size || index<0) {
            return null;
        }

        return getRecursive(index, head.next);
    }

}
