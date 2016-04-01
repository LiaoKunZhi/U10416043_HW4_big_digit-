//U10416043   廖崑智

import java.util.Scanner;
import java.lang.*;
import java.util.*;

//Class
public class BigDigitAddition{

	//Data field
	String Myprint = "";
	int digitA;
	int digitB;
	int digitA_pass;
	int digitB_pass;
	int digitA_later;
	int digitB_later;
	int digit_later;
	int can = 0;
	int before_digitA;
	int before_digitB;

	int listA_digit;
	int listB_digit;

	//Make new ArrayLists
	ArrayList<String> listA = new ArrayList<String>();
	ArrayList<String> listB = new ArrayList<String>();
	ArrayList<String> addition = new ArrayList<String>();
	
	//Create a new constructor
	BigDigitAddition (String newDigitA, String newDigitB) {
		setList(newDigitA, newDigitB);
		digitA = listA.indexOf(".");
		digitB = listB.indexOf(".");		
		checkDigit();
		makeAddition();
	}
	
	//Make a new method to set ArrayLists
	public void setList (String digitA, String digitB) {
		//Create two new for to set ArrayLists
		for (int dA = digitA.length() - 1; dA >= 0; dA--){
			listA.add(String.valueOf(digitA.charAt(dA)));
		}
		for (int dB = digitB.length() - 1; dB >= 0; dB--){
			listB.add(String.valueOf(digitB.charAt(dB)));
		}
	}	
	
	//Make a new method to check
	public void checkDigit() {		
		before_digitA = listA.size() - digitA - 1;
		before_digitB = listB.size() - digitB - 1;

		//Check the digitA_pass
		if (digitA_pass == listA.size()) {
			digitA_later = 0;
		}		
		else {
			digitA_later = digitA;
		}

		//Check the digitB_pass
		if (digitB_pass == listB.size()) {
			digitB_later = 0;
		}
		else {
			digitB_later = digitB;
		}	
	}
	
	//Make a new method to add two numbers
	public void makeAddition() {

		int A;
		int a;
		int B;
		int b;

		//Check if the later digit of first is more than the second
		if (digitA_later > digitB_later) {
			for (A = 0; A < (digitA_later - digitB_later); A++) {
				addition.add(listA.get(A));
			}
			for (a = 0; a < digitB_later; a++) {				
				listA_digit = Integer.valueOf(listA.get(A+a));
				listB_digit = Integer.valueOf(listB.get(a));
				addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

				if ((listA_digit + listB_digit + can) / 10 == 1) {
					can = 1;
				}
				else {
					can = 0;
				}
			}
			addition.add(".");
			
			//Check if the pass digit of first is more than the second
			if (digitA_pass > digitB_pass) {
				B = A;
				for (b = a + 1; b < listB.size(); b++) {					
					listA_digit = Integer.valueOf(listA.get(B + b));
					listB_digit = Integer.valueOf(listB.get(b));
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}

				for (B += b; B < listA.size(); B++) {
					listA_digit = Integer.valueOf(listA.get(B));
					addition.add (String.valueOf((listA_digit + can) % 10));

					if ((listA_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if(can == 1) {
					addition.add (String.valueOf(1));
				}
				
			}
			
			//Check if the pass digit of second is more than the first
			else if (digitB_pass > digitA_pass) {

				if (digitB_later == 0) {
					B = A + 1;
					b = a;
				}					
				else {
					B = A;
					b = a + 1;
				}

				for (b = b; (B + b) < listA.size(); b++) {					
					listA_digit = Integer.valueOf(listA.get(B + b));
					listB_digit = Integer.valueOf(listB.get(b));
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}				
				
				for (b = b; b < listB.size(); b++) {					
					listB_digit = Integer.valueOf(listB.get(b));
					addition.add (String.valueOf((listB_digit + can) % 10));

					if ((listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
			}	
			
			//Check if the pass digit of two numbers are the same
			else {				
				if (digitB_later == 0) {
					B = A + 1;
					b = a;
				}					
				else {
					B = A;
					b = a + 1;
				}
				
				for (b = b; b < listB.size(); b++) {					
					listA_digit = Integer.valueOf(listA.get(B + b));					
					listB_digit = Integer.valueOf(listB.get(b));					
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
			}
		}
		
		//Check if the later digit of second is more than the first
		else if (digitB_later > digitA_later) {
			for (A = 0; A < (digitB_later - digitA_later); A++) {
				addition.add (listB.get(A));
			}
			
			for (a = 0; a < digitA_later; a++) {				
				listA_digit = Integer.valueOf(listA.get(a));
				listB_digit = Integer.valueOf(listB.get(A + a));
				addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

				if ((listA_digit + listB_digit + can) / 10 == 1) {
					can = 1;
				}
				else {
					can = 0;
				}
			}
			addition.add(".");			
			
			//Check if the pass digit of first is more than the second
			if (digitA_pass > digitB_pass) {
				if (digitA_later == 0) {
					B = A+1;
					b = a;
				}
				else {
					B = A;
					b = a+1;
				}

				for (b = b; (B+b) < listB.size(); b++) {					
					listA_digit = Integer.valueOf(listA.get(b));					
					listB_digit = Integer.valueOf(listB.get(B+b));					
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}

				for (B = b; B < listA.size(); B++) {
					listA_digit = Integer.valueOf(listA.get(B));
					addition.add (String.valueOf((listA_digit + can) % 10));

					if ((listA_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
				
			}
			
			//Check if the pass digit of second is more than the first
			else if (digitB_pass > digitA_pass) {
				B = a;
				for (b = A+1; b < listA.size(); b++) {					
					listA_digit = Integer.valueOf(listA.get(b));					
					listB_digit = Integer.valueOf(listB.get(B + b));					
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}

				for (b += B; b < listB.size(); b++) {					
					listB_digit = Integer.valueOf(listB.get(b));
					addition.add (String.valueOf((listB_digit + can) % 10));

					if ((listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
			}	
			
			//Check if the pass digit of two numbers are the same
			else {
				if (digitA_later == 0) {
					B = A+1;
					b = a;
				}
				else {
					B = A;
					b = a+1;
				}
												
				for (b = b; b < listA.size(); b++) {					
					listA_digit = Integer.valueOf(listA.get(b));					
					listB_digit = Integer.valueOf(listB.get(B + b));					
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
			}
		}
		
		//Check if the later digit of two numbers are the same
		else {			
			for (A = 0; A <= digitA_later; A++) {
				listA_digit = Integer.valueOf(listA.get(A));
				listB_digit = Integer.valueOf(listB.get(A));
				addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

				if ((listA_digit + listB_digit + can) / 10 == 1) {
					can = 1;
				}
				else {
					can = 0;
				}
			}
			if (digitA != -1) {
				addition.add(".");
			}
			else {
				A--;
			}
			
			//Check if the pass digit of first is more than the second
			if (digitA_pass > digitB_pass) {
				for (B = A+1; B < listB.size(); B++) {
					listA_digit = Integer.valueOf(listA.get(B));
					listB_digit = Integer.valueOf(listB.get(B));
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}

				for (B = B; B < listA.size(); B++) {
					listA_digit = Integer.valueOf(listA.get(B));
					addition.add (String.valueOf((listA_digit + can) % 10));

					if ((listA_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
			}
			
			//Check if the pass digit of second is more than the first
			else if (digitB_pass > digitA_pass) {
				for (B = A+1; B < listA.size(); B++) {
					listA_digit = Integer.valueOf(listA.get(B));
					listB_digit = Integer.valueOf(listB.get(B));
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}

				for (B = B; B < listB.size(); B++) {
					listB_digit = Integer.valueOf(listB.get(B));
					addition.add (String.valueOf((listB_digit + can) % 10));

					if ((listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
			}
			
			//Check if the pass digit of two numbers are the same
			else {
				for (B = A+1; B < listA.size(); B++) {
					listA_digit = Integer.valueOf(listA.get(B));
					listB_digit = Integer.valueOf(listB.get(B));
					addition.add (String.valueOf((listA_digit + listB_digit + can) % 10));

					if ((listA_digit + listB_digit + can) / 10 == 1) {
						can = 1;
					}
					else {
						can = 0;
					}
				}
				if (can == 1) {
					addition.add (String.valueOf(1));
				}
			}
		}	
		}		
	}	

	//Make a new method to return the end
	public String getPrint() {
		//Make a new for
		for (int E = addition.size() - 1; E >= 0; E--) {
			Myprint += addition.get(E);
		}
		return Myprint;
	}
}
