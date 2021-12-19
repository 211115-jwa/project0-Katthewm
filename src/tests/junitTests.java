package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;


import org.junit.jupiter.api.Test;

import project0Katthewm.Bicycle;
import project0Katthewm.BicycleDAO;

class junitTests {

	@Test
	void createdefaultBicyletest() 
	{
		Bicycle bike = new Bicycle();	
		assertNotEquals(bike, null);//not exactly sure if this is good
	}
	
	@Test
	void createBicyletest() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		
		assertNotEquals(bike, null);//not exactly sure if this is good
	}
	
	@Test
	void getBicylebyIDtest() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");	
		assertEquals(9999, bike.getId());
	}
	
	@Test
	void getBicylebyBrandtest() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		
		expectedbikes.add(bike1);
		expectedbikes.add(bike2);
		
		Set<Bicycle> actualbikes = BicycleDAO.getBybrand("Ford");
		assertEquals(expectedbikes, actualbikes);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	void getBicylebyModeltest() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		
		expectedbikes.add(bike2);
		expectedbikes.add(bike3);
		
		Set<Bicycle> actualbikes = BicycleDAO.getBymodel("Road");
		assertEquals(expectedbikes, actualbikes);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	void getBicyleID() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		int expected=9999;
		int actual = bike.getId();
		
		assertEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	void getBicylebrand() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		String expected="Giant";
		String actual = bike.getBrand();
		
		assertEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	void getBicylemodel() 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		String expected="Mountain";
		String actual = bike.getBrand();
		
		assertEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
}
