package services;

import java.util.Set;

import project0Katthewm.Bicycle;

public interface EmployeeService {
	// services represent business logic - actual user activities.
	// what can an employee do?
	public Bicycle createnewbike(Bicycle newbike);
	public Bicycle editBike(int id);
	public Bicycle getById(int id);
	public void deletebike(int id);
	public Set<Bicycle> getBikeBybrand(String brand);
	public Set<Bicycle> viewAllBikes();
	public Set<Bicycle> getBymodel(String model);
}
