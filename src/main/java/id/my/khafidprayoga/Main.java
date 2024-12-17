package id.my.khafidprayoga;

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


public class Main {
    public static void main(String[] args) {
        Box in = new Box(Integer.valueOf(12));
        in = new Box(String.valueOf("Hi"));
        System.out.println(in.toString());

        Boxes<String> name = new Boxes<String>("Hello");
        System.out.println(name.get());

        Boxes<Long> idCard = new Boxes<Long>(Long.valueOf(12));
        System.out.println(idCard.get());
    }
}