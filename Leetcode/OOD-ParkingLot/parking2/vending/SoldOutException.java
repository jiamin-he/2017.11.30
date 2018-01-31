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

// The Vending Machine throws this exception if the user request for a product which is sold out

package vending;
public class SoldOutException extends RuntimeException {
    private String message;
   
    public SoldOutException(String string) {
        this.message = string;
    }
   
    @Override
    public String getMessage(){
        return message;
    }
   
}