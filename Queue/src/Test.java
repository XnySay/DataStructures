import java.util.Scanner;


public class Test {
    public static void main(String[] args) {


        LinkedQueue<String> queue = new LinkedQueue<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("请选择操作(顺序存储)：");
            System.out.println("1. 入队列");
            System.out.println("2. 出队列");
            System.out.println("3. 显示当前队列元素");
            System.out.println("4. 退出");
            System.out.print("输入数字选择操作：");
            choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    System.out.print("请输入要入队列的元素(顺序存储)：");
                    String data = scanner.nextLine();
                    queue.push(data);
                    System.out.println("元素 " + data + " 入队列成功！(顺序存储)");
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("队列为空，无法出队列！(顺序存储)");
                    } else {
                        String poppedElement = queue.pop();
                        System.out.println("出队列的元素为(顺序存储)：" + poppedElement);
                    }
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    System.out.println("(顺序存储)程序退出！");
                    break;
                default:
                    System.out.println("无效的选择！");
                    break;
            }
        }

        LinkedQueue<String> queue_link = new LinkedQueue<>();
        Scanner scanner_link = new Scanner(System.in);
        int choice_link = 0;

        while (choice_link != 4) {
            System.out.println("请选择操作(链式存储)：");
            System.out.println("1. 入队列");
            System.out.println("2. 出队列");
            System.out.println("3. 显示当前队列元素");
            System.out.println("4. 退出");
            System.out.print("输入数字选择操作：");
            choice_link = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice_link) {
                case 1:
                    System.out.print("请输入要入队列的元素(链式存储)：");
                    String data = scanner.nextLine();
                    queue.push(data);
                    System.out.println("元素 " + data + " 入队列成功！(链式存储)");
                    break;
                case 2:
                    try {
                        String poppedElement = queue.pop();
                        System.out.println("出队列的元素为(链式存储)：" + poppedElement);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    System.out.println("程序退出！");
                    break;
                default:
                    System.out.println("无效的选择！");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }





}
