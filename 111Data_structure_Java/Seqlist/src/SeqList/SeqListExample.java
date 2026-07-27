package SeqList;
import java.util.Scanner;
    //联系人类
class Person {
    private String name;
    private String phone;
    private String email;

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 重写 toString() 方法，用于打印联系人信息
    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email;
    }
}

// 定义一个通讯录类，使用一个数组来存储联系人
class AddressBook {
    private Person[] people;
    private int size;

    // 构造函数，创建指定大小的通讯录
    public AddressBook(int capacity) {
        people = new Person[capacity];
        size = 0;
    }

    // 向通讯录中添加联系人
    public boolean add(Person person) {
        if (size >= people.length) {
            System.out.println("Address book is full.");
            return false;
        } else {
            people[size] = person;
            size++;
            System.out.println("Added: " + person.getName());
            return true;
        }
    }
    // 从通讯录中删除指定姓名的联系人
    public boolean delete(String name) {
        int index = findIndex(name);
        if (index == -1) {
            System.out.println(name + " not found.");
            return false;
        } else {
            for (int i = index; i < size - 1; i++) {
                people[i] = people[i + 1];
            }
            people[size - 1] = null;
            size--;
            System.out.println("Deleted: " + name);
            return true;
        }
    }

    // 显示通讯录中的所有联系人
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Person " + (i + 1) + "\n" + people[i] + "\n");
        }
    }

    public void search(String name) {
        int index = findIndex(name);
        if (index == -1) {
            System.out.println(name + " not found.");
        } else {
            System.out.println("Person " + (index + 1) + "\n" + people[index] + "\n");
        }
    }
    public boolean modify(String name, String phone, String email) {
        int index = findIndex(name);
        if (index == -1) {
            System.out.println(name + " not found.");
            return false;
        } else {
            people[index].setPhone(phone);
            people[index].setEmail(email);
            System.out.println("Modified: " + name);
            return true;
        }
    }

    // 修改通讯录中指定姓名的联系人的电话号码和电子邮件地址
    private int findIndex(String name) {
        for (int i = 0; i < size; i++) {
            if (people[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

public class SeqListExample{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AddressBook addressBook = new AddressBook(10);

        while (true) {
            System.out.println("通讯录功能");
            System.out.println("1. 添加");
            System.out.println("2. 删除");
            System.out.println("3. 显示所有");
            System.out.println("4. 查询");
            System.out.println("5. 修改");
            System.out.println("6. Exit");
            System.out.print("请选择(1-6): ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("输入名字: ");
                    String name = input.nextLine();
                    System.out.print("输入电话号码: ");
                    String phone = input.nextLine();
                    System.out.print("输入邮件地址: ");
                    String email = input.nextLine();
                    addressBook.add(new Person(name, phone, email));
                    break;
                case 2:
                    System.out.print("输入名字: ");
                    name = input.nextLine();
                    addressBook.delete(name);
                    break;
                case 3:
                    addressBook.display();
                    break;
                case 4:
                    System.out.print("输入名字: ");
                    name = input.nextLine();
                    addressBook.search(name);
                    break;
                case 5:
                    System.out.print("输入名字: ");
                    name = input.nextLine();
                    System.out.print("输入新的电话号码: ");
                    phone = input.nextLine();
                    System.out.print("输入新的电子邮件: ");
                    email = input.nextLine();
                    addressBook.modify(name, phone, email);
                    break;
                case 6:
                    System.out.println("退出.");
                    System.exit(0);
                default:
                    System.out.println("无效指令，请重新输入.");
            }

            System.out.println();
        }
    }
}