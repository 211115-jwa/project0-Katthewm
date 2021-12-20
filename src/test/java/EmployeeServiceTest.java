import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import project0Katthewm.Bicycle;
import project0Katthewm.BicycleDAO;
import project0Katthewm.BicyclePostgres;
import services.EmployeeService;
import services.EmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock
	private BicycleDAO bicycleDAO;
	
	@InjectMocks
	private EmployeeService empServ = new EmployeeServiceImpl();
	
	Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
	Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
	Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
	Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
	Set<Bicycle> testbikes = new HashSet<Bicycle>(); // Create an set object
	
	@Test
	public void addNewBikeSuccessfully() 
	{
		Bicycle bike = new Bicycle();//create new bicycle
		
		when(BicyclePostgres.createnewbicycle(bike));
		
		Bicycle newbike = empServ.createnewbike(bike); 
		
		assertEquals(bike, newbike);
	}
	
	@Test
	public void addNewBikeSomethingWrong() {
		Bicycle bike = new Bicycle();//create new bicycle
		
		when(bicycleDAO.create(bike)).thenReturn(0);
		
		Bicycle newbike = empServ.createnewbike(bike);
		
		assertNotEquals(bike, newbike);
	}
	@Test
	public void editBikeSuccessfully() 
	{
		Bicycle editedBike = new Bicycle();//create new bicycle
		editedBike.setId(9990);
		
		when(BicyclePostgres.getbikesById(9990)).thenReturn(editedBike);
		doNothing().when(bicycleDAO).update(Mockito.any(Bicycle.class));
		
		Bicycle actualBike = empServ.editBike(9990);
		
		assertEquals(editedBike, actualBike);
	}
	@Test
	public void editBikeSomethingWrong() {
		Bicycle editBike = new Bicycle();//create new bicycle
		editBike.setId(9991);
		
		when(empServ.getById(2)).thenReturn(editBike);
		doNothing().when(bicycleDAO).update(Mockito.any(Bicycle.class));
		
		Bicycle editedBike = new Bicycle();//create new bicycle
		editedBike.setId(9991);
		
		Bicycle actualBike = empServ.editBike(9991);
		
		assertNotEquals(editedBike, actualBike);
	}
	
	@Test
	public void getByIdBikeExists() {
		Bicycle bike = new Bicycle();//create new bicycle
		bike.setId(9993);
		
		when(empServ.getById(9993)).thenReturn(bike);
		
		Bicycle actualBike = empServ.getById(9993);
		assertEquals(bike, actualBike);
	}
	
	@Test
	public void getByIdBikeDoesNotExist() {
		when(empServ.getById(9993)).thenReturn(null);
		
		Bicycle actualBike = empServ.getById(9993);
		assertNull(actualBike);
	}
}
