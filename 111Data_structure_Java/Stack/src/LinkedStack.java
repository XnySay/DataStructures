public class LinkedStack {
    private Node top = null; // 栈顶

// 入栈
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

// 出栈
    public int pop() {
        if (top == null) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

// 判断栈是否为空
    public boolean isEmpty() {
        return top == null;
    }

// 遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        Node temp = top;
        System.out.print("链栈中元素为：");
        while (temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }
    private class Node {
        private int data; // 数据
        private Node next; // 指向下一个节点的指针

        public Node(int data) {
            this.data = data;
        }
    }
}