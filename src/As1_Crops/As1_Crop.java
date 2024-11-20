package As1_Crops;

import java.util.ArrayList;

public class As1_Crop {
    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;

    public As1_Crop(String n, double y, String u, double p) {
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;
    }
    public String toString(){
        return name + " " + yield + " " + units + " " + price + " " + acres;
    }

    public String getName() {
        return name;
    }

    public void setAcres(int acres) {
        this.acres = acres;
    }
    public void addAcres(int acres){
        this.acres = this.acres + acres;
    }
    public void printMe(){
        System.out.println("Crop: " + name + ", Amount yield: " + yield + " " + units + ", Price: " + price + ", Amount of Acres: " + acres);
    }

    public double harvest(){
       double total = this.price * this.yield * this.acres;
        System.out.println("Harvest value:  $" + total);
        this.acres = 0;
        return total;
    }

}
