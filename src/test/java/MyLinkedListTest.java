import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyLinkedList myList;

    @Before
    public void setup() {
        myList = new MyLinkedList();
        myList.addToHead(1);
        myList.addToHead(2);
        myList.addToHead(3);
    }

    @Test
    public void testAddToHead() {
        myList.addToHead(4);
        assertEquals("[4],[3],[2],[1]", myList.toString());
    }

    @Test
    public void testGetFirst() {
        assertEquals(3, myList.getFirst());
    }



    @Test
    public void testGetAndDeleteFirst() {
        Object firstValue = myList.getAndDeleteFirst();
        assertEquals(3, firstValue);
        assertEquals("[2],[1]", myList.toString());
    }



    @Test
    public void testAddToTail() {
        myList.addToTail(4);
        assertEquals("[3],[2],[1],[4]", myList.toString());
    }

    @Test
    public void testGetLast() {
        assertEquals(1, myList.getLast());
    }



    @Test
    public void testGetAndDeleteLast() {
        Object lastValue = myList.getAndDeleteLast();
        assertEquals(1, lastValue);
        assertEquals("[3],[2]", myList.toString());
    }



    @Test
    public void testCheckToValue() {
        assertTrue(myList.checkToValue(2));
        assertFalse(myList.checkToValue(4));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(myList.isEmpty());

        MyLinkedList emptyList = new MyLinkedList();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testDeleteValue() {
        myList.deleteValue(2);
        assertEquals("[3],[1]", myList.toString());

        // Delete non-existent value
        myList.deleteValue(4);
        assertEquals("[3],[1]", myList.toString());
    }


}
