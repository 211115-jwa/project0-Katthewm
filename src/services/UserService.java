package services;

import java.util.Set;

import project0Katthewm.Bicycle;



public interface UserService {
	// services represent business logic - actual user activities.
	// what can a user do?
	public Person register(Person newUser);
	public Person logIn(String username, String password);
	public Person updateUser(Person userToUpdate);
	public Person adoptPet(int petId, Person newOwner);
	public Set<Pet> viewAvailablePets();
	public Set<Pet> searchAvailablePetsBySpecies(String species);
}
