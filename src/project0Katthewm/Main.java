package project0Katthewm;
import java.util.ArrayList; // import the ArrayList class
import io.javalin.Javalin;
import java.util.Collections; // import the Collections class
import java.util.HashMap; // import the HashMap class
import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import static io.javalin.apibuilder.ApiBuilder.*;
import java.util.Set;
import org.eclipse.jetty.http.HttpStatus;

import services.EmployeeService;
import services.EmployeeServiceImpl;




public class Main
{
	private static EmployeeService empServ = new EmployeeServiceImpl();
	
	public static void main(String[] args) {
		Javalin app = Javalin.create();
		
		app.start();
		
		/*
		 what endpoints do we need?
		 in other words, what actions would a user need to do
		 and what address + HTTP method combo would represent
		 each of those actions?
		 (in your p0, these endpoints are provided to you.)
		*/
		app.routes(() -> {
			// localhost:8080/pets
			path("/bikesbrand", () -> {
				get(ctx -> {
					// checking if they did /pets?species=
					String brandSearch = ctx.queryParam("brand");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (brandSearch != null && !"".equals(brandSearch)) {
						Set<Bicycle> petsFound = empServ.getBikeBybrand(brandSearch);
						ctx.json(petsFound);
					} else {
						// if they didn't put ?species
						Set<Bicycle> bikes = empServ.viewAllBikes();
						ctx.json(bikes);
					}
				});
				post(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle newBike = ctx.bodyAsClass(Bicycle.class);
					if (newBike !=null) {
						empServ.addNewBike(newBike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				/*
				// localhost:8080/pets/adopt/8
				path("/adopt/{id}", () -> {
					put(ctx -> {
						try {
							int petId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Person newOwner = ctx.bodyAsClass(Person.class);
							// returns the person with their new pet added
							newOwner = userServ.adoptPet(petId, newOwner);
							ctx.json(newOwner);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Pet ID must be a numeric value");
						}
					});
				});
				
				// localhost:8080/pets/8
				path("/{id}", () -> {
					
					get(ctx -> {
						try {
							int petId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Pet pet = empServ.getPetById(petId);
							if (pet != null)
								ctx.json(pet);
							else
								ctx.status(404);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Pet ID must be a numeric value");
						}
					});
					
					put(ctx -> {
						try {
							int petId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Pet petToEdit = ctx.bodyAsClass(Pet.class);
							if (petToEdit != null && petToEdit.getId() == petId) {
								petToEdit = empServ.editPet(petToEdit);
								if (petToEdit != null)
									ctx.json(petToEdit);
								else
									ctx.status(404);
							} else {
								// conflict: the id doesn't match the id of the pet sent
								ctx.status(HttpCode.CONFLICT);
							}
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Pet ID must be a numeric value");
						}
					});*/
					
				});
			});
		});
	}
}