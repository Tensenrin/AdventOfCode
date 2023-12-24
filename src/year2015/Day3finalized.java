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
        StringBuilder roboStringBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); i += 2) {
            roboStringBuilder.append(line.charAt(i));
        }
        StringBuilder santaStringBuilder = new StringBuilder();
        for (int i = 1; i < line.length(); i += 2) {
            santaStringBuilder.append(line.charAt(i));
        }
        String santaMoves = santaStringBuilder.toString();
        String roboSantaMoves = roboStringBuilder.toString();
        ArrayList<Integer[]> falseSantaMoves = housesSantaVisited(santaMoves);
        ArrayList<Integer[]> falseRoboSantaMoves = housesSantaVisited(roboSantaMoves);
        ArrayList<Integer[]> totalFalseSteps = santaAndRoboSantaStepsMerger(falseSantaMoves, falseRoboSantaMoves);
        Integer[] startingPosition = {0, 0};
        totalFalseSteps.add(startingPosition);
        int trueCombinedSteps = trueHousesSantaVisited(totalFalseSteps);
        System.out.println(trueCombinedSteps);

    }

    public static ArrayList<Integer[]> housesSantaVisited(String santaType) {
        char[] charArray = santaType.toCharArray();
        int stepsX = 0;
        int stepsY = 0;
        ArrayList<Integer[]> steps = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            String direction = String.valueOf(charArray[i]);
            // directions
            if (direction.equals(NORTH)) {
                stepsY += 1;
            } else if (direction.equals(SOUTH)) {
                stepsY -= 1;
            } else if (direction.equals(EAST)) {
                stepsX += 1;
            } else if (direction.equals(WEST)) {
                stepsX -= 1;
            }
            Integer[] currentLocation = {stepsY, stepsX};
            steps.add(currentLocation);
        }
        return steps;
    }

    public static int trueHousesSantaVisited(ArrayList<Integer[]> markedAddresses) {
        boolean repeatedCoordinates;
        int housesVisited = 0;
        for (int i = 0; i < markedAddresses.size(); i++) {
            repeatedCoordinates = false;
            for (int j = i + 1; j < markedAddresses.size(); j++) {
                if (Arrays.toString(markedAddresses.get(i)).equals(Arrays.toString(markedAddresses.get(j)))) {
                    repeatedCoordinates = true;
                    break;
                }
            }
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
