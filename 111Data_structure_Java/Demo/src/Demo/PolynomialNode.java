package Demo;

public class PolynomialNode {
    private int coef;// 存储的一元多项式的系数
    private int expon;// 存储的一元多项式的指数
    private PolynomialNode next;// 下一个结点引用指针

    public PolynomialNode() {
        super();
    }

    public PolynomialNode(int coef, int expon, PolynomialNode next) {
        super();
        this.coef = coef;
        this.expon = expon;
        this.next = next;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExpon() {
        return expon;
    }

    public void setExpon(int expon) {
        this.expon = expon;
    }

    public PolynomialNode getNext() {
        return next;
    }

    public void setNext(PolynomialNode next) {
        this.next = next;
    }
}
