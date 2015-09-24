
public class Collision {
	private String bourough;
	private int zipCode;
	private String vehicleOne; //# type of one of the vehicles involved
	private String vehicleTwo; //# type of the other vehicle involved
	private int personsInjured; //# of total people (motos, cycls, peds) injured
	private int personsKilled; //# of total people (motos, cycls, peds) killed
	private int pedsInjured; //# of pedestrians injured
	private int pedsKilled; //# of pedestrians killed
	private int cyclistsInjured;
	private int cyclistsKilled; 
	private int motosInjured; //# of motorists injured
	private int motosKilled; //# of motorists killed
	private int totalHurt =(personsInjured) + (personsKilled); //# of people both killed and injured
	
	public Collision(
			String bourough, 
			String zipCode,
			String vehicleOne, 
			String vehicleTwo,
			String personsInjured,
			String personsKilled,
			String pedsInjured,
			String pedsKilled,
			String cyclistsInjured,
			String cyclistsKilled,
			String motosInjured,
			String motosKilled
			)
	{
		this.bourough = bourough;
		this.zipCode = Integer.parseInt(zipCode);
		this.vehicleOne = vehicleOne;
		this.vehicleTwo = vehicleTwo;
		this.personsInjured = Integer.parseInt(personsInjured);
		this.personsKilled = Integer.parseInt(personsKilled);
		this.pedsInjured = Integer.parseInt(pedsInjured);
		this.pedsKilled = Integer.parseInt(pedsKilled);
		this.cyclistsInjured = Integer.parseInt(cyclistsInjured);
		this.cyclistsKilled = Integer.parseInt(cyclistsKilled);
		this.motosInjured = Integer.parseInt(motosInjured);
		this.totalHurt = this.personsInjured + this.personsKilled;
	}

	public String getBourough() {
		return bourough;
	}

	public void setBourough(String bourough) {
		this.bourough = bourough;
	}

	public int getZipCode(){
		return zipCode;
	}
	
	
	public String getVehicleOne() {
		return vehicleOne;
	}

	public void setVehicleOne(String vehicleOne) {
		this.vehicleOne = vehicleOne;
	}

	public String getVehicleTwo() {
		return vehicleTwo;
	}

	public void setVehicleTwo(String vehicleTwo) {
		this.vehicleTwo = vehicleTwo;
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

	public int getPedsInjured() {
		return pedsInjured;
	}

	public void setPedsInjured(int pedsInjured) {
		this.pedsInjured = pedsInjured;
	}

	public int getPedsKilled() {
		return pedsKilled;
	}

	public void setPedsKilled(int pedsKilled) {
		this.pedsKilled = pedsKilled;
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

	public int getMotosInjured() {
		return motosInjured;
	}

	public void setMotosInjured(int motosInjured) {
		this.motosInjured = motosInjured;
	}

	public int getMotosKilled() {
		return motosKilled;
	}

	public void setMotosKilled(int motosKilled) {
		this.motosKilled = motosKilled;
	}

	public int getTotalHurt() {
		return totalHurt;
	}

	public void setTotalHurt(int totalHurt) {
		this.totalHurt = totalHurt;
	}

}
