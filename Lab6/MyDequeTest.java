import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyDequeTest {
    @Test
    public void cannotRemoveFromEmptyQueue() {
        MyDeque<String> q = new MyDeque<>();
        assertThrows(Exception.class, () -> q.removeFirst());
        assertThrows(Exception.class, () -> q.removeLast());
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
        q.addFirst("Hello");
        q.addLast("James");
        q.addFirst("Well");
        q.addLast("Wane");
        q.addLast("what");
        q.addLast("is");
        q.addLast("your");
        q.addLast("problem");
        q.addLast("AI");
        q.addLast("will");
        q.addLast("be");
        q.addLast("the");
        q.addLast("future");
        q.addLast("of");
        q.addLast("computing");
        q.addFirst("Hola");

        assertEquals(16, q.size());


    }



}
