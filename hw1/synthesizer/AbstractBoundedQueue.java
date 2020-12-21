package synthesizer;

public abstract class AbstractBoundedQueue<T> implements  BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
 //   protected T[] data;
/*
    public AbstractBoundedQueue(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public AbstractBoundedQueue() {
        data = (T[]) new Object[capacity];
    }
     public int capacity(){
        return capacity;
    }
    public int fillCount(){
        return fillCount;
    }
    public boolean isEmpty(){
        if(fillCount==0)
            return true;
        return false;
    }
    public boolean isFull(){
            if(fillCount==capacity)
                return true;
            else
                return false;
    }
    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);
*/


    @Override
    /** Returns if the buffer is empty */
    public int capacity() {
        return capacity;
    }

    @Override
    /** Returns if the buffer is full */
    public int fillCount() {
        return fillCount;
    }
}
