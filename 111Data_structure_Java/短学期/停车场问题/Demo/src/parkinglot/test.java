package parkinglot;


import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        int record = 0, fixed = 0;

        ParkingLotManagement parkingLotManagement = new ParkingLotManagement(2);


        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = ",";
        while (true) {
            System.out.println("请输入字符串（输入“(E,0,0)”停止）：");
            input = scanner.nextLine();

            if (input.equals("(E,0,0)")) {
                break;
            }

            input = input.replaceAll("[()]", "");
            String[] a = input.split(regex);

            record = Integer.parseInt(a[2]);

            if(record < fixed){
                System.out.println("数据有误，请重新输入");
            }else{
                parkingLotManagement.record(a);
                fixed = record;
            }
        }
        scanner.close();
    }

}

