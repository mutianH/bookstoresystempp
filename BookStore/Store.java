
public class Store extends User{
	private String address;
	private String storeName;
	public Store() {
		
	}
	public Store(double money, String userName, String passWord, String phoneNumber,String address, String storeName) {
		super(money, userName, passWord, phoneNumber);
		this.address = address;
		this.storeName = storeName;
		
	}
	public Store(String address, String storeName) {
		this.address = address;
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
