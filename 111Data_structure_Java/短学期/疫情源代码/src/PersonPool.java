import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 区域人群对象池
 *
 * @ClassName: PersonPool
 * @Description: 区域人群对象池，该地区假设为一个近似封闭的环境，拥有几乎不变的民众数量
 * @author: Bruce Young
 * @date: 2020年02月02日 17:21
 */
public class PersonPool {
    /**
     * 【思路】：
     * 1. 人群池，初始化一次
     * 2. 拥有统计不同人群状态的人数，用于绘制信息数据
     */
    private static PersonPool personPool = new PersonPool();

    public static PersonPool getInstance() {
        return personPool;
    }

    List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }


    /**
     * 【思路】：由于市民的状态采用数字表示，输入数字，统计不同状态的人数
     * @param state 市民类型 Person.State的值，若为-1则返回当前总数目
     * @return 获取指定人群数量
     */
    public int getPeopleSize(int state) {
        if (state == -1) {
            return personList.size();
        }
        int i = 0;
        for (Person person : personList) {
            if (person.getState() == state) {
                i++;
            }
        }
        return i;
    }

    /**
     * 私有构造方法，只调用一次，初始化所有市民的初始坐标，采用正态分布随机赋值
     */
    private PersonPool() {
        City city = new City(400, 400);//设置城市中心为坐标(400,400)
        //添加城市居民
        for (int i = 0; i < Constants.CITY_PERSON_SIZE; i++) {
            Random random = new Random();
            //产生N(a,b)的数：Math.sqrt(b)*random.nextGaussian()+a
            int x = (int) (100 * random.nextGaussian() + city.getCenterX());
            int y = (int) (100 * random.nextGaussian() + city.getCenterY());
            if (x > 700) {
                x = 700;
            }
            personList.add(new Person(city, x, y));
        }
    }
}
