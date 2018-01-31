/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public interface ParkingSpotAssignmentStrategy {
	public ParkingSpot assign(Vehicle vehicle) throws SpotNotAvailableException;
}
