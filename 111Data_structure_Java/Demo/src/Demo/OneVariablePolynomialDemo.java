package Demo;

import java.util.Scanner;

// 节点类

public class OneVariablePolynomialDemo {
    /**
     * 判断两个指数谁大
     *
     * @param e1 指数1
     * @param e2 指数2
     * @return 如果e1>e2返回1，如果e1<e2返回-1，如果e1=e2返回0
     */
    private static int compare(int e1, int e2) {
        // 比较两项指数e1和e2，根据大小等三种情况返回1、-1，0
        if (e1 > e2) {
            return 1;
        } else if (e1 < e2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static PolynomialNode attach(int coef, int expon, PolynomialNode rearNode) {
        // 创建一个新结点并存储指数项和系数项
        PolynomialNode newNode = new PolynomialNode();
        newNode.setCoef(coef);
        newNode.setExpon(expon);
        newNode.setNext(null);
        // 将新结点插入到当前结果表达式的后面，现在尾结点变成了newNode
        rearNode.setNext(newNode);
        // 将尾结点指向新插入的结点newNode
        rearNode = newNode;
        // 返回链表
        return rearNode;
    }


    public static void printNode(PolynomialNode node) {
        String polynomial = "";
        // 循环链表
        while (node != null) {
            // 判断系数和指数
            if (node.getCoef() == 1) {
                if (node.getExpon() == 1) {
                    polynomial += "+x";
                } else if (node.getExpon() == 0) {
                    polynomial += "+" + node.getCoef();
                } else if (node.getExpon() < 0) {
                    polynomial += "+" + node.getCoef() + "x^(" + node.getExpon() + ")";
                } else {
                    polynomial += "+" + "x^" + node.getExpon();
                }
            } else if (node.getCoef() == 0) {
                polynomial += "";
            } else if (node.getCoef() < 0) {
                if (node.getExpon() == 1) {
                    polynomial += "+(" + node.getCoef() + ")x";
                } else if (node.getExpon() == 0) {
                    polynomial += "+(" + node.getCoef() + ")";
                } else if (node.getExpon() < 0) {
                    polynomial += "+(" + node.getCoef() + ")x^(" + node.getExpon() + ")";
                } else {
                    polynomial += "+(" + node.getCoef() + ")x^" + node.getExpon();
                }
            } else {
                if (node.getExpon() == 1) {
                    polynomial += "+" + node.getCoef() + "x";
                } else if (node.getExpon() == 0) {
                    polynomial += "+" + node.getCoef();
                } else if (node.getExpon() < 0) {
                    polynomial += "+" + node.getCoef() + "x^(" + node.getExpon() + ")";
                } else {
                    polynomial += "+" + node.getCoef() + "x^" + node.getExpon();
                }
            }
            node = node.getNext();
        }
        System.out.println(polynomial.substring(1, polynomial.length()));
    }


    public static PolynomialNode polyAdd(PolynomialNode p1, PolynomialNode p2) {
        PolynomialNode front, rear, temp;
        int sum;
        // 为方便表头插入，先产生一个临时空结点作为结果多项式链表头
        rear = new PolynomialNode();
        // 由front记录结果多项式头结点
        front = rear;
        // 当两个多项式都有非零项待处理时
        while (p1 != null && p2 != null) {
            // 根据比较结点的指数返回的值进行操作
            switch (compare(p1.getExpon(), p2.getExpon())) {
                // P1中的数据项指数较大时
                case 1:
                    // 将P1的结点放到结果链表中并返回成功的结果链表
                    rear = attach(p1.getCoef(), p1.getExpon(), rear);
                    // 并将P1结点指向它的下一个结点
                    p1 = p1.getNext();
                    break;
                // P2中的数据项指数较大时
                case -1:
                    // 将P2的结点放到结果链表中并返回成功的结果链表
                    rear = attach(p2.getCoef(), p2.getExpon(), rear);
                    // 将P2结点指向它的下一个结点
                    p2 = p2.getNext();
                    break;
                // 两数据项指数相等
                case 0:
                    // 当指数相等时，让系数相加
                    sum = p1.getCoef() + p2.getCoef();
                    // 如果相加的系数不为0（大于或小于0都可）
                    if (sum != 0) {
                        //将该结点放到结果链表中并返回成功的结果链表
                        rear = attach(sum, p1.getExpon(), rear);
                    }
                    // 让P1结点和P2结点都指向下一个结点元素
                    p1 = p1.getNext();
                    p2 = p2.getNext();
                    break;
                default:
                    break;
            }
        }
        // 将未处理完的另一个多项式的所有结点依次复制到结果链表中
        for (; p1 != null; p1 = p1.getNext()) {
            rear = attach(p1.getCoef(), p1.getExpon(), rear);
        }
        for (; p2 != null; p2 = p2.getNext()) {
            rear = attach(p2.getCoef(), p2.getExpon(), rear);
        }
        rear.setNext(null);
        temp = front;
        // 使front指向结果多项式的第一个非零项
        front = front.getNext();
        return front;
    }

    public static void main(String[] args) {
        // 注意：一元多项式的各项要按照指数递减的顺序排列各项
        Scanner scanner = new Scanner(System.in);

        // 获取第一个多项式链表
        System.out.println("【注意：一元多项式的各项要按照指数递减的顺序排列各项】");
        System.out.print("请输入第一个多项式的项数：");
        PolynomialNode p1 = new PolynomialNode();
        // 保存头结点
        PolynomialNode front1 = p1;
        // 获取第一个多项式的项数
        int itemCount = scanner.nextInt();
        // 循环获取多项式的系数和指数
        for (int i = 1; i <= itemCount; i++) {
            System.out.print("第" + i + "项的系数是：");
            int coef = scanner.nextInt();
            System.out.print("第" + i + "项的指数是：");
            int expon = scanner.nextInt();
            // 创建新结点，将数据赋给结点元素
            PolynomialNode p = new PolynomialNode(coef, expon, null);
            p1.setNext(p);
            p1 = p;
        }
        // 打印第一个多项式
        System.out.print("p1(x)=");
        printNode(front1);

        // 获取第二个多项式链表
        System.out.print("请输入第二个多项式的项数：");
        PolynomialNode p2 = new PolynomialNode();
        // 保存头结点
        PolynomialNode front2 = p2;
        // 获取第二个多项式的项数
        int itemCount2 = scanner.nextInt();
        // 循环获取多项式的系数和指数
        for (int i = 1; i <= itemCount2; i++) {
            System.out.print("第" + i + "项的系数是：");
            int coef = scanner.nextInt();
            System.out.print("第" + i + "项的指数是：");
            int expon = scanner.nextInt();
            PolynomialNode p = new PolynomialNode(coef, expon, null);
            p2.setNext(p);
            p2 = p;
        }
        // 打印第一个多项式
        System.out.print("p2(x)=");
        printNode(front2);

        // 计算两个一元多项式相加
        System.out.print("p1(x)+p2(x)=");
        printNode(polyAdd(front1, front2));
    }
}

