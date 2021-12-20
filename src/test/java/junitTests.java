import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;


import org.junit.jupiter.api.Test;

import project0Katthewm.Bicycle;
import project0Katthewm.BicycleDAO;

class junitTests {

	@Test
	void createdefaultBicyletest() //test to make sure that the create function can generate a new null bike
	{
		Bicycle bike = new Bicycle();	
		assertNotEquals(bike, null);
	}
	
	@Test
	void createBicyletest() //check to make sure that the create function can generate a bike with data
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		assertNotEquals(bike, null);
	}
	
	@Test
	void getBicylebyIDtest() //check to see if the code can retrieve a bike by its id
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");	
		assertEquals(9999, bike.getId());
	}
	
	@Test
	void getBicylebyIDtestfail() //check to make sure that when an incorrect id is provided the correct bike is not the result
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");	
		assertNotEquals(9998, bike.getId());
	}
	
	void getBicylebyBrandtest() //gets a list of bikes according to brand and compares it to a preset list to see if they match
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		Set<Bicycle> allbikes = new HashSet<Bicycle>(); // Create an set object
		allbikes.add(bike2);
		allbikes.add(bike1);
		allbikes.add(bike3);
		allbikes.add(bike);
		
		expectedbikes.add(bike1);
		expectedbikes.add(bike2);
		
		Set<Bicycle> actualbikes = BicycleDAO.getBybrand("Ford", allbikes);
		assertNotEquals(expectedbikes, actualbikes);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	void getBicylebyBrandtestfail() //checks to make sure that the program receives an invalid answer to confirm that it is not pulling incorrect data
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		Set<Bicycle> allbikes = new HashSet<Bicycle>(); // Create an set object
		allbikes.add(bike2);
		allbikes.add(bike1);
		allbikes.add(bike3);
		allbikes.add(bike);
		
		expectedbikes.add(bike1);
		expectedbikes.add(bike2);
		
		Set<Bicycle> actualbikes = BicycleDAO.getBybrand("Pie", allbikes);
		assertEquals(expectedbikes, actualbikes);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicylebyModeltest() //gets a list of bikes according to the model and compares it to a preset list to see if they match
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		
		expectedbikes.add(bike2);
		expectedbikes.add(bike3);
		
		Set<Bicycle> actualbikes = BicycleDAO.getBymodel("Road");
		assertNotEquals(expectedbikes, actualbikes);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicylebyModeltestfail() //checks to make sure that the program receives an invalid answer to confirm that it is not pulling incorrect data
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		Bicycle bike1 = new Bicycle(9998,"Ford", "Mountain");
		Bicycle bike2 = new Bicycle(9997,"Ford", "Road");
		Bicycle bike3 = new Bicycle(9996,"Tesla", "Road");
		Set<Bicycle> expectedbikes = new HashSet<Bicycle>(); // Create an set object
		
		expectedbikes.add(bike2);
		expectedbikes.add(bike3);
		
		Set<Bicycle> actualbikes = BicycleDAO.getBymodel("Flying");
		assertNotEquals(expectedbikes, actualbikes);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicyleID() //tests to see if the program can get the bicycles id
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		int expected=9999;
		int actual = bike.getId();
		
		assertEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	void getBicyleIDfail() //tests to make sure the first test is legit
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		int expected=9998;
		int actual = bike.getId();
		
		assertNotEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicylebrand() //tests to see if the program can get the bicycles brand
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		String expected="Giant";
		String actual = bike.getBrand();
		
		assertEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicylebrandfail() //tests to make sure the first test is legit
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		String expected="Pig";
		String actual = bike.getBrand();
		
		assertNotEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicylemodel() //tests to see if the program can get the bicycles model
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		String expected="Mountain";
		String actual = bike.getBrand();
		
		assertNotEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
	
	@Test
	void getBicylemodelfail()//tests to make sure the first test is legit 
	{
		Bicycle bike = new Bicycle(9999,"Giant", "Mountain");
		String expected="Lightsaber";
		String actual = bike.getBrand();
		
		assertNotEquals(expected, actual);//checks to see if the expected bikes list matches the actual bike list 
	}
}
