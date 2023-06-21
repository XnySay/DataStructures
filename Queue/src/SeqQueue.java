public class SeqQueue<E> {
    private static final int QUWUE_CAPACITY = 1000;
    private Object[] elementData;




    private int rear;
    private int front;



    public SeqQueue(){
        this.elementData = new Object[QUWUE_CAPACITY];
        this.front = -1;
        this.rear = -1;
    }



    //入队
    public void push(E data){
        //判断队列是否已满
        if (this.rear + 1 >= QUWUE_CAPACITY){
            throw new RuntimeException("队列已满，入队失败！");
        }
        ++rear;
        this.elementData[rear] = data;
    }


    //队头出队
    public E pop(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，出队失败！");
        }
        ++front;
        return (E) this.elementData[front];
    }

    public E peek(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，获取队头失败！");
        }
        return (E) this.elementData[front+1];
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }



    //打印元素
    public void print(){
        if (isEmpty()){
            System.out.println("此时为空队列！");
            return;
        }
        System.out.println("队列中共有" + (rear-front) + "个元素，内部元素为：");
        for (int i = front+1;i <= rear; ++i){
            System.out.println(elementData[i] + " ");
        }
        System.out.println();
    }
}
