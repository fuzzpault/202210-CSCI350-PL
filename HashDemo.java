/* HashDemo.java
 * Paul Talaga
 * September 7, 2022
 * 
 * Hashes an integer (variable a) and displays the resulting 
 * SHA-256 hash value in hex.
 * 
 */

package CSCI350;

import java.security.*;


public class HashDemo {
	
	public static String byteArrayToHex(byte[] a) {
		   StringBuilder sb = new StringBuilder(a.length * 2);
		   for(byte b: a)
		      sb.append(String.format("%02x ", b));
		   return sb.toString();
		}

	public static void main(String[] args) {
		Integer a = 5;
	
		//byte[] bytesOfMessage = a.byteValue();
		byte[] bytesOfMessage = new byte[] {
	            (byte)(a >>> 24),
	            (byte)(a >>> 16),
	            (byte)(a >>> 8),
	            (byte)(a >>> 0)};
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(bytesOfMessage);
			
			System.out.println(byteArrayToHex(digest));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
	
	}
	
	
	
}
