/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Parking Lot
*/


package parking2;

public enum ParkingLot {
	INSTANCE,
	//..internal DSes to maintain parking spots, vehicles and assignments.
	//strategies for validation and assignment
	private ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;
	private VehicleValidationStrategy vehicleValidationStrategy;
	public ParkingLot() {
		//..init internal DSes to maintain parking spots, vehicles and assignments. 
		//init strategies
		parkingSpotAssignmentStrategy = new ParkingSpotAssignmentStrategyImpl(this);
		vehicleValidationStrategy = new VehicleValidationStrategyImpl(this);
	}
	public ParkingSpot addVehicle(Vehicle vehicle) throws SpotNotAvailableException, IllegitimateVehicleException {
		//check if vehicle is elligible for parking(we can have a Validator object) and assign ParkingSpot according to strategy
		vehicleValidationStrategy.validate();
		//assignment happens only after validation
		return assign(vehicle);
	}
	private ParkingSpot assign(Vehicle vehicle) throws SpotNotAvailableException {
		ParkingSpot vacantParkingSpot = parkingSpotAssignmentStrategy.assign(vehicle);
		synchronized(vacantParkingSpot) { //so that no two vehicles are assigned the same spot
			if(vacantParkingSpot.isVacant()) {
				//..associate vehicle with vacantParkingSpot. Update internal DSes.	
				//start timekeeping using a TimeKeeper object
			}
			else {
				//retry
				return assign(vehicle);
			}
		}
		return vacantParkingSpot;
	}
	public Vehicle getVehicle(String plate) {
		//..get vehicle by plate
	}
	public void removeVehicle(Vehicle vehicle) {
		//..remove vehicle from lot. reclaim parkingSpot. Update internal DSes.
		//stop timekeeping.
	}
	public void getTimeKept(Vehicle vehicle) {
		//return time kept by TimeKeeper
	}
}