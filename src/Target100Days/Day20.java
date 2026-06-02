package Target100Days;
import java.util.*;

public class Day20 {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();


        // Inserting the elements using put() method
        tm.put(3, "Java");
        tm.put(2, "C++");
        tm.put(1, "Python");
        tm.put(4, "JS");

        System.out.println(tm);

        // Removing the element corresponding to key
        tm.remove(4);

        System.out.println(tm);
    }
}
