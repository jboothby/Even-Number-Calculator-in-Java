/*	Joseph Boothby, 16 April 2020
 *	Programming Assignment 1, CSE223
 *
 *	This program implements a java class called Even
 *	to work with even integers. An instance of this class
 *	creates an object of type "Even". There are modules
 *	Even.add(), Even.sub(), Even.mul(), Even.div(), Even.toInt(),
 *	Even.toString(), that allow manipulation of these objects.
 */
import java.math.BigInteger; //used to ensure that integer overflow doesn't occur in operations

/** A simple class that allows for creation and manipulation of even integers.
 *  Includes methods for adding, subtracting, multiplying, dividing these objects.
 *  Also includes a method for returning the object value as a string or an integer.
 *  Only has one constructor method with format Even( int instance )
 */
public class Even {

	public static final BigInteger MAX = new BigInteger(Integer.toString((Integer.MAX_VALUE)));//store the value of MAX_VALUE as a BigInt for comparison
	public static final BigInteger MIN = new BigInteger(Integer.toString((Integer.MIN_VALUE)));//store the value of MIN_VALUE as a BigInt for comparison
	private int value;	//Holds the integer value (main variable for class)

	//Constructor method
	/**This is the constructor method for Even objects, It will create an instance of Even
	 * with the given value, if the value is odd, it will add 1 to make it even
	 * Only accepts an integer as a parameter and will throw an IllegalArgumentException
	 * if passed a parameter that is not an integer.
	 * @param instance An integer used to make an Even. If odd, will add 1 to become even
	 */ 
	Even( int instance ){
		if( (instance % 2) == 0 ){	//if parameter is already even
			value = instance;
		}
		else{		//if parameter is odd
			value = instance + 1;
		}
	}//end of Constructor method




	//Method for adding the value of two evens 
	/**This method adds the current parameters value to the current objects value, and returns the result
	 * Does not allow the result to overflow the memory capacity of an interger
	 * Instead returns a value of Integer.MAX_VALUE or Integer.MIN_VALUE respectively
	 * @param y An instance of Even whose value is to be added to the current objects value
	 * @return x The sum of the value of y and the value of the current object
	 */
	Even add( Even y ){	

		Even x = new Even(0);							//initialize the return object
		BigInteger thisValue = new BigInteger( Integer.toString(this.value) ); 	//convert value of current object to BigInt for comparison
		BigInteger paramValue = new BigInteger( Integer.toString(y.toInt()) );  	//conver value of param to BigInt for Comparison
		BigInteger sum = thisValue.subtract(paramValue);			//take the sum and store as a BigInt

		if( sum.compareTo( MAX ) >= 0 ){		//if the sum overflows the max memory for an integer
				System.out.println("\nThe result of that subraction is too large to store as an integer");
				System.out.println("Returning a value of " + MAX + " which is the biggest an integer can be\n");
				x.value = Integer.MAX_VALUE;	//set the value of the return object to be the largest an integer can be
				return( x );
		}
		else if( sum.compareTo( MIN ) <= 0){		//if the sum is smaller than the minimum for an interger
				System.out.println("\nThe result of that subraction is too small to store as an integer");
				System.out.println("Returning a value of " + MIN + " which is the smallest an integer can be\n");
				x.value = Integer.MIN_VALUE;	//set the value of return object to be the smallest an integer can be
				return( x );
		}
		else{		//if the sum is within range, return the sum 
			x.value = this.value + y.toInt();
			return(x);
		}
	}





	/**This method subtracts the given parameter from an even, and returns the result as an even
	 * Does not allow the result to overflow the memory capacity of an interger
	 * Instead returns a value of Integer.MAX_VALUE or Integer.MIN_VALUE respectively
	 * @param y Any instance of Even. The value to be subtracted from the current object
	 * @return x The result of subtracting by the value of y
	 */
	Even sub( Even y ){

		Even x = new Even(0);							//initialize the return object
		BigInteger thisValue = new BigInteger( Integer.toString(this.value) ); 	//convert value of current object to BigInt for comparison
		BigInteger paramValue = new BigInteger( Integer.toString(y.toInt()) );  	//conver value of param to BigInt for Comparison
		BigInteger diff = thisValue.subtract(paramValue);			//take the difference and store as a BigInt

		if( diff.compareTo( MAX ) >= 0 ){		//if the difference overflows the max memory for an integer
				System.out.println("\nThe result of that subraction is too large to store as an integer");
				System.out.println("Returning a value of " + MAX + " which is the biggest an integer can be\n");
				x.value = Integer.MAX_VALUE;	//set the value of the return object to be the largest an integer can be
				return( x );
		}
		else if( diff.compareTo( MIN ) <= 0){		//if the difference is smaller than the minimum for an interger
				System.out.println("\nThe result of that subraction is too small to store as an integer");
				System.out.println("Returning a value of " + MIN + " which is the smallest an integer can be\n");
				x.value = Integer.MIN_VALUE;	//set the value of return object to be the smallest an integer can be
				return( x );
		}
		else{		//if the difference is within range, return the difference
			x.value = this.value - y.toInt();
			return(x);
		}
	}//end of method sub





	/**This method multiplies the value of the current object by the value of the parameter
	 * and returns the result as an Even
	 * Does not allow the result to overflow the memory capacity of an interger
	 * Instead returns a value of Integer.MAX_VALUE or Integer.MIN_VALUE respectively
	 * @param y Any Instance of Even whose value will be added to that of the current object
	 * @return x The result of multiplying the value of the current object by the value of y
	 */
	Even mul( Even y ){

		Even x = new Even(0);							//initialize the return object
		BigInteger thisValue = new BigInteger( Integer.toString(this.value) ); 	//convert value of current object to BigInt for comparison
		BigInteger paramValue = new BigInteger( Integer.toString(y.toInt()) );  	//conver value of param to BigInt for Comparison
		BigInteger prod = thisValue.multiply(paramValue);			//multiply two values together as a BigInt

		if( prod.compareTo( MAX ) >= 0 ){		//if the product overflows the max memory for an integer
				System.out.println("\nThe product of that mutliplication is too large to store as an integer");
				System.out.println("Returning a value of " + MAX + " which is the biggest an integer can be\n");
				x.value = Integer.MAX_VALUE;	//set the value of the return object to be the largest an integer can be
				return( x );
		}
		else if( prod.compareTo( MIN ) <= 0){		//if the product is smaller than the minimum for an interger
				System.out.println("\nThe product of that multiplication is too small to store as an integer");
				System.out.println("Returning a value of " + MIN + " which is the smallest an integer can be\n");
				x.value = Integer.MIN_VALUE;	//set the value of return object to be the smallest an integer can be
				return( x );
		}
		else{		//if the product is within range, return the product
			x.value = this.value * y.toInt();
			return(x);
		}
	}//end of method mul





	/**This method divides the value of the current object by the value of the parameter 
	 * If it encounters an odd number upon division, it will add 1 to make the result even
	 * The module does not allow dividing by zero, so it will print a message and return
	 * the parameter object
	 * @param y An instance of Even.
	 * @return x The result of dividing the value of the current object by the value of y
	 */
	Even div( Even y ){

		//Cover the problem of dividing by 0
		if( y.value == 0 ){
			System.out.println("\nYou cannot divide by zero!");
			System.out.println("Returning a value of zero!\n");
			return( y );
		}
		//Create branch for result of division being even or odd
		//Round up by adding 1 if the value would be odd

		if( ( (this.value / y.value) / 2) != 0){	//if x/y is odd
			Even x = new Even( (this.value / y.value) + 1 );//add one to x/y
			return( x );
		}
		else{	//if x/y is already even
			Even x = new Even( this.value / y.value );
			return( x );
		}
	}//end div method


		
	/**This method returns the integer value of the current object
	 * @param No parameters
	 * @return this.value is the integer value of the current 
	 */
	int toInt(){

		return(this.value);	//return integer value of current instance of Even

	}//end of toInt method



	/**This method will return the plain text equivalent of the integer value of the current object
	 * Example: If the value of current object is 634, this method returns the string "six three four "
	 * Uses the string "negative" to preceed a negative number.
	 * @param No parameters
	 * @return Returns a String containing spelled out integers
	 */
	public String toString(){
		
		//Initialize variables
		//We convert the this.value to a String and then to a Character array (no built in method for int -> charArray)
		
		StringBuilder builder = new StringBuilder();			//Creates string builder build for method output
		String s = new String( Integer.toString( this.value ) );	//Convert current value to a string
		char c[] = s.toCharArray(); 					//Convert string to char array. Now contains array that indexes each digit of original value

		//Iterate through each digit in the char array
		for( int i = 0; i < c.length; i++){
			switch( c[i] ){		//switch on the value of the current index in c[]
						//in each case, we append the appropriate text version of the character to the string builder
				case '-':
					builder.append("negative ");
					break;
				case '0':
					builder.append("zero ");
					break;
				case '1':
					builder.append("one ");
					break;
				case '2':
					builder.append("two ");
					break;
				case '3':
					builder.append("three ");
					break;
				case '4':
					builder.append("four ");
					break;
				case '5':
					builder.append("five ");
					break;
				case '6':
					builder.append("six ");
					break;
				case '7':
					builder.append("seven ");
					break;
				case '8':
					builder.append("eight ");
					break;
				case '9':
					builder.append("nine ");
					break;
				default:
					System.out.println("There was an error in the switch statement");
			}//end switch statement

		}//end for loop
		
		builder.deleteCharAt( builder.length() - 1);	//Strip trailing whitespace
		
		return( builder.toString() );		//return string value of StringBuilder

	}//end toString method

/* --------- I included a second method for executing the toString() function. I'm not sure which is cleaner, so I did both -----------------*/
/* --------- The second method indexes an array of strings instead of using the 11 way switch statement. 		    -----------------*/

/*      public String toString(){

                //Initialize variables

                String[] numToText = {  "zero", "one", "two", "three",          //Contains the text values to be output
                                        "four", "five", "six", "seven",         //Each has a space before it for formatting,
                                        "eight", "nine", "negative"     };
                int i = 0;                                                              //the loop index. stored outside of loop so
                                                                                        //that it can be incremented for a negative number

                //We convert the this.value to a String and then to a Character array (no built in method for int -> charArray)
                StringBuilder builder = new StringBuilder();                    //Creates string builder for method output
                String s = new String( Integer.toString( this.value ) );        //Convert current value to a string
                char c[] = s.toCharArray();                                     //Convert string to char array. Now contains array that indexes each digit of original value

                //if statement to cover case of negative number
                if( c[0] == '-' ){
                        builder.append( numToText[10] );                //add the word negative in front of negative numbers
                        builder.append( " " );                          //add space for formatting
                        i++;
                }

                //Iterate through each digit in the char array
                while( i < c.length ){

                        int temp = Character.getNumericValue( c[i] );   //convert each digit back to an integer
                        builder.append( numToText[ temp ] );            //add the text stored at the respective location in numToText
                        builder.append( " " );                          //add space for formatting
                        i++;                                            //increment counter for next character


                }//end while loop

                builder.deleteCharAt( builder.length() - 1);            //strip trailing whitespace
                return( builder.toString() );                           //return string value of StringBuilder

        }//end toString method
*/

}//end Even class
		
