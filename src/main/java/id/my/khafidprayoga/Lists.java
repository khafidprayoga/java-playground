package id.my.khafidprayoga;


import java.util.*;

public class Lists {
    public static void main(String[] args) {
        List<String> w = new ArrayList<>(
                List.of("Hello", "world", "asda")
        );
        w.add("Jak");
        var indexAt = w.indexOf("Jak");

        System.out.println(w.get(2));
        List<String> nums = Arrays.asList("one", "two", "three");


        for (ListIterator<String> iterator = nums.listIterator(); iterator.hasNext(); ) {
            String elem = iterator.next();
            if (elem.equals("two")) {
                iterator.set("2");
            }
        }

        System.out.println(nums);

        LinkedList<Integer> listJob = new LinkedList<>();
        listJob.add(123);
        listJob.add(456);
        listJob.add(789);


        // linkedlist for lifo and fifo usecase
        for (ListIterator<Integer> iterator = listJob.listIterator(); iterator.hasNext(); ) {
            Integer elem = iterator.next();
            if (elem == 123) {
                iterator.remove();
            }
        }

        System.out.println(listJob);
    }
}
