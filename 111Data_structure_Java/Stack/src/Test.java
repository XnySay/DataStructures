public class Test {
    public static void main(String args[]){
        ArrayStack arrayStack = new ArrayStack(9);
        LinkedStack linkedStack = new LinkedStack();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.push(9);
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        linkedStack.push(6);
        linkedStack.push(7);
        linkedStack.push(8);
        linkedStack.push(9);
        arrayStack.list();
        System.out.print("\n");
        linkedStack.list();

        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        System.out.print("\n");
        arrayStack.list();
        linkedStack.list();
    }
}
