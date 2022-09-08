/* HelloWorld.java
 * Paul Talaga
 * September 1, 2022
 * 
 * Hello world and a OOP demo.
 * 
 */
package CSCI350;

public class HelloWorld {
	
	public Integer a;
	
	public HelloWorld() {
		a = 5;
	}
	
	public void increment() {
		a++;
	}

	public static void main(String[] args) {
		HelloWorld obj = new HelloWorld();
		System.out.print("hello");
		System.out.print(obj.a);
		obj.increment();
		System.out.print(obj.a);

	}

}
	