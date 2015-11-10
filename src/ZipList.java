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
	
	/**
	 * Checks if a ZipList contains any elements
	 * @return true / false based on whether a ZipList contains any elements
	 */
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
	/**
	 * Sorts a ZipList in place by the number of Injuries and Fatalities that occurred
	 * in each Zip object in the ZipList
	 * If two Zip objects have the same number of injuries ties are broken by Fatalities
	 */
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
		//looking for the most collisions by Zip
		if(determinant.equals("most collisions")){
			//start at the beginning of a sorted ZipList
			for(int index = 0; index < zips.size(); index++){
				//only search for as long as we have < 3 or < 3 with ties included
				if(counter > 0){
					current = zips.get(index).getCollisions();
					//if the topThreeZips has nothing in it add the first Zip we come to
					//push the current spot in topThreeZips list...and decrement amount looking for
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter --;
						latest++;
					}
					//if the current Zip object has the same amount of collisions we can add it
					//but it does not count against the total allowed so no decrementing counter
					else if(current == topThreeZips.get(latest).getCollisions()){
						topThreeZips.addZip(zips.get(index));
						latest++;
					}
					//Zips are already sorted so if there isn't a tie just add and decrement
					else{
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
				}
				else{
					break;
				}
			}
		}
		//looking for cyclist injuries and deaths in a ZipList
		else if(determinant.equals("cyclists")){
			//search through the ZipList
			for(int index = 0; index < zips.size(); index++){
				//search for three disregarding ties so 3+ if ties
				if(counter > 0){
					current = zips.get(index).getCyclistsTotalHurt();
					//if the new ZipList is empty add the first one automatically and shrink the counter
					//push position in the new ZipList
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					//if the current Zip has the same number of cyclists hurt then check for a tie
					else if(current == topThreeZips.get(latest).getCyclistsTotalHurt()){
						//if there isn't a tie between the current spot in our new ZipList and the current Zip trying to be added 
						//skip it because the current one must have fewer deaths
						if(!(topThreeZips.get(latest).getTie() && zips.get(index).getTie())){
							counter--;
						}
						//if they both have a tie add it to the ZipList because they have same deaths and same hurt
						else{
							topThreeZips.addZip(zips.get(index));
							latest++;
						}	
					}
					//if there isn't a tie in hurt add the Zip because they are already sorted
					else{
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
				}
				else{
					break;
				}
			}
		}
		//finding the most injuries and fatalities
		else if(determinant.equals("injuries/fatalities")){
			for(int index = 0; index < zips.size(); index++){
				//continue through the ZipList as long as we have < 3 or < 3 with ties
				if(counter > 0){
					current = zips.get(index).getTotalHurt();
					//if the topThreeZips is empty add the first one we come to and 
					//decrement counter / increment place in topThreeZips
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
					//if there is a tie between the amount of people injured and killed
					//break it depending on people killed. 
					else if(current == topThreeZips.get(latest).getTotalHurt()){
						if(!(topThreeZips.get(latest).getTie() && zips.get(index).getTie())){
							counter--;
						}
						else{
							topThreeZips.addZip(zips.get(index));
							latest++;
						}	
					}
					//Zips are already sorted so if no tie it gets added automatically
					else{
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
					}
				}
				else{
					break;
				}
			}
		}
		//finding the least amount of collisions...modeled after finding most collisions
		else if(determinant.equals("least collisions")){
			//search a presorted ZipList from the back to get fewest collisions
			for(int index = zips.size() - 1; index >= 0; index--){
				//add Zip codes to the ZipList as long as we have less than 3 according to ties
				if(counter > 0){
					current = zips.get(index).getCollisions();
					//if the list is empty we have to add one to it to start lowering the counter
					//and increasing the latest spot in the topThreeZips list
					if(topThreeZips.isEmpty()){
						topThreeZips.addZip(zips.get(index));
						counter --;
						latest++;
					}
					//if the current Zip object has the same amount of collisions we add it
					//but don't count it against the total allowed so don't lower the counter
					//but do increment spot in the topThreeZips list
					else if(current == topThreeZips.get(latest).getCollisions()){
						topThreeZips.addZip(zips.get(index));
						latest++;
					}
					//Zips are already sorted so if there isn't a tie added it automatically and decrement
					else{
						topThreeZips.addZip(zips.get(index));
						counter--;
						latest++;
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
