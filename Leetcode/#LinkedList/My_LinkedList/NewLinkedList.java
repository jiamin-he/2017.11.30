/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 17, 2017
 Problem:    Linked List
 Results:


*/


class NewLinkedList {

    static class LinkedList{

    Node head;

    public void print(){
        Node cur = head;
        while (cur!=null){
            System.out.print(cur.value +" ");
            cur=cur.next;
        }
    }
}

    

    static class Node {
            int value;
            Node next;

            Node(int d){
                value =d;
                next = null;
            }
        }

    public static void printReverse(Node head) {
        
        if (head==null) return;

        printReverse(head.next);
        System.out.printf(head.value + " ");

    
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new Node(0);
        Node second = new Node(1);
        Node third = new Node(2);

        list.head.next = second;
        second.next = third;

        list.print(); 
        printReverse(list.head);
    }

    


}
