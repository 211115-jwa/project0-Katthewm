package project0Katthewm;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import services.EmployeeService;
import services.EmployeeServiceImpl;

// this static import is for the path and get/post/put methods
import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;


public class Main 
{
	private static EmployeeService empServ = new EmployeeServiceImpl();

	public static void main(String[] args) 
	{
		Javalin app = Javalin.create();
		
		app.start();
		
		/*
		 what endpoints do we need?
		 in other words, what actions would a user need to do
		 and what address + HTTP method combo would represent
		 each of those actions?
		 (in your p0, these endpoints are provided to you.)
		*/
		app.routes(() -> 
		{
			// localhost:8080/pets
			path("/bikesbybrand", () -> 
			{
				get(ctx -> {
					// checking if they did /bikesbybrand?brand=
					String brand = ctx.queryParam("brand");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (brand != null && !"".equals(brand)) {
						Set<Bicycle> matchingBrand = empServ.getBikeBybrand(brand);
						ctx.json(matchingBrand);
					} else 
					{
						// if they didn't put ?brand
						Set<Bicycle> allbikes = empServ.viewAllBikes();
						ctx.json(allbikes);
					}
				});
				/*post(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle bike = ctx.bodyAsClass(Bicycle.class);
					if (bike !=null) {
						empServ.addNewBike(bike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});*/
			});
			path("/bikesbymodel", () -> 
			{
				get(ctx -> {
					// checking if they did /bikesbymodel?model=
					String model = ctx.queryParam("model");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (model != null && !"".equals(model)) {
						Set<Bicycle> matchingmodel = empServ.getBymodel(model);
						ctx.json(matchingmodel);
					} else {
						// if they didn't put ?model
						Set<Bicycle> allbikes = empServ.viewAllBikes();
						ctx.json(allbikes);
					}
				});
				/*post(ctx -> 
				{
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle bike = ctx.bodyAsClass(Bicycle.class);
					if (bike !=null) {
						empServ.addNewBike(bike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});*/
			});
			path("/bikesbyid", () -> 
			{
				get(ctx -> {
					// checking if they did /bikesbymodel?model=
					String id = ctx.queryParam("id");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (id != null && !"".equals(id)) {
						Bicycle matchingid = empServ.getById(Integer.parseInt(id));
						ctx.json(matchingid);
					} else {
						// if they didn't put ?model
						Set<Bicycle> allbikes = empServ.viewAllBikes();
						ctx.json(allbikes);
					}
				});
				/*post(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle bike = ctx.bodyAsClass(Bicycle.class);
					if (bike !=null) {
						empServ.addNewBike(bike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});*/
			});
			path("/updatebike/{id}", () -> 
			{
				put(ctx -> {
					
					try {
						int id = Integer.parseInt(ctx.pathParam("id")); // num format exception
						Bicycle updatedbike = empServ.editBike(id);
						System.out.print(updatedbike.getBrand());
						ctx.json(updatedbike);

					} catch (NumberFormatException e) {
						ctx.status(400);
						ctx.result("Bike ID must be a numeric value");
					}
				});
				/*put(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle bike = ctx.bodyAsClass(Bicycle.class);
					if (bike !=null) {
						empServ.addNewBike(bike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});*/
			});
			path("/createbike", () -> 
			{
				put(ctx -> {
					
					try {
						empServ.createnewbike();
						//System.out.print(createdbike.getBrand());
						//ctx.json(createdbike);

					} catch (NumberFormatException e) {
						ctx.status(400);
						ctx.result("Bike ID must be a numeric value");
					}
				});
				/*put(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle bike = ctx.bodyAsClass(Bicycle.class);
					if (bike !=null) {
						empServ.addNewBike(bike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});*/
			});
			path("/deletebike/{id}", () -> 
			{
				put(ctx -> {
					try {
						int id = Integer.parseInt(ctx.pathParam("id")); // num format exception
						empServ.deletebike(id);

					} catch (NumberFormatException e) {
						ctx.status(400);
						ctx.result("Bike ID must be a numeric value");
					}
				});
				/*delete(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle bike = ctx.bodyAsClass(Bicycle.class);
					if (bike !=null) {
						empServ.addNewBike(bike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});*/
			});
		});
	}
}
