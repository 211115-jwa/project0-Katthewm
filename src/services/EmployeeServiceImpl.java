package services;

import java.util.Set;

import project0Katthewm.Bicycle;
import project0Katthewm.BicycleDAO;
import project0Katthewm.BicyclePostgres;

public class EmployeeServiceImpl implements EmployeeService {
	private BicycleDAO bicycleDAO = new BicyclePostgres();

	@Override
	public int addNewBike(Bicycle newPet) {
		return bicycleDAO.create(newPet);
	}

	@Override
	public Bicycle editBike(Bicycle petToEdit) {
		Bicycle petFromDatabase = bicycleDAO.getById(petToEdit.getId());
		if (petFromDatabase != null) {
			bicycleDAO.update(petToEdit);
			return bicycleDAO.getById(petToEdit.getId());
		}
		return null;
	}

	@Override
	public Bicycle getBikeById(int id) {
		return bicycleDAO.getById(id);
	}
	
	@Override
	public Set<Bicycle> getBikeBybrand(String brand) 
	{
		return BicycleDAO.getBybrand(brand);
	}
	
	@Override
	public Set<Bicycle> viewAllBikes() 
	{
		return BicycleDAO.viewAllBikes();
	}
}
