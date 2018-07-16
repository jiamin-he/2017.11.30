/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public interface VehicleValidationStrategy {
	public void validate(Vehicle vehicle) throws IllegitimateVehicleException;
}