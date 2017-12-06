/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 16, 2017
 Problem:    Linked List
 Results:


*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Search {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hi");
        list.add("hello");
        list.add("world");
        list.add("hello");

        System.out.println("list: " + list);

        
        System.out.println("the first index: "+list.indexOf("hello"));
        System.out.println("the last index: "+list.lastIndexOf("hello"));

        /*
list: [hi, hello, world, hello]
the first index: 1
the last index: 3
        */

        List sublist = list.subList(1,2);
        System.out.println("the sublist: "+sublist);
        
        sublist.remove(0);
        System.out.println("the sublist: "+sublist);
        System.out.println("the list: "+list);

        /* sublist只是显示出来 原存储还是在list那里 所以对sublist做的删除操作还是会影响到list
the sublist: [hello]
the sublist: []
the list: [hi, world, hello]
        */

        if (list.contains("hello")) {
           System.out.println("yes");
         
        } else {
            System.out.println("no");
        
        }

        /*
yes
        */
    }
}
