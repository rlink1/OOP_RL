package As2_League;

import As1_Crops.As1_Crop;
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
            System.out.println("4.  Sort by lowest winnings to highest");
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
                System.out.println("Average age range: " + (avgavgAge/allTeams.size()) + "\nAverage number of Tournaments Played: " + (avgTourneys/ allTeams.size()) + "\nAverage amount of winning money per team: " + (avgMoney/ allTeams.size()));

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
                System.out.println("\nSort by Won earning:\n");
            sortByEarnings(allTeams);

            } else if (choice == 5) {
                System.out.println("Enter the name of the team you would like to update stats for");
                String searchFun = Library.input.nextLine();
                int foundIndex = searchByName(allTeams, searchFun);
                if(foundIndex > -1){

                    System.out.println("Updating " + searchFun + ":\n");
                    System.out.println("Did they change locations?");
                    String temp1 = Library.input.nextLine();
                    if(temp1.startsWith("y")){
                        System.out.println("What is their new location?");
                        String tempLoc = Library.input.nextLine();
                        allTeams.get(foundIndex).setCity(tempLoc);
                    }

                    System.out.println("Did they play in any more tournaments?");
                    String temp2 = Library.input.nextLine();
                    if(temp2.startsWith("y")){
                        System.out.println("How many more tournaments did they play in?");
                        int tempTourn = Library.input.nextInt();
                        Library.input.nextLine();
                        allTeams.get(foundIndex).setNumTourneys(tempTourn);
                    }

                    System.out.println("Did they win any tournaments?");
                    String temp3 = Library.input.nextLine();
                    if(temp3.startsWith("y")){
                        allTeams.get(foundIndex).setHasWon(true);
                    }

                    System.out.println("Did they win any more money?");
                    String temp4 = Library.input.nextLine();
                    if(temp4.startsWith("y")){
                        System.out.println("How much money have they won?");
                        double tempWins = Library.input.nextDouble();
                        Library.input.nextLine();
                        allTeams.get(foundIndex).setTotalMoney(tempWins);
                    }

                }else{
                    Boolean tempWon = false;

                    System.out.println("Adding " + searchFun + "\n\nWhere is " + searchFun + " located?");
                    String tempLoc = Library.input.nextLine();

                    System.out.println("What is the average age range of " + searchFun + "?");
                    int tempAge = Library.input.nextInt();
                    Library.input.nextLine();

                    System.out.println("How many tournaments has " + searchFun + " played in?");
                    int tempTourn = Library.input.nextInt();
                    Library.input.nextLine();

                    System.out.println("Has " + searchFun + " won any of these tournaments?");
                    String tempCheck = Library.input.nextLine();
                    if(tempCheck.startsWith("y")){
                        tempWon = true;
                    }

                    System.out.println("How much money has " + searchFun + " won?");
                    double tempMoney = Library.input.nextDouble();
                    Library.input.nextLine();

                    allTeams.add( new As2_Team(searchFun, tempLoc, tempAge, tempTourn, tempWon, tempMoney));

                }



            } else {
                boolean check = false;
                System.out.println("Would you like to save?");
                String temp = Library.input.nextLine();
                if(temp.startsWith("y")){
                    saveFile("data/Teams_ClientData.csv", allTeams);
                }
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

    public static void sortByEarnings(ArrayList<As2_Team> list) {


        for(int i=0; i<list.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j< list.size(); j++){
                if(list.get(j).getTotalMoney() < list.get(lowestIndex).getTotalMoney()){
                    lowestIndex = j;
                }
            }
            //swap the data
            As2_Team temp = list.get(i);
            list.set(i, list.get(lowestIndex) );
            list.set(lowestIndex, temp);

        }

    }

    public static int searchByName(ArrayList<As2_Team> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getNickname() )){
                return i;
            }
        }
        return -1;
    }


}
