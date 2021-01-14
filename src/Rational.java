
public class Rational implements Arithmetic<Rational> {
	private int numerator, denominator;
	/**
	 * Constructor
	 */
	public Rational() {
		numerator =0;
		denominator = 1;
	}
	/**
	 * Constructor with two parameters
	 * @param n to be assigned to numerator
	 * @param d to be assigned to denominator
	 */
	public Rational(int n, int d) {
		this.numerator = n;
		this.denominator=d;
	}
	/**
	 * Constructor to assign numerator and denominator by splitting along "/"
	 * @param s String input to be parsed and split
	 */
	public Rational(String s) {
		if(s.matches("\\d+/\\d+")) {
			numerator =  Integer.parseInt(s.split("/")[0]);
			denominator = Integer.parseInt(s.split("/")[1]);
		}
	}
	/**
	 * Adds to rational numbers and returns a new rational number as output
	 */
	public Rational add(Rational f) {
		
		int n= (numerator * f.denominator) + (f.numerator * denominator);
		int d= denominator * f.denominator;
		Rational output = new Rational(n,d);
		output.reduce();
		return output;
	 	
	}
	/**
	 * Subtracts two rational numbers and returns a new rational number as output
	 */
	public Rational subtract(Rational f) {
		
		int n= numerator * f.denominator - f.numerator * denominator;
		int d= denominator * f.denominator;
		Rational output = new Rational(n,d);
		output.reduce();
		return output;
		
	}
	/**
	 * Multiplies two rational numbers and returns a new rational number as output
	 */
	public Rational multiply(Rational f) {
		int n= numerator * f.numerator;
		int d= denominator * f.denominator;
		Rational output = new Rational(n,d);
		output.reduce();
		return output;
	}
	/**
	 * Divides two rational numbers and returns a new rational number as output
	 */
	public Rational divide(Rational f) {
		int n= numerator * f.denominator;
		int d= f.numerator * denominator;
		Rational output = new Rational(n,d);
		output.reduce();
		return output;
	
	}
	/**
	 * Returns formatted output
	 */
	public String toString() {
		String output ="";
		if(numerator == 0) {
			return "0";
		}
		else if(denominator==1) {
			output+=numerator;
			return output;
		}
		else {
			return numerator + "/" + denominator;
		}
		
	}
	/**
	 * Reduces fractions based on their gcd
	 */
	private void reduce() {
		int g = gcd(numerator, denominator);
		numerator/= g;
		denominator/= g;
		
	}
	/**
	 * Euclid's gcd recursion 
	 */
	public static int gcd(int m, int n) {
		if(m%n == 0) {
			return n;   
		}
		else {
			return gcd(n, m%n);
		}
	}
}
