package project0Katthewm;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

// this static import is for the path and get/post/put methods
import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;

public class bikeApp 
{
	public static void main(String[] args) 
	{
		Javalin app = Javalin.create();
		app.start();
	}
}
