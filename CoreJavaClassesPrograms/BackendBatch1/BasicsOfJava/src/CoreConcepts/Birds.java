package CoreConcepts;

public class Birds extends Animals {
	public int wings;
	public String name;
	
	public Birds() {
		this.name = super.getName();
		System.out.println("Birds Constructor called");
	}
	
	@Override
	public void run() {
		System.out.println("Birds cannot run");
	}
	
	public void fly() {
		System.out.println(name+" is flying with"+wings+" wings");
	}
	
	@Override
	public String toString() {
		return "Birds [wings= "+wings+", legs=, name=" + name + ", eyes=]";
	}
	
}
