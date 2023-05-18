import static org.junit.Assert.*;

import org.junit.Test;

public class StoreTest {

	@Test
	public void test() {
		
		Store st1 = new Store(10000,"Store1","456","204987654","15-bookSt","BookWorld");
		
		assertNotNull(st1);
		
	}

}
