import java.util.ArrayList;

public class VehicleList {
	private ArrayList<VehicleType> types;
	
	public VehicleList(){
		types = new ArrayList<VehicleType>();
	}
	public void addVehicleType(String s){
		VehicleType v = new VehicleType(s);
		types.add(v);
	}
	
	public void addVehicleType(VehicleType t){
		types.add(t);
	}
	
	public int size(){
		return types.size();
	}
	
	public VehicleType get(VehicleType v){
		for(int i = 0; i < types.size(); i++){
			if(types.get(i).getVehicleType().equals(v.getVehicleType())){
				return types.get(i);
			}
		}
		return null;
	}
	public VehicleType get(int index){
		for(int i = 0; i < types.size(); i++){
			if(i == index){
				return types.get(i);
			}
		}
		return null;
	}

	public boolean contains(VehicleType t){
		for(int i = 0; i < types.size(); i++){
			if(types.get(i).getVehicleType().equals(t.getVehicleType())){
				return true;
			}
		}
		return false;
	}
	
}
