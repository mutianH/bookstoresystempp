
public class User {
	private double money;//money in User's app account;
	private String userName;
	private String passWord;
	private String PhoneNumber;
	public User() {
		
	}
	public User(double money, String userName, String passWord, String phoneNumber) {
		super();
		this.money = money;
		this.userName = userName;
		this.passWord = passWord;
		PhoneNumber = phoneNumber;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "User [money=" + money + ", userName=" + userName + ", passWord=" + passWord + ", PhoneNumber="
				+ PhoneNumber + "]";
	}
	
}
