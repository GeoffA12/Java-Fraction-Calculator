import java.util.Scanner;
public class FractionCalc {

	public static void main(String[] args) {
		System.out.println("This is a fraction calculator.");
		System.out.println("It will add, subtract, multiply and divide frations until you type Q to quit.");
		System.out.println("Please enter your fractions in the form \"a/b\", where \"a\" and \"b\" are integers.");
		while (true) {
			System.out.println("--------------------------------------------------------------------------------");
			String operation = getOperation();
	
			Fraction userFrac1 = getFraction();
			Fraction userFrac2 = getFraction();

			printResult(userFrac1, userFrac2, operation);
		}
	}
	
	public static String getOperation() {
		Scanner newInput = new Scanner(System.in);
		String operation1 = " ";
		boolean flag = false;
		System.out.println("Please enter an operation (+, -, /, *, =, or Q to quit): ");
		while (flag == false) {
			do {
				try	{
					operation1 = newInput.nextLine();
					if (operation1.equalsIgnoreCase("Q")) {
						System.out.println("Process finished with exit code 0");
						System.exit(0);
					}
					break;
				
				}
					catch (Exception e) {
					System.out.println("Invalid input. Press (+, -, /, *, = or Q to quit):");
				}
			} 	while (true);
		
			if (!operation1.equals("+") && !operation1.equals("/") && !operation1.equals("-") && !operation1.equals("*") && !operation1.equals("=")) {
				System.out.println("Invalid input (+, -, /, *, = or Q to quit):");
				continue;
			}
			break;
		}
		return operation1;
	}
	
	public static Fraction getFraction() {
		Scanner userInput = new Scanner(System.in);
		String dFrac3 = isValidFraction();
		if (dFrac3.contains("/")) {
			String[] splitter = dFrac3.split("/");
			String split1 = splitter[0];
			Integer a = Integer.parseInt(split1);
			String split2 = splitter[1];
			Integer b = Integer.parseInt(split2);
			return new Fraction(a, b);
		}
		else {
			Integer a = Integer.parseInt(dFrac3);
			return new Fraction(a);
		}
	}
	
	public static String isValidFraction() {
		Scanner revisedInput = new Scanner(System.in);
		String dFrac = null;
		System.out.println("Please enter a fraction \"a/b\" or integer \"a\": ");
		boolean key;
		outerLoop:
		while (true) {
			dFrac = revisedInput.nextLine();
			int length = dFrac.length();
			String dFrac2 = null;
			if (dFrac.equals("")) {
				System.out.println("I got to the null error!");
				System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
				continue;
			}
			if (!dFrac.contains("/")) {
				if (dFrac.contains("-")) {
					int a = dFrac.indexOf("-");
					if (a != 0) {
						System.out.println("You entered a negative sign in the wrong place. Try again!");
						System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
						continue;
					}
					dFrac2 = dFrac.substring(1, length - 1);
					key = isNumber(dFrac2);
					if (key == false) {
						continue outerLoop;
					}
					break outerLoop;
				}
				key = isNumber(dFrac);
				if (key == false) {
					continue outerLoop;
				}
				break outerLoop;
				
			}
			else if (dFrac.contains("/")) {
				String part1 = null;
				String part2 = null;
				String[] parts = dFrac.split("/");
				if (parts.length <= 1) {
					System.out.println("You entered a fraction with one of the parts as a null value!.");
					System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
					continue outerLoop;
				}
				part1 = parts[0];
				part2 = parts[1];
				
		
				if (part2.equals("0")) {
					System.out.println("You can't divide by zero!");
					System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
					continue outerLoop;
				}
				if (part1.equals("") || part2.equals("")) {
					System.out.println("You entered a fraction with one of the parts as a null value.");
					System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
					continue outerLoop;
				}
				if (part2.contains("-")) {
					System.out.println("You tried to enter a negative sign int the denominator. Must be in the numerator.");
					System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
					continue outerLoop;
				}
				if (part1.contains("-")) {
					int b = dFrac.indexOf("-");
					if (b != 0) {
						System.out.println("You entered a negative sign in the wrong place. Try again!");
						System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
						continue outerLoop;
					}
					String dFrac4 = part1.substring(1, part1.length() - 1);
					key = isNumber(dFrac4);
					if (key == false) {
						continue outerLoop;
					}
					String dFrac5 = part2.substring(0, part2.length() - 1);
					key = isNumber(dFrac5);
					if (key == false) {
						continue outerLoop;
					}
					break outerLoop;
				}
				key = isNumber(part1);
				if (key == false) {
					continue outerLoop;
				}
				key = isNumber(part2);
				if (key == false) {
					continue outerLoop;
				}
				break outerLoop;
				
			}
		}
		
		return dFrac;
	}
	
	public static boolean isNumber(String nook) {
		for (int j = 0; j < nook.length(); j++) {
				if (nook.charAt(j) != '1' && nook.charAt(j) != '2' && nook.charAt(j) != '0' && nook.charAt(j) != '3' && nook.charAt(j) != '4' && nook.charAt(j) != '5' && nook.charAt(j) != '6' && nook.charAt(j) != '7' && nook.charAt(j) != '8' && nook.charAt(j) != '9') {
					System.out.println("Bad input. Are you entering all valid integers?");
					System.out.println("Invalid fraction. Please enter a fraction \"(a/b)\" or integer \"(a)\": ");
					return false;
					
				}
		}
		return true;
	}
	
	public static void printResult(Fraction m1, Fraction m2, String sign) {
		boolean right = false;
		if (sign.equals("+")) {
			Fraction newFrac1 = m1.add(m2);
			System.out.println(m1.toString() + " + " + m2.toString() + " = " + newFrac1.toString());
		}
		else if (sign.equals("-")) {
			Fraction newFrac2 = m1.subtract(m2);
			System.out.println(m1.toString() + " - " + m2.toString() + " = " + newFrac2.toString());
		}
		else if (sign.equals("*")) {
			Fraction newFrac3 = m1.multiply(m2);
			System.out.println(m1.toString() + " * " + m2.toString() + " = " + newFrac3.toString());
		}
		else if (sign.equals("/")) {
			Fraction newFrac4 = m1.divide(m2);
			System.out.println(m1.toString() + " / " + m2.toString() + " = " + newFrac4.toString());
		}
		else if (sign.equals("=")) {
			right = m1.equals(m2);
			if (right == true) {
				System.out.println(m1.toString() + " is equal to " + m2.toString());
			}
			else {
				System.out.println(m1.toString() + " is not equal to " + m2.toString());
			}
		}
	}
}
