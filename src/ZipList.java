/**
 * This class represents a grouping of Zip objects. 
 * @author aaronwalker
 */
import java.util.ArrayList;
import java.util.Collections;

public class ZipList {
	private ArrayList<Zip> zips;
	
	public ZipList(){
		zips = new ArrayList<Zip>();
	}
	/**
	 * Adds a Zip object to a ZipList
	 * @param z is a Zip object to be added to the current ZipList
	 */
	public void addZip(Zip z){
		zips.add(z);
	}
	
	/**
	 * Finds the amount of Zip objects in a ZipList.
	 * @return the integer amount of Zip objects in a ZipList
	 */
	public int size(){
		return zips.size();
	}
	
	public boolean isEmpty(){
		return zips.isEmpty();
	}

	/**
	 * Finds the Zip object within a ZipList at a given index.
	 * @param index an integer representing a place in the current ZipList
	 * @return the Zip object at the given index if it is available or null
	 * if the object does not exist or the index is out of bounds.  
	 */
 	public Zip get(int index){
		//go through a ZipList...
		for(int i = 0; i< zips.size(); i++){
			//check each current place in the list against the wanted place
			if(i == index){
				return zips.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Checks a ZipList for a specific Zip object. 
	 * 
	 * @param z is a Zip object representing a Zip Code.
	 * @return true if the parameter z is inside the ZipList, false if 
	 * z is not in the ZipList
	 */
	public boolean contains(Zip z){
		//scan through a ZipList
		for(int i = 0; i < zips.size(); i++){
			//check the current place against the passed in Zip
			if( zips.get(i).getZipCode() == z.getZipCode()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sorts a ZipList in place by the number of Collisions that occurred
	 * in each Zip object in the ZipList.
	 * If two Zip object have the same number of Collisions they are treated
	 * as equal.
	 */
	public void sortByCollisions(){
		Collections.sort(zips, new ZipByCollisionsComp());
	}
	
	public void sortByInjuriesAndFatalities(){
		Collections.sort(zips, new ZipByInjuriesAndFatalitiesComp());
	}
	
	/**
	 * Sorts a ZipList in place by the number of cyclist injuries and 
	 * fatalities that occurred in each Zip object in the ZipList.
	 * If two Zip object have the same number of cyclist injuries and
	 * fatalities ZipByCyclistsComp() breaks the tie by looking at 
	 * pure fatalities. If the tie still cannot be broken they are 
	 * treated as equal. 
	 */
	public void sortByCyclists(){
		Collections.sort(zips, new ZipByCyclistsComp());
	}
	
	public ZipList findTopThreeZips(String determinant){
		int counter = 3;
		int current = 0; // current will be set to the current number of collisions for the next Zip object
		int latest = -1; // last position of the topThreeZips ZipList for comparisons
		ZipList topThreeZips = new ZipList();
		
		if(determinant.equals("collisions")){
			for(int index = 0; index < zips.size(); index++){
				if(counter > 0){
					current = zips.get(index).getCollisions();
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter --;
						latest++;
					}
					else if(current != topThreeZips.get(latest).getCollisions()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					else if(current == topThreeZips.get(latest).getCollisions()){
						if(!(topThreeZips.get(latest).getTie() && zips.get(index).getTie())){
							counter--;
						}
						else{
							topThreeZips.addZip(zips.get(index));
							latest++;
							//counter--;
						}
					}
				}
				else{
					break;
				}
			}
		}
		else if(determinant.equals("cyclists")){
			for(int index = 0; index < zips.size(); index++){
				if(counter > 0){
					current = zips.get(index).getCyclistsTotalHurt();
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					else if(current != topThreeZips.get(latest).getCyclistsTotalHurt()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					else if(current == topThreeZips.get(latest).getCyclistsTotalHurt()){
						if(!(topThreeZips.get(latest).getTie() && zips.get(index).getTie())){
							counter--;
						}
						else{
							topThreeZips.addZip(zips.get(index));
							latest++;
							//counter--;
						}	
					}
				}
				else{
					break;
				}
			}
		}
		else if(determinant.equals("injuries/fatalities")){
			for(int index = 0; index < zips.size(); index++){
				if(counter > 0){
					current = zips.get(index).getTotalHurt();
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					else if(current != topThreeZips.get(latest).getTotalHurt()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					else if(current == topThreeZips.get(latest).getTotalHurt()){
						if(!(topThreeZips.get(latest).getTie() && zips.get(index).getTie())){
							counter--;
						}
						else{
							topThreeZips.addZip(zips.get(index));
							latest++;
							//counter--;
						}	
					}
				}
				else{
					break;
				}
			}
		}
		return topThreeZips;
	}
}
