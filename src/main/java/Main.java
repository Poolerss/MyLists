import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        MyList list1 = new MyLinkedList();
        list1.deleteValue(0);
        list1.addToHead(1);
        list1.addToHead(0);
        list1.addToHead(-1);
        System.out.println(list1);
        System.out.println(list1.getAndDeleteFirst());
        list1.print();
        list1.addToTail(2);
        list1.addToTail(3);
        list1.addToTail(4);
        list1.addToTail(5);
        list1.addToTail(6);
        list1.addToTail(6);
        list1.addToTail(6);
        list1.addToTail(7);
        list1.addToTail(8);
        System.out.println(list1);
        System.out.println(list1.getLast());
        System.out.println(list1.getAndDeleteLast());
        list1.print();
        System.out.println(list1.checkToValue(0));
        System.out.println(list1.checkToValue(7));
        System.out.println(list1.checkToValue(8));
        list1.deleteValue(6);
        list1.print();

         */

        MyDoubleLinkedList list = new MyDoubleLinkedList();
        System.out.println(list.getFirst());
        list.addToHead(3);
        list.addToHead(2);
        list.addToHead(1);
        System.out.println(list);
        //list.getAndDeleteFirst();
        list.print();
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(5);
        list.addToTail(5);
        list.addToTail(5);
        list.addToTail(5);
        list.print();
        System.out.println(list.getAndDeleteLast());
        list.print();
        System.out.println(list.checkToValue(0));
        list.deleteValue(5);
        list.print();

        Object[] arr=new Object[] {-3,-2, -1, -0};
        list.addAllToHead(arr);
        list.print();
        List arr2 = new LinkedList();
        arr2.add(-4);
        arr2.add(-5);

        list.addAllToHead(arr2);
        list.print();

        Object[] arrTail=new Object[] {5,6, 7, 8};
        list.addAllToTail(arrTail);
        list.print();
        list.printReversed();

        List arr2ToTeal = new LinkedList();
        arr2ToTeal.add(9);
        arr2ToTeal.add(10);
        list.addAllToTail(arr2ToTeal);
        list.print();

        MyDoubleLinkedList list3 = new MyDoubleLinkedList();
        list.addToHead(3);
        list.addToHead(2);
        list.addToHead(1);

        list.absorbListAtEnd(list3);
        list.absorbListAtStart(list3);
        list.print();
        list3.print();

        MyArrayLinkedList list4 = new MyArrayLinkedList();
        list4.addToHead(2);
        list4.addToHead(3);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.addToTail(4);
        list4.print();
        System.out.println(list4.getAndDeleteLast());
        list4.print();
        System.out.println(list4.checkToValue(4));
        list4.deleteValue(4);
        list4.print();








    }
}
