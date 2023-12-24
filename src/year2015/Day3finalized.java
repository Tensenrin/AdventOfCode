package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3finalized {

    // The cardinal directions
    private static String NORTH = "^";
    private static String EAST = ">";
    private static String SOUTH = "v";
    private static String WEST = "<";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("resources/2015/day3-inputs.txt"));
        String line = fileRead.next();
        Scanner scanner = new Scanner(System.in);

        // giving the user a choice for part 1 or part 2 of Day 3.
        System.out.println("'1' for part 1, '2' for part 2");
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            PartOne(line);
        }
        if (userChoice == 2) {
            PartTwo(line);
        }
    }

    public static void PartOne(String line) {
        ArrayList<Integer[]> markedAddresses = housesSantaVisited(line);
        int housesVisited = trueHousesSantaVisited(markedAddresses);
        System.out.println("Part 1 - Houses that Santa has visited: " + (housesVisited + 1) /*1 to account for starting position*/);
    }

    public static void PartTwo(String line) {
        // Initialize string builders for Santa and Robo-Santa
        StringBuilder santaMoves = new StringBuilder();
        StringBuilder roboSantaMoves = new StringBuilder();

        // Separate Santa and Robo-Santa moves
        for (int i = 0; i < line.length(); i++) {
            if (i % 2 == 0) {
                roboSantaMoves.append(line.charAt(i));
            } else {
                santaMoves.append(line.charAt(i));
            }
        }
        // Get the lists of houses visited by Santa and Robo-Santa
        ArrayList<Integer[]> falseSantaMoves = housesSantaVisited(santaMoves.toString());
        ArrayList<Integer[]> falseRoboSantaMoves = housesSantaVisited(roboSantaMoves.toString());

        // Combine Santa and Robo-Santa moves
        ArrayList<Integer[]> totalFalseSteps = new ArrayList<>(falseSantaMoves);
        totalFalseSteps.addAll(falseRoboSantaMoves);

        // Add the starting position
        totalFalseSteps.add(new Integer[]{0, 0});

        // Calculate the count of true houses visited
        int trueCombinedSteps = trueHousesSantaVisited(totalFalseSteps);
        System.out.println(trueCombinedSteps);

    }

    public static ArrayList<Integer[]> housesSantaVisited(String str) {

        // convers the string to a char array so the program can read the directions individually.
        char[] charArray = str.toCharArray();
        int stepsX = 0;
        int stepsY = 0;
        ArrayList<Integer[]> steps = new ArrayList<>();

        // for-loop checks the input of each character and decides which cardinal direction they are.
        for (int i = 0; i < charArray.length; i++) {
            String direction = String.valueOf(charArray[i]);

            // cardinal directions. North and East result in a positive 1, South and West result in negative 1.
            if (direction.equals(NORTH)) {
                stepsY += 1;
            } else if (direction.equals(SOUTH)) {
                stepsY -= 1;
            } else if (direction.equals(EAST)) {
                stepsX += 1;
            } else if (direction.equals(WEST)) {
                stepsX -= 1;
            }

            // creates an array of the current coordinates, e.g. {0, 1} and appends them to the steps array.
            Integer[] currentLocation = {stepsY, stepsX};
            steps.add(currentLocation);
        }
        return steps;
    }

    public static int trueHousesSantaVisited(ArrayList<Integer[]> markedAddresses) {
        boolean repeatedCoordinates;
        int housesVisited = 0;

        // for-loop that checks for duplicate address entries.
        for (int i = 0; i < markedAddresses.size(); i++) {
            repeatedCoordinates = false;

            // nested for-loop gets the entry next to the one being checked. i=0, j=1, first entry compared to second.
            for (int j = i + 1; j < markedAddresses.size(); j++) {
                if (Arrays.toString(markedAddresses.get(i)).equals(Arrays.toString(markedAddresses.get(j)))) {
                    repeatedCoordinates = true;
                    break;
                }
            }

            // if coordinate is not repeated then it's a house that's not been visited.
            if (!repeatedCoordinates) {
                housesVisited += 1;
            }
        }
        return housesVisited;
    }

    public static ArrayList<Integer[]> santaAndRoboSantaStepsMerger(ArrayList<Integer[]> falseSantaMoves, ArrayList<Integer[]> falseRoboSantaMoves) {
        ArrayList<Integer[]> combinedList = new ArrayList<>();
        combinedList.addAll(falseSantaMoves);
        combinedList.addAll(falseRoboSantaMoves);

        return combinedList;
    }
}
