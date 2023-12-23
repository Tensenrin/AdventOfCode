package year2015;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class DayOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("resources/day1.txt"));
        String line = fileRead.nextLine();
        char[] charArray = line.toCharArray();
        int currentFloor = 0;

        System.out.println("These instructions take Santa to floor: "
                + instructionDicipher(charArray, currentFloor).get(0)
                + "\nThe position of the character that takes him to the basement is "
                + instructionDicipher(charArray, currentFloor).get(1));
    }

    public static ArrayList<Integer> instructionDicipher(char[] charArray, int currentFloor) {
        ArrayList<Integer> values = new ArrayList<>();
        int positionOfBasementCharacter = 0;
        for (int i = 0; i < charArray.length; i++) {
            String currentChar = String.valueOf(charArray[i]);

            // part 1 finding what floor the instructions take Santa to.
            if (currentChar.equals("(")) {
                currentFloor += 1;
            } else if (currentChar.equals(")")) {
                currentFloor -= 1;
            }

            /* part 2: this if statement finds the first time currentFloor reaches -1.
            To make sure positionOfBasementCharacter is never changed again,
            I use && to show that if it's not it's original value (0) then it cannot be changed.*/
            if (currentFloor <= -1 && positionOfBasementCharacter == 0) {
                positionOfBasementCharacter = (i + 1);
            }
        }
        values.add(currentFloor);
        values.add(positionOfBasementCharacter);
        System.out.println(values.size());
        return values;
    }
}
