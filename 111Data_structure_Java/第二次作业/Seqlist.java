//public class Seqlist<T> {
//
//    protected static int n;//顺序表元素个数
//    protected static Object[] element;//顺序表元素
//
//    public static final int MIN_CAPCITY = 16;//顺序表最小容量
//
//
//    //构造函数指定了长度
//    public Seqlist(int length) {
//        if (length < MIN_CAPCITY) {
//            length = MIN_CAPCITY;
//        }
//        //System.out.println("已经调用");
//        this.element = new Object[length];
//        this.n = 0;
//
//    }
//
//    //构造函数什么都未指定，默认长度
//    //如果未指定长度，this方法自动调用其他构造方法
//    public Seqlist() {
//
//        this(MIN_CAPCITY);
//
//    }
//
//    //构造函数指定数组
//    public Seqlist(T[] values) {
//
//        this(values.length * 2);//this方法调用指定长度的构造方法
//        for (int i = 0; i < values.length; i++) {
//            if (values[i] != null) {
//                this.element[this.n++] = values[i];
//            }
//        }
//    }
//
//
//    /*
//     public boolean isEmpty()
//     判断是否为空
//     return:  是否为空
//     */
//    public static boolean isEmpty() {
//        return (n == 0);
//    }
//
//
//    /*
//    public T get(int i)
//    指定元素，返回元素
//    i：要返回元素的索引
//     */
//    public T get(int i) {
//
//        if (i >= 0 && i <= n) {
//            return (T) this.element[i];
//        }
//
//        return null;
//    }
//
//
//    /*
//    public void set(int i,T x)
//    指定元素进行赋值
//    i：指定元素位置索引
//    x：元素的值
//     */
//    public void set(int i, T x) {
//
//        if (x == null) {
//            throw new NullPointerException("X=NULL");
//        }
//
//        if (i >= 0 && i <= this.n) {
//            element[i] = x;
//        } else {
//            throw new ArrayIndexOutOfBoundsException(i + "");
//        }
//
//    }
//
//
//    /*
//     public int getSize()
//     返回顺序表长度
//     return:返回元素的长度，如果没有则返回-1
//     */
//    public static int getSize() {
//        if (n >= 0) {
//            return n;
//        }
//
//        return -1;
//        //return null;
//    }
//
//    /*
//    public int insert(int k, T e)
//    指定索引，插入元素
//    k:指定索引
//    e:要插入的元素
//    return；返回插入的索引
//     */
//    public int insert(int k, T e) {
//        if (e == null) {return -1;}// 为空则return-1
//        if (k < 0) {k = 0;} //如果小于0，就查到头部
//        if (k >this.n) {k = this.n;} //如果要插入的位置大于当前数组元素数量，就插到尾部
//
//        //数组扩容
//        //如果没有扩容，source就是创建了一个相同的数组，为下面的插入进行准备
//        //如果做了扩容，也是一样
//        Object[] source = this.element;//如果不扩容，操作source和element都一样
//        if(this.n == this.element.length){
//            this.element = new Object[source.length*2];//进行扩容
//            for (int j = 0;  j < this.n; j++) {
//                element[j] = source[j];//进行赋值
//            }
//        }
//
//        //进行插入
//        //利用source进行插入
//        int m = 0;
//        for (int j = this.n - 1; j > k; j--) {
//            this.element[j+1] = source[j];
//        }
//        this.element[k] = e;
//        this.n++;
//
//
//        return k;
//    }
//
//    /*
//    public T delete(int index)
//    删除,并返回删除的元素
//    index:要删除元素的索引
//    return:被删除的元素
//     */
//    public T delete(int index){
//
//        //没有元素，无发删除
//        //大于存储的元素数量无法删除
//        //负数索引不行
//        if( n == 0 || index >n || index < 0){
//            return null;
//        }
//
//        //存储要删除的元素，作为返回值
//        T temp = (T)element[index];
//
//        //如果是删除尾部元素，直接删除
//        if( index == n ){
//             this.element[index] = null;
//        }
//
//        //进行删除
//        for (int k = index; k < this.n - 1; k++){
//            //T temp;
//            element[k] = element[k + 1];
//        }
//        element[this.n-1] = null;
//        this.n--;
//        return temp;
//    }
//
//
//    /*
//    public void clear()
//    清空所有元素
//     */
//    public void clear(){ this.n = 0;}
//
//    /*
//    public int search(T key)
//    进行查找
//    key；要查找的元素
//    return: 如果找到该元素，则返回该元素索引
//    否则，返回-1，为没有找到该元素
//     */
//
//    public int search(T key){
//
//        for (int i = 0; i < this.n; i++) {
//
//            if(key.equals(this.element[i])){
//                return i;
//            }
//        }
//        return -1;
//
//
//    }
//
//    //逆置算法1
//    public void InversionList(){
//		if(isEmpty()){
//			//判断是否为空
//			System.out.println("顺序表为空");
//		}else{
//			//临时变量
//			T temp;
//			for (int i = 0; i < getSize()/2; i++) {
//				temp=(T) element[i];//利用临时变量存储前半的元素，以进行对换
//				element[i]=element[getSize()-i-1];
//				element[getSize()-i-1] =temp;
//			}
//		}
//	}
//
//    //逆置算法2
//    public static <T extends Object>void InversionList2(Seqlist<Integer> a){
//        if(isEmpty()){
//			//判断是否为空
//			System.out.println("顺序表为空");
//		}else{
//            for(int i=0;i<getSize()/2;i++){
//                //出发点是不利用临时变量占用空间，但仍需要引入变量用以计算
//                int x=(int) element[i];
//                int y=(int) element[getSize()-1];
//                y=x+y;//通过两个需对调的元素的自我加减实现对调
//                x=y-x;
//                y=y-x;
//                element[i]=x;
//                element[getSize()-1]=y;
//            }
//        }
//    }
//
//	// 正序输出顺序表中所有元素
//	public void print() {
//		for (int i = 0; i < getSize(); i++)
//			System.out.print(element[i] + " ");
//		System.out.println();
//	}
//
//public static void main(String[] args) {
//    //逆置方法1
//    Seqlist<Integer> sq = new Seqlist<Integer>(5);
//    sq.insert(1, 1);
//    sq.insert(2, 2);
//    sq.insert(3, 3);
//    sq.insert(4, 4);
//    sq.insert(5, 5);
//    System.out.print("转置前");
//    sq.print();
//    sq.InversionList();
//    System.out.print("转置后");
//    sq.print();
//
//    //逆置算法2
//    int[] a={12,23,35,49,56};
//    Seqlist<Integer> La = new Seqlist<Integer>();
//    for(int i=0;i<a.length;i++)
//        La.insert(a[i], i+1);
//        System.out.println("逆置前顺序表La中的数据元素:");
//        La.print();
//        InversionList2(La);
//        System.out.println("逆置后顺序表La中的数据元素为:");
//        La.print();
//    }
//}
//
//
