package id.my.khafidprayoga;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random(50L);
        // this code more performant than Supplier<Integer>
        IntSupplier newRandom = () -> rand.nextInt(100);

        for (int i = 0; i < 10; i++) {
            System.out.println(newRandom.getAsInt());
        }
    }
}
