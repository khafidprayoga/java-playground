package id.my.khafidprayoga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Collection<String> strings = new ArrayList<String>();

        strings.add("one");
        strings.add("two");
        strings.add("three");

        boolean isContainsTwo = strings.contains("two");

        Collection<String> search = new ArrayList<>();
        search.add("one");
        search.add("two");

        boolean isExist = strings.containsAll(search);

        strings.addAll(search);

        Collection<String> tobeRemove = new ArrayList<>();
        tobeRemove.add("three");
        strings.removeAll(tobeRemove);

        Collection<String> retained = new ArrayList<>();
        retained.add("one");
        strings.retainAll(retained);
        System.out.println("asd");


        Collection<Integer> absentNum = new ArrayList<>();
        System.out.println(absentNum.isEmpty());
        System.out.println(strings.size());


        String[] tabStr = strings.toArray(new String[strings.size()]);

        Collection<String> words = Arrays.asList("hello", "world", "iam", "here");

        String[] tab = words.toArray(String[]::new);

        Collection<String> stringCheck = new ArrayList<>();
        stringCheck.add(null);
        stringCheck.add("world");
        stringCheck.add("");
        stringCheck.add("Hello");
        stringCheck.add(null);
        stringCheck.add("");

        System.out.println(stringCheck);
        stringCheck.removeIf(Main.CollectFilter.isNullOrEmpty());
        System.out.println(stringCheck);
    }

    static class CollectFilter {
        static Predicate<String> isNull() {
            return Objects::isNull;
        }

        static Predicate<String> isEmptyString() {
            return String::isEmpty;
        }

        static Predicate<String> isNullOrEmpty() {
            return isNull().or(isEmptyString());
        }
    }
}