import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testElemnt(){
        Element element1 = new Element(null, "test", null);
        assertNotNull(element1);
        assertNull(element1.previous);
        assertEquals("test", element1.value);
        assertNull(element1.next);
    }

    @Test
    public void testDblList(){
        DblList list1 = new DblList();
        assertNotNull(list1);
        list1.add("1");
        list1.add("2");
        list1.add("3");
        assertEquals("1", list1.nextElement());
        assertEquals("2", list1.nextElement());
        assertEquals("3", list1.nextElement());
        assertNull(list1.nextElement());
        assertEquals("2", list1.previousElement());
        assertEquals("1", list1.previousElement());
        assertNull(list1.previousElement());
    }
}
