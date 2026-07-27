package Demo;

public class Demo {
    public class inversionLink {
        public static void main(String args[]){
            //运用逆置算法1
            InversionNode Link1=new InversionNode();
            Link1.insertFromHead(1);
            Link1.insertFromHead(2);
            Link1.insertFromHead(3);
            Link1.insertFromHead(4);
            Link1.insertFromHead(5);
            Link1.printNode();
            Link1.inversion();
            Link1.printNode();

            //运用逆置算法2
            LinkList Link2=new LinkList();
            Link2.insertFromHead(6);
            Link2.insertFromHead(7);
            Link2.insertFromHead(8);
            Link2.insertFromHead(9);
            Link2.insertFromHead(10);
            Link2.printNode();
            Link2.inversion();
            Link2.printNode();
        }
    }
}
