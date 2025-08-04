package CoreConcepts;

public class Animals{
	private int legs;
	private String name = "Animal";
	private int eyes;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getEyes() {
		return eyes;
	}

	public void setEyes(int eyes) {
		this.eyes = eyes;
	}

	public Animals() {
		System.out.println("Animals contructor called");
	}
	
	public void eat() {
		System.out.println(name+" is eating it's food");
	}
	
	public void run() {
		System.out.println(name+" is running");
	}
	
	public void sleep() {
		System.out.println(name+" is sleeping");
	}

	@Override
	public String toString() {
		return "Animals [legs=" + legs + ", name=" + name + ", eyes=" + eyes + "]";
	}
	
	
}
