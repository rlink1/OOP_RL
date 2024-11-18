package As1_Crops;

import java.util.ArrayList;

public class As1_Main {
    public static void run() {
        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(new As1_Crop("Oats", 58.7, "bu/acre", 3.69)  );
        allCrops.add(new As1_Crop( "Barley", 47.4, "bu/acre", 5.10)  );
        allCrops.add(new As1_Crop("Canola",  	38.1, "bu/acre", 16.44)  );
        allCrops.add(new As1_Crop("Flaxseed", 16.9 , "bu/acre", 12.00)  );
        allCrops.add(new As1_Crop("All rye", 55.0, "bu/acre", 9.26)  );

        for (int i = 0; i < allCrops.size(); i++) {
            System.out.println(allCrops.get(i).toString());
        }



    }
}
