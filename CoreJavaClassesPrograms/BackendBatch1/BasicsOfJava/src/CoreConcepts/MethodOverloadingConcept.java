package CoreConcepts;

public class MethodOverloadingConcept {
	void read() {
		System.out.println("User is reading the book");
	}
	
	void read(String username) {
		System.out.println(username+" is reading the book");
	}
	
	void read(String username, int age) {
		System.out.println(username+" of age : "+age+" is reading the book");
	}
}
