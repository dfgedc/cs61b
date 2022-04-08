

class LinkedListDeque<T>{
    public void printDeque() {
        Node node = head;
        while (node.right!=null){
            System.out.print(node.element+" ");
            node = node.right;
        }
    }

    class Node<T>{
        private T element;

        private Node<T> right;

        public Node(T element, Node<T> right) {
            this.element = element;
            this.right = right;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
    private int size = 0;
    private int len;
    Node<T> head ;
    Node<T> tail;

    public LinkedListDeque() {
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.setRight(tail);
    }

    public void addFirst(T item)
    {
        Node<T>  node= new Node<>(item,head);
        //  node  =head.right;
        head = node;
        size++;
    }
    public void addLast(T item)
    {
        Node<T> node = new Node<>(item,null);
        tail = node;
        size++;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public int size()
    {
        return size;
    }
    public void removeFirst()
    {
        if(size==0){
            return;
        }else{
            head = head.right;
            size--;
        }
    }
    public T removeLast()
    {
        if(size==0){
            return null;
        }else{
            T element = tail.element;
            tail.right = null;
            size --;
            return element;
        }

    }
    public T get(int index)
    {
        Node e = head;
        for (int i = 0; i < index; i++) {
            e = e.right;
        }
        return (T)e.getElement();
    }
}