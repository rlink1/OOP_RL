package Examples;

public class Ex3_Client {

    private String name;
    private String address;
    private int lawnSize;
    private boolean hasDog;
    private double outstandingFees;

    //constructor method

    public Ex3_Client(String n, String a, int l, boolean d){
        name = n;
        address = a;
        lawnSize = l;
        hasDog = d;
        outstandingFees = 0;
    }//constructor

    public String toString(){
        return name + " " + address + " " + lawnSize + " " + hasDog + " " + outstandingFees;
    }

    public String getName() {
        return name;
    }

    public void printMe(){
        System.out.println();
        System.out.println();
    }

    public void setHasDog(boolean hasDog) {
        this.hasDog = hasDog;
    }



    public void mowLawn(){
        double baseFee = 30;

        if( lawnSize > 200 ){
            baseFee += 0.1 * lawnSize;
        }

        if( hasDog){
            baseFee += 50;
        }

        outstandingFees += baseFee;

//        System.out.println(name + " your lawn was mowed today for a charge of $" + baseFee);
//        System.out.println("Your outstanding fees are $" + outstandingFees);
    }
    public void processPayment(double dollars){
        outstandingFees -= dollars;
        System.out.println(name + " you currently owe $" + outstandingFees);
    }

    public void deliquent(){
        double interest = 5 + outstandingFees * 0.1;
        System.out.println(name + " your payment is overdue, you've been charged interest of " + interest);
        outstandingFees += interest;

        if(outstandingFees > 500 && hasDog){
            hasDog = false;
        }
    }
}
