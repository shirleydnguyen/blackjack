public class player {
    String name = "";
    int roundsWon = 0;
    int roundsLost = 0;

    public player(){
    }

    public void addName(String inName) {
        name = inName;
    }

    public void won(){
        roundsWon++;
    }

    public void lost(){
        roundsLost++;
    }

    public int getWins() {
        return roundsWon;
    }

    public int getLosses(){
        return roundsLost;
    }

    public String getName(){
        return name;
    }
}
