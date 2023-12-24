package year2015;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {

    // The cardinal directions
    private static String NORTH = "^";
    private static String EAST = ">";
    private static String SOUTH = "v";
    private static String WEST = "<";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("resources/2015/day3-inputs.txt"));
        String line = fileRead.next();
        ArrayList<Integer[]> markedAddresses = new ArrayList<>();
        markedAddresses = housesSantaVisited(line);
        int housesVisited = trueHousesSantaVisited(markedAddresses);
        System.out.println("Part 1 - Houses that Santa has visited: " + housesVisited);
    }

    public static ArrayList<Integer[]> housesSantaVisited(String line) {
        char[] charArray = line.toCharArray();
        int stepsX = 0;
        int stepsY = 0;
        ArrayList<Integer[]> steps = new ArrayList<>();
        Integer[] startingPosition = {0, 0};
        steps.add(startingPosition);
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

    // !! part two is unfinished !!
    public static void santaAndRoboSanta(String line) {
        StringBuilder roboSantaMoves = new StringBuilder();
        for (int i = 0; i < line.length(); i += 2) {
            roboSantaMoves.append(line.charAt(i));

        }
        System.out.println(roboSantaMoves);
    }
}

