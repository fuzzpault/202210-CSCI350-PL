package CSCI350;

import java.util.*;	// For Vector

class Circle extends Thread {
	  private String name;
	  public Integer result;
	  Circle(String n){
		  name = n;
		  result = 0;
	  }
	  
	  public void run() {
	    System.out.println("This code is running in a thread" + name);
	    try {
	    	// Computationally hard code here
	    	Thread.sleep(500);
	    } catch (InterruptedException e) {
	         System.out.println("Thread " +  name + " interrupted.");
	    }
	    result = 100;
	    System.out.println("End" + name);
	  }
	}



	


public class JavaThreadDemo {

	public static void main(String[] args) {
		
		// A container to hold the threads
		Vector<Circle> threads = new Vector<Circle>();
		
		// Start all the threads
		for(Integer i = 0; i < 10; i++) {
			Circle c = new Circle("Thread " + i.toString());
			
			threads.add( c  );	// Hold onto the object so we can wait on it later
			c.start();			// Start the thread
								// The .run() method MUST be implemented
								// for this to work.  start starts a thread
								// and runs the run method.
		}
		
		// Now wait till they're all done
		for(Circle c : threads) {
			try {
				while(c.isAlive())Thread.sleep(50);
			}catch(InterruptedException e) {
				System.out.print("Something went wrong");
			}
			// Even though the thread has finished, the object still exists
			// and can be accessed to get data back.
			System.out.println(c.result);
		}
		
		System.out.print("All threads done");

	}

}
