/**
 * 
 * @author aaronwalker
 *
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

	public int getZipCode(){
		return zip;
	}
	
	public boolean getTie(){
		return tie;
	}
	
	public void setTie(boolean tie){
		this.tie = tie;
	}
	
	public int getCollisions() {
		return collisions;
	}

	public void setCollisions(int collisions) {
		this.collisions = collisions;
	}

	public int getTotalHurt() {
		return totalHurt;
	}

	public void setTotalHurt(int totalHurt) {
		this.totalHurt = totalHurt;
	}
	
	public int getPeopleKilled(){
		return peopleKilled;
	}
	
	public void setPeopleKilled(int peopleKilled){
		this.peopleKilled = peopleKilled;
	}
	
	public int getCyclistsTotalHurt() {
		return cyclistsTotalHurt;
	}
	
	public void setCyclistsTotalHurt(int cyclistsTotalHurt) {
		this.cyclistsTotalHurt = cyclistsTotalHurt;
	}
	
	public int getCyclistsKilled(){
		return cyclistsKilled;
	}
	
	public void setCyclistsKilled(int cyclistsKilled){
		this.cyclistsKilled = cyclistsKilled;
	}
	
	public boolean equals(Zip z){
		if(this.zip == z.zip){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return String.format("%s", Integer.toString(this.zip));
	}
}
