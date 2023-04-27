
public class Customer extends User {
	private String postCode;

	public Customer() {
		super();
	}

	public Customer(double money, String userName, String passWord, String phoneNumber,String postCode) {
		super(money, userName, passWord, phoneNumber);
		this.postCode = postCode;
	}

	public Customer(String postCode) {
		this.postCode = postCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
}
