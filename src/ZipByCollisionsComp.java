import java.util.Comparator;

public class ZipByCollisionsComp implements Comparator<Zip> {
	@Override
	public int compare(Zip z1, Zip z2){
		if(z1.getCollisions() < z2.getCollisions()){
			return 1;
		}
		if(z1.getCollisions() == z2.getCollisions()){
			return 0;
		}
		else{
			return -1;
		}
	}
	
}
