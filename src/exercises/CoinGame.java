package exercises;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CoinGame {

    public static void main(String[] args) {
        String personOneChoice = choiceDecider();
        String personTwoChocie = choiceDecider();

        System.out.println(getCoinBalances(personOneChoice, personOneChoice));
    }

    static String choiceDecider() {
        int choice = ThreadLocalRandom.current().nextInt(1, 3);

        if (choice == 1) {
            return "share";
        } else {
            return "steal";
        }
    }

    static ArrayList<Integer> getCoinBalances(String personOneChoice, String personTwoChoice) {
        ArrayList<Integer> playerPurse = new ArrayList<>();
        int personOneWallet = 3;
        int personTwoWallet = 3;

        if (personOneChoice.equals("share") && personTwoChoice.equals("share")) {
            personOneWallet = (personOneWallet - 1) + 2;
            personTwoWallet = (personTwoWallet - 1) + 2;
        } else if (personOneChoice.equals("steal") && personTwoChoice.equals("share")) {
            personOneWallet += 3;
            personTwoWallet -= 2;
        } else if (personOneChoice.equals("share") && personTwoChoice.equals("steal")) {
            personOneWallet -= 2;
            personTwoWallet += 3;
        } else if (personOneChoice.equals("steal") && personTwoChoice.equals("steal")) {
            personOneWallet += 0;
            personTwoWallet += 0;
        }
        playerPurse.add(personOneWallet);
        playerPurse.add(personTwoWallet);
        return playerPurse;
    }
}

