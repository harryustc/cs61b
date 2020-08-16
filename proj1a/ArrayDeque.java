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
        return (head + size + 1)%vol;
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
        head = (head-1)<0? vol: head-1;
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
        head = (head + 1) % vol;
        return item[head];
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }

        --size;
        int newtail = calTail(head, size, vol) - 1;
        return newtail<0? item[vol]: item[newtail];
    }

    public T get(int index){
        if(isEmpty() || index>=size || index<0){
            return null;
        }

        return item[(index + head) % vol];
    }

}
