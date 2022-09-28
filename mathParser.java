package CSCI350;

class Node{
	public int eval() {
		System.out.print("Hopefully this doesn't work");
		return -1;
	}
}

class Leaf extends Node{
	public int value;
	public int eval() {
		System.out.println("Leaf eval" + value);
		return value;
	}
	public Leaf(Integer i) {
		value = i;
	}
}

class Op extends Node{
	public char operator;
	public Node left;
	public Node right;
	public int eval() {
		if(operator == '(') {
			return left.eval();
		}else if(operator == '+') {
				return left.eval() + right.eval();
		}else if(operator == '-') {
			return left.eval() - right.eval();
		}else {
			System.out.println("Op: " + operator + " not implemented");
			return -1;
		}
		
	}
	public Op(char o, Node l, Node r) {
		operator = o;
		left = l;
		right = r;
	}
}

class Parser{
	public Node tree;
	public Parser() {
		tree = null;
	}
	
	
	public Node factor(String input) {
		if(input.length() == 0)return null;
		System.out.println("factor: '" + input + "'");
		char[] chars = input.toCharArray();
		// Check for ()
		if(chars[0] == '(' 
				&& chars[input.length()-1] == ')') {
			//return expr(input.substring(1, input.length()-1).strip());
			return new Op('(',expr(input.substring(1, input.length()-1).strip()),null);
		}
		// See if its all digits
		for(char c: chars) {
			if(! Character.isDigit(c))return null;
		}
		return new Leaf((Integer.parseInt(input)));
		//return true; // must be good!
	}
	
	public Node term(String input) {
		System.out.println("term: '" + input + "'");
		return factor(input.strip());
	}
	
	public Node expr(String input) {
		System.out.println("expr: '" + input + "'");
		int plus_loc = input.indexOf("+");
		while(plus_loc != -1 && plus_loc != input.length()-1) {
			Node left = term(input.substring(0,plus_loc).strip());
			Node right = term(input.substring(plus_loc + 1).strip());
			System.out.println("Split at: " + plus_loc);
			if(left != null && right != null) {
				return new Op('+',left,right);
			}
			plus_loc = input.indexOf("+", plus_loc + 1);
		}
		
		plus_loc = input.indexOf("-");
		while(plus_loc != -1 && plus_loc != input.length()-1) {
			Node left = term(input.substring(0,plus_loc).strip());
			Node right = term(input.substring(plus_loc + 1).strip());
			System.out.println("Split at: " + plus_loc);
			if(left != null && right != null) {
				return new Op('-',left,right);
			}
			plus_loc = input.indexOf("-", plus_loc + 1);
		}
		
		return term(input);
	}
	
	public boolean parse(String input) {
		tree = expr(input);
		return tree != null;
	}
	
	public int numNodes() {
		return -1;
	}
	
	public int eval() {
		if(tree != null) {
			return tree.eval();
		}else {
			System.out.print("No tree to eval");
			return -1;
		}
	}
}

public class mathParser {

	public static void main(String[] args) {
		String tests[] = {"56"};
		
		Parser p = new Parser();
		
		for(String t: tests) {
			if(p.parse(t)) {
				System.out.println(t + " Accepted");
			}else {
				System.out.println(t + " NOT Accepted");
			}
		}
		System.out.println(p.eval());
		System.out.println(p.numNodes());

	}

}
