package id.my.khafidprayoga;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@FunctionalInterface
interface Runnable {
    public abstract void run();
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T> after) {
        return null;
    }

    ;
}

public class Main {
    static int calculateTotalPrice(List<?> products){
        AtomicInteger total = new AtomicInteger(0);
        Consumer<?> consumer = product -> total.addAndGet(100);
        return total.get();
    }
    public static void main(String[] args) {
        Consumer<String> consume = s -> System.out.println(s);

        consume.accept("Hello");

        Runnable r = () -> System.out.println("I am running");

        r.run();

        Predicate<String> prec = s -> s.length() > 0;
        System.out.println(prec.test("Hello world"));
        var x = Main.calculateTotalPrice(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(x);
    }
}
