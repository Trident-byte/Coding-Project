package edu.stuy.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyDequeTest {
    @Test
    public void cannotRemoveFromEmptyQueue() {
        MyDeque<String> q = new MyDeque<>();
        assertThrows(Exception.class, () -> q.removeFirst());
        assertThrows(Exception.class, () -> q.removeLast());
        assertThrows(Exception.class, () -> q.getFirst());
        assertThrows(Exception.class, () -> q.getLast());
        assertThrows(Exception.class, () -> q.getStart());
        assertThrows(Exception.class, () -> q.getEnd());
        assertThrows(Exception.class, () -> q.getData());
        assertEquals(0, q.size());
    }

    @Test
    public void cannotInsertNullElement() {
        MyDeque<String> q = new MyDeque<>();
        assertThrows(Exception.class, () -> q.addFirst(null));
        assertThrows(Exception.class, () -> q.addLast(null));
        assertEquals(0, q.size());
    }

    @Test
    public void regularAddAndRemove() {
        MyDeque<String> q = new MyDeque<>();
        q.addFirst("Hello");
        q.addLast("James");
        q.addFirst("Well");
        q.addLast("Wane");


        assertEquals(4, q.size());
        assertEquals("[Well, Hello, James, Wane]", q.toString());

        assertEquals("Well", q.removeFirst());
        assertEquals("Wane", q.removeLast());

    }

    @Test
    public void triggerResize() {
        MyDeque<String> q = new MyDeque<>();
        q.addFirst("pal");
        q.addFirst("there");
        q.addFirst("Hello");
        q.addLast("Leon");
        q.addFirst("Well");
        q.addLast("Smith");
        q.addLast("Where");
        q.addLast("is");
        q.addLast("your");
        q.addLast("Friend");
        q.addLast("ML");
        q.addLast("will");
        q.addLast("be");
        q.addLast("the");
        q.addLast("future");
        q.addLast("of");
        q.addLast("computing");
        q.addFirst("Hola");

        assertEquals(18, q.size());

        while (q.size() != 0) {
            if (q.size() % 2 == 1) {
                q.removeFirst();
            } else {
                q.removeLast();
            }
        }

        assertEquals(0, q.size());

    }


    @Test
    public void getLastAndRemoveLastWithoutAddingLast(){
        MyDeque<String> q = new MyDeque<>();
        q.addFirst("James");
        assertEquals("James", q.getLast());
        //Add breakpoint here
        q.removeLast();

    }

    @Test
    public void mixAddOperations() {
        MyDeque<String> q = new MyDeque<>();
        q.addFirst("James");
        assertEquals("James", q.getLast());
        q.removeLast();
        q.addLast("Bond");
        q.addLast("Rules");
        q.addFirst("James");
        assertEquals("[James, Bond, Rules]",q.toString());
    }


}
