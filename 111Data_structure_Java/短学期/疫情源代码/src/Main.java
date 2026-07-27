import javax.swing.*;

import java.util.List;
import java.util.Random;

/**
 * 模拟程序主入口
 *
 * @author
 * @comment GinRyan
 */
public class Main {

    /**
     * 【程序的入口】阅读代码从这里开始，整个程序设计者的思路充分利用到了单例模式，
     *              没有重复初始化对象，整个程序中有很多对象只用初始化一次：
     * 程序中主要使用到三个对象：
     * 1. Hospital:医院，存放绘制医院的所需要的属性，医院中的病床
     * 2. PersonPool：存放全市市民，以及根据市民患病状态统计人数方法
     * 3. beds:存放医院中的所有的床位，床位本质为市民，只是将隔离的市民移至医院，更新坐标
     * @param args
     */


    public static void main(String[] args) {
        /**
         * 【程序思路】
         * 1. 初始化医院对象，只需要初始化一次，获取医院的左上角锚点，宽高，初始化医院的病床队列
         * 2. 初始化画板，定义基本的画板属性，
         *
         */

        initHospital();//初始化医院的对象，可以跳转到Hospital.class看医院的代码，然后转回这里
        initPanel();//初始化画板，
        initInfected();//初始化最初的感染者【比较简单】
    }

    /**
     * 初始化画布
     * 【思路】
     * 1. 采用java中GUI API，定义了一个MyPanel类，继承自JPanel，并实现多线程接口
     * 2. 新定义类可绘制JPanel 组件，并采用多线程运行
     * 3. 设置一些基本的标题等等，启动绘制MyPanel线程运行，这个线程将会调用一系列的人群移动，感染传播方法，并多次更新绘制
     *
     */
    private static void initPanel() {
        MyPanel p = new MyPanel();
        Thread panelThread = new Thread(p);
        //定义新的画布，并设置画布的一些基本属性
        JFrame frame = new JFrame();
        frame.add(p);//将绘制的组件添加到画布中
        frame.setSize(Constants.CITY_WIDTH + hospitalWidth + 300, Constants.CITY_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("瘟疫传播模拟");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelThread.start();//开启画布线程，即世界线程，接着看代码的下一站可以转MyPanel.java
    }

    private static int hospitalWidth;

    /**
     * 初始化医院参数
     * 【思路】
     * 1. 医院类采用单例模式，当调用获取医院宽度时，已经初始化了整个医院，只初始化一次
     *
     */
    private static void initHospital() {
        hospitalWidth = Hospital.getInstance().getWidth();
    }

    /**
     * 初始化初始感染者
     * 【思路】
     * 1. 获取人群池中的所有人群队列，人群池表示整个城市的所有人群，只初始化一次
     * 2. 采用随机算法，对人群池中的人群进行初始化随机感染。例如最初的50个感染源
     */
    private static void initInfected() {
        List<Person> people = PersonPool.getInstance().getPersonList();//获取所有的市民
        for (int i = 0; i < Constants.ORIGINAL_COUNT; i++) {
            Person person;
            do {
                person = people.get(new Random().nextInt(people.size() - 1));//随机挑选一个市民
            } while (person.isInfected());//如果该市民已经被感染，重新挑选
            person.beInfected();//让这个幸运的市民成为感染者
        }
    }

}
