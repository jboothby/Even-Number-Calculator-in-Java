/* This class continues to accept user inputted two-integer math problems
 * until the user types exit. It implements a scanner to obtain input from System.in
 * and makes use of a regex to parse the user input and ensure the correct format
 * It will accept a math problem with any of the following operands: +, -, /, *
 * and two integers, either positive or negative. The regex ignores whitespace in the equation
 * and will not throw an error for invalid input, it just queries the user again.
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EvenDriver{

	public static void main( String args[] ){

		//Initialize variables
		Scanner stdin = new Scanner( System.in );	//scanner for reading input from System.in
		int firstNum = 0, secondNum = 0;		//first and second numbers from user
		char operand;					//holds the operand from the user. one of {/,*,+,-}
		String userInput = null;			//string from stdin.nextLine();
		boolean valid = false;				//true if input format is valid

		//Regex to match a proper math problem input type.
		//Ignores whitespace and checks for pos or neg integers with an operand between
		//Splits input into three groups, an integer, an operand, and a second integer
		Pattern wholeLine = Pattern.compile("([\\-]*\\d{1,})\\s*([\\+\\-\\*/])\\s*([\\-]*\\d{1,})");
		Matcher m = wholeLine.matcher(" ");		//create matcher. hold input after regex sorting
		
		//Main loop will continue until user types "exit"
		mainloop: while( true ){
			
			//Continue to prompt user for input until it matches the regex format
			while( !valid ){

				System.out.print("Please enter a two integer math problem(type exit to exit): ");

				userInput = stdin.nextLine();			//store input from user in string
				if (userInput.matches("exit")) System.exit(0);	//end program is input is "exit"
				
				m.reset();				//reset matcher to have no reference
				m = wholeLine.matcher( userInput );	//matcher m now contains sorted userInput
				
				//if the entire input matches the format for a math problem, then exit loop. If not, prompt again
				if( m.matches() ){
					System.out.println("The input type is valid");
					valid = true;
				}
				else{
					System.out.println("The input type is NOT valid!!");
				}
			}//end while

			//Pull output from the matcher. Typecast to integer then create instances of Even
			firstNum = Integer.parseInt(m.group(1));	//group(1) contains the first capture from the regex. a neg or pos integer
			Even e1 = new Even(firstNum);			//create an instance of Even with the first integer from the user

			secondNum = Integer.parseInt(m.group(3));	//group(3) contains the third capture from the regex, the second integer
			Even e2 = new Even(secondNum);			//create an instance of Even with the second integer from the user
			
			operand = m.group(2).charAt(0);			//group(2) contains the second capture form the user, a single character operand
				
			//Print the value of Each object 
			System.out.println();
			System.out.println( "When converted to an Even " + firstNum + " becomes " + e1);
			System.out.println( "When converted to an Even " + secondNum + " becomes " +e2);

			//Switch on the operand. call the appropriate module from Even class
			//For example, if the operand is a +  then print the results from Even.add
			switch( operand ){
				case '+':
						System.out.println( e1 + " + " + e2 + " = " + e1.add(e2));
						break;
				case '-':	
						System.out.println( e1 + " - " + e2 + " = " + e1.sub(e2));
						break;
				case '*':	
						System.out.println( e1 + " * " + e2 + " = " + e1.mul(e2));
						break;
				case '/':	
						System.out.println( e1 + " / " + e2 + " = " + e1.div(e2));
						break;
				default:
						System.out.println( "The operand is invalid" );
			}//end switch
			System.out.println();	//end with blank line
			valid = false;		//revert the valid boolean for next loop
		}//end mainloop
	}//end main()
}//end class
