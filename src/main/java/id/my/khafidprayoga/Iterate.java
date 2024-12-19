package id.my.khafidprayoga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Iterate {
    public static void main(String[] args) {
        Collection<String> words = List.of("Hello", "World", "m", "e");
        // method 1
        for (String word : words) {
//            System.out.println(word);
        }

        // method 2
        for (Iterator<String> iter = words.iterator(); iter.hasNext(); ) {
            String elem = iter.next();
            if (elem.length() == 5) {
//                System.out.println(elem);
            }

//            error because List is immutable
//            if (elem == "e") {
//                iter.remove();
//            }
        }

//        System.out.println(words);
        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {

            String element = iterator.next();
//            produce error bcz its melanggar aturan fail-fast
            // karena collection diubah tanpa melalui iterator
//            strings.remove(element);
            iterator.remove();
        }

    }
}
