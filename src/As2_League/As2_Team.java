package As2_League;

import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;

public class As2_Team {

    private String nickname;
    private String city;
    private int avgAge;
    private int numTourneys;
    private Boolean hasWon;
    private double totalMoney;

    public As2_Team(String n, String c, int a, int t, Boolean w, double m){
        nickname = n;
        city = c;
        avgAge = a;
        numTourneys = t;
        hasWon = w;
        totalMoney = m;
    }
        public void printMe(){
            System.out.println("Team Name: " + this.nickname + ", City/Country: " + this.city + ", Average Age: " + this.avgAge + ", Number of Tournaments " + this.numTourneys + ", Has won: " +this.hasWon + ", Total Winning earnings: " +this.totalMoney);
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
}
