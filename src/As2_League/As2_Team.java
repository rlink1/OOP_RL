package As2_League;

import java.util.ArrayList;

public class As2_Team {

    private String nickname;
    private String city;
    private int avgAge;
    private int numTourneys;
    private Boolean hasWon;
    private double totalMoney;
    private String ogName;

    private ArrayList<As3_Players> allPlayers;

    public As2_Team(String n, String c, int a, int t, Boolean w, double m){
        nickname = n;
        city = c;
        avgAge = a;
        numTourneys = t;
        hasWon = w;
        totalMoney = m;
        allPlayers = new ArrayList<>();

    }

    public As2_Team(String n, String c, int a, int t, Boolean w, double m, String ogn){
        nickname = n;
        city = c;
        avgAge = a;
        numTourneys = t;
        hasWon = w;
        totalMoney = m;
        allPlayers = new ArrayList<>();
        ogName = ogn;


        ArrayList<As3_Players> allPlayers = new ArrayList<>();
    }


        public void printMe(){
            System.out.println("Team Name: " + this.nickname + ", City/Country: " + this.city + ", Average Age: " + this.avgAge + ", Number of Tournaments " + this.numTourneys + ", Has won: " +this.hasWon + ", Total Winning earnings: " +this.totalMoney);
        }

        public void printPlayers(){
            System.out.println( "\n\n" + this.nickname + "'s Players:");
                for (int i = 0; i < this.allPlayers.size(); i++) {
                    System.out.println("\nName: " + this.allPlayers.get(i).getName() + ", Nickname: " + this.allPlayers.get(i).getPlayername() + ", Age: " + this.allPlayers.get(i).getAge() + ", Total Winnings: " + this.allPlayers.get(i).getWinnings());
                }

        }

    public void printPlayers2(){
        double totalM = 0;
        System.out.println( "\n\n" + this.nickname + "'s Players:");
        for (int i = 0; i < this.allPlayers.size(); i++) {
            System.out.println("\nName: " + this.allPlayers.get(i).getName() + ", Nickname: " + this.allPlayers.get(i).getPlayername() + ", Age: " + this.allPlayers.get(i).getAge() + ", Total Winnings: " + this.allPlayers.get(i).getWinnings());
            totalM = totalM + this.allPlayers.get(i).getWinnings();
        }
        System.out.println("\nTotal money: " + totalM);

    }

        public ArrayList<As3_Players> getPlayers(){
        return allPlayers;
        }
    public String getNickname() {
        return nickname;
    }

    public String getCity() {
        return city;
    }

    public int getAvgAge() {
        return avgAge;
    }

    public int getNumTourneys() {
        return numTourneys;
    }

    public Boolean getHasWon() {
        return hasWon;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public String getOgName(){
        return ogName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvgAge(int avgAge) {
        this.avgAge = avgAge;
    }

    public void setNumTourneys(int numTourneys) {
        this.numTourneys += numTourneys;
    }

    public void setHasWon(Boolean hasWon) {
        this.hasWon = hasWon;
    }
    public void setTotalMoney(double totalMoney) {
        this.totalMoney += totalMoney;
    }

    public void newPlayer(String n, String p, int a, double w){
        allPlayers.add(new As3_Players(n,p,a,w));
    }
}
