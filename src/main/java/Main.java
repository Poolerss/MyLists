

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addToTail("1");
        list.addToTail("2");
        list.addToTail("3");
        list.addToTail("4");
        list.addToTail("5");
        list.addToTail("6");
        System.out.println("перебор всех значений");
        list.forEach(System.out::println);
        System.out.println("перебор от начала до заданного");
        list.forEach(value -> value.equals("4"), System.out::println);
        System.out.println("перебор от заданного до конца");
        list.forEach("4", list.getLast(), System.out::println);






    }
}
