package parkinglot;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParkingLotManagement {

    Stack<Car> parkingLot;
    //等候区（暂停便道）
    Queue<Car> waitingQueue;
    //让路便道
    Stack<Car> giveWayStack;

    int total;


    ParkingLotManagement(int total){
        this.total = total;
        waitingQueue = new LinkedList<>();
        giveWayStack = new Stack<>();
        parkingLot = new Stack<>();
    }

    //传值
    public void record(String[] msg){
        if(msg[0].equals("A")){
            this.carArrival(msg);
        } else if(msg[0].equals("D")) {
            this.carDeparture(msg);
        }

    }

    //车辆到达
    public void carArrival(String[] msg) {

        Car newCar = new Car(msg);
        if (parkingLot.size() < total) {
            parkingLot.push(newCar);
            System.out.printf("可以停车，车主%s\n",msg[1]);


        } else {
            System.out.printf("停车场满了，车主%s，请等待\n",msg[1]);
            waitingQueue.offer(newCar);
        }
    }

    //车辆离开
    public void carDeparture(String[] msg){

        boolean found = false;
        while(!parkingLot.isEmpty()) {

            Car car = parkingLot.pop();

            if(car.getId().equals(msg[1])) {

                car.setDepartureTime(msg);
                car.money();
                found = true;
                break;
            } else {
                giveWayStack.push(car);
            }
        }
        while (!giveWayStack.isEmpty()) {
            parkingLot.push(giveWayStack.pop());
        }

        while(!waitingQueue.isEmpty() && !found) {

            Car car = waitingQueue.poll();

            if(car.getId().equals(msg[1])) {
                System.out.println("车辆" + msg[1] + "从等待区离开");
                found = true;
                break;
            }else {
                giveWayStack.push(car);
            }
        }
        while (!giveWayStack.isEmpty()) {
            parkingLot.push(giveWayStack.pop());
        }

        if (!found) {
            System.out.println("车辆" + msg[1] + "不在停车场和等待区.");
        }

        parkCars(msg);
    }

    void parkCars(String[] a) {

        while(!waitingQueue.isEmpty() && parkingLot.size() < this.total){
            Car car = waitingQueue.poll();
            car.setEntries(a[2]);
            parkingLot.push(car);
            System.out.println("车辆" + car.getId() + "从等待区进入停车场,进入时间为" + car.getArrivalTime());
        }

    }
}
