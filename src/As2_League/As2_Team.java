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

}
