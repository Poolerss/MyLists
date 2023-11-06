

public class MyLinkedList implements MyList {
    private Node head;

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    @Override
    public void addToHead(Object object) {
        Node newNode = new Node(object);
        if (!isEmpty()) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
        }
    }

    @Override
    public Object getFirst() {
        if (!isEmpty()) {
            return head.value;
        }
        return null;
    }

    @Override
    public Object getAndDeleteFirst() {
        if (!isEmpty()) {
            Node current = head;
            head = current.next;
            return current.value;
        }
        return null;
    }

    @Override
    public void addToTail(Object object) {
        if (!isEmpty()){
            Node current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next=new Node(object);
        }
    }

    @Override
    public Object getLast() {
        if (!isEmpty()){
            Node current = head;
            while (current.next!=null   ){
                current=current.next;
            }
            return current.value;
        }
        return null;
    }

    @Override
    public Object getAndDeleteLast() {
        if(!isEmpty()){
            Node current = head;
            while (current.next.next!=null){
                current=current.next;
            }
            Node last = current.next;
            current.next=null;
            return last.value;
        }
        return null;
    }

    @Override
    public boolean checkToValue(Object object) {
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


    public void deleteValue(Object object) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyLinkedList that = (MyLinkedList) o;

        return head != null ? head.equals(that.head) : that.head == null;
    }

    @Override
    public int hashCode() {
        return head != null ? head.hashCode() : 0;
    }
}
