import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyLinkedList<T> implements MyList <T>, Iterable<T>{
    private Node head;

    private class Node <T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void addToHead(T object) {
        Node newNode = new Node(object);
        if (!isEmpty()) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
        }
    }

    @Override
    public T getFirst() {
        if (!isEmpty()) {
            return (T) head.value;
        }
        return null;
    }

    @Override
    public T getAndDeleteFirst() {
        if (!isEmpty()) {
            Node current = head;
            head = current.next;
            return (T) current.value;
        }
        return null;
    }

    @Override
    public void addToTail(T object) {
        if (!isEmpty()){
            Node<T> current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next=new Node<>(object);
        } else {
            head = new Node<>(object);
        }
    }

    @Override
    public T getLast() {
        if (!isEmpty()){
            Node current = head;
            while (current.next!=null   ){
                current=current.next;
            }
            return (T) current.value;
        }
        return null;
    }

    @Override
    public T getAndDeleteLast() {
        if(!isEmpty()){
            Node current = head;
            while (current.next.next!=null){
                current=current.next;
            }
            Node last = current.next;
            current.next=null;
            return (T) last.value;
        }
        return null;
    }

    @Override
    public boolean checkToValue(T object) {
        if (!isEmpty()){
            Node current = head;
            while (current.next!=null){
                if (current.value.equals(object)){
                    return true;
                }
                current=current.next;
            }
            return current.value.equals(object);
        }
        return false;

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }


    public void deleteValue(T object) {
        while (head != null && head.value.equals(object)) {
            head = head.next;
        }
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                if (current.next.value.equals(object)) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append("[").append(current.value);
                if (current.next != null) {
                    sb.append("],");

                }
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        } else {
            return null;
        }
    }




    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }




    public void forEach(Consumer<? super T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.value);
            current = current.next;
        }
    }


    public void forEach(Predicate<? super T> predicate, Consumer<? super T> action) {
        Node<T> current = head;
        while (current != null) {
            if (!predicate.test(current.value)) {
                action.accept(current.value);
            }else {
                break;
            }
            current = current.next;
        }
    }


    public void forEach(T startValue, T endValue, Consumer<? super T> action) {
        boolean withinRange = false;

        for (T value : this) {
            if (withinRange) {
                action.accept(value);
            }
            if (value.equals(startValue)) {
                withinRange = true;
            }
            if (value.equals(endValue)) {
                break;
            }
        }
    }




    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }


    }


}
