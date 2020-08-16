public class ArrayDeque<T> {
    private int head;
    private int size;
    private int vol;
    private T[] item;

    public ArrayDeque(){
        head = 0;
        size = 0;
        vol = 8;
        item = (T[]) new Object[vol];
    }

    //tail point to the place followed by the last item of this Deque.
    private int calTail(int head, int size, int vol){
        return (head + size)%vol;
    }

    private boolean isFull(){
        return (size == vol);
    }

    private T[] resize(T[] old){
        vol = vol * 2;
        T[] it = (T[]) new Object[vol];
        for(int i=0; i<size; ++i, head=(++head)%size){
            it[i] = item[head];
        }
        head = 0;
        return it;
    }

    public void addFirst(T item){
        if(isFull()){
            this.item = resize(this.item);
        }

        ++size;
        head = (head-1)<0? vol-1: head-1;
        this.item[head] = item;
    }

    public void addLast(T item){
        if(isFull()){
            this.item = resize(this.item);
        }

        int newtail = calTail(head, size, vol);
        this.item[newtail] = item;
        ++size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i = 0, j = head;
        while(i<size){
            System.out.print(item[j] + " ");
            ++i;
            j = (++j) % vol;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }

        --size;
        int rm = head;
        head = (head + 1) % vol;
        return item[rm];
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }

        --size;
        int newtail = calTail(head, size, vol);
        return item[newtail];
    }

    public T get(int index){
        if(isEmpty() || index>=size || index<0){
            return null;
        }

        return item[(index + head) % vol];
    }

    /*
    public static void main(String[] args){
        ArrayDeque<Double> a = new ArrayDeque<Double>();
        for(int i = 0; i<8; i++) {
            a.addFirst(1.1*i);
        }
        a.printDeque();
        System.out.println(a.get(7));
        a.addLast(10.1);
        a.addLast(11.1);
        a.addLast(12.1);
        a.removeFirst();
        a.printDeque();
        System.out.println("size=" + a.size());

        ArrayDeque<Integer> b = new ArrayDeque<Integer>();
        for(int i=0; i<20; ++i) {
            b.addLast(i+1);
        }
        b.printDeque();
        System.out.println("size=" + b.size());
    }
     */

}
