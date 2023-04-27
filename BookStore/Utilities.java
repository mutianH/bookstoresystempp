import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Utilities {
	private static Scanner input = new Scanner(System.in);
	
	
	public static String inputString() {
		String value = input.nextLine();
		return value;
	}
	public static String inputString(String message) {
		System.out.printf("%s", message);
		String value = inputString();
		return value;
	}
	public static int inputInteger(String message) {
		// This method calls inputInteger(), so no changes are needed here.
		System.out.printf("%s", message);
		int value = inputInteger(); 
		return value;
	}
	
	public static int inputInteger() {
		boolean isInputBad = true;
		boolean hasNextInt;
		int value = 0;
		while(isInputBad) {
			hasNextInt = input.hasNextInt();
			if(hasNextInt) {
				value = input.nextInt();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter an integer number: ");
			}
			input.nextLine(); // clean up input stream
		}
		return value;
	}
	
	public static User getUserByName(String loginName) {
		
		for (User user : RunBookstore.ALL_USERS) {
			if (user.getUserName().equals(loginName)) {
				return user;
			}
		}
		return null;
	}
	
	public static double inputDouble(String message) {
		// This method calls inputDouble(), so no changes are needed here.
		System.out.printf("%s", message);
		double value = inputDouble();
		return value;
	}
	
	public static double inputDouble() {
		boolean isInputBad = true;
		boolean hasNextDouble;
		double value = 0.0;
		while(isInputBad) {
			hasNextDouble = input.hasNextDouble();
			if(hasNextDouble) {
				value = input.nextDouble();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter a number: ");
			}
			input.nextLine(); // clean up input stream
		}
		return value;	
	}
	
	public static Store getUserByName1(String storeName) {
		Set<Store> stores = RunBookstore.ALL_BOOKS.keySet();
		for (Store store : stores) {
			if(store.getStoreName().equalsIgnoreCase(storeName)) {
				return store;
			}
		}
		
		return null;
		
	}
	
	public static Book getBookByStoreName(Store store,String name) {
		         List<Book> books = RunBookstore.ALL_BOOKS.get(store);
		         for (Book book : books) {
					if(book.getName().equalsIgnoreCase(name)) {
						return book;
					}
				}
		return null;
		
	}
	
}
