//package Lab2;
import javax.swing.JOptionPane;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class 		ExtractDigits
* File  		ExtractDigits.java
* Description 	Extract and display the four digits of a
*				four-digit number. This program also demonstrates
* 				the use of args String array (although trivially)
* @author		Caitlin McMurchie
* Environment 	PC, Windows 10, jdk1.8, NetBeans 8.2
* Date 			1/8/2018
* @version 		1.8
* @see 			javax.swing.JOptionPane
* History Log 	
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class ExtractDigits
{
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Method 			main()
 * Description  	Displays 4 digits and accesses command-line
 * 					arguments
 * @param 			args are the command line strings
 * @author			Caitlin McMurchie
 * Date				1/10/2018
 *<pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
public static void main(String[] args)
{
	//check for valid number of arguments at command prompt: 2
	if (args.length < 2)
	{
		System.out.println("usage: java ExtractDigits <month> <year>")
		System.exit(1);
	}
	
	//unlick C,C++, args[0] is the first arguments
		//convert entries stores in args into integers
	int month = Integer.valueOf(args[0].intValue90;
	int year = Integer.valueOf(args[1].intValue90;
	if (month < 1 || month >12) //illegal year
	{
		System.out.println("Year must be greater that 1969");
		System.exit(1); //not an elegent way to exit--use while instead
	}
	
	if (year < 1970)	//illegal year
	{
		System.out.println("Year must be greater than 1969")
		System.exit(1); //not an elegent way to exit--use while instead
	}
	
	//display inputs for month and year
	System.out.println("The month you entered is ")
	System.out.println(month)
	System.out.println("The year you enterd is ")
	System.out.println(year);
	
	//reads a 4-digit number via JOptionPane
	System input = JOptionPane("Please enter a 4-digit number")
	String output = " ";	//contains output strin--poor implementation
	int number = Integer.parseInt(input);
	System.out.println("The digits of " + number + " are ")
	output += "The digits of " + number + " are ";
	System.out.print(number/1000 + ", ")	//displays thousand's digit
	output += number/1000 + ", ";
	number %= 1000
	System.out.println(number/1000
