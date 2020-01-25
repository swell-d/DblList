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

    @Test(expected = IllegalCallerException.class)
    public void testDblListError1() {
        DblList list1 = new DblList();
        assertNotNull(list1);
        list1.add("1");
        list1.add("2");
        assertEquals("1", list1.nextElement());
        assertEquals("2", list1.nextElement());
        list1.nextElement();
    }

    @Test(expected = IllegalCallerException.class)
    public void testDblListError2() {
        DblList list1 = new DblList();
        list1.add("1");
        assertEquals("1", list1.nextElement());
        list1.add("2");
        assertEquals("2", list1.nextElement());
        assertEquals("1", list1.previousElement());
        list1.previousElement();
    }
}
