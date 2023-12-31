package year2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/2016/day1-inputs.txt"));
        String route = scanner.nextLine();
        ArrayList<String> direction = new ArrayList<>();

        Integer total = 0;

        for (int i = 0; i < route.length(); i++) {
            direction.add(Arrays.toString(route.split("")));
        }

        for (int i = 0; i < direction.size(); i++) {
            String currentNum = charRemover(direction.get(i));
            total += Integer.parseInt(currentNum);
        }
        System.out.println(total);
    }


    public static String charRemover(String str) {
        return str.substring(1, str.length() - 1);
    }
}
