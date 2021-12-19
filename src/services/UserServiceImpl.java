package services;

import java.util.Set;
import java.util.stream.Collectors;

import com.revature.beans.Person;
import com.revature.beans.Pet;
import com.revature.data.PersonDAO;
import com.revature.data.PetDAO;
import com.revature.data.postgres.PersonPostgres;
import com.revature.data.postgres.PetPostgres;

public class UserServiceImpl implements UserService {
	private PersonDAO personDao = new PersonPostgres();
	private PetDAO petDao = new PetPostgres();

	@Override
	public Person register(Person newUser) {
		int newId = personDao.create(newUser);
		if (newId != 0) {
			newUser.setId(newId);
			return newUser;
		}
		return null;
	}

	@Override
	public Person logIn(String username, String password) {
		Person personFromDatabase = personDao.getByUsername(username);
		if (personFromDatabase != null && personFromDatabase.getPassword().equals(password)) {
			return personFromDatabase;
		}
		return null;
	}

	@Override
	public Person updateUser(Person userToUpdate) {
		if (personDao.getById(userToUpdate.getId()) != null) {
			personDao.update(userToUpdate);
			userToUpdate = personDao.getById(userToUpdate.getId());
			return userToUpdate;
		}
		return null;
	}

	@Override
	public Person adoptPet(int petId, Person newOwner) {
		Pet petToAdopt = petDao.getById(petId);
		if (petToAdopt.getStatus().equals("Available")) {
			petToAdopt.setStatus("Adopted");
			newOwner.getPets().add(petToAdopt);
			
			petDao.update(petToAdopt);
			personDao.update(newOwner);
			return newOwner;
		}
		return null;
	}

	@Override
	public Set<Pet> viewAvailablePets() {
		return petDao.getByStatus("Available");
	}

	@Override
	public Set<Pet> searchAvailablePetsBySpecies(String species) {
		Set<Pet> availablePets = petDao.getByStatus("Available");
		
		/* 
		   using a Stream to filter the pets
		   "filter" takes in a Predicate (functional interface)
		   and iterates through each pet, adding the pet to the stream
		   if the predicate returns "true"
		*/
		availablePets = availablePets.stream()
				.filter(pet -> pet.getSpecies().toLowerCase().contains(species.toLowerCase()))
				.collect(Collectors.toSet());
		
		// if you don't want to use a Stream, you can always just
		// do this yourself using a for loop :) it will do the same thing!
		/*
		 * Set<Pet> petsBySpecies = new HashSet<>();
		 * for (Pet pet : availablePets) {
		 * 		if(pet.getSpecies().toLowercase().contains(species.toLowercase())) {
		 * 			petsBySpecies.add(pet);
		 * 		}
		 * }
		 * 
		 * availablePets = petsBySpecies;
		 */
		
		return availablePets;
	}

}
