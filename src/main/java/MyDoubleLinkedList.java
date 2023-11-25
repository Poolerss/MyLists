import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class MyDoubleLinkedList<T> implements MyList<T>{
    Node<T> first;
    Node last;

    @Override
    public void addToHead(Object object) {
        if (!isEmpty()){
            Node newNode = new Node(null, object, first);
            first=newNode;
        }else{
            first=last=new Node(null,object,null);
        }
    }

    @Override
    public T getFirst() {
        if (!isEmpty()) {
            return first.value;
        }
        return null;
    }

    @Override
    public T getAndDeleteFirst() {
        if (!isEmpty()){
            Node current = first;
             first=first.next;
             return (T) current.value;
        }
        return null;
    }

    @Override
    public void addToTail(Object object) {
        if (!isEmpty()){
            last.next = new Node(last,object,null) ;
            last=last.next;
        }else {
            first=last=new Node(null, object,null);
        }
    }

    @Override
    public T getLast() {
        return (T) last.value;
    }

    @Override
    public T getAndDeleteLast() {
        if (!isEmpty()){
            Node current = last;
            last = last.previous;
            last.next=null;
            return (T) current.value;
        }
        return null;
    }

    @Override
    public boolean checkToValue(Object object) {
        if (!isEmpty()){
            Node current = first;
            while (current!=null){
                if (current.value.equals(object)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public void deleteValue(Object object) {
        if (!isEmpty()) {
            Node current = first;
            while (current != null) {
                if (current.value.equals(object)) {
                    if (current == first) {
                        first = current.next;
                        if (first != null) {
                            first.previous = null;
                        }
                    } else if (current == last) {
                        last = current.previous;
                        if (last != null) {
                            last.next = null;
                        }
                    } else {
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                    }
                }
                current = current.next;
            }
        }
    }

    @Override
    public void print() {
        System.out.println(toString());
    }



    @Override
    public String toString() {
        if (!isEmpty()){
            StringBuilder sb= new StringBuilder();
            Node current = first;
            while (current!=null){
                sb.append("[").append(current.value).append("]").append(current.next!=null ? "," : "");
                current = current.next;
            }
            return sb.toString();
        }
        return null;
    }


    public void printReversed() {
        if (!isEmpty()){
            StringBuilder sb= new StringBuilder();
            Node current = last;
            while (current!=null){
                sb.append("[").append(current.value).append("]").append(current.previous!=null ? "," : "");
                current = current.previous;
            }
            System.out.println(sb);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDoubleLinkedList that = (MyDoubleLinkedList) o;
        return Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }



    public void addAllToHead(Object[] array) {
        if (array != null && array.length > 0) {
            for (int i = array.length - 1; i >= 0; i--) {
                addToHead(array[i]);
            }
        }
    }
    private void clear() {
        first = null;
        last = null;
    }
    public void addAllToHead(Iterable<Object> iterable) {
        if (iterable != null) {
            for (Object value : iterable) {
                addToHead(value);
            }
        }
    }
    public void addAllToTail(Iterable<Object> iterable) {
        if (iterable != null) {
            for (Object value : iterable) {
                addToTail(value);
            }
        }
    }
    public void addAllToTail(Object[] array) {
        if (array != null) {
            for (Object value : array) {
                addToTail(value);
            }
        }
    }

    public void absorbListAtEnd(MyDoubleLinkedList otherList) {
        if (!otherList.isEmpty()) {
            if (isEmpty()) {
                first = otherList.first;
                last = otherList.last;
            } else {
                last.next = otherList.first;
                otherList.first.previous = last;
                last = otherList.last;
            }
            otherList.clear();
        }
    }

    public void absorbListAtStart(MyDoubleLinkedList otherList) {
        if (!otherList.isEmpty()) {
            if (isEmpty()) {
                first = otherList.first;
                last = otherList.last;
            } else {
                otherList.last.next = first;
                first.previous = otherList.last;
                first = otherList.first;
            }
            otherList.clear();
        }
    }

    @Override
    public Iterator iterator() {
        return new MyDoubleLinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        MyList.super.forEach(action);
    }
    public void forEach(T startValue, T endValue, Consumer<? super T> action) {
        Node<T> currentNode = first;
        boolean withinRange = false;

        while (currentNode != null) {
            if (currentNode.value.equals(startValue)) {
                withinRange = true;
            }
            if (withinRange) {
                action.accept(currentNode.value);
            }
            if (currentNode.value.equals(endValue)) {
                break;
            }
            currentNode = currentNode.next;
        }
    }
    public void forEachToTail(T endValue, T startValue, Consumer<? super T> action) {
        Node<T> currentNode = last;
        boolean withinRange = false;

        while (currentNode != null) {
            if (currentNode.value.equals(startValue)) {
                withinRange = true;
            }
            if (withinRange) {
                action.accept(currentNode.value);
            }
            if (currentNode.value.equals(endValue)) {
                break;
            }
            currentNode = currentNode.previous;
        }
    }

    private class Node <T>{
    Node <T> previous;
    private T value;
    Node<T> next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    private class MyDoubleLinkedListIterator implements Iterator<T> {
        private Node<T> current = first;

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
