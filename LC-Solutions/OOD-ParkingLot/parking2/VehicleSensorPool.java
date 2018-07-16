/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public enum VehicleSensorPool {
	INSTANCE;
	private List<VehicleSensor> vehicleSensors;
	public VehicleSensorPool() {
		//init vehicleSensors, according to config
		for(VehicleSensor vehicleSensor : vehicleSensors) {
			new Thread(vehicleSensor).start();
		}
	}
	public void register(VehicleEventListener vehicleEventListener) {
		for(VehicleSensor vehicleSensor : vehicleSensors) {
			vehicleSensor.addEventListener(vehicleEventListener);
		}
	}
}