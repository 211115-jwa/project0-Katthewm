package project0Katthewm;

public class Bicycle 
{
	int id;
	String brand;
	String model;
	
	public Bicycle() 
	{

	}
	
	public Bicycle(int idInput, String brandInput, String modelInput) 
	{
		id=idInput;
		brand = brandInput;
		model = modelInput;
	}
	
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getBrand() 
	{
		return brand;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	public String getModel() 
	{
		return model;
	}
	public void setModel(String model) 
	{
		this.model = model;
	}
}
