public class MyArrayLinkedList implements MyList{
    private static final int SIZE_PER_NODE = 10;
    private Node head;



    @Override
    public void addToHead(Object object) {
        if (isEmpty()) {
            head = new Node();
            head.values[0] = object;
        } else {
            Node current = head;
            while (current.next != null) {
                if (isNodeFull(current)) {
                    current = current.next;
                } else {
                    current.values[getNextIndex(current)] = object;
                    return;
                }
            }

            if (isNodeFull(current)) {
                Node newNode = new Node();
                newNode.values[0] = object;
                current.next = newNode;
            } else {
                current.values[getNextIndex(current)] = object;
            }
        }
    }

    @Override
    public Object getFirst() {
        if (head != null && head.values[0] != null) {
            return head.values[0];
        }
           return null;
        }

    @Override
    public Object getAndDeleteFirst() {
        if (head != null && head.values[0] != null) {
            Object value = head.values[0];
            head.values[0] = null;
            if (head.next != null) {
                if (head.next.values[0] == null) {
                    // Remove empty node
                    head.next = head.next.next;
                }
            }
            return value;
        }
        return null;

    }

    @Override
    public void addToTail(Object object) {
        if (head == null) {
            addToHead(object);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            if (isNodeFull(current)) {
                Node newNode = new Node();
                newNode.values[0] = object;
                current.next = newNode;
            } else {
                current.values[getNextIndex(current)] = object;
            }
        }
    }

    @Override
    public Object getLast() {
        if (!isEmpty()) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            for (int i = SIZE_PER_NODE - 1; i >= 0; i--) {
                if (current.values[i] != null) {
                    return current.values[i];
                }
            }
        }

       return null;
    }

    @Override
    public Object getAndDeleteLast() {
        if (!isEmpty()) {
            Node current = head;
            while (current.next != null) {
                if (current.next.next == null && current.next.values[0] != null) {
                    Object value = current.next.values[0];
                    current.next.values[0] = null;
                    return value;
                } else if (current.next.next == null) {
                    current.next = null;
                    return null;
                }
                current = current.next;
            }

            for (int i = SIZE_PER_NODE - 1; i >= 0; i--) {
                if (current.values[i] != null) {
                    Object value = current.values[i];
                    current.values[i] = null;
                    return value;
                }
            }
        }

        return null;
    }

    @Override
    public boolean checkToValue(Object object) {
        Node current = head;
        while (current != null) {
            for (Object val : current.values) {
                if (val != null && val.equals(object)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return  head == null;
    }

    @Override
    public void deleteValue(Object object) {
        if (head != null) {
            Node current = head;
            while (current != null) {
                for (int i = 0; i < SIZE_PER_NODE; i++) {
                    if (current.values[i] != null && current.values[i].equals(object)) {
                        current.values[i] = null;
                    }
                }
                current = current.next;
            }
        }
    }

    @Override
    public void print() {
        Node current = head;
        int index = 0;
        while (current != null) {
            for (int i = 0; i < SIZE_PER_NODE; i++) {
                if (current.values[i] != null) {
                    System.out.println("Index " + index + ": " + current.values[i]);
                }
                index++;
            }
            current = current.next;
        }
    }

    private boolean isNodeFull(Node node) {
        return getNextIndex(node) >= SIZE_PER_NODE;
    }

    private int getNextIndex(Node node) {
        for (int i = 0; i < SIZE_PER_NODE; i++) {
            if (node.values[i] == null) {
                return i;
            }
        }
        return SIZE_PER_NODE;
    }

    private class Node {
        public Object[] values;
        public Node next;

        public Node() {
            values = new Object[SIZE_PER_NODE];
        }
    }
    }



