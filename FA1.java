/* FA1.java
 * Paul Talaga
 * September 19, 2022
 * 
 * Language validator using recursion
 * and hard-coded functions.
 * 
 */

package CSCI350;

public class FA1 {
	
	public static Boolean D(String in) {
		System.out.println("D:" + in);
		if(in.length() == 0)return true;
		if(in.charAt(0) == '4') {
			return A(in.substring(1));
		}
		return false;
	}
	
	public static Boolean C(String in) {
		System.out.println("C:" + in);
		if(in.length() == 0)return false;
		if(in.charAt(0) == '3') {
			return D(in.substring(1));
		}
		return false;
	}
	
	public static Boolean B(String in) {
		System.out.println("B:" + in);
		if(in.length() == 0)return false;
		if(in.charAt(0) == '1') {
			return D(in.substring(1));
		}
		if(in.charAt(0) == '2') {
			return C(in.substring(1));
		}
		return false;
	}
	
	public static Boolean A(String in) {
		System.out.println("A:" + in);
		if(in.length() == 0)return false;
		if(in.charAt(0) == '1') {
			return B(in.substring(1));
		}
		return false;
	}
	
	public static Boolean validate(String in) {
		return A(in);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = {"123","1234123","1234"};
		
		for(String sentance: a) {
			if(validate(sentance)) {
				System.out.println(sentance + ": IN LANGUAGE");
			}else {
				System.out.println(sentance + ": NOT IN LANGUAGE");
			}
		}

	}

}
