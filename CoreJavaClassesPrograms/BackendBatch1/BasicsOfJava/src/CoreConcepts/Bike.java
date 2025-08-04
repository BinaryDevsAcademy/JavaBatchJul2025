package CoreConcepts;

public abstract class Bike {
	private String bikeName;
	
	public abstract void start();
	
	public void setBikeName(String name) {
		bikeName = name;
	}
	public String getBikeName() {
		return bikeName;
	}
}
