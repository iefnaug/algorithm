package com.datastructure.recursion;

import java.util.LinkedList;

/**
 * @author GF
 * @since 2023/4/29
 */
public class HanluoTa {

    /**
     * 汉罗塔
     * @param n 个数
     * @param a 起始塔
     * @param b 借助塔
     * @param c 目标塔
     */
    public static void move(int n, MyList a, MyList b, MyList c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print(a,b,c);
        move(n - 1, b, a, c);
    }

    private static void print(MyList a, MyList b, MyList c) {
        System.out.println(a.getName() + ":" + a.toString());
        System.out.println(b.getName() + ":" + b.toString());
        System.out.println(c.getName() + ":" + c.toString());
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        MyList a = new MyList("a");
        MyList b = new MyList("b");
        MyList c = new MyList("c");

        for (int i = 1; i < 4; i++) {
            a.add(i);
        }

        print(a, b, c);

        move(3, a, b, c);
    }

    static class MyList extends LinkedList<Integer> {
        
        private String name;
        
        public MyList(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    
}
