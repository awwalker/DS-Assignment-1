/**
 * This class represents a single collision
 * @author aaronwalker
 *
 */
public class Collision {
	private String bourough;
	private int zipCode;
	private int personsInjured; //# of total people (motos, cycls, peds) injured
	private int personsKilled; //# of total people (motos, cycls, peds) killed
	private int cyclistsInjured;
	private int cyclistsKilled; 
	private int totalHurt =(personsInjured) + (personsKilled); //# of people both killed and injured
	
	public Collision(
			String bourough, 
			String zipCode,
			String personsInjured,
			String personsKilled,
			String cyclistsInjured,
			String cyclistsKilled
			)
	{
		this.bourough = bourough;
		this.zipCode = Integer.parseInt(zipCode);
		this.personsInjured = Integer.parseInt(personsInjured);
		this.personsKilled = Integer.parseInt(personsKilled);
		this.cyclistsInjured = Integer.parseInt(cyclistsInjured);
		this.cyclistsKilled = Integer.parseInt(cyclistsKilled);
		this.totalHurt = this.personsInjured + this.personsKilled;
	}

	public String getBourough() {
		return bourough;
	}

	public int getZipCode(){
		return zipCode;
	}
	
	public int getPersonsInjured() {
		return personsInjured;
	}

	public void setPersonsInjured(int personsInjured) {
		this.personsInjured = personsInjured;
	}

	public int getPersonsKilled() {
		return personsKilled;
	}

	public void setPersonsKilled(int personsKilled) {
		this.personsKilled = personsKilled;
	}

	public int getCyclistsInjured() {
		return cyclistsInjured;
	}

	public void setCyclistsInjured(int cyclistsInjured) {
		this.cyclistsInjured = cyclistsInjured;
	}

	public int getCyclistsKilled() {
		return cyclistsKilled;
	}

	public void setCyclistsKilled(int cyclistsKilled) {
		this.cyclistsKilled = cyclistsKilled;
	}

	public int getTotalHurt() {
		return totalHurt;
	}

	public void setTotalHurt(int totalHurt) {
		this.totalHurt = totalHurt;
	}
}
