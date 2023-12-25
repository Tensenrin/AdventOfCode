package year2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Day4 {
    private static final String PUZZLE_INPUT = "yzbqklnj";
    private static final String ZEROS_TEMPLATE = "00000%s";

    public static void main(String[] args) {
        boolean partDecider = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("'1' for part 1, '2' for part 2 (takes longer)");
        int userInput = scanner.nextInt();
        if (userInput == 2) {
            partDecider = false;
        }
        Integer numbers = 0;
        boolean searchProcess = true;

        while (searchProcess) {
            String check = PUZZLE_INPUT + numbers;
            String md5Encoded = getMd5Hash(check);

            // checking whether it starts with 5 zeros, or using the ternary for 6 zeros
            if (md5Encoded.startsWith(String.format(ZEROS_TEMPLATE, partDecider ? "" : "0"))) {
                searchProcess = false;
            } else {
                numbers++;
            }
        }
        System.out.println(numbers);
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
