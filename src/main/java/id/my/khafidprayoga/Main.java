package id.my.khafidprayoga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Collection<String> strings = new ArrayList<String>();

        strings.add("one");
        strings.add("two");
        strings.add("three");

        boolean isContainsTwo = strings.contains("two");

        Collection<String > search = new ArrayList<>();
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

        Collection<String> words = Arrays.asList("hello","world","iam","here");

        String[] tab = words.toArray(String[]::new);



    }
}