package As2_League;

public class As3_Players {


    private String name;
    private String playername;
    private int age;
    private double winnings;

    public As3_Players(String n, String p, int a, double w){
        this.name = n;
        this.playername = p;
        this.age = a;
        this.winnings = w;
    }

    public String toString(){
        return name + ", " + playername + ", " + age + ", " + winnings;
    }

    public void printMe(){
        System.out.println(name + ", " + playername + ", " + age + ", " + winnings);
    }

    public String getName() {
        return name;
    }

    public String getPlayername() {
        return playername;
    }

    public int getAge() {
        return age;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public void addAge(int age){
        this.age += age;
    }
    public void addWinnings(double winningsadd){
        this.winnings += winningsadd;
    }
}
