package demo;

public class Polynomial {
    private ListNode head;

    // 构造函数，生成一个空链表头
    public Polynomial() {
        head = new ListNode(-1, -1);
    }

    // 添加项函数
    public void addTerm(int coefficient, int exponent) {
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.exponent > exponent) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null && curr.exponent == exponent) {
            curr.coefficient += coefficient;
            if (curr.coefficient == 0) { // 删除系数为0的节点
                prev.next = curr.next;
            }
        } else {
            ListNode newNode = new ListNode(coefficient, exponent);
            prev.next = newNode;
            newNode.next = curr;
        }
    }

    // 加法运算函数
    public Polynomial plus(Polynomial other) {
        Polynomial result = new Polynomial();
        ListNode l1 = this.head.next;
        ListNode l2 = other.head.next;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.addTerm(l2.coefficient, l2.exponent);
                l2 = l2.next;
            } else if (l2 == null) {
                result.addTerm(l1.coefficient, l1.exponent);
                l1 = l1.next;
            } else if (l1.exponent == l2.exponent) {
                int sum = l1.coefficient + l2.coefficient;
                if (sum != 0) {
                    result.addTerm(sum, l1.exponent);
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.exponent > l2.exponent) {
                result.addTerm(l1.coefficient, l1.exponent);
                l1 = l1.next;
            } else {
                result.addTerm(l2.coefficient, l2.exponent);
                l2 = l2.next;
            }
        }
        return result;
    }

    // 减法运算函数
    public Polynomial minus(Polynomial other) {
        Polynomial result = new Polynomial();
        ListNode l1 = this.head.next;
        ListNode l2 = other.head.next;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.addTerm(-l2.coefficient, l2.exponent);
                l2 = l2.next;
            } else if (l2 == null) {
                result.addTerm(l1.coefficient, l1.exponent);
                l1 = l1.next;
            } else if (l1.exponent == l2.exponent) {
                int diff = l1.coefficient - l2.coefficient;
                if (diff != 0) {
                    result.addTerm(diff, l1.exponent);
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.exponent > l2.exponent) {
                result.addTerm(l1.coefficient, l1.exponent);
                l1 = l1.next;
            } else {
                result.addTerm(-l2.coefficient, l2.exponent);
                l2 = l2.next;
            }
        }
        return result;
    }

    // 输出多项式
    public void print() {
        ListNode curr = head.next;
        while (curr != null) {
            System.out.print(curr.coefficient + "x^" + curr.exponent + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.addTerm(2, 2);
        p1.addTerm(3, 3);
        p1.addTerm(4, 4);
        p1.addTerm(-3, 2);
        System.out.print("p1: ");
        p1.print();

        Polynomial p2 = new Polynomial();
        p2.addTerm(2, 3);
        p2.addTerm(-3, 3);
        p2.addTerm(9, 2);
        p2.addTerm(-5, 2);
        p2.addTerm(9, 5);
        System.out.print("p2: ");
        p2.print();

        Polynomial p3 = p1.plus(p2);
        System.out.print("p1 + p2: ");
        p3.print();

        Polynomial p4 = p1.minus(p2);
        System.out.print("p1 - p2: ");
        p4.print();
    }

}
