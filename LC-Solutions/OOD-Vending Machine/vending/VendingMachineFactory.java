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

// A Factory class to create different kinds of Vending Machine

package vending;

/**
  * Factory class to create instance of Vending Machine, this can be extended to create instance of
  * different types of vending machines.
  * @author Javin Paul
  */
public class VendingMachineFactory {      
    public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl();
    }
}

