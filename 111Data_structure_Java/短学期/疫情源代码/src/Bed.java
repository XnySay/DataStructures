/**
 * 床位
 *
 *
 * @ClassName: Bed
 * @Description: 床位
 * @author: Bruce Young
 * @date: 2020年02月02日 21:00
 */
public class Bed extends Point {
    /**
     * 【思路】床位在绘制时，不需要重新绘制床位，只需将隔离人群的坐标更新为床位的坐标，将人移动到医院边框内
     * 每次床位增加，城市中减少一个患者。也就是说，绘制时，床位即为人群个体（3*3的小圆点）
     *
     * 1. 继承自 Point方法，参考自己写的Point类，只有x,y两个坐标属性
     * 2. 需要调用父类方法
     * 3. 新增属性判断床位是否为空
     * @param x
     * @param y
     */
    public Bed(int x, int y) {
        super(x, y);
    }

    /**
     * 是否占用了该床位
     */
    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
