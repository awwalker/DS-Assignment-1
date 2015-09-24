import java.util.Comparator;
public class ZipByInjuriesAndFatalitiesComp implements Comparator<Zip>{
	@Override
	public int compare(Zip z1, Zip z2){
		if(z1.getTotalHurt() < z2.getTotalHurt()){
			return 1;
		}
		//NEED TO MANAGE TIES
		else if(z1.getTotalHurt() == z2.getTotalHurt()){
			z1.setTie(true);
			z2.setTie(true);
			if(z1.getPeopleKilled() < z2.getPeopleKilled()){
				z1.setTie(false);
				z2.setTie(false);
				return 1;
			}
			else if(z1.getPeopleKilled() == z2.getPeopleKilled()){
				return 0;
			}
			else{
				z1.setTie(false);
				z2.setTie(false);
				return -1;
			}
		}
		
		else{
			return -1;
		}
	}
}
