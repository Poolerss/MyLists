import java.util.Objects;

public class MyDoubleLinkedList implements MyList{
    Node first;
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
    public Object getFirst() {
        if (!isEmpty()) {
            return first.value;
        }
        return null;
    }

    @Override
    public Object getAndDeleteFirst() {
        if (!isEmpty()){
            Node current = first;
             first=first.next;
             return current.value;
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
    public Object getLast() {
        return last.value;
    }

    @Override
    public Object getAndDeleteLast() {
        if (!isEmpty()){
            Node current = last;
            last = last.previous;
            last.next=null;
            return current.value;
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


private class Node{
    Node previous;
    private Object value;
    Node next;

        public Node(Node previous, Object value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }




}
