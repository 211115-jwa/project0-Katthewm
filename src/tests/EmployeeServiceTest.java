package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import project0Katthewm.Bicycle;
import project0Katthewm.BicycleDAO;
import services.EmployeeService;
import services.EmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock
	private BicycleDAO bicycleDAO;
	
	@InjectMocks
	private EmployeeService empServ = new EmployeeServiceImpl();
	
	@Test
	public void addNewPetSuccessfully() {
		Bicycle pet = new Bicycle();
		
		when(bicycleDAO.create(pet)).thenReturn(10);
		
		int newId = empServ.addNewBike(pet);
		
		assertNotEquals(0, newId);
	}
	
	@Test
	public void addNewBicycleSomethingWrong() {
		Bicycle bike = new Bicycle();
		
		when(bicycleDAO.create(bike)).thenReturn(0);
		
		int newId = empServ.addNewBike(bike);
		
		assertEquals(0,newId);
	}
	
	@Test
	public void editPetSuccessfully() {
		Bicycle editedBike = new Bicycle();
		editedBike.setId(2);
		editedBike.setModel("Mountain");
		
		when(bicycleDAO.getById(2)).thenReturn(editedBike);
		doNothing().when(bicycleDAO).update(Mockito.any(Bicycle.class));
		
		Bicycle actualBike = empServ.editBike(editedBike);
		
		assertEquals(editedBike, actualBike);
	}
	
	@Test
	public void editPetSomethingWrong() {
		Bicycle mockPet = new Bicycle();
		mockPet.setId(2);
		
		when(bicycleDAO.getById(2)).thenReturn(mockPet);
		doNothing().when(bicycleDAO).update(Mockito.any(Bicycle.class));
		
		Bicycle editedBike = new Bicycle();
		editedBike.setId(2);
		editedBike.setModel("Mountain");
		
		Bicycle actualPet = empServ.editBike(editedBike);
		
		assertNotEquals(editedBike, actualPet);
	}
	
	@Test
	public void editPetDoesNotExist() {
		when(bicycleDAO.getById(2)).thenReturn(null);
		
		Bicycle editedBike = new Bicycle();
		editedBike.setId(2);
		editedBike.setModel("Mountain");
		
		Bicycle actualBike = empServ.editBike(editedBike);
		
		assertNull(actualBike);
		verify(bicycleDAO, times(0)).update(Mockito.any(Bicycle.class));
	}
	
	@Test
	public void getByIdPetExists() {
		Bicycle bike = new Bicycle();
		bike.setId(2);
		
		when(bicycleDAO.getById(2)).thenReturn(bike);
		
		Bicycle actualBike = empServ.getBikeById(2);
		assertEquals(bike, actualBike);
	}
	
	@Test
	public void getByIdPetDoesNotExist() {
		when(bicycleDAO.getById(2)).thenReturn(null);
		
		Bicycle actualBike = empServ.getBikeById(2);
		assertNull(actualBike);
	}
}
