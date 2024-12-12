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

        for (int i = 0; i < allTeams.size(); i++) {
            if(allTeams.get(i).getOgName().equalsIgnoreCase("Team Falcons") ){
                allTeams.get(i).newPlayer("Peter Kata", "Peterbot", 17, 643724);
                allTeams.get(i).newPlayer("Fahad Almutairi", "FHD", 20, 0);
                allTeams.get(i).newPlayer("Tai Starčič", "TaySon", 20, 1209389);
                allTeams.get(i).newPlayer("Abdullah Albaqami", "GntL", 22, 137460);
                allTeams.get(i).newPlayer("Faisal Almusharraf", "Yonx", 20, 83700);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Dignitas")){
                allTeams.get(i).newPlayer("Abdullah Akhras", "Acron", 20, 684427);
                allTeams.get(i).newPlayer("Cooper Smith", "Cooper", 17, 0);
            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Twisted Minds")){
                allTeams.get(i).newPlayer("Aleksa Cvetkovic", "Queasy", 22, 1195845);
                allTeams.get(i).newPlayer("Hamad Almutairi", "Rapit", 21, 61375);
                allTeams.get(i).newPlayer("Salman", "Arrow", 21, 0);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Team Liquid")){
                allTeams.get(i).newPlayer("Edcarlos Santos", "EdRoadToGlory", 19, 143525);
                allTeams.get(i).newPlayer("Thales Henrique", "Pulga", 0, 48625);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Guild Esports")){
                allTeams.get(i).newPlayer("Henrik Mclean", "Hen", 19, 740947);
                allTeams.get(i).newPlayer("Błazej Surmacz", "Blacha", 19, 96103);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Solary")){
                allTeams.get(i).newPlayer("Naël A.", "Artskill", 18, 30050);
                allTeams.get(i).newPlayer("Manoël Da Costa", "Floki", 21, 0);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("PWR")){
                allTeams.get(i).newPlayer("Austin King", "Worthy", 21, 138712);
                allTeams.get(i).newPlayer("Sebastian", "Looter", 20, 98911);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Wave Esports")){
                allTeams.get(i).newPlayer("Ludwig Kainz", "Luuu", 34, 34123);
                allTeams.get(i).newPlayer("Francisco Oliveira", "Kikoo", 18, 31860);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("Agent Gaming")){
                allTeams.get(i).newPlayer("Logan Eschenburg", "Bucke", 21, 251786);
                allTeams.get(i).newPlayer("Evan Barron", "Cented", 23, 495409);

            }
            else if(allTeams.get(i).getOgName().equalsIgnoreCase("GameWith")){
                allTeams.get(i).newPlayer("unknown", "Chocoluv", 21, 300);
                allTeams.get(i).newPlayer("unknown", "Albedo", 19, 60385);

            }
        }

        System.out.println("TEAMS");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print all Teams");
            System.out.println("2.  Find Averages");
            System.out.println("3.  View age groups");
            System.out.println("4.  Sort by lowest winnings to highest");
            System.out.println("5.  Update Stats");
            System.out.println("6.  Print Players");
            System.out.println("7.  Update Players");
            System.out.println("8.  Exit and Save");

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



            } else if (choice == 6) {
                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.get(i).printPlayers();
                }

            } else if (choice == 7) {

                System.out.println("Enter the nickname (username) of the player you would like to update stats for");
                String searchFun = Library.input.nextLine();
                int foundIndex = -1;
                int mainint = -1;
                while(foundIndex == -1){

                    for (int i = 0; i < allTeams.size(); i++) {
                        foundIndex = searchByName1(allTeams.get(i).getPlayers(), searchFun);
                        if(foundIndex > -1){
                            mainint = i;
                            break;
                        }
                    }
                    break;

                }
                if(foundIndex > -1){

                    System.out.println("Updating " + searchFun + ":\n");
                    System.out.println("Did they change their real name?");
                    String temp1 = Library.input.nextLine();
                    if(temp1.startsWith("y")){
                        System.out.println("What is their new name?");
                        String tempName = Library.input.nextLine();
                        allTeams.get(mainint).getPlayers().get(foundIndex).setName(tempName);
                    }

                    System.out.println("Did they change their username?");
                    String temp2 = Library.input.nextLine();
                    if(temp2.startsWith("y")){
                        System.out.println("What is their new username??");
                        String tempNick = Library.input.nextLine();
                        allTeams.get(mainint).getPlayers().get(foundIndex).setPlayername(tempNick);
                    }

                    System.out.println("Would you like to change their age?");
                    String temp3 = Library.input.nextLine();
                    if(temp3.startsWith("y")){
                        System.out.println("What is their new age??");
                        int tempAge = Library.input.nextInt();
                        Library.input.nextLine();
                        allTeams.get(mainint).getPlayers().get(foundIndex).setAge(tempAge);
                    }

                    System.out.println("Did they win any more money?");
                    String temp4 = Library.input.nextLine();
                    if(temp4.startsWith("y")){
                        System.out.println("How much money have they won?");
                        double tempWins = Library.input.nextDouble();
                        Library.input.nextLine();
                        allTeams.get(mainint).getPlayers().get(foundIndex).addWinnings(tempWins);
                    }

                }else{
                    System.out.println("Invalid player name. Please try again.");
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
                list.add( new As2_Team(  tempArray[0],tempArray[1], Integer.parseInt(tempArray[2]), Integer.parseInt(tempArray[3]),Boolean.parseBoolean(tempArray[4]), Double.parseDouble(tempArray[5]), tempArray[6]   ));

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

    public static int searchByName1(ArrayList<As3_Players> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getPlayername() )){
                return i;
            }
        }
        return -1;
    }


}
