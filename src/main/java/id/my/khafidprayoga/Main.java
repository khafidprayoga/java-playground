package id.my.khafidprayoga;

import java.util.List;

class Box {
    private Object object;

    public Box(Object object) {
        this.object = object;
    }

}

class Boxes<T> {
    private final T t;

    public Boxes(T t) {
        this.t = t;
    }

    T get() {
        return this.t;
    }
}

interface Pair<K, V> {
    public K getFirst();

    public V getValue();
}


class OrderedPair<K, V> implements Pair<K, V> {
    private final K key;
    private final V value;

    OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getFirst() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}

class Boxs<T extends Number> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return this.t;
    }

    public void inspect(T u) {
        System.out.println(t.getClass().getSimpleName());
        System.out.println(u.getClass().getSimpleName());
    }
}

public class Main {
    public static void main(String[] args) {
        Box in = new Box(Integer.valueOf(12));
        in = new Box(String.valueOf("Hi"));
        System.out.println(in.toString());

        Boxes<String> name = new Boxes<String>("Hello");
        System.out.println(name.get());

        Boxes<Long> idCard = new Boxes<>(Long.valueOf(12));
        System.out.println(idCard.get());

        Pair<String, Integer> pairOne = new OrderedPair<>("World", Integer.valueOf(12));
        System.out.println(pairOne.getFirst());

        OrderedPair<Integer, String> pairTwo = new OrderedPair<>(12, "Doni W.");
        System.out.println(pairTwo.getValue());

        Pair<String, List<Integer>> students = new OrderedPair<>("Student remedial absent", List.of(12, 123, 1));

        System.out.println(students.getValue());

        Boxs<Integer> integerBox = new Boxs<>();
        integerBox.setT(Integer.valueOf(12));
        integerBox.inspect(1312);
    }
}