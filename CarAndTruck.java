//homework
public class CarAndTruck
{
	
/**************************************************************
 * Instance Variable / Field 
 * make names useful
 ***************************************************************/
	
int year;  
String make, model;

//constuctor not just public and class name	
public Car()
{
	year =   0 ;
	model = "Don't Know"  ;
	make = "Who make it doe?"  ;
}

	
	
public Car ( String carMake, String carModel, int yearMade)
{
	year = yearMade;
	make = carMake;
	model = carModel;
		//spacing will be off maybe you can make it better.
}	
//public Car ()
//{
//	year = 2016;
//	make = "Dodge";
//	model = "Challenger";
//}
	//make a mthod that return the make of the car
	public String getMake()
	{
		return make;
	}
	public String honk()
	{
		return "Beep Beep";
	}
	
public String toString()
	{
		return "The car is a " + year + " " + make + " " + model;
	}  
public static void main(String[] args)
	{
	  	Car bestCar = new Car("Buick", "Century", 1976 );
	  	System.out.println( bestCar.toString() );
	  	
	  	
	  //Create a car for a 2015 Ford Escape and print the info
	  	
		Car betterCar = new Car ("Ford", "Escape", 2015);
		System.out.println( betterCar.toString() );
		System.out.println("this car is a " + betterCar.getMake() + betterCar.honk());
	  	
//	  	Make a new constructor in the Car class that
//		will give default values for the make model and year
		//Car hopeYourCodeWorks = new Car( );
	}
}
