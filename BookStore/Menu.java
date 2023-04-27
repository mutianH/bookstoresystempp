import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Menu {
    public static User u;
	public static void showMainPage() {
		 boolean flag = true;
		while(flag) {
		System.out.println("=============Welcome To Online Book Store=============");
		System.out.println("Please Choose Cammand from 1 - 3");
		System.out.println("1:Login");
		System.out.println("2:Store Register");
		System.out.println("3:Customer Register");
       
		
		int command = Utilities.inputInteger();
		if(command > 3 || command<=0) {
			System.out.println("please enter 1,2 or 3");
		
		}else {
			 switch(command){
		       case 1:
		    	   loginMenu();
		    	   break;
		       case 2:
		    	   storeRegister();
		    	   break;
		       case 3:
		    	   customerRegister(); 
		    	   break;
		    	default:
		    		System.out.println("wrong command");
		    		flag = false;
		    }
		}
       
   }	
}

	

	private static void customerRegister() {
		String userName="";
		String password = "";
		double money = 0;
		String phoneNumber = "";
		String postcode ="";
		
		while(true) {
			while (true) { 
				userName = Utilities.inputString("please enter your user name");
				for (User user : RunBookstore.ALL_USERS) {
					if (user.getUserName().equalsIgnoreCase(userName)) {
						System.out.println(userName + " already exist do please try again ");
						return;
					}else {
						password = Utilities.inputString("please enter your password");
						String password1 = Utilities.inputString("please enter your password again");
						if (password == null) {
							System.out.println("password can not be null, please try again ");
	                           return;
						} else if (!password.equals(password1)) {
							System.out.println("make sure you enter same passwords, please try again ");
							return;
						}else {
							money = Utilities.inputDouble("please enter account balance");
							if (money<=0) {
								System.out.println("make sure your account money is greater than 0, please try again ");
								return;
							}else {
								phoneNumber = Utilities.inputString("please enter phone number");
								String pattern = "^(\\([0-9]{3}\\)|[0-9]{3})[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}$";
								Pattern p = Pattern.compile(pattern);
						        Matcher m = p.matcher(phoneNumber);
						        if (!m.matches()) {
						            System.out.println("Invalid phone number");
						            System.out.println("make sure your phone number format is "
						            		+ "(123) 456-7890\r\n"
						            		+ "123-456-7890\r\n"
						            		+ "123.456.7890\r\n"
						            		+ "1234567890\\r\\n"
						            		+ "please try again ");
						            return;
						            
							    }else {
							    	postcode = Utilities.inputString("please enter postcode");
							    	String regex = "^[A-Za-z]\\d[A-Za-z]\\s?\\d[A-Za-z]\\d$";
							    	Pattern p1 = Pattern.compile(regex);
							    	Matcher m1 = p1.matcher(postcode);
							    	if (!m1.matches()) {
							            System.out.println("Invalid Postcode");
							            System.out.println("make sure your phone number format is "
							                    + "A1A 1A1\\r\\n"
							            		+ "please try again ");
							            return;
								    }else {
								    	//public Customer(double money, String userName, String passWord, String phoneNumber,String postCode)
								    	Customer customer = new Customer(money, userName, password, phoneNumber, postcode);
								    	RunBookstore.ALL_USERS.add(customer);
								    	System.out.println("user "+ userName+" added");
								    	return;
								    }
							    }
							}
						} 
					}
				} 
			} 
	    }
}

    private static void storeRegister() {
    	//public Store(double money, String userName, String passWord, String phoneNumber,String address, String storeName) 
    	String userName="";
		String password = "";
		double money = 0;
		String phoneNumber = "";
		String storeName ="";
		String address = "";
	
		while(true) {
			storeName = Utilities.inputString("please enter your store name");
            if(storeName == null) {
            	System.out.println("store name cannot be null, please try again");
                     return;
            }else {
            	userName = Utilities.inputString("please enter your user name");
            	for (User user : RunBookstore.ALL_USERS) {
					if (user.getUserName().equalsIgnoreCase(userName)) {
						System.out.println(userName + " already exist please try again");
                               return;
					}
				}
            	money = Utilities.inputDouble("please enter account balance");
				if (money<=0) {
					System.out.println("make sure your account money is greater than 0, pelase try again");
					return;
				}else {
                    password = Utilities.inputString("please enter your password");
					String password1 = Utilities.inputString("please enter your password again");
					if (password == null) {
						System.out.println("password can not be null, please try again");
						return;
					} else if (!password.equals(password1)) {
						System.out.println("make sure you enter same passwords, please try again ");
						return;
					}else {
						phoneNumber = Utilities.inputString("please enter phone number");
						String pattern = "^(\\([0-9]{3}\\)|[0-9]{3})[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}$";
						Pattern p = Pattern.compile(pattern);
				        Matcher m = p.matcher(phoneNumber);
				        if (!m.matches()) {
				            System.out.println("Invalid phone number");
				            System.out.println("make sure your phone number format is "
				            		+ "(123) 456-7890\r\n"
				            		+ "123-456-7890\r\n"
				            		+ "123.456.7890\r\n"
				            		+ "1234567890\\r\\n"
				            		+ "please try again");
				             return;
				            
					    }else {
					    	address = Utilities.inputString("please enter your address");
					    	if(address == null) {
					    		System.out.println("address can not be null, please try again");
                                        return;
					        }else {
					        	Store store = new Store(money, userName, password, phoneNumber, address, storeName);
					        	List<Book> books = new ArrayList<>();
					        	RunBookstore.ALL_BOOKS.put(store, books);
					        	System.out.println("store user "+storeName+" added");
					        	return;
		     }
           }
        }
	  }
    }
   }
  }

	private static void loginMenu() {
      while (true) {
		String userName = Utilities.inputString("please enter your user name");
		String password = Utilities.inputString("please enter your password");
		User user = Utilities.getUserByName(userName);
		if (user != null) {
			//login successfully
			u = user;
           if(user.getPassWord().equals(password)) {
        	   if(user instanceof Customer) {
        		   // customer user
        		   showCustomerPage();
        		 
        	   }else {
        		   //Store user
        		   showStorePage();
        		  
        	   }
        	   return;
           }else {
        	   System.out.println("wrong password");
           }
		} else {
			System.out.println("wrong login name");
		} 
	}
  }

	private static void showStorePage() {
		while(true) {
		System.out.println("==========Store Page==========");
		System.out.println("welcome  "+u.getUserName());
		System.out.println("1:show store infomation");
		System.out.println("2:add books");
		System.out.println("3:remove books");
		System.out.println("4:update books");
		System.out.println("5:logout");
		System.out.println("please choose command 1 - 5");
		//while(true) {
		int command = Utilities.inputInteger();
		if(command > 5 || command<=0) {
			System.out.println("please enter 1,2,3,4 or 5");
		
		}else {
			 switch(command){
		       case 1:
		    	   showInfo();
		    	   break;
		       case 2:
		    	   addBooks();
		    	   break;
		       case 3:
		    	   delete(); 
		    	   break;
		       case 4:
		    	   updateBook();
		    	   break;
		       case 5:
		    	   return;
		    	
		    }
		}
	}
		
	}

	private static void updateBook() {
		System.out.println("------------update books-------------");
		Store store = (Store)u;
		List<Book> books = RunBookstore.ALL_BOOKS.get(store);
		String flag = "y";
		while (flag.equalsIgnoreCase("y")) {
			String bookName = Utilities.inputString("please enter book name you want to update");
			for (Book book : books) {
				if (book.getName().equalsIgnoreCase(bookName)) {
					String name = Utilities.inputString("please enter book name");
					double price = Utilities.inputDouble("please enter book price");
					String authorName = Utilities.inputString("please enter Author name");
					int number = Utilities.inputInteger("please enter how many books in stock");
					book.setAuthor(authorName);
					book.setName(name);
					book.setNumber(number);
					book.setPrice(price);
					System.out.println(book.getName()+"has been updated");
					showInfo();
					return;
				} 
			} 
			flag = Utilities.inputString("no such book name found do you want to try again?(y/n) ");
		}
	
	
	
	}

	private static void delete() {
		System.out.println("------------delete books-------------");
		Store store = (Store)u;
		List<Book> books = RunBookstore.ALL_BOOKS.get(store);
		if(books.size()==0) {
			System.out.println("no books in stock");
			return;
		}
		String flag = "y";
		String contains = "n";
		while (flag.equalsIgnoreCase("y")) {
			String bookName = Utilities.inputString("please enter book name you want to remove");
			for (Book book : books) {
				if(book.getName().equals(bookName)) {
					books.remove(book);
					contains = "y";
					System.out.println(book.getName()+" has been deleted");
					showInfo();
					return;
				}
			}
			if (contains == "n") {
				flag = Utilities.inputString("no such book name found do you want to try again?(y/n) ");
			}
		}
	}

	private static void addBooks() {
		System.out.println("--------add books------------");
		Store store = (Store)u;
		List<Book> books = RunBookstore.ALL_BOOKS.get(store);
		String bookName = Utilities.inputString("please enter book name");
		double price = Utilities.inputDouble("please enter book price");
		String authorName = Utilities.inputString("please enter Author name");
		int number = Utilities.inputInteger("please enter how many books in stock");
		while (true) {
			try {
				String date = Utilities.inputString("please enter book publish date (yyyy/mm/hh)");

				Book book = new Book(Double.valueOf(price), number, authorName, RunBookstore.sdf.parse(date), bookName);
				books.add(book);
				System.out.println("add "+book.getName()+" successfuly");
				showInfo();
				return;
			} catch (ParseException e) {

				e.printStackTrace();
			} 
		}
		
	}

	private static void showInfo() {
		Store store = (Store)u;
		List<Book> books = RunBookstore.ALL_BOOKS.get(store);
		System.out.println("User Name: "+store.getUserName());
		System.out.println("Account Balance: "+store.getMoney());
		System.out.println("Store Name: "+store.getStoreName());
		System.out.println("Store Address: "+store.getAddress());
		System.out.println();
		System.out.println("Book Name\t\t\tBook Price\t\t\tStock\t\t\tAuthor");
		for (Book book : books) {
			System.out.println(book.getName()+"\t\t\t\t"+book.getPrice()+"\t\t\t\t"+book.getNumber()+"\t\t\t"+book.getAuthor());
		}
		showStorePage();
		
	}

	private static void showCustomerPage() {
		boolean flag = true;
		while(flag) {
		System.out.println("==========Customer Page==========");
		System.out.println("welcome  "+ u.getUserName());
		System.out.println("1:show all books");
		System.out.println("2:show book info by book name");
		System.out.println("3:purchase");
		System.out.println("4:logout");
		System.out.println("please choose command 1 - 4");

		
		int command = Utilities.inputInteger();
		if(command > 4 || command<=0) {
			System.out.println("please enter 1,2,3 or 4");
		
		}else {
			 switch(command){
		       case 1:
		    	   showAll();
		    	   break;
		       case 2:
		    	   queryName();
		    	   break;
		       case 3:
		    	   purchase(); 
		    	   break;
		       case 4:
		    	   return;
		    	default:
		    		System.out.println("wrong command");
		    		
		    }
		}
	}
}

	private static void purchase() {
		System.out.println("---------purchase book---------");
		showAll();
		String flag = "y";
		while (flag.equalsIgnoreCase("y")) {
			String storeName = Utilities.inputString("please enter store name");
			Store store = Utilities.getUserByName1(storeName);
			if (store == null) {
				flag = Utilities.inputString("no such book name found do you want to try again?(y/n) ");
			}else {
				List<Book>books = RunBookstore.ALL_BOOKS.get(store);
				 if(books.size()>0) {
					 String bookName = Utilities.inputString("please enter book name");
					         Book book = Utilities.getBookByStoreName(store, bookName);
					         if(book != null) {
					        	 int number = Utilities.inputInteger("how many books you want to purchase?");
					        	  if(number<book.getNumber()) {
					        		  double buyAmount = number*(book.getPrice());
					        		  if(buyAmount<u.getMoney()) {
					        			   double newBalance = u.getMoney() - buyAmount;
					        			   u.setMoney(newBalance);
					        			   double earnMoney = store.getMoney() + buyAmount; 
					        			   store.setMoney(earnMoney);
					        			   int newNumber = book.getNumber() - number;
					        			   book.setNumber(newNumber);
					        			  System.out.println("buy "+book.getName()+" "+ buyAmount+" books successfully your balance is now: "+u.getMoney());
					        			  return;
					        		  }else {
					        			  flag = Utilities.inputString("balance not engough do you want to try again?(y/n) ");
					        		  }
					        	  }else {
					        		  flag = Utilities.inputString("maximum  "+book.getNumber()+"  do you want to try again?(y/n) ");
					        	  }
					         }else {
					        	 flag = Utilities.inputString("wrong book name do you want to try again?(y/n) ");
					         }
				 }else {
					 flag = Utilities.inputString("no book aviliable do you want to try again?(y/n) ");
				 }
			} 
		}
		
	}

	private static void queryName() {
	    String flag = "y";
	    String contains = "n";
		while (flag.equalsIgnoreCase("y")) {
		String bookName = Utilities.inputString("please enter book name");
		Set<Store> stores = RunBookstore.ALL_BOOKS.keySet();
		for (Store store : stores) {
			List<Book> books = RunBookstore.ALL_BOOKS.get(store);
			for (Book book : books) {
				if (book.getName().contains(bookName)) {
					System.out.println(book.getName() + "\t\t\t\t" + book.getPrice() + "\t\t\t\t" + book.getNumber()
							+ "\t\t\t" + book.getAuthor());
					contains = "y";
					return;
                 } 
			}
    }
		if (contains == "n") {
			flag = Utilities.inputString("no such book name found do you want to try again?(y/n) ");
		} 
	 }
}	


	private static void showAll() {
	
	
			Set<Store> stores = RunBookstore.ALL_BOOKS.keySet();
			for (Store store : stores) {
				System.out.println("Store name: "+store.getStoreName());
			List<Book> books = RunBookstore.ALL_BOOKS.get(store);
			System.out.println("Book Name\t\t\tBook Price\t\t\tStock\t\t\tAuthor");
			System.out.println();
			  for (Book book : books) {
				System.out.println(book.getName()+"\t\t\t\t"+book.getPrice()+"\t\t\t\t"+book.getNumber()+"\t\t\t"+book.getAuthor());
		}
	}
			return;
}
		


}
