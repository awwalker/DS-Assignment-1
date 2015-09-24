/**
 * This class represents a vehicle type (taxi, bus, fire truck, etc.)
 * Each vehicle is represented as a String and has a data field called collisions 
 * that accumulates crashes involving said vehicle type
 * @author aaronwalker
 *
 */
public class VehicleType{
	private String type; //
	private int collisions = 0;
	
	public VehicleType(String type){
		this.type = type;
	}
	
	/**
	 * Gives back the type of vehicle the VehicleTpye object represents
	 * @return a String representing the type of vehicle being represented 
	 */
	public String getVehicleType(){
		return type;
	}
	
	/**
	 * Adds 1 to the amount of collisions associated with a vehicle type
	 */
	public void addCollision(){
		this.collisions++;
	}
	
	/**
	 * Gives back the amount of collisions a vehicle type is involved in
	 * @return an int of all collisions a vehicle type is involved in
	 */
	public int getCollisions(){
		return collisions;
	}
	
}
