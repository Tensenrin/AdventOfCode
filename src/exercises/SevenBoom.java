package exercises;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SevenBoom {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        // adds ten random numbers to the array.
        for (int i = 0; i < 10; i++) {
            arr.add(ThreadLocalRandom.current().nextInt(1, 9));
        }

        System.out.println(sevenBoom(arr));

    }

    static String sevenBoom(ArrayList<Integer> arr) {

        // checking whether the array contains 7.
        if (arr.contains(7)) {
            return "Boom!";
        }
        return "None of these items contain 7";
    }
}
