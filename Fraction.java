
public class Fraction {
	private int n;
	private int d;
	public Fraction(int userN, int userD) {
		// User Can't divide by zero.
		if (userD == 0) {
			throw new IllegalArgumentException("You can't divide by 0!");
		}
		else if (userD < 0 && userN < 0) {
			userD = -1 * userD; // Set a negative fraction to be 5/3 rather than -5/-3
			this.d = userD;
			userN = -1 * userN;
			this.n = userN;
		}
		else if (userD < 0 && userN > 0) {
			userD = -1 * userD; // Set a negative fraction to be -5/3 rather than 5/-3
			this.d = userD;
			userN = -1 * userN;
			this.n = userN;
		}
		else {
			this.n = userN; // Construct the field values based on input from the client class.
			this.d = userD;
		}
	}
	public Fraction(int userT) {
		this.n = userT; // If the user enters in only one input, this input should be the numerator.
		this.d = 1;
	}
	public Fraction() {
		this.n = 0; // This handles an empty "" input from the client class
		this.d = 1;
	}
	// Here are the methods to implement. 
	public int getNumerator() {
		return this.n;
	}
	
	public int getDenominator() {
		return this.d;
	}
	
	public String toString() {
		String n1 = Integer.toString(this.n);
		String n2 = Integer.toString(this.d);
		return (n1 + "/" + n2);
	}
	public double toDouble() {
		double result = this.n / this.d; // need to round by two or re-write the math so that 5/4 doesn't return 1.0
		return result;
	}
	
	public Fraction add(Fraction other) {
		int GCD = other.d * this.d;
		int p2 = (other.n * this.d) + (other.d * this.n);
		Fraction newerFrac = new Fraction(p2, GCD);
		return newerFrac;
	}
	public Fraction subtract(Fraction other) {
		int GCD = other.d * this.d;
		int p1 = (other.n * this.d) - (other.d * this.n);
		Fraction newestFrac = new Fraction(p1, GCD);
		return newestFrac;
	}
	public Fraction multiply(Fraction other) {
		int top = other.n * this.n;
		int bottom = other.d * this.d;
		return new Fraction(top, bottom);
	}
	
	public Fraction divide(Fraction other) {
		int num = other.n * this.d;
		int denom = other.d * this.n;
		if (denom == 0) {
			throw new IllegalArgumentException("You can't divide by zero!");
		}
		else {
		return new Fraction(num, denom);
		}
	}
	public boolean equals(Object other) {
		boolean result = false;
		if (other == null || (getClass() != other.getClass())) {
			result = false;
			System.out.println("The object must be of the type Fraction, and it must not be null.");
			return result;
		}
		// other = (Fraction)other;
		double answer1 = ((Fraction)other).getNumerator() / ((Fraction)other).getDenominator();
		answer1 = Math.floor(answer1 * 100) / 100;
		double answer2 = this.n / this.d;
		answer2 = Math.floor(answer2 * 100) / 100;
		if (answer1 == answer2) {
			System.out.println("Fractions are equal!");
			result = true;
			return result;
		}
		else if (answer1 != answer2) {
			System.out.println("Fractions are not equal.");
			result = false;
			return result;
		}
		return result;
	}
	public void toLowestTerms() {
		int counter = 0;
		int modulo = 0;
		while (this.n != 0 && this.d != 0) {
			modulo = this.n % this.d;
			this.n = this.d;
			this.d = modulo;
		}
		this.n = this.n / modulo;
		this.d = this.d / modulo;
		Fraction simpleFrac = new Fraction(this.n, this.d);
	}
	
	public static int gcd(int num, int den) {
		int counter = 0;
		int modulo = 0;
		while (num != 0 && den != 0) {
			modulo = num % den;
			num = den;
			den = modulo;
		}
		return num;
	}
}