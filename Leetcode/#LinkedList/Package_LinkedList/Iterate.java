/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 16, 2017
 Problem:    Linked List
 Results:


*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;


class Iterate {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hi");
        list.add("hello");
        list.add("world");

        System.out.println("list: " + list);

        System.out.println("for loop: " + list);

        for (int i = 0; i< list.size() ; i++ ) {
            System.out.println(list.get(i));
        }

        System.out.println("advanced loop: " + list);
        for (String s : list ) {
            System.out.println(s);
        }

        System.out.println("iterator: " + list);
        Iterator i = list.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("while loop: " + list);
        int num = 0;
        while(list.size()>num){
            System.out.println(list.get(num++));
        }

        /*

list: [hi, hello, world]
for loop: [hi, hello, world]
hi
hello
world
advanced loop: [hi, hello, world]
hi
hello
world
iterator: [hi, hello, world]
hi
hello
world
while loop: [hi, hello, world]
hi
hello
world

        */

        Iterator reverseI = list.descendingIterator();
        System.out.println("reversed iterate:");

        while(reverseI.hasNext()){
            System.out.println(reverseI.next());
        }

        /*
reversed iterate:
world
hello
hi
        */
    }
}
