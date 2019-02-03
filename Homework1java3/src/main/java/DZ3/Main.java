package DZ3;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<Apple>("Apple", new Apple(), new Apple(), new Apple());
        Box<Orange> box2 = new Box<Orange>("Orange", new Orange(), new Orange());
        Box<Orange> box3 = new Box<Orange>("AnotherOrange");
        System.out.println("Вес " + box2.getName() + ": " + box2.getWeight());
        System.out.println("Вес " + box2.getName() + ": " + box2.getWeight());
        System.out.println(box1.compare(box2));
        box2.info();
        box2.replaceFruitsToAnotherBox(box3);
        box2.info();
        box3.info();
        box3.addFruit(new Orange());
        System.out.println(box1.compare(box3));
    }
}
