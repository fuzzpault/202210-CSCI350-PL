/* hw4dfa.java
 * <name>
 * <date>
 * 
 * <description>
 * 
 */

package CSCI350;

public class hw4dfa {
	
	// You'll need to put your extra functions up here!

	public static Boolean fn1(String in) {
		// Change me!
		return false;
	}
	
	public static Boolean fn2(String in) {
		// Change me!
		return false;
	}
	
	public static Boolean fn3(String in) {
		// Change me!
		return false;
	}
	
	public static Boolean fn4(String in) {
		// Change me!
		return false;
	}
	
	public static Boolean fn5(String in) {
		// Change me!
		return false;
	}
	
	public static void main(String[] args) {
		// Do whatever you want down here to develop your functions above.
		String a[] = {"123","1234123","1234"};
		
		for(String sentance: a) {
			if(fn1(sentance)) {
				System.out.println(sentance + ": IN LANGUAGE");
			}else {
				System.out.println(sentance + ": NOT IN LANGUAGE");
			}
		}

	}

}
