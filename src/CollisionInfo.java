/**
 * This class runs the main method returning a .out file with statistics based on ZIP code 
 * including collisions, injuries / deaths, vehicle types, and percentage of accidents occurring
 * in each borough
 * @author aaronwalker
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CollisionInfo {
	
	private static CollisionList collisions = new CollisionList();
	private static ZipList zipCodes = new ZipList();
	private static VehicleList vehicleTypes = new VehicleList();
	private static ArrayList<Integer> boroughPercents = new ArrayList<Integer>();
	private static ArrayList<String> boroughs = new ArrayList<String>();
	//positions in the csv file of each necessary data field
	private static final int BOROUGH = 2;
	private static final int ZIP = 3;
	private static final int VEHICLE1 = 19;
	private static final int VEHICLE2 = 20;
	private static final int PERSONS_INJURED = 8;
	private static final int PERSONS_KILLED = 9;
	private static final int CYCLISTS_INJURED = 12;
	private static final int CYCLISTS_KILLED = 13;

	private static int BROOKLYN = 0;
	private static int QUEENS = 1;
	private static int MANHATTAN = 2;
	private static int BRONX = 3;
	private static int STATEN_ISLAND = 4;
	
	public static void main(String[] args){
		//pre-set the vehicle types in order
		vehicleTypes.addVehicleType("taxi");
		vehicleTypes.addVehicleType("bus");
		vehicleTypes.addVehicleType("bicycle");
		vehicleTypes.addVehicleType("ambulance");
		vehicleTypes.addVehicleType("fire truck");
		//set up counters for borough accidents
		boroughPercents.add(0);
		boroughPercents.add(0);
		boroughPercents.add(0);
		boroughPercents.add(0);
		boroughPercents.add(0);
		//get a file to read and create an output file
		try{
			File read = new File(args[0]);
			File write = new File(createOutPutFile(args[0]));
			try{
				Scanner sc = new Scanner(read);
				while(sc.hasNext()){
					String line = sc.nextLine();
					ArrayList<String> info = split(line);
					
					//eliminate the header row and any row with missing data fields.
					if( (!info.contains("")) && (!info.get(ZIP).equals("ZIP CODE"))){
						//create collision object
						Collision c = new Collision(
								info.get(BOROUGH),
								info.get(ZIP),
								info.get(PERSONS_INJURED),
								info.get(PERSONS_KILLED),
								info.get(CYCLISTS_INJURED),
								info.get(CYCLISTS_KILLED)
								);
						collisions.addCollision(c);
						if(!boroughs.contains(info.get(BOROUGH))){
							boroughs.add(info.get(BOROUGH));
						}
						//create a new Zip object code...
						Zip zip =  new Zip(info.get(ZIP));
						//add the zip code to our zipCodesList only if it isn't there already
						if(!zipCodes.contains(zip)){
							zipCodes.addZip(zip);
						}
						//create a new VehicleType....
						VehicleType v1 = new VehicleType(info.get(VEHICLE1).toLowerCase());
						VehicleType v2 = new VehicleType(info.get(VEHICLE2).toLowerCase());
						//track collisions amongst vehicle types
						if(vehicleTypes.contains(v1)){
							vehicleTypes.get(v1).addCollision();
						}
						if(vehicleTypes.contains(v2)){
							vehicleTypes.get(v2).addCollision();
						}
						//track collisions amongst boroughs
						if(info.get(BOROUGH).equals("BROOKLYN")){
							boroughPercents.set(BROOKLYN, boroughPercents.get(BROOKLYN) + 1 );
						}
						else if(info.get(BOROUGH).equals("MANHATTAN")){
							boroughPercents.set(MANHATTAN, boroughPercents.get(MANHATTAN) + 1);
						}
						else if(info.get(BOROUGH).equals("QUEENS")){
							boroughPercents.set(QUEENS, boroughPercents.get(QUEENS) + 1 );
						}
						else if(info.get(BOROUGH).equals("STATEN ISLAND")){
							boroughPercents.set(STATEN_ISLAND, boroughPercents.get(STATEN_ISLAND) + 1);
						}
						else if(info.get(BOROUGH).equals("BRONX")){
							boroughPercents.set(BRONX, boroughPercents.get(BRONX) + 1);
						}
					}
				}
			////************\\\\	
				 //OUTPUT\\
			////**************\\\\
				try{
					PrintWriter out = new PrintWriter(write);
					//detail where output comes from
					out.printf("Out Put Data from %s", args[0]);
					out.println("\n");
					
					//getting all data for ZIP codes using Zip methods
					for(int index = 0; index < zipCodes.size(); index++){
						Zip currentZip = zipCodes.get(index);
						currentZip.setCollisions(collisions.collisionsByZip(currentZip));
						currentZip.setCyclistsKilled(collisions.cyclistsKilledByZip(currentZip));
						currentZip.setCyclistsTotalHurt(collisions.cyclistsTotalHurtByZip(currentZip));
						currentZip.setPeopleKilled(collisions.fatalitiesByZip(currentZip));
						currentZip.setTotalHurt(collisions.injuriesAndFatalitiesByZip(currentZip));
					} 
					
					////*******************\\\\
					 ////ZIP BY COLLISIONS\\\\
				   ////********************\\\\
					
					//set up the output for ZIP code collision data
					out.println("ZIP codes with the largest number of collisions:");
					//sort zip codes by the number of collisions
					zipCodes.sortByCollisions();
					ZipList topZipsByCollisions = zipCodes.findTopThreeZips("most collisions");
					for(int index = 0; index < topZipsByCollisions.size(); index++){
						out.println(
								"     " +
								topZipsByCollisions.get(index) + "     " + 
								topZipsByCollisions.get(index).getCollisions() +
								" collisions");
					}
					out.println("\n");
					
					out.println("ZIP codes with the fewest number of collisions:");
					//find the three zip codes with the fewest collisions including ties
					ZipList bottomZipsByCollisions = zipCodes.findTopThreeZips("least collisions");
					//reorder so most collisions is on top
					bottomZipsByCollisions.sortByCollisions();
					for(int index = 0; index < bottomZipsByCollisions.size(); index++){
						out.println(
								"     " + 
								bottomZipsByCollisions.get(index) + "     " + 
								bottomZipsByCollisions.get(index).getCollisions() +
								" collisions");
					}
					out.println("\n");
					////********************\\\\
					  ////ZIP BY CYCLISTS\\\\
				    ////********************\\\\
					
					//set up the output for ZIP code cyclist data
					out.println("ZIP codes with the largest number of Cyclist injuries and deaths:");
					//sort by cyclist injuries
					zipCodes.sortByCyclists();
					//find the top three zip codes
					ZipList topZipsByCyclists = zipCodes.findTopThreeZips("cyclists");
					for(int index = 0; index < topZipsByCyclists.size(); index++){
						out.println(
								"     " +
								topZipsByCyclists.get(index) + "     " + 
								topZipsByCyclists.get(index).getCyclistsTotalHurt() +  
								" cyclists injured and killed");
					}
					out.println("\n");
					
					////******************************\\\\
					 //ZIP BY INJURIES & FATALITIES\\\\
				   ////*******************************\\\\
					
					//set up the output for ZIP code injuries and fatalities data
					out.println("ZIP codes with the most injuries and fatalities (combined): ");
					//sort by injuires and fatalities
					zipCodes.sortByInjuriesAndFatalities();
					ZipList topZipsByInjuriesAndFatalities = zipCodes.findTopThreeZips("injuries/fatalities");
					for(int index = 0; index < topZipsByInjuriesAndFatalities.size(); index++){
						out.println(
								"     " +
								topZipsByInjuriesAndFatalities.get(index) + "     " +
								topZipsByInjuriesAndFatalities.get(index).getTotalHurt() +
								" total injuries and fatalities");
					}
					out.println("\n");
					
					////********************\\\\
					 ////VEHICLE TYPES DATA\\\\
				   ////*********************\\\\
					
					//set up the output for vehicle types percentages
					out.println("Percentage of collisions involving certain vehicle type:");
					//spacing of how far out the fire truck decimal point will be 10 for "fire truck" 5 for a tab and then the number of digits before the decimal point
					int fireTruckSpacing = 10 + 5 + String.format("%.2f", ((double)vehicleTypes.get(4).getCollisions() / collisions.size()) * 50).length() - 2 ;
					//print out every vehicleType and the percentage of accidents associated with it
					for(int index = 0; index < vehicleTypes.size(); index++){
						//format the percent to have two numbers after 
						String percent = String.format("%.2f", ((double)vehicleTypes.get(index).getCollisions() / collisions.size()) * 50);
						//int representing the amount of digits before the decimal space 
						int loseSpacing = percent.length() - 2;
						//StringBuilder to avoid new String Object construction
						StringBuilder spaces = new StringBuilder("");
						//add a space for every empty "space" between the end of the current vehicle type and the decimal spot of fire truck
						for(int i = 0; i < fireTruckSpacing - vehicleTypes.get(index).getVehicleType().length() - loseSpacing; i++){
							spaces.append(" ");
						}
						out.println(
								"     " +
								vehicleTypes.get(index).getVehicleType() + 
								spaces + 
								percent + "%"
								);
					}
					out.println("\n");
					////**********************\\\\
					  //******EXTRA TASK******\\
					////**********************\\\\
					
					
					
					out.println("Percentage of accidents by borough");
					int statenSpacing = 13 + 5 + String.format("%.2f",((double)boroughPercents.get(STATEN_ISLAND) / collisions.size()) * 100  ).length() - 2;
					for(int index = 0; index < boroughs.size(); index++){
						if(boroughs.get(index).equals("MANHATTAN")){
							//configure spacing based on size of the STATEN ISLAND output because it will be the longest
							String percent = String.format("%.2f", ((double)boroughPercents.get(MANHATTAN) / collisions.size()) * 100 );
							int loseSpacing = percent.length() - 2;
							StringBuilder spaces = new StringBuilder("");
							for(int i = 0; i < statenSpacing - 9 - loseSpacing; i++){
								spaces.append(" ");
							}
							out.println("     MANHATTAN:" + spaces +  percent + "%");
						}
						//configure spacing
						else if(boroughs.get(index).equals("BROOKLYN")){
							String percent = String.format("%.2f", ((double)boroughPercents.get(BROOKLYN) / collisions.size()) * 100 );
							int loseSpacing = percent.length() - 2;
							StringBuilder spaces = new StringBuilder("");
							for(int i = 0; i < statenSpacing - 8 - loseSpacing; i++){
								spaces.append(" ");
							}
							out.println("     BROOKLYN:" + spaces +  percent + "%");
						}
						//configure spacing
						else if(boroughs.get(index).equals("QUEENS")){
							String percent = String.format("%.2f", ((double)boroughPercents.get(QUEENS) / collisions.size()) * 100 );
							int loseSpacing = percent.length() - 2;
							StringBuilder spaces = new StringBuilder("");
							for(int i = 0; i < statenSpacing - 6 - loseSpacing; i++){
								spaces.append(" ");
							}
							out.println("     QUEENS:" + spaces + percent + "%");
						}
						//configure spacing
						else if(boroughs.get(index).equals("BRONX")){
							String percent = String.format("%.2f", ((double)boroughPercents.get(BRONX)  / collisions.size()) * 100 );
							int loseSpacing = percent.length() - 2;
							StringBuilder spaces = new StringBuilder("");
							for(int i = 0; i < statenSpacing - 5 - loseSpacing; i++){
								spaces.append(" ");
							}
							out.println("     BRONX:" + spaces + percent + "%");
						}
						//configure spacing
						else{
							String percent =  String.format("%.2f", ((double)boroughPercents.get(STATEN_ISLAND) / collisions.size()) * 100);
							out.println("     STATEN ISLAND:     " + percent + "%");
						}
					}
					out.close();
					sc.close();
				
				//if no out put file is detected...	
				}catch(IOException e){
					System.out.printf("Could not write to file: ", write);
				}
			//if no input file detected...
			}catch(IOException e){
				System.out.println("No Input file detected: java.io.FileNotFoundException");
			}
		//if neither input/out put file 
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Input and/or out put file not specified");
		}
	}
	/**
	 * Splits a given line according to commas (commas within entries are ignored) 
	 * @param textLine line of text to be parsed 
	 * @return an ArrayList object containing all individual entries/tokens
	 * found on the line. 
	 */
	public static ArrayList<String> split (String textLine ) {
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer(); 
		char nextChar;
		boolean insideQuotes = false;
		
		for(int i = 0; i < lineLength; i++ ) {
			nextChar = textLine.charAt(i); 
			//add character to the current entry 
			if ( nextChar != ',' && nextChar != '"' ) {
				nextWord.append( nextChar );
			}
			//double quote found, decide if it is opening or closing one
			else if (nextChar == '"' ) {
				if ( insideQuotes ) {
					insideQuotes = false;
				}
				else {
					insideQuotes = true;
				}
			}
			//found comma inside double quotes, just add it to the string
			else if (nextChar == ',' && insideQuotes) {
				nextWord.append( nextChar );
			}
			//end of the current entry reached, add it to the list of entries
			//and reset the nextWord to empty string
			else if (nextChar == ',' && !insideQuotes) {
				//trim the white space before adding to the list
				entries.add( nextWord.toString().trim() );
				
				nextWord = new StringBuffer();
			}
			
			else {
				System.err.println("This should never be printed.\n");
			}
		}
		//add the last word
		//trim the white space before adding to the list
		entries.add( nextWord.toString().trim() );
				
		return entries; 
	}
	
	/**
	 * Creates an output file based on the name of the input file passed in args[0].
	 * @param inputFile a String representing the name of the input file at args[0].
	 * @return outputFile a String that either adds .out to inputFile or changes the 
	 * .csv ending of inputFile to .out.
	 */
	public static String createOutPutFile(String inputFile){
		String outputFile = null;
		//if the .csv extension exists replace .csv with .out
		if(inputFile.contains(".csv")){
			outputFile = inputFile.replace(".csv", ".out");
		}
		//if the .csv does not yet exist simply add the .out extension 
		else{
			outputFile = inputFile + ".out";
		}
		return outputFile;
	}
}
	
