/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Vending Machine

Use case list:

select item and get price
accept bills/coins
dispense items purchased and return change
refund when cancelling the request
Possible exceptions:

Sold out
Not fully paid
Not enough changes

*/

// A parameterized utility class to hold two objects.

package vending;
/**
  * A parameterized utility class to hold two different object.
  * @author Javin Paul
  */
public class Bucket<E1, E2> {
    private E1 first;
    private E2 second;
   
    public Bucket(E1 first, E2 second){
        this.first = first;
        this.second = second;
    }
   
    public E1 getFirst(){
        return first;
    }
   
    public E2 getSecond(){
        return second;
    }
}