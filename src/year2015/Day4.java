package year2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day4 {
    private static final String PUZZLE_INPUT = "abcdef";

    public static void main(String[] args) {
        String asciiValue = convertToASCII(PUZZLE_INPUT);
        System.out.println(asciiValue);
        String hexValue = convertToHexadecimal(asciiValue);
        System.out.println(hexValue);
        String MD5Value = getMd5Hash(hexValue);
        System.out.println(MD5Value);
    }

    public static String convertToASCII(String input) {
        int asciiValue;
        ArrayList<Character> inputChars = new ArrayList<>();
        String ASCII = "";
        for (char character : input.toCharArray()) {
            asciiValue = (int) character; // Get ASCII value of the character
            ASCII += asciiValue + " "; // Append the ASCII value to the ASCII string
        }
        return ASCII;
    }

    public static String convertToHexadecimal(String input) {
        String[] numbers = input.split(" ");
        String hexNums = "";
        for (int i = 0; i < numbers.length; i++) {
            Integer asciiNum = Integer.parseInt(numbers[i]);
            String hexValue = Integer.toHexString(asciiNum);
            hexNums += hexValue + " " // Do I need these spaces for the getMD5Hash method?;
        }
        return hexNums;
    }

    // Friend gave me this method, he got it from net.
    public static String getMd5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
