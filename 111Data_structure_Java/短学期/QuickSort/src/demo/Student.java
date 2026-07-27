package demo;



public class Student {
    String name;
    int chinese;
    int math;
    int english;
    int totalScore;
    int rank;

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.totalScore = chinese + math + english;
        this.rank = 0;
    }
}
