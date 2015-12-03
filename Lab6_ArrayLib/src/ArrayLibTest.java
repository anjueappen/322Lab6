import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class ArrayLibTest {

	@Test
	public void testReverse() {
		Integer[] ints = new Integer[]{3,4,5};  
		Integer[] returned = ArrayLib.reverse(ints, Integer.class); 
		assertArrayEquals(returned, new Integer[]{5,4,3});
	}
	@Test
	public void testReverseIdenticals() {
		Integer[] ints = new Integer[]{3,3,3};  
		Integer[] returned = ArrayLib.reverse(ints, Integer.class); 
		assertArrayEquals(returned, new Integer[]{3,3,3});
	}
	@Test
	public void testReverseEmpty() {
		Integer[] ints = new Integer[]{};  
		Integer[] returned = ArrayLib.reverse(ints, Integer.class); 
		assertArrayEquals(returned, new Integer[]{});
	}

	@Test
	public void testUniqueEmpty() {
		Integer[] ints = new Integer[]{};  
		Integer[] returned = ArrayLib.unique(ints, Integer.class);
		assertArrayEquals(returned, new Integer[]{});
	}

	@Test
	public void testUnique() {
		Integer[] ints = new Integer[]{3,4,5};  
		Integer[] returned = ArrayLib.unique(ints, Integer.class); 
		assertArrayEquals(returned, new Integer[]{3,4,5});
	}
	@Test
	public void testUniqueSame() {
		Integer[] ints = new Integer[]{3,3,3};  
		Integer[] returned = ArrayLib.unique(ints, Integer.class);
		assertArrayEquals(returned, new Integer[]{3});
	}
	@Test
	public void testIntersectionSame() {
		//Fails
		Integer[] ints = new Integer[]{3,3,3}; 
		Integer[] ints2 = new Integer[]{3,3,3};
		Integer[] returned = ArrayLib.intersection(ints, ints, Integer.class);
		assertArrayEquals(returned, new Integer[]{3});
	}
	@Test
	public void testIntersection() {
		Integer[] ints = new Integer[]{3, 4, 4}; 
		Integer[] ints2 = new Integer[]{4,5,1};
		Integer[] returned = ArrayLib.intersection(ints, ints2, Integer.class);
		assertArrayEquals(returned, new Integer[]{4});
	}
	
	public void testIntersectionNone() {
		Integer[] ints = new Integer[]{3, 4, 4}; 
		Integer[] ints2 = new Integer[]{6,5,1};
		Integer[] returned = ArrayLib.intersection(ints, ints2, Integer.class);
		assertArrayEquals(returned, new Integer[]{});
	}
	
	public void testIntersectionEmpty() {
		Integer[] ints = new Integer[]{}; 
		Integer[] returned = ArrayLib.intersection(ints, ints, Integer.class);
		assertArrayEquals(returned, new Integer[]{});
	}
	
	public void testIntersectionSimilar() {
		Integer[] ints = new Integer[]{3, 4, 4}; 
		Integer[] ints2 = new Integer[]{3,4,4};
		Integer[] returned = ArrayLib.intersection(ints, ints2, Integer.class);
		assertArrayEquals(returned, new Integer[]{3,4});
	}
	

	public void testIntersectionDiffLengths() {
		Integer[] ints = new Integer[]{3, 4, 4, 5}; 
		Integer[] ints2 = new Integer[]{1,1,5};
		Integer[] returned = ArrayLib.intersection(ints, ints2, Integer.class);
		assertArrayEquals(returned, new Integer[]{5});
	}
	

	public void testUnionEmpty() {
		Integer[] ints = new Integer[]{}; 
		Integer[] returned = ArrayLib.intersection(ints, ints, Integer.class);
		assertArrayEquals(returned, new Integer[]{});
	}

	public void testUnionSame() {
		Integer[] ints = new Integer[]{3, 3, 3}; 
		Integer[] returned = ArrayLib.intersection(ints, ints, Integer.class);
		assertArrayEquals(returned, new Integer[]{3, 3, 3, 3, 3, 3});
	}
	
	public void testUnionDiff() {
		Integer[] ints = new Integer[]{3, 3, 3}; 
		Integer[] ints2 = new Integer[]{4, 4, 4}; 
		Integer[] returned = ArrayLib.intersection(ints, ints2, Integer.class);
		assertArrayEquals(returned, new Integer[]{3, 3, 3, 4, 4, 4});
	}
	public void testUnionOneEmpty() {
		Integer[] ints = new Integer[]{3, 3, 3}; 
		Integer[] ints2 = new Integer[]{}; 
		Integer[] returned = ArrayLib.intersection(ints, ints2, Integer.class);
		assertArrayEquals(returned, new Integer[]{3, 3, 3});
	}
}
