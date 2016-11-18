package com.vinod.studentController;
/*
 * Program for mapping a given string of length 9 onto a numeric representation (Similar to a telephone with specific format)
 * 
 * Example: Sample Input String = 123GOOGLE ; Sample Output String = (123)466-453  
 * 
 */
public class MysteryQuestion {

	/*
	 * @returns 	a formatted numerically represented string
	 * @param s 	Supplied Input String  
	 * 
	 */
	public static String function(String s) {
		
		/*
		 * Performing Sanity Checks
		 * Checking whether the given string is null or the length of the string is not equal to 9
		 */
		 if (s == null || s.length() != 9) {
			 throw new RuntimeException();
		 }
		 
		 StringBuffer sb = new StringBuffer();

		 /*
		  * Iterating through the given input string and appending the appropriate formatting elements for the string to be returned
		  * Input String = XXXXXXXXX (Here, X can be any alphanumeric element) 
		  * 			 i=012345678
		  * After appending elements, the value of string buffer will be (XXX)XXX-XXXX
		  */
		 for (int i = 0; i < 9; i++) {
				 if (i == 0) {
					 sb.append('(');
				 } else if (i == 3) {
					 sb.append(')');
				 } else if (i == 6) {
					 sb.append('-');
				 }
				 
			 char c = s.charAt(i);
	
			 /*
			  * 
			  * Retains the characters in the string as it is, if they are numerals and are appended to the string buffer
			  *   
			  */
			 if (Character.isDigit(c)) {
				 sb.append(c);
			 }
			 /*
			  *Converts any alphabet into corresponding digit like that of a telephone keypad and are appended to the string buffer 
			  */
			 else if (Character.isLetter(c)) {
				 char c1 = (char) (Character.toLowerCase(c) - 'a');
				 char c2 = (char) (((int) '2') + (c1 / 3));
				 sb.append(c2);
			 }
			 /*
			  * Special characters are not accepted
			  */
			 else {
				 throw new RuntimeException();
			 }
		 }
		 /*
		  * Resultant string buffer converted to string 
		  */
		 return sb.toString();
	 }
}