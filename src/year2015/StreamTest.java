package year2015;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Matthew Taylor", 20));
        people.add(new Person("Joseph Palmer", 4));
        people.add(new Person("James Walters", -99));
        people.add(new Person("Cody Palmer", 333));
        people.add(new Person("Daniel Bradbury", 6));


        // This stream does the exact same thing as the commented for loop (and ArrayList creation) below.
        List<Person> hundredClub = people.stream()
                .filter(person -> person.billions >= 100).collect(Collectors.toList());

//        List<Person> hundredClub = new ArrayList<>();
////        for (Person p : people) {
////            if (p.billions >= 100) {
////                hundredClub.add(p);
////            }
////        }
        hundredClub.forEach(person -> System.out.println(person.name));

        List<Person> largestToSmallest = people.stream()
                .sorted(Comparator.comparing(person -> person.billions))
                .collect(Collectors.toList());

        boolean isNegative = true;

        largestToSmallest.forEach(person -> System.out.println(
                "Name: " + person.name + "\nNet worth:" + person.billions));
    }

    static class Person {
        String name;
        int billions;

        public Person(String name, int billions) {
            this.name = name;
            this.billions = billions;
        }
    }
}
