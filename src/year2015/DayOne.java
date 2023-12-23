package year2015;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DayOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File ("resources/day1.txt"));
        String line = fileRead.nextLine();
        char[] charArray = line.toCharArray();
        int currentFloor = 0;
        System.out.println("These instructions take Santa to floor: " + part1(charArray, currentFloor));
    }
    public static int part1(char[] charArray, int currentFloor) {
        for (int i = 0; i < charArray.length; i++) {
            String currentChar = String.valueOf(charArray[i]);
            if (currentChar.equals("(")) {
                currentFloor += 1;
            } else if (currentChar.equals(")")) {
                currentFloor -= 1;
            }
        } return currentFloor;
    }
}
