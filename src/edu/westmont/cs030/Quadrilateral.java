/*This program is for returning the right number for the right Quadrilateral.
 * @ Author Zhenyuan Gao
 */

package edu.westmont.cs030;

public class Quadrilateral {

	static final double SMALL_NUMBER =1.0E-6;
	public static final int IS_SQUARE=0;
	public static final int IS_RECTANGLE=1;
	public static final int IS_TRAPEZOID=2;
	public static final int IS_RHOMBUS=3;
	public static final int IS_NONE=4;
	static  double x_1;
	static  double x_2;
	static  double x_3;
	static  double x_4;
	static  double y_1;
	static  double y_2;
	static  double y_3;
	static  double y_4;

	public Quadrilateral(double x_1 , double y_1 , double x_2 , double y_2 , double x_3 ,double y_3, double x_4 , double y_4){
	
		this.x_1= x_1;
		this.x_2= x_2;
		this.x_3= x_3;
		this.x_4= x_4;
		this.y_1= y_1;
		this.y_2=y_2;
		this.y_3=y_3;
		this.y_4=y_4;
	
	}
	
	static boolean feq(double x ,double y){
		return (Math.abs(x-y)< SMALL_NUMBER);
	}
		
	static double length(double x_1, double y_1,double x_2,double y_2 ){
		double length = Math.sqrt(Math.pow(y_2-y_1, 2)+Math.pow(x_2-x_1,2));
		return length;

	}
	
	static double angle(double x_1, double y_1,double x_2,double y_2 ,double x_3, double y_3 ){
// Try to get three length to make a triangle.	
		
		double firstLength= length( x_1,  y_1, x_2, y_2);
		double secondLength= length( x_2,  y_2, x_3, y_3);
		double diagonal= length( x_1,  y_1, x_3, y_3);
		
		
//apply cos()=(-c^2+a^2+b^2)/2ab
//Then change the cos() into degree
		double d=-((Math.pow((diagonal), 2)-Math.pow((secondLength), 2)-Math.pow((firstLength), 2))/(2*firstLength* secondLength));
		double radianAngle = Math.acos(d);
		double angle=Math.toDegrees(radianAngle);
			return angle;
	
	}
	
	
// Test whether two lines are parallel or not. First if is for special case.
	static public boolean IsParallel(double x_a, double y_a, double x_b, double y_b, double x_c, double y_c, double x_d,
			double y_d) {
		if (feq(x_a - x_b ,0) && feq(x_c - x_d , 0)) {
			return true;
		}
 
		else if (feq((y_a - y_b) / (x_a - x_b), (y_d - y_c) / (x_d - x_c))) {
			return true;
		}else {

			return false;
		}
	}
		
	public boolean RectangleCheck(){
//Get the four angles for Quadrilateral.
		double angleA=angle(this.x_1,this. y_1,this.x_2,this.y_2,this.x_3,this.y_3);
		double angleB=angle(this.x_2,this. y_2,this.x_3,this.y_3,this.x_4,this.y_4);
		double angleC=angle(this.x_2,this. y_2,this.x_1,this.y_1,this.x_4,this.y_4);
		double angleD=angle(this.x_1,this. y_1,this.x_4,this.y_4,this.x_3,this.y_3);
		
//Make sure those four angles are equal.		
		if (feq(angleA,90)&&feq(angleB,90)&&feq(angleC,90)&&feq(angleD,90))

					return true;
	
		else
			return false ;
		
	}
	
	public boolean SquareCheck(){
		double firstLength= length( x_1,  y_1, x_2, y_2);
		double secondLength= length( x_2,  y_2, x_3, y_3);
		double thirdLength= length( x_3,  y_3, x_4, y_4);
		double fourthLength= length( x_1,  y_1, x_4, y_4);
		
		
//make sure four angles are equal and four sidelengths are equal.		
		
		if(RectangleCheck()&& feq(firstLength,secondLength)&&feq(firstLength,thirdLength)&&feq(firstLength,fourthLength)){
		
				
			return true;
		}
			
		else
			return false;
			
			
		}		
	
			
// make sure there is only one pair of parallel lines.
	public boolean TrapezoidCheck(){ 			
		if(IsParallel(x_1,y_1,x_2,y_2,x_3,y_3,x_4,y_4)&&!(IsParallel( x_1,  y_1, x_4, y_4,x_2,y_2,x_3,y_3 ))||
				(!IsParallel(x_1,y_1,x_2,y_2,x_3,y_3,x_4,y_4)&&IsParallel(x_1, y_1, x_4, y_4,x_2,y_2,x_3,y_3))){
			return true;
		}
	 
	
		else
			return false;
	
	}
	
	public boolean RhombusCheck(){ 			
		double firstLength= length( x_1,  y_1, x_2, y_2);
		double secondLength= length( x_2,  y_2, x_3, y_3);
		double thirdLength= length( x_3,  y_3, x_4, y_4);
		double fourthLength= length( x_1,  y_1, x_4, y_4);
		
//make sure four sidelengths are equal and two pairs of lines are parallel.
			
		if(feq(firstLength,secondLength)&&feq(firstLength,thirdLength)&&feq(firstLength,fourthLength)
				&&IsParallel( x_1,  y_1, x_4, y_4,x_2,y_2,x_3,y_3 )
				&&IsParallel(x_1,y_1,x_2,y_2,x_3,y_3,x_4,y_4)){
			return true;
		}
		else
			return false;
				
	}

// Return the number that assign to the shape.
	public int analyze (  ){
			if(SquareCheck()){
			
				return IS_SQUARE;
			}else if(RectangleCheck()){
				return IS_RECTANGLE;
				
			}else if(TrapezoidCheck()){
				return IS_TRAPEZOID;
				
			}else if(RhombusCheck()){
				return IS_RHOMBUS;
				
			}else 
				return IS_NONE;			
			
			}
	}
