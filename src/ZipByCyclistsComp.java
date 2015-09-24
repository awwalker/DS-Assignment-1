import java.util.Comparator;

public class ZipByCyclistsComp implements Comparator<Zip> {
	@Override
	public int compare(Zip z1, Zip z2){
		
		if(z1.getCyclistsTotalHurt() < z2.getCyclistsTotalHurt()){
			return 1;
		}
		
		//NEED TO MANAGE TIES
		else if(z1.getCyclistsTotalHurt() == z2.getCyclistsTotalHurt()){
			z1.setTie(true);
			z2.setTie(true);
			if(z1.getCyclistsKilled() < z2.getCyclistsKilled()){
				z1.setTie(false);
				z2.setTie(false);
				return 1;
			}
			else if (z1.getCyclistsKilled() == z2.getCyclistsKilled()){
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
