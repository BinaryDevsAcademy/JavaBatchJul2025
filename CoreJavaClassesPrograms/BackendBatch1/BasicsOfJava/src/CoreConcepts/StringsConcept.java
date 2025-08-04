package CoreConcepts;

public class StringsConcept {
	String name = "Tom";
	
	int checkVowels(String str) {
		int count = 0;
		String[] strArray = str.split("");
		for(int i = 0; i < strArray.length; i ++) {
			if(strArray[i].equalsIgnoreCase("a") ||
			   strArray[i].equalsIgnoreCase("e") ||
			   strArray[i].equalsIgnoreCase("i") ||
			   strArray[i].equalsIgnoreCase("o") ||
			   strArray[i].equalsIgnoreCase("u")) {
				count ++;
			}
		}
		return count;
	}
	
	int characterCount(String str, String originalString) {
		int count = 0;
		String[] strArray = originalString.split("");
		for(String character : strArray) {
			if(str.equalsIgnoreCase(character))
				count ++;
		}
		return count;
	}
	
	boolean checkCompletedCharacters(String character, String[] array) {
		boolean found = false;
		
		for(String arrCharacter : array) {
			if(character.equalsIgnoreCase(arrCharacter))
				found = true;
		}
		return found;
	}
}
