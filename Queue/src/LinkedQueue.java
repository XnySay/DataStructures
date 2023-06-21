public class LinkedQueue<E> {
    private int size;
    Node front;
    Node rear;


    public LinkedQueue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return size == 0 || (this.front == null && this.rear == null);
    }


    public void push(E data) {
        // 创建一个新元素
        Node newNode = new Node(data);

        if (isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            // 使旧队尾元素的后继next指向新元素
            this.rear.next = newNode;
            // 使队尾指针指向新元素
            this.rear = newNode;
        }

        // size自增
        ++size;
    }


    //出队
    public E pop() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，出队失败! ");
        }

        // 如果队列不为空，则执行出队列操作
        E data = this.front.data;
        this.front = this.front.next;

        // 若仅有一个元素，则使rear指向front
        if (this.size == 1) {
            this.rear = this.front;
        }

        // size自减
        --size;

        return data;
    }

    public void print() {
        System.out.print("链表长度为：" + size + "，内部元素为：");
        Node node = front;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private class Node {
        private final E data;
        private Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
