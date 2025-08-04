package CoreConcepts;

public class Publishers extends Author{
	public String bookName;

	public void publishBook() {
		bookName = super.bookName;
		System.out.println("Book Name ; "+bookName+" Author : "+authorName+" price "+bookPrice);
	}
}
