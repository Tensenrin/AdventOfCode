package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
What makes a 'nice' string?
- contains at least THREE vowels
- contains one letter that appears TWICE in a row (aa)
- does not contain the naughty strings, even if it fulfills above requirements
 */
public class Day5 {

    // properties
    private static final String[] NAUGHTY_PROPERTIES = {"ab", "cd", "pq", "xy"};
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner readFile = new Scanner(new File("resources/2015/day5-inputs.txt"));
        int niceNum = 0;
        ArrayList<String> lines = new ArrayList<>();
        while (readFile.hasNext()) {
            String[] line = readFile.nextLine().split("");
            for (int i = 0; i < line.length; i++) {
                for (int j = 0; j < VOWELS.length; j++) {
                    if (line[i].contains(String.valueOf(VOWELS[j]))) {
//                        System.out.println("Vowel " + VOWELS[j] + " detected at " + i);
                        lines.add(concatenateArray(line));

                        if (readFile.hasNext()) {
                            line = readFile.nextLine().split("");
                            break;
                        }
                    }
                }
            }
        }
        boolean isRunning = true;
        int counter = 0;
        while (isRunning) {
            String[] line = lines.get(counter).split("");
            for (int i = 0; i < line.length; i++) {
                for (int j = 0; j < NAUGHTY_PROPERTIES.length; j++) {
                    if (line[i].contains(NAUGHTY_PROPERTIES[j])) {
                        lines.remove(concatenateArray(line));
                        counter++;

                        if (counter < lines.size()) {
                            line = lines.get(counter).split("");
                            break;
                        }
                    }
                }
            }
            counter++;
        }
        System.out.println(lines);

    }

    public static String concatenateArray(String[] arr) {
        StringBuilder result = new StringBuilder();
        for (String str : arr) {
            result.append(str);
        }
        return result.toString();
    }
}