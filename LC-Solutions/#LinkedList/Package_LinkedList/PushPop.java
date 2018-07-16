/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 17, 2017
 Problem:    Linked List
 Results:


*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class PushPop {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hi");
        list.add("hello");
        list.add("world");
        list.add("hello");

        System.out.println("list: " + list);

        list.push("first");
        System.out.println("push: "+list);


        System.out.println("pop this: "+list.pop() + "  list after pop: "+list);

        /*
list: [hi, hello, world, hello]
push: [first, hi, hello, world, hello]
pop this: first  list after pop: [hi, hello, world, hello]
        */
        // push是在最前面加入 pop是在最前面弹出
        
    }
}
