/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public enum VehicleEventListenerPool implements VehicleEventListener { //composite singleton
	INSTANCE;
	private List<VehicleEventListener> vehicleEventListeners;
	public VehicleEventListenerPool() {
		//init vehicleEventListeners, according to config
	}
	public void onVehicleEnter(VehicleEntryEvent vehicleEntryEvent) {
		//select a listener from the pool and call its onVehicleEnter method
	}
	public void onVehicleExit(VehicleExitEvent vehicleExitEvent) {
		//select a listener from the pool and call its onVehicleExit method
	}
}