import static org.junit.Assert.*;

public class TreeMapTest {

    @org.junit.Test
    public void add() {
        TreeMap<Integer, String> tree = new TreeMap<Integer, String>();

        tree.add(1,"1");
        tree.add(2,"2");
        tree.add(3,"3");
    }

    @org.junit.Test
    public void get() {
        TreeMap<Integer, String> tree = new TreeMap<Integer, String>();

        tree.add(1,"1");
        tree.add(2,"2");
        tree.add(3,"3");

        assertEquals("1", tree.get(1));
    }
}