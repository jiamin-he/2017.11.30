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

// The public API of vending machine, usually all high-level functionality should go in this class

package vending;

import java.util.List;

/**
  * Decleare public API for Vending Machine
  * @author Javin Paul
  */
public interface VendingMachine {   
    public long selectItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();   
    public void reset();
}