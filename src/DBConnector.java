import java.sql.*;
import java.util.*;
public class DBConnector {
	public Connection conct;
	public DBConnector(String url, String user, String pwd) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conct=DriverManager.getConnection(url, user, pwd);
		}catch(Exception exc) {
			System.out.println("Connection has failed.");
			exc.printStackTrace();
		}
	}
	//every three elements in returned array is a tuple of (book title, author name, ISBN)
	public ArrayList<Book> OnSearchForAuthor(String author_name) {
		String query = "select AuthorID, Name from Author where Name like\"%"+author_name+"%\";";
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			if(conct==null) System.out.println("conct is null");
			Statement sttm = conct.createStatement();
			ResultSet rst = sttm.executeQuery(query);
			query = "select Title, ISBN from Book where AuthorID=";
			System.out.println(author_name);
			while(rst.next()) {
				String id = rst.getString(1);
				String name = rst.getString(2);
				System.out.println(id+"-"+name);
				Statement sttm_cpy = conct.createStatement();
				ResultSet bookset = sttm_cpy.executeQuery(query+id+";");
				while(bookset.next()) {
					Book book = new Book();
					book.isbn = bookset.getString(2);
					book.title = bookset.getString(1);
					book.author = new Author();
					book.author.authorID = id;
					book.author.name = name;
					list.add(book);
				}
				sttm_cpy.close();
			}
			sttm.close();
		}catch(Exception exc) {
			System.out.println("Unhandled exception was thrown when searching for author \""+author_name+"\"");
			exc.printStackTrace();
		}
		return list;
	}
	public Book OnSearchForBook(String ISBN) {
		Book book = null;
		try{
			Statement sttm = conct.createStatement();
			ResultSet bookrst = sttm.executeQuery("select * from Book where ISBN=\""+ISBN+"\";");
			if(bookrst.next()) {
				book = new Book();
				book.isbn = bookrst.getString(1);
				book.title = bookrst.getString(2);
				book.publisher = bookrst.getString(4);
				book.publish_date = bookrst.getString(5);
				book.price = bookrst.getString(6);
				ResultSet authorrst = sttm.executeQuery("select * from Author where AuthorID="+bookrst.getString(3)+";");
				if(authorrst.next()) {
					book.author = new Author();
					book.author.authorID = authorrst.getString(1);
					book.author.name = authorrst.getString(2);
					book.author.age = authorrst.getString(3);
					book.author.country = authorrst.getString(4);
				}
			}
			sttm.close();
		}catch(Exception exc) {
			System.out.println("Unhandled exception was thrown when searching for book with ISBN "+ISBN);
			exc.printStackTrace();
		}
		return book;
	}
	public void OnDeleteBook(String ISBN) {
		try{
			Statement sttm = conct.createStatement();
			sttm.executeUpdate("delete from Book where ISBN=\""+ISBN+"\";");
			sttm.close();
		}
		catch(Exception exc) {
			System.out.println("Unhandled exception was thrown when deleting book with ISBN "+ISBN);
			exc.printStackTrace();
		}
	}
	public void close() {
		try{
		conct.close();
		}catch(Exception ecp)
		{
			System.out.println("Problem occurred when close connection to database.");
		}
	}
}
