package demo1;

public class Test {
    public static void main(String[] args){
        InsertNode node = new InsertNode();
        node.add(7);
        node.add(57);
        node.add(75);
        node.add(76);
        node.add(67);
        node.add(76);
        node.add(799);
        node.printNode();
        node.mergeSort(node.head);
        node.printNode();
        node.insert(6);
        node.printNode();
        node.insert(999);
        node.printNode();
        node.insert(33);
        node.printNode();
    }

}
