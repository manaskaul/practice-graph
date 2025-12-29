package solutions;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Map<String, Integer> map = new HashMap<>();
        // map.put("abc", 1);
        // map.put("abc", -1);
        // System.out.println(map.get("abc"));

        // String s = "xyz";
        // char[] c = s.toCharArray();
        
        // String x = String.valueOf(c);
        // System.out.printf("%s\n", x);
        
        // c[1] = (char) ('a' + 3);
        // String y = String.valueOf(c);
        // System.out.printf("%s\n", y);

        // char y = (char) ('a' + 3);
        // System.out.printf("%c\n", y);

        Map<String, List<Integer>> map = new HashMap<>();

        map.forEach((key, value) -> {
            System.out.printf("%s : ", key);
            for(int n : value) {
                System.out.printf("<%d>", n);
            }
            System.out.printf("\n");
        });

        map.getOrDefault("a", new ArrayList<>()).add(1);
        map.getOrDefault("b", new ArrayList<>()).add(2);
        map.getOrDefault("a", new ArrayList<>()).add(2);

        map.forEach((key, value) -> {
            System.out.printf("%s : ", key);
            for(int n : value) {
                System.out.printf("<%d>", n);
            }
            System.out.printf("\n");
        });
    }
}
