package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.MathPackage;

public class MathPackageTest {

	@Test
	public void testRandomNormal() {
		MathPackage.random(3, 2, 7);
	}
	@Test
	public void testRandomWith() {
		return; 
	}

}
