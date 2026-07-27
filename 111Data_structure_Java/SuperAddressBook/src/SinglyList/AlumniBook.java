package SinglyList;
import java.util.Scanner;

public class AlumniBook {
    private StudentNode head; // 链表头节点

    public AlumniBook() {
        head = null;
    }

    // 添加学生记录
    public void add(Student student) {
        StudentNode node = new StudentNode(student);
        if (head == null) { // 如果链表为空，则直接插入到头部
            head = node;
        } else if (student.getSurname().compareTo(head.getStudent().getSurname()) < 0) { // 如果需要插入到头部
            node.setNext(head);
            head = node;
        } else { // 否则按姓氏顺序插入到链表中
            StudentNode p = head;
            while (p.getNext() != null && student.getSurname().compareTo(p.getNext().getStudent().getSurname()) > 0) {
                p = p.getNext();
            }
            node.setNext(p.getNext());
            p.setNext(node);
        }
    }

    // 根据学号删除学生记录
    public void delete(int id) {
        if (head == null) {
            System.out.println("没有找到学号为" + id + "的学生记录！");
            return;
        }

        if (head.getStudent().getId() == id) { // 如果要删除的学生记录为头节点
            head = head.getNext();
            return;
        }

        StudentNode p = head;
        while (p.getNext() != null && p.getNext().getStudent().getId() != id) {
            p = p.getNext();
        }

        if (p.getNext() == null) {
            System.out.println("没有找到学号为" + id + "的学生记录！");
            return;
        }

        p.setNext(p.getNext().getNext());
    }

    // 修改学生记录
    public void update(int id, Student newStudent) {
        if (head == null) {
            System.out.println("没有找到学号为" + id + "的学生记录！");
            return;
        }

        if (head.getStudent().getId() == id) { // 如果要修改的学生记录为头节点
            head.setNext(head.getNext());
            head = new StudentNode(newStudent);
            return;
        }

        StudentNode p = head;
        while (p.getNext() != null && p.getNext().getStudent().getId() != id) {
            p = p.getNext();
        }

        if (p.getNext() == null) {
            System.out.println("没有找到学号为" + id + "的学生记录！");
            return;
        }

        p.setNext(p.getNext().getNext());
        p.setNext(new StudentNode(newStudent));
    }

    // 查找学生记录
    public Student search(int id) {
        StudentNode p = head;
        while (p != null && p.getStudent().getId() != id) {
            p = p.getNext();
        }
        if (p == null) {
            System.out.println("没有找到学号为" + id + "的学生记录！");
            return null;
        } else {
            return p.getStudent();
        }
    }

    // 输出所有学生记录
    public void print() {
        StudentNode p = head;
        while (p != null) {
            System.out.println(p.getStudent());
            p = p.getNext();
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
            String surname = name.substring(0, 1); // 姓氏为姓名的第一个字
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
                    String surname = name.substring(0, 1); // 姓氏为姓名的第一个字
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
                    String updateSurname = updateName.substring(0, 1); // 姓氏为姓名的第一个字
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
class Student {
    private int id;
    private String name;
    private String surname; // 姓氏

    public Student(int id, String name, String surname) {
        this.id =id;
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
}
class StudentNode {
    private Student student;
    private StudentNode next;
    public StudentNode(Student student) {
        this.student = student;
        this.next = null;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}        
