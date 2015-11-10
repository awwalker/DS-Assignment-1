/**
 * This class allows the comparison of Zip objects by the number of cyclists hurt / killed
 * @author aaronwalker
 */
import java.util.Comparator;

public class ZipByCyclistsComp implements Comparator<Zip> {
	/**
	 * Overrides the compare method...compares two Zip objects by the number of people hurt 
	 * uses the number of cyclists who died to break ties
	 * 
	 * @param Takes two Zip objects to compare
	 * @return Gives back an int to sort the two Zip objects with
	 */
	@Override
	public int compare(Zip z1, Zip z2){
		//if the number of cyclists hurt in Zip z1 is less than z2 z2 comes first
		if(z1.getCyclistsTotalHurt() < z2.getCyclistsTotalHurt()){
			return 1;
		}
		//if they both have the same number hurt/killed use deaths to settle the tie
		else if(z1.getCyclistsTotalHurt() == z2.getCyclistsTotalHurt()){
			//if z1 has fewer deaths than z2 z2 comes first
			if(z1.getCyclistsKilled() < z2.getCyclistsKilled()){
				return 1;
			}
			//if there's a tie set the Tie parameter of both zips and make no distinction between them
			else if (z1.getCyclistsKilled() == z2.getCyclistsKilled()){
				z1.setTie(true);
				z2.setTie(true);
				return 0;
			}
			//if z1 has more deaths than z2 it comes first
			else{
				return -1;
			}
		}
		//if z1 has more hurt than z2 it comes first
		else{
			return -1;
		}
	}
}
