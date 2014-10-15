import java.util.*;
public class Actions {
	//private static DBConnector cont = new DBConnector("jdbc:mysql://localhost:3306/lib_test", "root", "usetheforce");
	private static String isbn = new String();
	private static Book book_info=new Book();
	private static String author_name=new String();
	private static List<Book> books = new ArrayList<Book>();
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		Actions.isbn = isbn;
	}
	public Book getBook_info() {
		return book_info;
	}
	public void setBook_info(Book book_info) {
		Actions.book_info = book_info;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		Actions.author_name = author_name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		Actions.books = books;
	}
	public String SearchAuthorexcute() {
		DBConnector cont = new DBConnector("jdbc:mysql://localhost:3306/lib_test", "root", "usetheforce");
		ArrayList<Book> list = cont.OnSearchForAuthor(author_name);
		books.clear();
		System.out.println("function SearchAuthor");
		for(int i=0; i<list.size();i++) {
			books.add(list.get(i));
			System.out.println(list.get(i).title);
		}
		cont.close();
		return "booklist";
	}
	public String BookListexcute() {
		DBConnector cont = new DBConnector("jdbc:mysql://localhost:3306/lib_test", "root", "usetheforce");
		book_info = cont.OnSearchForBook(isbn);
		cont.close();
		return "bookinfo";
	}
	public String Deleteexcute() {
		DBConnector cont = new DBConnector("jdbc:mysql://localhost:3306/lib_test", "root", "usetheforce");
		cont.OnDeleteBook(isbn);
		cont.close();
		return "SearchAuthor";
	}
	public String Backexcute() {
		return "SearchAuthor";
	}
}
