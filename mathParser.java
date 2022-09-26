package CSCI350;

class Parser{
	public Parser() {
		
	}
	
	
	public boolean factor(String input) {
		if(input.length() == 0)return false;
		System.out.println("factor: '" + input + "'");
		char[] chars = input.toCharArray();
		// Check for ()
		if(chars[0] == '(' 
				&& chars[input.length()-1] == ')') {
			return expr(input.substring(1, input.length()-1).strip());
		}
		// See if its all digits
		for(char c: chars) {
			if(! Character.isDigit(c))return false;
		}
		return true; // must be good!
	}
	
	public boolean term(String input) {
		System.out.println("term: '" + input + "'");
		return factor(input.strip());
	}
	
	public boolean expr(String input) {
		System.out.println("expr: '" + input + "'");
		int plus_loc = input.indexOf("+");
		while(plus_loc != -1 && plus_loc != input.length()-1) {
			boolean left = term(input.substring(0,plus_loc).strip());
			boolean right = term(input.substring(plus_loc + 1).strip());
			System.out.println("Split at: " + plus_loc);
			if(left && right)return true;
			plus_loc = input.indexOf("+", plus_loc + 1);
		}
		
		plus_loc = input.indexOf("-");
		while(plus_loc != -1 && plus_loc != input.length()-1) {
			boolean left = term(input.substring(0,plus_loc).strip());
			boolean right = term(input.substring(plus_loc + 1).strip());
			System.out.println("Split at: " + plus_loc);
			if(left && right)return true;
			plus_loc = input.indexOf("-", plus_loc + 1);
		}
		
		return term(input);
	}
	
	public boolean parse(String input) {
		return expr(input);
	}
}

public class mathParser {

	public static void main(String[] args) {
		String tests[] = {" (3+ 6)"};
		
		Parser p = new Parser();
		
		for(String t: tests) {
			if(p.parse(t)) {
				System.out.println(t + " Accepted");
			}else {
				System.out.println(t + " NOT Accepted");
			}
		}

	}

}
