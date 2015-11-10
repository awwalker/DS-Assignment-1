/**
 * This class allows the comparison of Zip objects by the number of injuries and fatalities
 * @author aaronwalker
 */
import java.util.Comparator;
public class ZipByInjuriesAndFatalitiesComp implements Comparator<Zip>{
	/**
	 * Overrides the compare method to compare two Zip objets based on the number of injuries and fatalities in both
	 * @param takes two Zip objects to compare
	 * @return an int used to sort the two objects
	 */
	@Override
	public int compare(Zip z1, Zip z2){
		//if z1 has less hurt in total than z2 z2 comes first
		if(z1.getTotalHurt() < z2.getTotalHurt()){
			return 1;
		}
		//if they are equal in total hurt settle the tie based on number of deaths
		else if(z1.getTotalHurt() == z2.getTotalHurt()){
			//if the number of deaths in z2 is > in z1 z2 comes first
			if(z1.getPeopleKilled() < z2.getPeopleKilled()){
				return 1;
			}
			//if there's a tie in deaths too then the two zips are regarded as equal and the Tie parameter of both is set to true
			else if(z1.getPeopleKilled() == z2.getPeopleKilled()){
				z1.setTie(true);
				z2.setTie(true);
				return 0;
			}
			//if the number of deaths in z1 > z2 z1 comes first
			else{
				return -1;
			}
		}
		//if z1 has more injuries + fatalities it comes before z2
		else{
			return -1;
		}
	}
}
