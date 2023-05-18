import static org.junit.Assert.*;

import org.junit.Test;


public class CustomerTest {

	@Test
	public void test1() {
		//double money, String userName, String passWord, String phoneNumber,String postCode
		
		Customer test1= new Customer(10,"test1","1234","1234567890","k2k6k9");
		assertEquals(test1.getMoney(), 10.00,0.0);	
	}

}
