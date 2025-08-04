package CoreConcepts;

public class RoyalEnfield implements BikeInterface{

	@Override
	public void start() {
		System.out.println("RE bike started");
	}

	@Override
	public void stop() {
		System.out.println("RE bike stopped");
	}

	@Override
	public void drive() {
		System.out.println("Driving RE Bike");		
	}

}
