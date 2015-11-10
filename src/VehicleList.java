/**
 * This class represents a list of VehicleTypes
 * @author aaronwalker
 */
import java.util.ArrayList;

public class VehicleList {
	private ArrayList<VehicleType> types;
	
	public VehicleList(){
		types = new ArrayList<VehicleType>();
	}
	
	/**
	 * Takes a String and creates a VehicleType object out of it and adds it to a VehicleList
	 * @param s a String representing the vehicle type to be added to the VehicleList
	 */
	public void addVehicleType(String s){
		VehicleType v = new VehicleType(s);
		types.add(v);
	}
	
	/**
	 * Gets the size of a VehicleList
	 * @return an int representing the size of the VehilceList
	 */
	public int size(){
		return types.size();
	}
	
	/**
	 * Search through a VehicleList and return the wanted VehicleType
	 * @param t a VehicleType to search for
	 * @return a VehicleType found in the VehicleList or null if it DNE
	 */
	public VehicleType get(VehicleType t){
		for(int i = 0; i < types.size(); i++){
			if(types.get(i).getVehicleType().equals(t.getVehicleType())){
				return types.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Search through a VehicleList and return the VehicleType at a given index
	 * @param index the place within the VehicleList to get the wanted VehicleType at
	 * @return a VehicleType found within the VehicleList at index or null if it DNE
	 */
	public VehicleType get(int index){
		for(int i = 0; i < types.size(); i++){
			if(i == index){
				return types.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Checks a VehicleList to see if a VehicleType is already in it
	 * @param t a VehicleType to check for
	 * @return a boolean value representing the presence or lack of a VehicleType in a VehicleList
	 */
	public boolean contains(VehicleType t){
		for(int i = 0; i < types.size(); i++){
			if(types.get(i).getVehicleType().equals(t.getVehicleType())){
				return true;
			}
		}
		return false;
	}
	
}
