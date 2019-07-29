import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Fraction {

	private int n;
	private int d;
	
	public Fraction (int n1, int d1) {
		if (d1 == 0) {
			throw new IllegalArgumentException("You can't divide by zero!");
		}

		
		if (n1 < 0 && d1 < 0) {
			n1 = n1 * -1;
			this.n = n1;
			d1 = d1 * -1;
			this.d = d1;
		}
		
		else if (n1 > 0 && d1 < 0) {
			n1 = n1 * -1;
			this.n = n1;
			d1 = d1 * -1;
			this.d = d1;
		}
		
		else {
			this.n = n1;
			this.d = d1;
		}
		
		
	}
	public Fraction(int s) {
		this.n = s;
		this.d = 1;
	}
	
	public Fraction() {
		this.n = 0;
		this.d = 0;
	}
	
	public int getNumerator() {
		return this.n;
	}
	public int getDenominator() {
		return this.d;
	}
	
	public String toString() {
		String newString = this.n + "/" + this.d;
		return newString;
	}
	
	public double toDouble() {
		double dd1 =  (double) this.n;
		double dd2 =  (double) this.d;
		return dd1 / dd2;
	}
	
	public Fraction add(Fraction other) {
		if (this.d != other.d) {
			int newDom = this.d * other.d;
			int newN1 = this.n * other.d;
			int newN2 = other.n * this.d;
			int combo = newN1 + newN2;
			Fraction added = new Fraction(combo, newDom);
			Fraction nadded = added.toLowestTerms();
			return nadded;
		}
		else {
			int newN = this.n + other.n;
			Fraction added2 = new Fraction(newN, other.d);
			Fraction nadded2 = added2.toLowestTerms();
			return nadded2;
		}
	}
	
	public Fraction subtract(Fraction other) {
		if (this.d != other.d) {
			int subDom = this.d * other.d;
			int s1 = this.n * other.d;
			int s2 = other.n * this.d;
			int combo2 = s1 - s2;
			Fraction sub = new Fraction(combo2, subDom);
			Fraction subN = sub.toLowestTerms();
			return subN;
		}
		else {
			int combo3 = this.n - other.n;
			Fraction subb = new Fraction(combo3, other.d);
			Fraction subbN = subb.toLowestTerms();
			return subbN;
		}
	}
	
	public Fraction multiply(Fraction other) {
		int multN = this.n * other.n;
		int multD = this.d * other.d;
		Fraction mf = new Fraction(multN, multD);
		Fraction rmf = mf.toLowestTerms();
		return rmf;
	}
	
	public Fraction divide(Fraction other) {
		double tester = (double) other.n / other.d;
		if (tester == 0.0) {
			throw new IllegalArgumentException("You can't divide by zero!");
		}
		else {
			int div1 = this.n * other.d;
			int div2 = other.n * this.d;
			Fraction divvy = new Fraction(div1, div2);
			Fraction divvyN = divvy.toLowestTerms();
			return divvyN;
		}
	}
	
	public boolean equals(Object other) {
		if (other instanceof Fraction) {
			float f1 = ((float)(this.n)) / ((float)(this.d));
			Fraction c = (Fraction) other;
			float f2 = ((float)(c.n))  / ((float)(c.d));
		
			if (f1 == f2) {
				return true;
			}
		return false;
	}
	return false;
}
	
	public Fraction toLowestTerms() {
		if (this.n == 0) {
			System.out.println("Your resulting fraction equals zero, therefore it can't be reduced.");
			int newInt = 0;
			return new Fraction(newInt);
		}
		int divi = 1;
		int t1 = this.n;
		int t2 = this.d;
		while (t1 != 0 && t2 != 0) {
			int m1 = t1 % t2;
			t1 = t2;
			t2 = m1;
			divi = t1;
		}
		int updN = this.n / divi;
		int updD = this.d / divi;
		return new Fraction(updN, updD);
	}
	
	public static int gcd(int n1, int n2) {
		int copyN = n1;
		int copyN2 = n2;
		int div = 0;
		while(copyN != 0 && copyN2 != 0) {
			int m1 = copyN % copyN2;
			copyN = copyN2;
			copyN2 = m1;
			div = copyN;
		}
		return div;
	}
}

