public class LinkedListDeque<T> implements Deque<T>{
    private int size ;
    private Node first;
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque(){
        first = new Node(null,null,null);
        first.prev = first;
        first.next = first;
        size = 0;
    }
    public T getRecursive(int index){
        if (index >= size) {
            return null;
        }

        return getRecursiveHelper(first.next, index);

    }
    /** Helper method for getRecursive */
    private T getRecursiveHelper(Node currentNode, int index) {
        if (index == 0) {
            return currentNode.item;
        }

        return getRecursiveHelper(currentNode.next, index - 1);
    }
    @Override
    public int size() {
        return size(first);
    }
    private int size(Node node){
        if(node.next==null)
            return  1;
        return 1+size(node.next);
    }
    @Override
    public boolean isEmpty() {
        if(first.next==first&&first.prev == first){
            return true;
        }
        return false;
    }

    @Override
    public void addLast(T item) {
        first.prev = new Node(item, first.prev, first);
        first.prev.prev.next = first.prev;
        size++;
    }

    @Override
    public void addFirst(T item) {
          first.prev = new Node(item,first.prev,first);
          first.prev.prev.next = first.prev;
          size+=1;
    }

    @Override
    public void printDeque() {
            if(first.item==null) return;
            while(first.next!=null){
                System.out.print(first.item);
                first = first.next;
            }
    }

    @Override
    public T removeFirst() {
        if(first.next == first){
            return null;
        }
        T removeItem = first.next.item;
        first.next = first.next.next;
        first.next.prev = first;
        size--;
        return removeItem;
    }

    @Override
    public T removeLast() {
        if(first.prev == first){
            return null;

        }
        T removeItem = first.prev.item;
        first.prev = first.prev.prev;
        first.prev.next = first;
        size--;
        return removeItem;
    }

    @Override
    public T get(int index) {
     //   return null;
        if(index>=size){
            return null;
        }
        Node currentNode = first.next;
        while (index!=0){
            currentNode = currentNode.next;
            index--;
        }
        return currentNode.item;
    }
}
