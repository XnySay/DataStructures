package demo;

import java.util.*;


public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生人数：");
        int n = scanner.nextInt();


        List<Student> students = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            System.out.printf("请输入第%d个学生的姓名和成绩（学生：语文、数学、英语）：", i + 1);
            String input = scanner.next();


            String[] parts = input.split(":")[1].split(",");
            String name = input.split(":")[0];

            int chinese = Integer.parseInt(parts[0]);
            int math = Integer.parseInt(parts[1]);
            int english = Integer.parseInt(parts[2]);

            students.add(new Student(name, chinese, math, english));
        }



        // 使用快速排序按总分排序
        QuickSort.quickSort(students, 0, students.size() - 1);



        // 分配排名
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || students.get(i).totalScore != students.get(i - 1).totalScore) {
                students.get(i).rank = rank;
            } else {
                students.get(i).rank = students.get(i - 1).rank;
            }
            rank++;
        }

        // 输出每个学生的姓名和分数
        System.out.println("排序结果：");
        for (Student student : students) {
            System.out.printf("%s，总分：%d，语文：%d，数学：%d，英语：%d，名次：%d\n",
                    student.name, student.totalScore, student.chinese, student.math, student.english, student.rank);
        }

        // 输出数据分析
        Analysis.printAnalysis(students);
    }
}
