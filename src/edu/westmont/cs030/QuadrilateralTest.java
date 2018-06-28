package edu.westmont.cs030;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuadrilateralTest {

	@Test
	public void testfeq() {
		assertTrue(Quadrilateral.feq(3.1, 3.1));
		assertTrue(Quadrilateral.feq(0, 0));
		assertTrue(Quadrilateral.feq(-1, -1));
		assertTrue(!Quadrilateral.feq(-1, -2));
		assertTrue(!Quadrilateral.feq(3, 2));
		assertTrue(!Quadrilateral.feq(1, -1));
	}

	@Test
	public void testLength() {
		double x = Quadrilateral.length(1, 1, 1, 1);
		assertTrue(Quadrilateral.feq(x, 0.0));
		x = Quadrilateral.length(1, 1, 1, 2);
		assertTrue(Quadrilateral.feq(x, 1.0));
		x = Quadrilateral.length(-1, -1, -2, -1);
		assertTrue(Quadrilateral.feq(x, 1.0));
		x = Quadrilateral.length(-3, -3, 3, 3);
		assertTrue(Quadrilateral.feq(x, Math.sqrt(72)));

	}

	@Test
	public void testAngle() {
		double x = Quadrilateral.angle(0, 1, 0, 0,1,0);
		assertTrue(Quadrilateral.feq(x, 90));
		 x = Quadrilateral.angle(0, 1, Math.sqrt(3), 0,0,0);
		assertTrue(Quadrilateral.feq(x, 30));
		x = Quadrilateral.angle(-1, 0, 0, 0,1,0);
		assertTrue(Quadrilateral.feq(x, 180));
		x = Quadrilateral.angle(0, 0,1, Math.sqrt(3), 2,0);
		assertTrue(Quadrilateral.feq(x, 60));
	
	
	
	}
	@Test
	public void testSlope() {
		boolean x = Quadrilateral.IsParallel(0, 0, 0, 1, 1,0,1,1);
		assertTrue(x);	
		x = Quadrilateral.IsParallel(1, 1, 2, 2, 3,3,4,4);
		assertTrue(x);	
		 x = Quadrilateral.IsParallel(5, 4, 10, 8, 15,12,20,16);
		assertTrue(x);	
		 x = Quadrilateral.IsParallel(7, 14, 9, 10, 2,1,1,3);
		assertTrue(x);	
		x = Quadrilateral.IsParallel(7, 14, 9, 10, 2,1,1,3);
		assertTrue(x);
		x = Quadrilateral.IsParallel(-1, 1, 1,1 , -1,-1,1,-1);
		assertTrue(x);
		x = Quadrilateral.IsParallel(-1, 1, 1,1 , -1,-1,1,-1);
		assertTrue(x);
		x = Quadrilateral.IsParallel(1, 1, 1,1 , -1,-1,1,-1);
		assertTrue(!x);
	}


	
		
		
		
		
		
		
	@Test
	public void test() {
		Quadrilateral q = new Quadrilateral(100.5,100.5,-100.5,100.5,-100.5,-100.5,100.5,-100.5); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_SQUARE == q.analyze()) ;
		assertEquals(0,q.analyze());

		Quadrilateral t = new Quadrilateral(-100.0,-100.0,-150.0,-170.0,-100.0,-240.0,-50.0,-170.0); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_RHOMBUS == q.analyze()) ;
		assertEquals(3,q.analyze());

		Quadrilateral f = new Quadrilateral(-2.7987881748301375,0.0,0.0,9.564316634449014,2.7987881748301375,0.0,0.0,-9.564316634449014 ); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_RHOMBUS == q.analyze()) ;
		assertEquals(0,q.analyze());
		Quadrilateral g = new Quadrilateral(0.0,100.0,100.0,0.0,99.0,-1.0,-1.0,99.0); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_RECTANGLE == q.analyze()) ;
		assertEquals(1,q.analyze());
		Quadrilateral h = new Quadrilateral(-7.0,0.0,-98.0,-3.0,2500.0,-3.0,50.0,0.0); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()) ;
		assertEquals(2,q.analyze());
		Quadrilateral o = new Quadrilateral(-100.0,-100.0,-150.0,-170.0,-100.0,-240.0,-50.0,-1888870.0); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_NONE == q.analyze()) ;
		assertEquals(4,q.analyze());
		Quadrilateral z = new Quadrilateral(-1.0,100.0,Math.sqrt(3),0,-1,-100.0,-(Math.sqrt(3)+2),0.0); 
	//	assertTrue(Quadrilateral.IS_TRAPEZOID == q.analyze()); }
		assertTrue(Quadrilateral.IS_RHOMBUS == q.analyze()) ;
		assertEquals(3,q.analyze());}
}
