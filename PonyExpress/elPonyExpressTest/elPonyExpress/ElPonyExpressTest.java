package elPonyExpress;

import org.junit.Assert;
import org.junit.Test;

public class ElPonyExpressTest {

	@Test
	public void elPonyExpresstest1() {
		Assert.assertEquals(1, PonyExpress.caballos(new int[] { 18, 15 }));
	}
	
	@Test
	public void elPonyExpresstest2() {
		Assert.assertEquals(2, PonyExpress.caballos(new int[] { 43, 23, 40, 13 }));
	}

	@Test
	public void elPonyExpresstest3() {
		Assert.assertEquals(3, PonyExpress.caballos(new int[] { 33, 8, 16, 47, 30, 30, 46 }));
	}
	
	@Test
	public void elPonyExpresstest4() {
		Assert.assertEquals(3, PonyExpress.caballos(new int[] { 51, 51, 51 }));
	}
	
	@Test
	public void elPonyExpresstest5() {
		Assert.assertEquals(4, PonyExpress.caballos(new int[] { 6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49 }));
	}
}
