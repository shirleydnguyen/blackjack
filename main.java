import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("BLACKJACK");
        System.out.println("NAME?");
        String name = input.next();
        System.out.println("PLAY?");
        String choice = input.next();
        player player = new player();
        player.addName(name);
        String playerName = player.getName();
        player house = new player();

        while (!choice.equals("NO")) { // checking if user wants to continue playing
            deck deck = new deck();
            deck.shuffle();
            card one = deck.deal();
            card two = deck.deal();
            card three = deck.deal();
            card four = deck.deal();
            int playerCardValue = 0;
            int houseCardValue = 0;
            System.out.println(playerName+ " CARDS");
            one.getCard();
            two.getCard();
            playerCardValue = one.getValue() + two.getValue();
            System.out.println("-- " + playerName + " CARD VALUE TOTAL = " + playerCardValue);
            System.out.println("HOUSE CARDS");
            three.getCard();
            System.out.println("FACEDOWN CARD");
            while (playerCardValue != 21 && playerCardValue < 21 && houseCardValue != 21 && houseCardValue < 21 && houseCardValue <= 16){
                System.out.println(playerName+ " HIT?");
                String answer = input.next();
                while (!answer.equals("NO")){
                    card hit = deck.deal();
                    hit.getCard();
                    playerCardValue += hit.getValue();
                    System.out.println("-- " + playerName + " CARD VALUE TOTAL = " + playerCardValue);
                    if (playerCardValue >= 21){
                        break;
                    }
                    System.out.println("HIT?");
                    answer = input.next();
                }

                System.out.println("HOUSE CARDS");
                three.getCard();
                four.getCard();
                houseCardValue = three.getValue() + four.getValue();

                while (houseCardValue <= 16){
                    card hit = deck.deal();
                    hit.getCard();
                    houseCardValue += hit.getValue();
                    System.out.println("--HOUSE CARD VALUE TOTAL: " + houseCardValue);
                }
            }

            if (playerCardValue == 21){
                System.out.println(playerName+ " WINS");
                player.won();
            }

            else if (houseCardValue == 21){
                System.out.println(playerName+ " LOST");
                player.lost();
            }

            else if (playerCardValue > 21 && houseCardValue < 21){
                System.out.println(playerName+ " LOSES");
                player.lost();
            }

            else if (playerCardValue < 21 && houseCardValue < 21){
                if (playerCardValue < houseCardValue){
                    System.out.println(playerName+ " LOSES");
                    player.lost();
                }
                else if (playerCardValue > houseCardValue){
                    System.out.println(playerName+ " WINS");
                    player.won();
                }
                else if (playerCardValue == houseCardValue){
                    System.out.println("TIE");
                }
            }

            else if (houseCardValue > 21 && playerCardValue < 21){
                System.out.println(playerName + " WINS");
                player.won();
            }
            //
            System.out.println();
            System.out.println("PLAYER " + playerName + " HANDS WON: " + player.getWins());
            System.out.println("PLAYER "+ playerName +  " HANDS LOST: " + player.getLosses());
            System.out.println("CONTINUE?");
            choice = input.next();
        }
    }
}