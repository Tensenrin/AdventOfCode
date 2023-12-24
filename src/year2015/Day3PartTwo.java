package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3PartTwo {
    // The cardinal directions
    private static String NORTH = "^";
    private static String EAST = ">";
    private static String SOUTH = "v";
    private static String WEST = "<";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("resources/2015/day3-inputs.txt"));
        String line = fileRead.next();

        StringBuilder roboStringBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); i += 2) {
            roboStringBuilder.append(line.charAt(i));
        }
        System.out.println(roboStringBuilder);

        StringBuilder santaStringBuilder = new StringBuilder();
        for (int i = 1; i < line.length(); i += 2) {
            santaStringBuilder.append(line.charAt(i));
        }
        System.out.println(santaStringBuilder);

        String santaMoves = santaStringBuilder.toString();
        String roboSantaMoves = roboStringBuilder.toString();
        ArrayList<Integer[]> falseSantaMoves = housesSantaVisited(santaMoves);
        ArrayList<Integer[]> falseRoboSantaMoves = housesSantaVisited(roboSantaMoves);
        ArrayList<Integer[]> totalFalseSteps = mergeArrayLists(falseSantaMoves, falseRoboSantaMoves);
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

    public static ArrayList<Integer[]> mergeArrayLists(ArrayList<Integer[]> list1, ArrayList<Integer[]> list2) {
        ArrayList<Integer[]> combinedList = new ArrayList<>();

        for (Integer[] arr : list1) {
            combinedList.add(arr);
        }

        for (Integer[] arr : list2) {
            combinedList.add(arr);
        }

        return combinedList;
    }
}
