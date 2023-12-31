package exercises;

import java.util.ArrayList;

public class findOtherSides {
    private static final String TWO_DECIMAL_PLACES = "%.2f";

    public static void main(String[] args) {
        System.out.println(sideFinder(3));
    }

    static ArrayList<String> sideFinder(double shortestSide) {
        ArrayList<String> otherSides = new ArrayList<>();
        String side1 = "" + String.format(TWO_DECIMAL_PLACES, (shortestSide * 2));
        String side2 = "" + String.format(TWO_DECIMAL_PLACES, (shortestSide * Math.sqrt(3)));
        otherSides.add(side1);
        otherSides.add(side2);
        return otherSides;
    }
}
