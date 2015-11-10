/**
 * This class allows the comparison of two Zip objects based on their number of collisions
 * @author aaronwalker
 */
import java.util.Comparator;

public class ZipByCollisionsComp implements Comparator<Zip> {
	/**
	 * This method Overrides the compare method and compares Zip objects by their collisions 
	 * @return an int to determine the sort order of two Zip objects
	 */
	@Override
	public int compare(Zip z1, Zip z2){
		//if z1 has fewer collisions it comes after z2
		if(z1.getCollisions() < z2.getCollisions()){
			return 1;
		}
		//if z1 has the same number of collisions it doesn't matter
		if(z1.getCollisions() == z2.getCollisions()){
			return 0;
		}
		//if z1 has more collisions it comes before z2
		else{
			return -1;
		}
	}
	
}
