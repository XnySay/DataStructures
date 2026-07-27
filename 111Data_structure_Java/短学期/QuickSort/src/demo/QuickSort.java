package demo;

import java.util.*;

public class QuickSort {
    public static void quickSort(List<Student> students, int left, int right) {
        if (left >= right) {
            return;
        }

        int flag = students.get(left + (right - left) / 2).totalScore;
        int i = left;
        int j = right;


        //从大到小，左边大右边小
        while (i <= j) {
            while (students.get(i).totalScore > flag) {
                i++;
            }
            while (students.get(j).totalScore < flag) {
                j--;
            }
            if (i <= j) {
                // 交换元素
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
                i++;
                j--;
            }
        }

        quickSort(students, left, j);
        quickSort(students, i, right);
    }
}
