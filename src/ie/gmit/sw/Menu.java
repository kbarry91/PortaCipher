// Author : Kevin Barry (G00339811)
//Program : Rapid Encryption using the Porta Cipher
//Course  : Software Development ,Year 2, Data Structure and Algorithms,Main Assignment
package ie.gmit.sw;

import java.util.*;

public class Menu {

	static Scanner scanner = new Scanner(System.in);//Initialize Scanner object named scanner

	//Running time is constant O(1) as this method is straightforward with no loops and uses a switch statement to determine the outcome
	public static void start() {
		int startOption = 0;// declare and Initialize startOption

		try {
			while (startOption != 2) {//keeps program running as long as not exited
				//menu header
				System.out.println("========================================="
						+ "\n||                                     ||" + "\n||   Porta Cipher Encryption Program   ||"
						+ "\n||              main menu              ||" + "\n||                                     ||"
						+ "\n=========================================");
				System.out.println("1.Begin Encryption \n2.Close");
				
				startOption = scanner.nextInt();//take in startOption
				switch (startOption) {
				case 1:
					TextParser.parseMenu();
				case 2:
					break;
				default:
					System.out.println("Invalid input in menu");
				}// switch

			} // while
		} catch (InputMismatchException e) {
			System.out.println("A MissMatchException occured\n\tPlease restart Program");
			startOption = 0;
		}//catch
	}// start
}// menu
