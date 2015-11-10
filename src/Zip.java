/**
 * This class represents a ZIP code 
 * @author aaronwalker
 */
public class Zip {
	private boolean tie;
	private int collisions;
	private int totalHurt; // # of people injured and killed
	private int peopleKilled; // # needed for ties between zips
	private int cyclistsTotalHurt;
	private int cyclistsKilled; //# needed for ties between zips when searching for cycling danger
	private int zip;
	
	public Zip(String zip){
		this.zip = Integer.parseInt(zip);	
	}
	
	/**
	 * @return int representing a ZIP code
	 */
	public int getZipCode(){
		return zip;
	}
	
	/**
	 * @return a boolean value of whether or not the Zip has any ties
	 */
	public boolean getTie(){
		return tie;
	}
	
	/**
	 * @param tie Set to either true / false depending on presence / lack of a tie
	 */
	public void setTie(boolean tie){
		this.tie = tie;
	}
	
	/**
	 * @return int of collisions associated with the Zip object
	 */
	public int getCollisions() {
		return collisions;
	}

	/**
	 * @param collisions Set the number of collisions associated with a ZIP code
	 */
	public void setCollisions(int collisions) {
		this.collisions = collisions;
	}

	/**
	 * @return int representing the total number of people hurt in the ZIP code
	 */
	public int getTotalHurt() {
		return totalHurt;
	}

	/**
	 * @param totalHurt Set the total number of people hurt in a ZIP code
	 */
	public void setTotalHurt(int totalHurt) {
		this.totalHurt = totalHurt;
	}
	
	/**
	 * @return int the number of people who died in a ZIP code
	 */
	public int getPeopleKilled(){
		return peopleKilled;
	}
	
	/**
	 * @param peopleKilled Set the number of people who have died in a ZIP code
	 */
	public void setPeopleKilled(int peopleKilled){
		this.peopleKilled = peopleKilled;
	}

	/**
	 * @return int of how many cyclists were injured and killed in a ZIP code
	 */
	public int getCyclistsTotalHurt() {
		return cyclistsTotalHurt;
	}
	
	/**
	 * @param cyclistsTotalHurt Set the number of cyclists injured and killed in a ZIP code
	 */
	public void setCyclistsTotalHurt(int cyclistsTotalHurt) {
		this.cyclistsTotalHurt = cyclistsTotalHurt;
	}
	
	/**
	 * @return int of how many cyclists were killed in a ZIP code
	 */
	public int getCyclistsKilled(){
		return cyclistsKilled;
	}
	
	/**
	 * @param cyclistsKilled Set the number of cyclists who were killed in a ZIP code
	 */
	public void setCyclistsKilled(int cyclistsKilled){
		this.cyclistsKilled = cyclistsKilled;
	}
	
	/**
	 * Checks if two Zip objects are equal based on the ZIP code number they represent
	 * @param z the Zip object to check against
	 * @return boolean value representing whether or not a Zip object is in a ZipList
	 */
	public boolean equals(Zip z){
		if(this.zip == z.zip){
			return true;
		}
		return false;
	}
	
	/**
	 * This method Overrides the toString() method and creates a string representation of a Zip object
	 * @return the string returned is simply the integer associated with a ZIP code
	 */
	@Override
	public String toString(){
		return String.format("%s", Integer.toString(this.zip));
	}
}
