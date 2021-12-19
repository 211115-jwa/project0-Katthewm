package services;

import java.util.Set;

import project0Katthewm.Bicycle;

public interface EmployeeService {
	// services represent business logic - actual user activities.
	// what can an employee do?
	public int addNewBike(Bicycle bike);
	public Bicycle editBike(Bicycle bikeToEdit);
	public Bicycle getBikeById(int id);
	public Set<Bicycle> getBikeBybrand(String brand);
	public Set<Bicycle> viewAllBikes();
}
