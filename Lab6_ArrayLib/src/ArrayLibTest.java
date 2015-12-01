import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class ArrayLibTest {

	@Test
	public void test() {
		Integer[] ints = new Integer[]{3,4,5};  
		Integer[] returned = ArrayLib.reverse(ints, Integer.class); 
		assertArrayEquals(returned, new Integer[]{5,4,3});
	}

}
