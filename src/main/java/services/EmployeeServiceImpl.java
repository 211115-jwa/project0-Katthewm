package services;

import java.util.Set;

import project0Katthewm.Bicycle;
import project0Katthewm.BicycleDAO;
import project0Katthewm.BicyclePostgres;

public class EmployeeServiceImpl implements EmployeeService 
{
	private BicycleDAO bicycleDAO = new BicyclePostgres();

	public Bicycle editBike(int id) {
		Bicycle bikeFromDatabase = BicyclePostgres.getbikesById(id);
		if (bikeFromDatabase != null) {
			BicyclePostgres.change(bikeFromDatabase);
			return bikeFromDatabase;
		}
		return null;
	}
	
	public void deletebike(int id) {
		Bicycle bikeFromDatabase = BicyclePostgres.getbikesById(id);
		if (bikeFromDatabase != null) {
			BicyclePostgres.deletebike(bikeFromDatabase);
			return;
		}
		return;
	}

	public Bicycle getById(int id) {
		return BicyclePostgres.getbikesById(id);
	}
	
	public Set<Bicycle> getBikeBybrand(String brand) 
	{
		return BicyclePostgres.getBybrand(brand);
	}
	
	public Set<Bicycle> getBymodel(String model) 
	{
		return BicyclePostgres.getBymodel(model);
	}
	
	public Set<Bicycle> viewAllBikes() 
	{
		Set<Bicycle> allbikes = bicycleDAO.getAll();
		return allbikes;
	}

	public Bicycle addNewBike(Bicycle newbike) 
	{
		return BicyclePostgres.createnewbicycle(newbike);
	}

	public Bicycle createnewbike() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bicycle createnewbike(Bicycle newbike) {
		// TODO Auto-generated method stub
		return null;
	}
}
