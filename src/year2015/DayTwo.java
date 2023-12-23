package year2015;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class DayTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File ("resources/day2.txt"));
        int totalSquareFeet = 0;
        int totalRibbon = 0;
        while(fileRead.hasNext()) {
            String line = fileRead.next();

            // splitting the equation at the multiplication symbol
            String[] equationParts = line.split("x");

            // separating the measurements in separate variables
            Integer length = Integer.parseInt(equationParts[0]);
            Integer width = Integer.parseInt(equationParts[1]);
            Integer height = Integer.parseInt(equationParts[2]);

            int surfaceArea = surfaceAreaCalculator(length,width,height);
            totalSquareFeet += surfaceArea;

            int ribbon = ribbonEfficencyCalculator(length,width,height);
            totalRibbon += ribbon;
        }
        System.out.println("Part 1 - Total wrapping paper to order: " + totalSquareFeet
                + "\nPart 2 - Total feet of ribbon to order: " + totalRibbon);
    }
    public static int surfaceAreaCalculator(Integer length, Integer width, Integer height) {
        // separating these into arrays as we will need to use their raw values (no multiplication by 2) later on.
        int[] surfaceAreaParts = {(length*width), (width*height), (height*length)};
        int surfaceArea = 2*surfaceAreaParts[0] + 2*surfaceAreaParts[1] + 2*surfaceAreaParts[2];

        // finding the smallest side from their raw values in the array.
        int smallestSide = Math.min(Math.min(surfaceAreaParts[0], surfaceAreaParts[1]), surfaceAreaParts[2]);
        return surfaceArea + smallestSide;
    }

    public static int ribbonEfficencyCalculator(Integer length, Integer width, Integer height) {
        // finding the maximum dimension
        int maxDimension = Math.max(Math.max(length,width), height);

        /* calculates the perimeter of the present by summing up all three dimensions and subtracting the maximum
        to account for the overlap in calculation*/
        int perimeterOfPresent = 2 * (length+width+height - maxDimension);
        int presentBow = length*width*height;

        return perimeterOfPresent + presentBow;
    }
}
