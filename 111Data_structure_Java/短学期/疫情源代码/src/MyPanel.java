import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 主面板。
 *
 * @ClassName: MyPanel
 * @Description: 主面板
 * @author: Bruce Young
 * @date: 2020年02月02日 17:03
 */
public class MyPanel extends JPanel implements Runnable {

    /**
     * 构造方法，由于继承自JPanel，super父类方法，并设置背景颜色
     */
    public MyPanel() {
        super();
        this.setBackground(new Color(0x444444));
    }

    /**
     * 【思路】
     * 1. paint方法为JPanel的一个方法，这个方法会在整个类运行时调用，并且具有重新绘制功能。
     * 2. 需要绘制的有：医院边框，医院字体，统计字体，人群以及颜色
     * 3. 遍历人群队列，根据每个人的坐标属性，以及state属性，判断是否感染，每个人为3*3的小圆点表示
     * 4. 统计数据功能：只需要遍历人群池中的人群状态，对不同状态进行统计即可。
     * @param g
     */

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0x00ff00));//设置医院边界颜色
        //绘制医院边界
        g.drawRect(Hospital.getInstance().getX(), Hospital.getInstance().getY(),
                Hospital.getInstance().getWidth(), Hospital.getInstance().getHeight());
        g.setFont(new Font("微软雅黑", Font.BOLD, 16));
        g.setColor(new Color(0x00ff00));
        g.drawString("医院", Hospital.getInstance().getX() + Hospital.getInstance().getWidth() / 4, Hospital.getInstance().getY() - 16);
        //绘制代表人类的圆点
        List<Person> people = PersonPool.getInstance().getPersonList();
        if (people == null) {
            return;
        }
        for (Person person : people) {
            switch (person.getState()) {
                case Person.State.NORMAL: {
                    //健康人
                    g.setColor(new Color(0xdddddd));
                    break;
                }
                case Person.State.SHADOW: {
                    //潜伏期感染者
                    g.setColor(new Color(0xffee00));
                    break;
                }

                case Person.State.CONFIRMED: {
                    //确诊患者
                    g.setColor(new Color(0xff0000));
                    break;
                }
                case Person.State.FREEZE: {
                    //已隔离者
                    g.setColor(new Color(0x48FFFC));
                    break;
                }
                case Person.State.DEATH: {
                    //死亡患者

                    g.setColor(new Color(0x000000));
                    break;
                }
            }
            person.update();//对各种状态的市民进行不同的处理
            g.fillOval(person.getX(), person.getY(), 3, 3);

        }

        int captionStartOffsetX = 700 + Hospital.getInstance().getWidth() + 40;
        int captionStartOffsetY = 40;
        int captionSize = 24;


        /**
         *【功能】显示数据信息，设置颜色
         * 显示数据时，已经在调用 getPeopleSize方法对不同人群进行统计
         */

        g.setColor(Color.WHITE);
        g.drawString("城市总人数：" + Constants.CITY_PERSON_SIZE, captionStartOffsetX, captionStartOffsetY);
        g.setColor(new Color(0xdddddd));
        g.drawString("健康者人数：" + PersonPool.getInstance().getPeopleSize(Person.State.NORMAL), captionStartOffsetX, captionStartOffsetY + captionSize);
        g.setColor(new Color(0xffee00));
        g.drawString("潜伏期人数：" + PersonPool.getInstance().getPeopleSize(Person.State.SHADOW), captionStartOffsetX, captionStartOffsetY + 2 * captionSize);
        g.setColor(new Color(0xff0000));
        g.drawString("发病者人数：" + PersonPool.getInstance().getPeopleSize(Person.State.CONFIRMED), captionStartOffsetX, captionStartOffsetY + 3 * captionSize);
        g.setColor(new Color(0x48FFFC));
        g.drawString("已隔离人数：" + PersonPool.getInstance().getPeopleSize(Person.State.FREEZE), captionStartOffsetX, captionStartOffsetY + 4 * captionSize);
        g.setColor(new Color(0x00ff00));
        g.drawString("空余病床：" + Math.max(Constants.BED_COUNT - PersonPool.getInstance().getPeopleSize(Person.State.FREEZE), 0), captionStartOffsetX, captionStartOffsetY + 5 * captionSize);
        g.setColor(new Color(0xE39476));
        //暂定急需病床数量为 NEED = 确诊发病者数量 - 已隔离住院数量
        //
        int needBeds = PersonPool.getInstance().getPeopleSize(Person.State.CONFIRMED)
                - PersonPool.getInstance().getPeopleSize(Person.State.FREEZE);

        g.drawString("急需病床：" + (needBeds > 0 ? needBeds : 0), captionStartOffsetX, captionStartOffsetY + 6 * captionSize);
        g.setColor(new Color(0xccbbcc));
        g.drawString("病死人数：" + PersonPool.getInstance().getPeopleSize(Person.State.DEATH), captionStartOffsetX, captionStartOffsetY + 7 * captionSize);
        g.setColor(new Color(0xffffff));
        g.drawString("世界时间（天）：" + (int) (worldTime / 10.0), captionStartOffsetX, captionStartOffsetY + 8 * captionSize);

    }


    public static int worldTime = 0;//世界时间

    /**
     * 【思路】：定义一个计时器，每隔一定时间调用repaint（）方法，重新绘制整个面板并统计数据
     */
    public Timer timer = new Timer();

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MyPanel.this.repaint();
            worldTime++;//每次绘制表示过了一天
        }
    }

    /**
     * 【思路】：这个run方法为多线程Runnable需要重写的方法
     * 1. myPnaelThread.start调用这个方法
     * 2. 启动计时器任务
     */
    @Override
    public void run() {
        timer.schedule(new MyTimerTask(), 0, 100);//启动世界计时器，时间开始流动，间隔100毫秒
    }


}
