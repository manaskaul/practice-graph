package solutions;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Map<String, Integer> map = new HashMap<>();
        // map.put("abc", 1);
        // map.put("abc", -1);
        // System.out.println(map.get("abc"));

        String s = "xyz";
        char[] c = s.toCharArray();
        
        String x = String.valueOf(c);
        System.out.printf("%s\n", x);
        
        c[1] = (char) ('a' + 3);
        String y = String.valueOf(c);
        System.out.printf("%s\n", y);

        // char y = (char) ('a' + 3);
        // System.out.printf("%c\n", y);
    }
}
