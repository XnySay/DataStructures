package parkinglot;

class Car {
    public String[] msg;
    public int arrivalTime;
    public int departureTime;

    public String getId(){
        return msg[1];
    }

    public String[] getMsg() {
        return msg;
    }

    public int getArrivalTime() {

        return arrivalTime;
    }

    public void setEntries(String msg){
        this.arrivalTime = Integer.parseInt(msg);
    }

    public void setDepartureTime(String[] msg) {
        this.departureTime = Integer.parseInt(msg[2]);
    }

    public Car(String[] msg) {
        if(msg[0].equals("A")){
            this.msg = msg;
            this.arrivalTime =Integer.parseInt(msg[2]);
        }else{
            this.departureTime =Integer.parseInt(msg[2]);
        }
    }
    public void money(){
        int a = this.arrivalTime;
        int b = this.departureTime;

        if(b-a < 30){
            System.out.printf("尊敬的%s车主，停留时间不足30，本次停车不收取费用\n",msg[1]);
        }else{
            double c = (b-a)/30;
            System.out.printf("尊敬的%s车主，停车费为1$/30，本次停车时长%d，共收取费用%.2f\n",msg[1],b-a,c);
        }
    }
}




