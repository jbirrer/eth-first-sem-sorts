import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class MedianTest {

	@Test
	public void testMedianSimple() {
		Scanner input = new Scanner("1 5 4 3 0");
		double result = Median.median(input);
		assertEquals(3, result, 0.0001);
		Scanner i = new Scanner("1 5 4 3");
		double r = Median.median(i);
		assertEquals(3.5, r, 0.0001);
		Scanner ir = new Scanner("1 3 4 3");
		double rr = Median.median(ir);
		assertEquals(3, rr, 0.0001);
	}
	@Test
	public void testMedian() {
		Scanner input = new Scanner("1");
		double result = Median.median(input);
		assertEquals(1, result, 0.0001);
	}
	@Test
	public void testMedianHEAVYLOAD() {
		Scanner input = new Scanner(" 0 0 0 -1 0 -2");
		double result = Median.median(input);
		assertEquals(0, result, 0.0001);
	}
}
