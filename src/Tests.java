import org.junit.Test;

import static org.junit.Assert.*;


public class Tests {

    @Test
    public void testElemnt1() {
        Element<String> element1 = new Element<>(null, "test", null);
        assertNotNull(element1);
        assertNull(element1.previous);
        assertEquals("test", element1.value);
        assertNull(element1.next);
    }

    @Test
    public void testElemnt2() {
        Element<Integer> element1 = new Element<>(null, 42, null);
        assertNotNull(element1);
        assertNull(element1.previous);
        assertEquals((Integer) 42, element1.value);
        assertNull(element1.next);
    }

    @Test
    public void testElemnt3() {
        Element<Object> element1 = new Element<>(null, 42.42, null);
        assertNotNull(element1);
        assertNull(element1.previous);
        assertEquals(42.42, element1.value);
        assertNull(element1.next);
    }

    @Test
    public void testTwoWayListWithStrings() {
        TwoWayList<String> list1 = new TwoWayList<>();
        assertNotNull(list1);
        list1.add("1");
        list1.add("2");
        Iterators iterator1 = list1.createSimpleIterator();
        assertEquals("1", iterator1.nextElement());
        assertEquals("2", iterator1.nextElement());
        assertEquals("1", iterator1.previousElement());
        list1.add("3");
        assertEquals("2", iterator1.nextElement());
        assertEquals("3", iterator1.nextElement());
    }

    @Test
    public void testTwoWayListWithObjects() {
        TwoWayList<Object> list1 = new TwoWayList<>();
        assertNotNull(list1);
        list1.add("1");
        list1.add(2);
        Iterators iterator1 = list1.createSimpleIterator();
        assertEquals("1", iterator1.nextElement());
        assertEquals(2, iterator1.nextElement());
        assertEquals("1", iterator1.previousElement());
        list1.add(42.42);
        assertEquals(2, iterator1.nextElement());
        assertEquals(42.42, iterator1.nextElement());
    }

    @Test(expected = IllegalCallerException.class)
    public void testTwoWayListError1() {
        TwoWayList<String> list1 = new TwoWayList<>();
        assertNotNull(list1);
        list1.add("1");
        list1.add("2");
        Iterators iterator1 = list1.createSimpleIterator();
        assertEquals("1", iterator1.nextElement());
        assertEquals("2", iterator1.nextElement());
        iterator1.nextElement();
    }

    @Test(expected = IllegalCallerException.class)
    public void testTwoWayListError2() {
        TwoWayList<String> list1 = new TwoWayList<>();
        Iterators iterator1 = list1.createSimpleIterator();
        list1.add("1");
        assertEquals("1", iterator1.nextElement());
        list1.add("2");
        assertEquals("2", iterator1.nextElement());
        assertEquals("1", iterator1.previousElement());
        iterator1.previousElement();
    }

    @Test(expected = IllegalCallerException.class)
    public void testTwoWayListError3() {
        TwoWayList list1 = new TwoWayList();
        Iterators iterator1 = list1.createSimpleIterator();
        iterator1.nextElement();
    }

    @Test
    public void test2TwoWayList() {
        TwoWayList<String> list1 = new TwoWayList<>();
        Iterators iterator1 = list1.createSimpleIterator();
        TwoWayList<String> list2 = new TwoWayList<>();
        Iterators iterator2 = list2.createSimpleIterator();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        assertEquals("1", iterator1.nextElement());
        list2.add("11");
        list2.add("22");
        list2.add("33");
        assertEquals("2", iterator1.nextElement());
        assertEquals("3", iterator1.nextElement());
        assertEquals("11", iterator2.nextElement());
        assertEquals("22", iterator2.nextElement());
        assertEquals("33", iterator2.nextElement());
        assertEquals("22", iterator2.previousElement());
    }

    @Test
    public void testTwoIterators() {
        TwoWayList<String> list1 = new TwoWayList<>();
        Iterators iterator1 = list1.createSimpleIterator();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        assertEquals("1", iterator1.nextElement());
        assertEquals("2", iterator1.nextElement());
        Iterators iterator2 = list1.createSimpleIterator();
        assertEquals("3", iterator1.nextElement());

        assertEquals("1", iterator2.nextElement());
        assertEquals("2", iterator2.nextElement());
        assertEquals("3", iterator2.nextElement());
        assertEquals("2", iterator2.previousElement());
    }
}
