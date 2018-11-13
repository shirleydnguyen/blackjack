import java.util.ArrayList;
import java.util.Random;

public class deck extends card {
    card [] deck = new card[52];
    String [] ranks = {"Ace","King","Queen","Jack","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two"};
    String[] suits ={"Hearts","Spades","Diamonds","Clubs"};
    int[] values ={11,10,10,10,10,9,8,7,6,5,4,3,2};
    ArrayList <card> dealtCards = new ArrayList<card>();
    int cardsRemaining = (52 - dealtCards.size());
    Random random = new Random();

    // 1 2 3 4 5 6 7 8 9 10

    public deck() {
        for(int i = 0; i<deck.length; i++)
        {
            deck[i] = new card(ranks[i%13], suits[i%4], values[i%13]);  // assigns all values of
        }
    }

    public void swap(card a, card b) {
        card temp = a;
        a = b;
        b = temp;
    }

    public void shuffle() {
        int count = 100;
        while (count != 0){
            int random1 = random.nextInt(52);
            int random2 = random.nextInt(52);
                while (random1 == random2){
                    random2 = random.nextInt(52);
                }
            swap(deck[random1], deck[random2]);
            count--;
        }
    }

    public card deal() {
        int randomCard = random.nextInt(52);
        for (int k = 0; k < dealtCards.size(); k++){
            if (!deck[randomCard].equals(dealtCards.get(k))){
                dealtCards.add(deck[k]);
            }
        }
        return deck[randomCard];
    }

    public void report() {
        System.out.println(cardsRemaining + " left");
    }
}
