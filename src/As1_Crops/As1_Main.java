package As1_Crops;

import Examples.Ex3_Client;
import Examples.Library;

import java.util.ArrayList;

public class As1_Main {
    public static void run() {
        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(new As1_Crop("Oats", 58.7, "bu/acre", 3.69)  );
        allCrops.add(new As1_Crop( "Barley", 47.4, "bu/acre", 5.10)  );
        allCrops.add(new As1_Crop("Canola",  	38.1, "bu/acre", 16.44)  );
        allCrops.add(new As1_Crop("Flaxseed", 16.9 , "bu/acre", 12.00)  );
        allCrops.add(new As1_Crop("All rye", 55.0, "bu/acre", 9.26)  );



        allCrops.get(0).setAcres( 200 );
        allCrops.get(1).setAcres( 300 );
        allCrops.get(2).setAcres( 100 );
        allCrops.get(3).setAcres( 50 );
        allCrops.get(4).setAcres( 350 );

        System.out.println("CROP MANAGEMENT SIR YES SIR.");
        double totalValue = 0;
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print farm summary");
            System.out.println("2.  Search & harvest a crop");
            System.out.println("3.  Get total revenue");
            System.out.println("4.  Plant a crop");
            System.out.println("5.  Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {
                for (int i = 0; i < allCrops.size(); i++) {
                   allCrops.get(i).printMe();
                }
            } else if (choice == 2) {
                System.out.println("Please enter the name of a crop");
                String cropSearch = Library.input.nextLine();
                int foundIndex = searchByName(allCrops, cropSearch);
                if(foundIndex > -1){
                   allCrops.get(foundIndex).printMe();
                    System.out.println("Would you like to harvest this crop?");
                    String yorn = Library.input.nextLine();
                    if(yorn.contains("y")){
                       totalValue = totalValue + allCrops.get(foundIndex).harvest();
                    }
                }
                else{
                    System.out.println("Not found, please try again");
                }
            } else if (choice == 3) {
                System.out.println("Total revenue from all harvested crops:  $" + totalValue);

            } else if (choice == 4) {
                System.out.println("Please enter the name of a crop");
                String cropSearch = Library.input.nextLine();
                System.out.println("How much acres (whole number) of this crop do you want to plant?");
                int cropAdd = Library.input.nextInt();
                Library.input.nextLine();
                int foundIndex = searchByName(allCrops, cropSearch);
                if(foundIndex > -1){
                    allCrops.get(foundIndex).addAcres(cropAdd);

                }
                else{
                    System.out.println("Planting " + cropSearch);


                    System.out.println("How much yield does " + cropSearch + " (double) have?");
                    double tempy = Library.input.nextDouble();
                    Library.input.nextLine();


                    System.out.println("How much can you buy " + cropSearch + " (double) for 1 bu/acre?");
                    double tempp = Library.input.nextDouble();

                    allCrops.add(new As1_Crop(cropSearch, tempy, "bu/acre", tempp, cropAdd));
                }
            } else if (choice == 5) {
                break;
            }
        } // while
        System.out.println("There is no use moanin as there is no mow like CROP MANAGEMENT SIR YES SIR.  \nGood bye.");
    }
    public static int searchByName(ArrayList<As1_Crop> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }
}
