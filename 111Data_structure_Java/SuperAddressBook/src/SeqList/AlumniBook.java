package SeqList;

import java.util.Scanner;
import java.util.Arrays;

public class AlumniBook {
    private static final int MAX_SIZE = 100; // 最大记录数
    private Student[] students; // 学生记录数组
    private int size; // 当前记录数

    public AlumniBook() {
        students = new Student[MAX_SIZE];
        size = 0;
    }

    // 添加学生记录
    public void add(Student student) {
        if (size >= MAX_SIZE) {
            System.out.println("已达到最大记录数，无法添加！");
            return;
        }

        students[size++] = student;
        Arrays.sort(students, 0, size); // 按姓氏排序
    }

    // 根据学号删除学生记录
    public void delete(int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--size] = null;
                return;
            }
        }
        System.out.println("没有找到学号为" + id + "的学生记录！");
    }

    // 修改学生记录
    public void update(int id, Student newStudent) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                students[i] = newStudent;
                Arrays.sort(students, 0, size); // 按姓氏排序
                return;
            }
        }
        System.out.println("没有找到学号为" + id + "的学生记录！");
    }

    // 查找学生记录
    public Student search(int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        System.out.println("没有找到学号为" + id + "的学生记录！");
        return null;
    }

    // 输出所有学生记录
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    // 从控制台读取学生记录信息并添加到记录中
    public void inputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生记录信息，每行输入一个学生的学号和姓名，以空格分隔。输入end表示输入结束。");
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            String[] parts = line.split(" ");
            if (parts.length != 2) {
                System.out.println("输入格式错误，请重新输入！");
                continue;
            }
            int id;
            try {
                id = Integer.parseInt(parts[0]);
            } catch (NumberFormatException e) {
                System.out.println("学号必须是整数，请重新输入！");
                continue;
            }
            String name = parts[1];
            String surname = name.substring(0, 1); // 截取姓名的第一个字作为姓氏
            Student student = new Student(id, name, surname);
            add(student);
        }
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        AlumniBook record = new AlumniBook();
        record.inputFromConsole(); // 从控制台读取学生记录信息并添加到记录中
        while (true) {
            System.out.println("请输入操作编号：1-添加，2-删除，3-修改，4-查找，5-输出所有，6-退出");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("请输入学生的学号和姓名，以空格分隔：");
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    String surname = name.substring(0, 1); // 截取姓名的第一个字作为姓氏
                    Student student = new Student(id, name, surname);
                    record.add(student);
                    System.out.println("添加成功！");
                    break;
                case 2:
                    System.out.println("请输入要删除的学生的学号：");
                    int deleteId = scanner.nextInt();
                    record.delete(deleteId);
                    break;
                case 3:
                    System.out.println("请输入要修改的学生的学号和姓名，以空格分隔：");
                    int updateId = scanner.nextInt();
                    String updateName = scanner.next();
                    String updateSurname = updateName.substring(0, 1); // 截取姓名的第一个字作为姓氏
                    Student updateStudent = new Student(updateId, updateName, updateSurname);
                    record.update(updateId, updateStudent);
                    break;
                case 4:
                    System.out.println("请输入要查找的学生的学号：");
                    int searchId = scanner.nextInt();
                    Student searchStudent = record.search(searchId);
                    if (searchStudent != null) {
                        System.out.println("找到学生：" + searchStudent);
                    }
                    break;
                case 5:
                    record.print();
                    break;
                case 6:
                    System.out.println("程序结束。");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效操作！");
                    break;
            }
        }
    }
}

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String surname;

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "学号：" + id + "，姓名：" + name + "，姓氏：" + surname;
    }

    // 按姓氏排序
    @Override
    public int compareTo(Student o) {
        return this.surname.compareTo(o.surname);
    }
}

