/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public class VehicleEventListenerImpl implements VehicleEventListener {
	public void onVehicleEnter(VehicleEntryEvent vehicleEntryEvent) {
		ParkingLotController.INSTANCE.enter(vehicleEntryEvent);
	}
	public void onVehicleExit(VehicleExitEvent vehicleExitEvent) {
		ParkingLotController.INSTANCE.exit(vehicleExitEvent);
	}
}