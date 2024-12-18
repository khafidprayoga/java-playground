package id.my.khafidprayoga;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        // Supplier produce return
        Random rand = new Random(50L);
        // this code more performant than Supplier<Integer>
        IntSupplier newRandom = () -> rand.nextInt(100);

        for (int i = 0; i < 2; i++) {
            System.out.println(newRandom.getAsInt());
        }

        // Consumer with param args but without return
        Consumer<String> invoiceConsumer = data -> {
            System.out.println("Producing invoice for: ".concat(data));
        };

        List<String > invoiceScheduled = List.of("Joe Arifin","Johan Dalton");
        invoiceScheduled.forEach(invoiceConsumer);

        BiConsumer<Random, Integer> randomNumberPrint = (random, integer) -> {
            for (int i = 0; i < integer; i++) {
                System.out.println("next rand=" + random.nextInt());
            }
        };

        randomNumberPrint.accept(new Random(314L), 2);

        // Consumer for testing object
        Predicate<String> hasAnd = s-> s.toLowerCase().contains("and");
        String sql = "and join users";

        System.out.println("sql has and query: " +hasAnd.test(sql));

    }
}
