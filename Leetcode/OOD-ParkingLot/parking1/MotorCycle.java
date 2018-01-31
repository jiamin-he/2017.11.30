/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking1;
public class Motorcycle extends Vehicle
{
    public Motorcycle()
    {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    public boolean canFitinSpot(ParkingSpot spot) 
    { ... }
}