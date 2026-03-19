package solutions;

import java.util.*;

public class Test {
    private static int INF = Integer.MAX_VALUE - 10;

  public static void main(String[] args) {
        System.out.println("Hello, World!");

        int x = 6;
        int a = 3;

        int y = (int) Math.ceil(a/x);
        System.out.println(y);

        // List<Integer> lst = new ArrayList<>();
        // lst.add(0);
        // lst.add(-0);
        // for (int i : lst) {
        //     System.out.println(i);
        // }

        // char[] B = new char[]{'0','1'};
        // for(char x : B) {
        //     for(char y : B) {
        //         for(char z : B) {
        //             char b1 = x, b2 = y, c = z;

        //             char[] sum1 = sum(b1, b2);
        //             char s1 = sum1[0]; 
        //             char c1 = sum1[1];

        //             char[] sum2 = sum(s1, c);
        //             char s2 = sum2[0];
        //             char c2 = sum2[1];

        //             c = c2;
                    
        //             System.out.printf("\nb1 = %c\tb2 = %c\tc = %c\n", s1, s2, c);
        //             System.out.printf("s = %c\tc = %c\n", s2, c);
        //         }
        //     }
        // }

  }

  private static char[] sum(char s1, char s2) {
        if(s1 == '0' && s2 == '0') {
            return new char[]{'0','0'};
        }
        else if(s1 == '0' && s2 == '1') {
            return new char[]{'1','0'};
        }
        else if(s1 == '1' && s2 == '0') {
            return new char[]{'1','0'};
        }
        else { // (s1 == '1' && s2 == '1')
            return new char[]{'0','1'};
        }
    }
}
