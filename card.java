public class card {
    String rank = "";
    String suit = "";
    int value = 0;

    public card() {
    }

    public card(String inRank, String inSuit, int inValue) {
        rank = inRank;
        suit = inSuit;
        value = inValue;
    }


    public void getCard() {
        System.out.println(rank + " : " + suit + " : " + value);
    }

    public int getValue(){
        return value;
    }
}
