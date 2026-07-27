package demo1;

class Node {
    public int data;
    public Node next;
    Node() {}
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class InsertNode {
    public Node head;
    public int size;

    //尾差法
    public void add(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            size++;
        } else {

            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            // 直接跟到最后
            cur.next = node;
            // 长度+1
            size++;
        }
    }

//    打印单链表
    public void printNode(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //归并排序
    public Node mergeSort(Node head) {

        //如果头结点为空或者只有头结点，返回头结点
        if (head == null || head.next == null) {
            return head;
        }

        // 设置快慢指针，找到链表中点，并将链表切分为两半
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;

        // 对两个链表分别进行排序
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        // 合并两个已排序的链表
        Node temp = new Node(0);
        Node cur = temp;
            //如果两个链表都不为空，依次对比赋值
        while (left != null && right != null) {
            if (left.data <= right.data) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if(left != null){
            cur.next = left;
        } else {
            cur.next = right;
        }

//        cur.next = (left != null) ? left : right;

        return temp.next;
    }


    //给排好序的单链表插入新的结点
    public void insert(int data) {
        Node node = new Node(data);
        //如果头结点为空，则直接插入
        if (head.next == null) {
            head.next = node;
            size++;
        }
        //如果头结点不为空，且要插入对的数小于第一个结点的值，插在头
        else if (head.data >= node.data) {
            node.next =head;
            head = node;
        }
        //寻找大于结点node的第一个值，插入到他的前面，直到找到最后一个，插到链表尾部
        else{
            Node cur = head.next;
            while(cur.next != null){
                if(cur.data <= node.data && cur.next.data <=node.data) {
                    cur = cur.next;
                }else if(cur.next.data >=node.data) {
                    node.next = cur.next;
                    cur.next = node;
                    break;
                }
            }

            cur.next = node;
            // 长度+1
            size++;
        }
    }
}


