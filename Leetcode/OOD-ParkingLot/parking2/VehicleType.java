/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public enum VehicleType {
	BIKE(100.0), BICYCLE(90.0), TRUCK(1000.0), CAR(400.0); //sample props of VehicleType
	private int maxHeight;
	public VehicleType(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	//..
}