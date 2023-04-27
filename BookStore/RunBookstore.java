import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunBookstore {
	public static final List<User> ALL_USERS = new ArrayList<>();
	public static final Map<Store, List<Book>>ALL_BOOKS = new HashMap<>();
	public static SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
	static {
		//create customer users
		Customer c1 = new Customer(1000,"Jacky","123","204123456","Z1Z,0Z1");		
		Customer c2 = new Customer(2000,"Wang","234","20423457","Q1Z,0Z1");
		Customer c3 = new Customer(1000,"Julie","345","204345678","W1Z,0Z1");
		Collections.addAll(ALL_USERS, c1,c2,c3);//add customers
		//create store users
		Store st1 = new Store(10000,"Store1","456","204987654","15-bookSt","BookWorld");
		Store st2 = new Store(20000,"Store2","789","204876543","20-bookSt","BookCollection");
		Collections.addAll(ALL_USERS, st1,st2);//add store users
		List <Book> books = new ArrayList<>();
		try {
			Book book = new Book(85.0,35,"Colleen Hoover",sdf.parse("2018/11/07"),"Verity");
			books.add(book);
			Book book1 = new Book(75.5,35,"Vladimir Nabokov",sdf.parse("1955/09/01"),"Lolita");
			books.add(book1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ALL_BOOKS.put(st1, books);
		
		List<Book> books2 = new ArrayList<>();//empty Book Array book2
		ALL_BOOKS.put(st2, books2);
		
	}
public static void main(String[] args) {
	Menu.showMainPage();
	
}
}
