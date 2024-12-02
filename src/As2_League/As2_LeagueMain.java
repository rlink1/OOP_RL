package As2_League;

import Examples.Ex3_Client;
import Examples.Library;

import java.io.*;
import java.util.ArrayList;

public class As2_LeagueMain {
    public static void run() {
        ArrayList<As2_Team> allTeams = new ArrayList<>();

        loadFile("data/Teams_ClientData.csv", allTeams);

        System.out.println("TEAMS");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print all Teams");
            System.out.println("2.  Find Averages");
            System.out.println("3.  View age groups");
            System.out.println("4.  Sort by number of tournaments played");
            System.out.println("5.  Update Stats");
            System.out.println("6.  Exit and Save");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {

                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.get(i).printMe();
                }

            } else if (choice == 2) {
                double avgavgAge = 0;
                double avgTourneys = 0;
                double avgMoney = 0;


                for (int i = 0; i < allTeams.size(); i++) {
                    avgavgAge = allTeams.get(i).getAvgAge() + avgavgAge;
                    avgTourneys = allTeams.get(i).getNumTourneys() + avgTourneys;
                    avgMoney = allTeams.get(i).getTotalMoney() + avgMoney;
                }
                System.out.println("Average age range: " + (avgavgAge/ allTeams.size()) + "\nAverage number of Tournaments Played: " + (avgTourneys/ allTeams.size()) + "\nAverage amount of winning money per team: " + (avgMoney/ allTeams.size()));

            } else if (choice == 3) {
                System.out.println("View age range\nWhat age range are you looking for?");
                Boolean check = false;


                int searchTerm = Library.input.nextInt();
                Library.input.nextLine();


                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getAvgAge() == searchTerm){
                        check = true;
                        allTeams.get(i).printMe();
                    }

                }
                if(check == false){
                    System.out.println("No age range found, please try again");
                }



            } else if (choice == 4) {

            } else if (choice == 5) {


            } else {
                saveFile("data/Teams_ClientData.csv", allTeams);
                break;
            }
        } // while
        System.out.println("There is no use teamin as there is no team like teams teaming.  \nGood bye.");

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

    public static void saveFile(String filename, ArrayList <As2_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getNickname();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave += "," + tempList.get(i).getAvgAge();
                toSave +="," + tempList.get(i).getNumTourneys();
                toSave +="," + tempList.get(i).getHasWon();
                toSave +="," + tempList.get(i).getTotalMoney();

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
