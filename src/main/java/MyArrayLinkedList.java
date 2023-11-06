public class MyArrayLinkedList {
    private Node head;
    private Node tail;

    public void add(int value) {
        if (head == null) {
            head = new Node();
            tail = head;
        }

        if (tail.valuesCount() == Node.MAX_SIZE) {
            Node newNode = new Node();
            tail.next = newNode;
            tail = newNode;
        }

        tail.addValue(value);
    }

    public void print() {
        Node current = head;

        while (current != null) {
            for (int i = 0; i < current.valuesCount(); i++) {
                System.out.print(current.getValue(i) + " ");
            }
            current = current.next;
        }
    }

    private static class Node {
        private static final int MAX_SIZE = 10;
        private int[] values;
        private int count;
        public Node next;

        public int valuesCount() {
            return count;
        }

        public Node() {
            values = new int[MAX_SIZE];
        }

        public void addValue(int value) {
            if (count < values.length) {
                values[count] = value;
                count++;
            }
        }

        public int getValue(int index) {
            if (index >= 0 && index < count) {
                return values[index];
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
