//U10416043   廖崑智

import java.util.Scanner;

//Class
public class TestBigDigitAddition{

	//Main method
	public static void main(String[] args){

		//Make a scanner
		Scanner input = new Scanner(System.in);
		
		//Let the user enter two big numbers
		System.out.println("Please enter two numbers to adding : ");
		System.out.println("First number : ");
		String first = input.next();
		System.out.println("Second number : ");
		String second = input.next();

		//Make it have a bright to next class
		BigDigitAddition addition = new BigDigitAddition(first, second);

		//Show the remind
		System.out.println(addition.getPrint());
	}
}
