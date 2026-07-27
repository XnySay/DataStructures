package SinglyList;

import java.util.Scanner;

public class AddressBook {
    private Person head;
    private int size;
    private Scanner scanner;

    // 构造函数，创建空的通讯录
    public AddressBook() {
        head = null;
        size = 0;
        scanner = new Scanner(System.in);
    }

    // 向通讯录中添加联系人
    public void add() {
        System.out.print("输入名字: ");
        String name = scanner.nextLine();
        System.out.print("输入电话号码:");
        String phone = scanner.nextLine();
        System.out.print("输入邮箱: ");
        String email = scanner.nextLine();
        Person person = new Person(name, phone, email);
        if (head == null) {
            head = person;
        } else {
            Person p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = person;
        }
        size++;
        System.out.println("Added: " + person.getName());
    }

    // 从通讯录中删除指定姓名的联系人
    public void delete() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Person p = head;
        Person prev = null;
        while (p != null) {
            if (p.getName().equals(name)) {
                if (prev == null) {
                    head = p.next;
                } else {
                    prev.next = p.next;
                }
                size--;
                System.out.println("Deleted: " + name);
                return;
            }
            prev = p;
            p = p.next;
        }
        System.out.println(name + " not found.");
    }

    // 显示通讯录中的所有联系人
    public void display() {
        if (head == null) {
            System.out.println("通讯录为空.");
        } else {
            Person p = head;
            int i = 1;
            while (p != null) {
                System.out.println("Person " + i + "\n" + p + "\n");
                p = p.next;
                i++;
            }
        }
    }

    // 在通讯录中查找指定姓名的联系人，并输出它的信息
    public void search() {
        System.out.print("输入名字: ");
        String name = scanner.nextLine();
        Person p = head;
        int i = 1;
        while (p != null) {
            if (p.getName().equals(name)) {
                System.out.println("Person " + i + "\n" + p + "\n");
                return;
            }
            p = p.next;
            i++;
        }
        System.out.println(name + " not found.");
    }

    // 修改通讯录中指定姓名的联系人的电话号码和电子邮件地址
    public void modify() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Person p = head;
        while (p != null) {
            if (p.getName().equals(name)) {
                System.out.print("Enter new phone number: ");
                String phone = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();
                p.setPhone(phone);
                p.setEmail(email);
                System.out.println("Modified: " + p.getName());
                return;
            }
            p = p.next;
        }
        System.out.println(name + " not found.");
    }
}

