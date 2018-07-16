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

// Another Java Enum to represent Coins supported by Vending Machine


package vending;

/**
  * Coins supported by Vending Machine.
  * @author Javin Paul
  */
public enum Coin {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
   
    private int denomination;
   
    private Coin(int denomination){
        this.denomination = denomination;
    }
   
    public int getDenomination(){
        return denomination;
    }
}