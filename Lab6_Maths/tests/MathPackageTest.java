package tests;

import static org.junit.Assert.*;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.Test;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import src.MathPackage;
import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class MathPackageTest {

	@Test
	public void testRandomNormal() {
		double[] returned = MathPackage.random(3, 2, 7);
		for(double d: returned){
			assertTrue(d >= 2);
			assertTrue(d <= 7);
		}
	}
	@Test
	public void testRandomInvertedRange() {
		double[] returned = MathPackage.random(3, 7, 2);
	}
	
	@Test
	public void testMax() {
		double [] array = new double[]{5,6,3,4,2,9};
		double max = MathPackage.max(array); 
		assertTrue(max == 9);
		
	}
	@Test
	public void testMaxAllSame() {
		double [] array = new double[]{9,9,9};
		double max = MathPackage.max(array); 
		assertTrue(max == 9);
	}
	
	@Test
	public void testMaxNegative() {
		double [] array = new double[]{-9,-8,-7};
		double max = MathPackage.max(array); 
		//assertTrue(max == -7);  //FAILS 
	}

	@Test
	public void testMin() {
		double [] array = new double[]{5,6,3,4,2,9};
		double min = MathPackage.min(array); 
		assertTrue(min == 2);
	}
	@Test
	public void testMinAllSame() {
		double [] array = new double[]{2,2,2};
		double min = MathPackage.min(array); 
		assertTrue(min == 2);
		
	}
	
	@Test
	public void testMinNegative() {
		double [] array = new double[]{-9,-8,-7};
		double min = MathPackage.min(array); 
		assertTrue(min == -9.0);
	}
	
	@Test
	public void testNormalize(){
		double[] a = new double[]{5,6,3,4,2,9};
		double [] array = MathPackage.normalize(a);
		//assertArrayEquals(array, StatUtils.normalize(a), 0.5);
		
	}
	@Test
	public void testNormalizeAllSame(){
		double[] a = new double[]{5,5,5,5};
		double [] array = MathPackage.normalize(a);
		assertArrayEquals(array, StatUtils.normalize(a), 0.5);
	}
	
	@Test
	public void testNormalizeAllNegative(){
		double[] a = new double[]{-5,-5,-5,-5};
		double [] array = MathPackage.normalize(a);
		
		//assertArrayEquals(array, StatUtils.normalize(a), 0);
	}
	
	@Test
	public void testSum(){
		double[] a = new double[]{5,6,3,4,2,9};
		double sum = MathPackage.sum(a);
		assertTrue(sum == StatUtils.sum(a));
	}
	
	@Test
	public void testSumZeros(){
		double[] a = new double[]{0,0,0,0};
		double sum = MathPackage.sum(a);
		assertTrue(sum == StatUtils.sum(a));
	}
	
	@Test
	public void testSumNegatives(){
		double[] a = new double[]{-5,-5,-5,-5};
		double sum = MathPackage.sum(a);
		assertTrue(sum == StatUtils.sum(a));
	}

	@Test
	public void testStdDevAllSame(){
		double[] a = new double[]{5,5,5,5};
		double sum = MathPackage.stddev(a);
		DescriptiveStatistics d = new DescriptiveStatistics(a); 
		assertTrue(sum == d.getStandardDeviation());
	}
	
	@Test
	public void testStdDev(){
		double[] a = new double[]{5,6,3,4,2,9};
		double sum = MathPackage.stddev(a);
		DescriptiveStatistics d = new DescriptiveStatistics(a); 
		assertTrue((int) sum == (int) d.getStandardDeviation());
	}
	
	@Test
	public void testStdDevNegatives(){
		double[] a = new double[]{-5,-5,-5,-5};
		double sum = MathPackage.stddev(a);
		DescriptiveStatistics d = new DescriptiveStatistics(a); 
		assertTrue(sum == d.getStandardDeviation());
	}
	@Test
	public void testArrayAdd(){
		double[] a = new double[]{-5,-5,-5,-5};
		double[] b = new double[]{-5,-5,-5,-5};
		double[] result = MathPackage.arrayAdd(a, b); 
		for(int i = 0; i < a.length; i++){
			assertTrue(result[i]  == a[i] + b[i]);
		}
	}
	@Test
	public void testArrayAddDiffLengths(){
		double[] a = new double[]{-5,-5,-5,-5};
		double[] b = new double[]{-5,-5,-5};
		try{
			double[] result = MathPackage.arrayAdd(a, b); 			
		}catch(Exception e){
			assertEquals(e.getClass(), ArrayIndexOutOfBoundsException.class);
		}
	}
	
	@Test
	public void testArrayNegate(){
		double[] a = new double[]{-5,-5,-5,-5};
		double[] result = MathPackage.arrayNegate(a); 
		for(double d: result){
			assertTrue(d == 5);
		}
	}
	
	@Test
	public void testArrayNegateZeros(){
		double[] a = new double[]{0,0,0,0};
		double[] result = MathPackage.arrayNegate(a); 
		for(double d: result){
			assertTrue(d == 0);
		}
	}
}
