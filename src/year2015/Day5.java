package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {

    // properties
    private static final String[] VOWELS = {"a", "e", "i", "o", "u"};
    private static final String[] REPEATED_CHARACTERS =
            {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn",
                    "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
    private static final String[] NAUGHTY_PROPERTIES = {"ab", "cd", "pq", "xy",};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner readFile = new Scanner(new File("resources/2015/day5-inputs.txt"));

        ArrayList<String> santasList = new ArrayList<>();

        // Writing all the strings on Santa's list!
        while (readFile.hasNext()) {
            santasList.add(readFile.nextLine());
        }
        ArrayList<String> vowelDetectionList = arrayFilter(santasList, VOWELS);
        ArrayList<String> repeatedDetectionList = arrayFilter(vowelDetectionList, REPEATED_CHARACTERS);
        ArrayList<String> naughtyDetectionList = arrayFilter(repeatedDetectionList, NAUGHTY_PROPERTIES);

        int niceStrings = repeatedDetectionList.size() - naughtyDetectionList.size();
        System.out.println(niceStrings);

    }

    private static ArrayList<String> arrayFilter(ArrayList<String> arr1, String[] arr2) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            String line = arr1.get(i);
            for (String index : arr2) {
                Pattern p = Pattern.compile(index);
                Matcher m = p.matcher(line);

                if (m.find()) {
                    arr.add(line);
                    break;
                }
            }
        }
        return arr;
    }
}