/*
This only completes part 1 of Day 5.
 */
package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day5 {

    // Properties
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    private static final String[] REPEATED_CHARACTERS =
            {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn",
                    "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
    private static final String[] NAUGHTY_PROPERTIES = {"ab", "cd", "pq", "xy"};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner readFile = new Scanner(new File("resources/2015/day5-inputs.txt"));
        ArrayList<String> santasList = new ArrayList<>();

        // Writing all the strings on Santa's list!
        while (readFile.hasNext()) {
            santasList.add(readFile.nextLine());
        }

        ArrayList<String> filteredList = filteredList(santasList);
        System.out.println(filteredList.size());
    }

    private static ArrayList<String> filteredList(ArrayList<String> list) {
        ArrayList<String> filtered = new ArrayList<>();
        for (String line : list) {

            // booleans for each of the properties
            boolean hasVowels = hasVowels(line);
            boolean hasRepeats = hasRepeatedOrNaughty(line, REPEATED_CHARACTERS);
            boolean hasNaughty = hasRepeatedOrNaughty(line, NAUGHTY_PROPERTIES);

            // checking whether a string satisfies these prerequisites
            if (hasVowels && hasRepeats && !hasNaughty) {
                filtered.add(line);
            }
        }
        return filtered;
    }


    private static boolean hasVowels(String line) {
        int vowelCount = 0;

        // for loop checks whether a character in the current string is a vowel, if so it updates the counter.
        for (char character : line.toCharArray()) {
            for (char vowel : VOWELS) {
                if (character == vowel) {
                    vowelCount++;
                    break;
                }
            }
        }
        // Checking if there are at least three vowels
        return vowelCount >= 3;
    }

    public static boolean hasRepeatedOrNaughty(String line, String[] arr) {

        // for loop to check whether a string pattern (i.e. aa or ab) is in a string.
        for (String strPattern : arr) {
            if (line.contains(strPattern)) {
                return true;
            }
        }
        return false;
    }
}