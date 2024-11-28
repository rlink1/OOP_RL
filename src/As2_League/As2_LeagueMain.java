package As2_League;

import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;

public class As2_LeagueMain {
    public static void run() {
        ArrayList<As2_Team> allTeams = new ArrayList<>();

        loadFile("data/Teams_ClientData.csv", allTeams);

    }

    public static void loadFile(String filename, ArrayList<As2_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As2_Team(  tempArray[0],tempArray[1], Integer.parseInt(tempArray[2]), Integer.parseInt(tempArray[3]),Boolean.parseBoolean(tempArray[4]), Double.parseDouble(tempArray[5])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <Ex3_Client> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getAddress();
                toSave += "," + tempList.get(i).getLawnSize();
                toSave +="," + tempList.get(i).getHasDog();
                toSave +="," + tempList.get(i).getOutstandingFees();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile
}
