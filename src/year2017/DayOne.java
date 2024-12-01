package year2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayOne {

    public int testSum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num >= 0) {
            int remainder = num % 10;
            list.add(remainder);
            num = num - (remainder*10);
        }
        return num;
    }

    public static void main(String[] args) {
        DayOne d1 = new DayOne();
        System.out.println(d1.testSum(1122));
    }
}
