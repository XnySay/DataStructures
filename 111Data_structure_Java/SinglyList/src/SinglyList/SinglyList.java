package SinglyList;

import java.util.Scanner;

public class SinglyList{
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("单链表式通讯录:");
            System.out.println("1. 添加");
            System.out.println("2. 删除");
            System.out.println("3. 全部显示");
            System.out.println("4. 查找");
            System.out.println("5. 修改");
            System.out.println("6. 退出");
            System.out.print("输入你的选择: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 ->
                    addressBook.add();
                case 2->
                    addressBook.delete();
                case 3->
                    addressBook.display();
                case 4->
                    addressBook.search();
                case 5->
                    addressBook.modify();
                case 6-> {
                    System.out.println("拜拜!");
                    scanner.close();
                }
                default->
                    System.out.println("重新输入.");
            }
        }
    }
}

