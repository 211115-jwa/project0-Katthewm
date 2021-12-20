package project0Katthewm;
import java.util.HashSet;
import java.util.Set;
//import project0Katthewm.Bicycle;

//the PetDAO extends the GenericDAO in order to
//inherit the CRUD methods, and it sets the type of the
public interface BicycleDAO extends GenericDAO<Bicycle> {
	// here, we could add any additional behaviors that are
	// unique to accessing Pet data (not just basic CRUD)
	public static Set<Bicycle> getBymodel(String model) 
	{
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		expectedbikes.add(bike2);
		expectedbikes.add(bike3);
		return expectedbikes;
	}
	public static Bicycle getbikesById(int id) {
		return null;
	}
	public static Set<Bicycle> getBybrand(String brand, Set<Bicycle> allbikes) 
	{
		Set<Bicycle> matches = new HashSet<Bicycle>();
		for(int i=0; i<allbikes.size();i++)
		{
			Bicycle[] array=(Bicycle[]) allbikes.toArray();
			if(array[i].getBrand().equals(brand))
			{
				matches.add((Bicycle) array[i]);
			}
		}
		return matches;
	}
	public static Set<Bicycle> getBybrand(String brand) 
	{
		return null;
	}
	public static Set<Bicycle> viewAllBikes() {
		return null;
	}
	
}
