import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 医院
 * <p>
 * 床位容量
 *
 * @ClassName: Hospital
 * @Description: 医院，包含床位容量
 * @author: Bruce Young
 * @date: 2020年02月02日 20:58
 */
public class Hospital extends Point {
    /**
     * 【思路】：医院采用单例模式，主要通过设置一些属性，用于绘制医院边框和床位
     * 1. 左上角锚点（720， 80）
     * 2. 长宽，宽随床位变化而变化
     * 3. 病床队列，初始化全为空。
     * 4. 获取和归还床位方法
     */
    public static final int HOSPITAL_X = 720;
    public static final int HOSPITAL_Y = 80;
    private int width;
    private int height = 600;

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    private static Hospital hospital = new Hospital();

    public static Hospital getInstance() {
        return hospital;
    }

    private Point point = new Point(HOSPITAL_X, HOSPITAL_Y);//第一个床位所在坐标，用于给其他床位定绝对坐标
    private List<Bed> beds = new ArrayList<>();

    /**
     * 获取所有床位
     *
     * @return
     */
    public List<Bed> getBeds() {
        return beds;
    }

    private Hospital() {
        //医院矩形所在坐标
        super(HOSPITAL_X, HOSPITAL_Y + 10);
        //根据床位数量调整医院矩形的大小
        if (Constants.BED_COUNT == 0) {
            width = 0;
            height = 0;
        }
        //根据医院床位数量计算医院宽度
        //因为高度定了只能装载100个床位
        int column = Constants.BED_COUNT / 100;
        width = column * 6;
        //根据第一个床位坐标初始化其他床位的坐标
        for (int i = 0; i < column; i++) {

            for (int j = 10; j <= 606; j += 6) {

                Bed bed = new Bed(point.getX() + i * 6, point.getY() + j);
                beds.add(bed);
                if (beds.size() >= Constants.BED_COUNT) {//确定医院床位承载数量
                    break;
                }
            }

        }
    }

    /**
     *  获取病床方法：根据beds队列，返回一个病床。如果没有可用病床，返回空。
     *
     *
     * @return
     */
    public Bed pickBed() {
        for (Bed bed : beds) {
            if (bed.isEmpty()) {
                return bed;
            }
        }
        return null;
    }

    /**
     * 死亡或痊愈出院空出床位
     * 归还病床方法：医院中存在死亡和治愈现象，归还病床。
     *
     * @param bed
     * @return
     */
    public Bed returnBed(Bed bed) {
        if (bed != null) {
            bed.setEmpty(true);
        }
        return bed;
    }
}
