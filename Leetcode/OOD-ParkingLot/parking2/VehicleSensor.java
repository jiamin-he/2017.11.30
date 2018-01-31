/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public class VehicleSensor implements Runnable {
	private class SensorData {//contains raw sensor data that the sensor must use to raise events}
	public void run() {
		while(true) {
			//sense Vehicle entry and exit and notify event listeners
			SensorData sensorData = sense(); //blocking call
			
			//on entry create a Vehicle object (populated with height, type, plate etc) and notify.
			//on exit retrieve vehicle object from ParkingLot object and raise event.
		}
	}
	private Vehicle createVehicleEvent(SensorData sensorData) {
		if( //sensorData points to entry) {
			Vehicle vehicle = createVehicle(sensorData);
			return new VehicleEntryEvent(vehicle);
		}
		else { //sensorData points to exit
			return new VehicleExitEvent(sensorData.getPlate());
		}
	}
	private Vehicle createVehicle(SensorData sensorData) {
		//series of vehicle.setXXX(sensorData.getXXX())
	}
}