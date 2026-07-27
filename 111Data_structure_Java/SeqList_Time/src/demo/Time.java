package demo;

import java.util.ArrayList;
import java.util.List;

class SequenceList<T> {

    final int maxSize = 10;
    private T[] listArray;
    private int length;
    // 顺序表的初始化
    public SequenceList() {
        length = 0; // 线性表初始化为空
        listArray = (T[]) new Object[maxSize];
    }

    public SequenceList(int n) {
        if (n <= 0) {
            System.out.println("error!");
            System.exit(1);
        }
        length = 0; // 线性表初始化为空
        listArray = (T[]) new Object[n];

    }
    // 顺序表的插入
    public boolean add(T obj, int pos) {
        if (pos < 1 || pos > length + 1) {
            System.out.println("pos值不合法");
            return false;
        }
        // 顺序表数组空间已满，则重新分配存储空间
        if (length == listArray.length) {
            T[] p = (T[]) new Object[length * 2];
            for (int i = 0; i < length; i++)
                p[i] = listArray[i];
            listArray = p;
        }
        // 顺序表数组空间没满，则从数组存储数据的最后一位开始，逐位往后移一位，直到pos位置
        for (int i = length; i >= pos; i--) {
            listArray[i] = listArray[i - 1];
        }
        listArray[pos - 1] = obj;
        length++;
        return true;
    }

    // 删除顺序表中第pos个位置的元素
    public T remove(int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空，无法执行删除操作");
            return null;
        } else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return null;
            }
            T x = listArray[pos - 1]; // 取得pos位置的元素
            // 删除位置后的所有元素往前移一位
            for (int i = pos; i <= length; i++) {
                listArray[i - 1] = listArray[i];
            }
            length--;
            return x;

        }

    }

    // 在顺序表中查找元素obj出现的位置
    public int find(T obj) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return -1;
        } else {
            for (int i = 0; i < length; i++)
                if (listArray[i].equals(obj))
                    return i + 1;
            return -1;
        }
    }

    // 获取顺序表第pos个位置的元素
    public T value(int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return null;
        } else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return null;
            }
            return listArray[pos - 1];
        }
    }

    // 修改顺序表第pos个位置的元素
    public boolean modify(T obj, int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return false;
        } else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return false;
            }
            listArray[pos - 1] = obj;
            return true;
        }
    }

    // 判断顺序表是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    // 求顺序表的长度
    public int Size() {
        return length;

    }

    // 正序输出顺序表中所有元素
    public void nextOrder() {
        for (int i = 0; i < length; i++)
            System.out.print(listArray[i] + " ");
        System.out.println();
    }

    // 清空顺序表
    public void clear() {
        length = 0;

    }
    //就地逆置算法方法1
    public static <T extends Object>void SqInversion(SequenceList<T> a){
        int i,j;
        for(i=1,j=a.Size();i<=j;i++,j--){
            T temp = a.value(i);
            a.modify(a.value(j), i);
            a.modify(temp, j);
        }
    }
    //就地逆置算法方法2
    public void getInversionList(){
        if(isEmpty()){
            //判断是否为空
            System.out.println("顺序表为空");
        }else{
            //临时变量
            T temp;
            for (int i = 0; i < Size()/2; i++) {
                temp=(T) listArray[i];
                listArray[i]=listArray[Size()-i-1];
                listArray[Size()-i-1] =temp;
            }
        }
    }

    public static void main(String[] args) {
        //方法1的用法
        SequenceList<Integer> sq = new SequenceList<Integer>(5);
        sq.add(1, 1);
        sq.add(2, 2);
        sq.add(3, 3);
        sq.add(4, 4);
        sq.add(5, 5);
        System.out.print("转置前");
        sq.nextOrder();
        sq.getInversionList();
        System.out.print("转置后");
        sq.nextOrder();

        //方法2的用法
        int[] a={12,23,35,49,56};
        SequenceList<Integer> La = new SequenceList<Integer>();
        for(int i=0;i<a.length;i++)
            La.add(a[i], i+1);
        System.out.println("逆置前顺序表La中的数据元素为：");
        La.nextOrder();
        SqInversion(La);
        System.out.println("逆置后顺序表La中的数据元素为：");
        La.nextOrder();
    }

}

