package demo;

import java.util.*;

public class Analysis {

    public static void printAnalysis(List<Student> students) {
        // 计算每个科目的平均分、最高分和最低分
        int chineseTotal = 0;
        int mathTotal = 0;
        int englishTotal = 0;

        int chineseMax = 0;
        int mathMax = 0;
        int englishMax = 0;
        int chineseMin = 0;
        int mathMin = 0;
        int englishMin = 0;


        for (Student student : students) {
            chineseTotal += student.chinese;
            mathTotal += student.math;
            englishTotal += student.english;
            chineseMax = Math.max(chineseMax, student.chinese);
            mathMax = Math.max(mathMax, student.math);
            englishMax = Math.max(englishMax, student.english);
            chineseMin = Math.min(chineseMin, student.chinese);
            mathMin = Math.min(mathMin, student.math);
            englishMin = Math.min(englishMin, student.english);
        }


        int n = students.size();

        double chineseAvg = (double) chineseTotal / n;
        double mathAvg = (double) mathTotal / n;
        double englishAvg = (double) englishTotal / n;
        System.out.printf("语文平均分：%.2f，最高分：%d，最低分：%d\n", chineseAvg, chineseMax, chineseMin);
        System.out.printf("数学平均分：%.2f，最高分：%d，最低分：%d\n", mathAvg, mathMax, mathMin);
        System.out.printf("英语平均分：%.2f，最高分：%d，最低分：%d\n", englishAvg, englishMax, englishMin);
    }

}
