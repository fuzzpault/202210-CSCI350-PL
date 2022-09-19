/* FAGenerator.java
 * Paul Talaga
 * September 19, 2022
 * 
 * Random sentence generator using
 * hard-coded functions.
 * 
 */

package CSCI350;

import java.util.Random;

public class FAGenerator1 {
	public static Random rand;
	
	public static String D() {
		if(rand.nextFloat() > 0.5)
			return "";
		else return "4" + A();
	}
	
	public static String C() {
		return "3" + D();
	}
	
	public static String B() {
		if(rand.nextFloat() > 0.5) 
			return "1" + D();
		else return "2" + C();
	}
	
	public static String A() {
		return "1" + B();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rand = new Random();
		for(int i = 0; i < 100; i++) {
			System.out.println(A());
		}
	}

}
