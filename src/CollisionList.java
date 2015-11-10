/**
 * This class represents a gathering of Collision objects
 * @author aaronwalker
 */
import java.util.ArrayList;

public class CollisionList {
	private ArrayList<Collision> collisions;
	
	public CollisionList(){
		collisions = new ArrayList<Collision>();
	}
	
	/**
	 * Adds a Collision object to the CollisionList
	 * @param c a Collision object to add
	 */
	public void addCollision(Collision c){
		collisions.add(c);
	}
	
	/**
	 * Returns the size of a CollisionList
	 * @return an int detailing the size of the CollisionList
	 */
	public int size(){
		return collisions.size();
	}
	
	/**
	 * Gets the Collision object at a specified index in a CollisionList
	 * @param i an int representing the desired location
	 * @return a Collision object at i in a CollisionList
	 */
	public Collision get(int i){
		return collisions.get(i);
	}
	
	/**
	 * Finds the number of Collisions that occurred in a specific zip code.
	 * @param zip a Zip object to use as a key to sort through a CollisionList. 
	 * @return numCollisions is an integer representing all collisions that occurred
	 * in a given zip code.
	 */
	public int collisionsByZip(Zip zip){
		int numCollisions = 0;
		for(int index = 0; index < collisions.size(); index++){
			if(collisions.get(index).getZipCode() == zip.getZipCode()){
				numCollisions ++;
			}
		}
		return numCollisions;
	}
	
	
	/**
	 * Finds the number of both injuries and fatalities that occurred in a given zip code.
	 * @param zip a Zip object to be used as a key to sort through a CollisionList.
	 * @return numInjuriesAndFatalities an integer representing both injuries and fatalities
	 * that occurred in a given zip code.
	 */
	public int injuriesAndFatalitiesByZip(Zip zip){
		int numInjuriesAndFatalities = 0;
		for(int index = 0; index < collisions.size(); index++){
			if(collisions.get(index).getZipCode() == zip.getZipCode()){
				numInjuriesAndFatalities += (collisions.get(index).getPersonsInjured() + collisions.get(index).getPersonsKilled());
			}
		}
		return numInjuriesAndFatalities;
	}
	
	/** 
	 * Finds the number of fatalities that occurred in a given zip code. 
	 * @param zip A Zip object to use as a key to sort through a CollisionList
	 * @return numFatalities is an integer representing all fatalities that occurred in 
	 * a given zip code.
	 */
	public int fatalitiesByZip(Zip zip){
		int numFatalities = 0;
		for(int index = 0; index < collisions.size(); index++){
			if(collisions.get(index).getZipCode() == zip.getZipCode()){
				numFatalities += collisions.get(index).getPersonsKilled();
			}
		}
		return numFatalities;
	}
	
	/**
	 * Finds the number of cyclist injuries and fatalities that occurred in a given zip code.
	 * @param zip a Zip object to be used as a key to sort through a CollisionList.
	 * @return numCyclistsTotalHurt an integer representing all cyclist injuries and fatalities
	 * that occurred in a given zip code.
	 */
	public int cyclistsTotalHurtByZip(Zip zip){
		int numCyclistsTotalHurt = 0;
		for(int index = 0; index < collisions.size(); index++){
			if(collisions.get(index).getZipCode() == zip.getZipCode()){
				numCyclistsTotalHurt += (collisions.get(index).getCyclistsInjured() + collisions.get(index).getCyclistsKilled());
			}
		}
		return numCyclistsTotalHurt;
	}
	
	/**
	 * Finds the number of cyclist fatalities that occurred in a given zip code.
	 * @param zip a Zip object to be used as a key to sort through a CollisionList.
	 * @return numCyclistsKilled an integer representing all cyclist fatalities that
	 * occurred in a given zip code.
	 */
	public int cyclistsKilledByZip(Zip zip){
		int numCyclistsKilled = 0;
		for(int index = 0; index < collisions.size(); index++){
			if(collisions.get(index).getZipCode() == zip.getZipCode()){
				numCyclistsKilled += collisions.get(index).getCyclistsKilled();
			}
		}
		return numCyclistsKilled;
	}
}
