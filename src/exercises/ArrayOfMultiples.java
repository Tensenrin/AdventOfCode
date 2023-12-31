package exercises;

import java.util.ArrayList;

public class ArrayOfMultiples {
    public static void main(String[] args) {

        int num = 7;
        int length = 5;
        System.out.println(arrayOfMultiples(num, length));
    }

    static ArrayList<Integer> arrayOfMultiples(int num, int length) {

        ArrayList<Integer> multipleOfNum = new ArrayList<>();

        // for loop starts at 1 for the first multiple, and ends at length+1 (to account for array indexing)
        for (int i = 1; i < (length + 1); i++) {
            multipleOfNum.add(num * i);
        }
        return multipleOfNum;
    }
}
