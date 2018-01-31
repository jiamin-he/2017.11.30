/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public enum ParkingLotController { //singleton facade controller
	INSTANCE;
	public ParkingLotController() {
		VehicleSensorPool.INSTANCE.register(VehicleEventListenerPool.INSTANCE);
	}
	
	public ParkingTicket enter(VehicleEntryEvent vehicleEntryEvent) throws SpotNotAvailableException, IllegitimateVehicleException { // app event
		ParkingSpot parkingSpot = null;
		Vehicle enteringVehicle = vehicleEntryEvent.getVehicle();
		try {
			parkingSpot = ParkingLot.addVehicle(enteringVehicle);
			return printTicket(enteringVehicle);
		}
		catch(SpotNotAvailableException e) {
			displayWaitMessage(e);
			//very primitive retry mechanism..substitute your own here
			//or we can use wait-notify
			Thread.sleep(WAIT_DURATION);
			enter(vehicleEntryEvent);
		}
		catch(IllegitimateVehicleException e) {
			displayIntoleranceMessage(e);
		}
	}
	
	public ParkingBill exit(VehicleExitEvent vehicleExitEvent) { // app event
		Vehicle exitingVehicle = ParkingLot.getVehicle(enteringVehicle);
		ParkingLot.removeVehicle(exitingVehicle);
		long timeVehicleKept = ParkingLot.getTimeKept(exitingVehicle);
		return printBill(exitingVehicle, timeVehicleKept);
	}
	
	private ParkingTicket printTicket(Vehicle vehicle) {
		//..
	}
	
	private ParkingBill printBill(Vehicle vehicle, long timeVehicleKept) {
                //BillingSystem is again a facade
		return BillingSystem.INSTANCE.printBill(vehicle, timeVehicleKept);
	}
}