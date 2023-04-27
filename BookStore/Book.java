import java.util.Date;

public class Book {
	private String name;
	private double price;
	private int number;
	private String author;
	private Date date;//published date;
	
	
	public Book() {
		
	}
	

	public Book(double price, int number, String author, Date date,String name) {
		this.name = name;
		this.price = price;
		this.number = number;
		this.author = author;
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}