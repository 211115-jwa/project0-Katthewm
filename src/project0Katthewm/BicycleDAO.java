package project0Katthewm;

import java.util.Set;
//import project0Katthewm.Bicycle;

//the PetDAO extends the GenericDAO in order to
//inherit the CRUD methods, and it sets the type of the
//data to be Pet objects
public interface BicycleDAO extends GenericDAO<Bicycle> {
	// here, we could add any additional behaviors that are
	// unique to accessing Pet data (not just basic CRUD)
	public static Set<Bicycle> getBymodel(String model) {
		return null;
	}
	public static Set<Bicycle> getBybrand(String brand) {
		return null;
	}
	public static Set<Bicycle> viewAllBikes() {
		return null;
	}
	
}
