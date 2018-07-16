/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 16, 2017
 Problem:    Linked List
 Results:


*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Add {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hi");
        list.add("hello");
        list.add("world");

        System.out.println("add: " + list);

        List<String> list2 = new ArrayList<>();
        list2.add("!");
        list2.add("Jiamin");
        list2.add("is");
        list2.add("here!");

        list.addAll(list2);

        System.out.println("add all: " + list);

        list.addFirst("Everyone!");
        
        System.out.println("add first: " + list);

        list.addLast("!!");

        System.out.println("add last: " + list);

/* 

add: [hi, hello, world]
add all: [hi, hello, world, !, Jiamin, is, here!]
add first: [Everyone!, hi, hello, world, !, Jiamin, is, here!]
add last: [Everyone!, hi, hello, world, !, Jiamin, is, here!, !!]

*/

        list.removeFirst();
        System.out.println("remove first: " + list);
        list.removeLast();
        System.out.println("remove last: " + list);

        list.set(2,"world!!!!!!");
        System.out.println("set the value of a certain position: " + list);

        System.out.println("get the value of a certain position: "+list.get(2));

        list.add(4,"He");
        System.out.println("add to a certain position: " + list);
        list.remove(4);
        System.out.println("remove a certain position: " + list);
    
/*

remove first: [hi, hello, world, !, Jiamin, is, here!, !!]
remove last: [hi, hello, world, !, Jiamin, is, here!]
set the value of a certain position: [hi, hello, world!!!!!!, !, Jiamin, is, here!]
get the value of a certain position: world!!!!!!
add to a certain position: [hi, hello, world!!!!!!, !, He, Jiamin, is, here!]
remove a certain position: [hi, hello, world!!!!!!, !, Jiamin, is, here!]

*/

        LinkedList<String> list3 = new LinkedList<>();
        list3 = (LinkedList)list.clone();
        System.out.println("clone: " + list3);

        /*
clone: [hi, hello, world!!!!!!, !, Jiamin, is, here!]
        */

    }
}
