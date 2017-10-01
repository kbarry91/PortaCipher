// Author : Kevin Barry (G00339811)
//Program : Rapid Encryption using the Porta Cipher
//Course  : Software Development ,Year 2, Data Structure and Algorithms,Main Assignment
package ie.gmit.sw;

//add imports
import java.net.URL;
import java.util.Scanner;
import java.io.*;

public class TextParser {
	//declared static to be used for multiple methods 
	static Scanner scanner =new Scanner(System.in);// Initialize scanner object
	static BufferedReader br = null;// create Buffered reader and initialize to								// null
	static int option;
	static String cipherKey;
	static long startTime;
	static long endTime;

	// RUNTIME is O(1)xO(n) 
	// although it is O(1) it contains methods that run in linear timeO(n)
	// each sub method has close to or the same running time so real running
	// time would be O(1)xO(n) so the methods have still have a small effect on
	// the running time
	//The most major runtime difference will be seen on line 85 as the length the while loop runs for is determined by the size of the file
	public static void parseMenu() {
		option = 0;
		System.out.println("Enter encryption key   : ");
		cipherKey = scanner.next();
		cipherKey = cipherKey.toUpperCase();

		String inputName = null;// String for input name for file or URL

		while (option != 4) {
			System.out.println("========================================="
					+ "\n||                                     ||" + "\n||          Encryption Menu            ||"
					+ "\n||                                     ||" + "\n=========================================");
			System.out.println("1.Encrypt a File\n2.Encrypt a URL\n3.Encrypt a sentence\n4.Return to main menu");
			option = scanner.nextInt();// input users option

			switch (option) {

			case 1:
				System.out.println("Enter name of file to parse(.txt) ");
				inputName = scanner.next();// input filename

				// starts counter as this is the start of the buffer/encryption
				// process
				startTime = System.currentTimeMillis();
				parseFile(inputName);
				break;

			case 2:
				System.out.println("Enter name of url to parse(www. --.com )");
				inputName = scanner.next();

				// starts counter as this is the start of the buffer/encryption
				// process
				startTime = System.currentTimeMillis();
				parseUrl(inputName);
				break;

			case 3:
				System.out.println("Enter sentence to Encrypt :");
				String sentance = scanner.nextLine();
				sentance = scanner.nextLine();

				// starts counter as this is the start of the buffer/encryption
				// process
				startTime = System.currentTimeMillis();
				encryptSent(sentance, cipherKey);
			}// switch

			if (option == 1 || option == 2) {
				if (option == 1) {
					br = parseFile(inputName);
				} else if (option == 2) {
					br = parseUrl(inputName);
				}
				;// else if

				try {
					int next;
					BufferedWriter bw = new BufferedWriter(new FileWriter("EncryptedFile.txt"));
					while ((next = br.read()) != -1) {
						char letter = PortaCipher.encrypt(Character.toUpperCase((char) next), cipherKey);

						bw.write(letter);
					} // while

					br.close();// close bufferreader
					bw.close();// close bufferwriter

					// calculate running time
					endTime = System.currentTimeMillis();
					long timeTaken = endTime - startTime;

					// output footer
					System.out.println("Encryption Took : " + timeTaken + " ms");
					System.out.println(
							"Your Encrypted message has been out outputted to 'EncryptedFile.txt' \nMake sure to take note of your encryption key for decryption");
				} catch (NullPointerException | IOException e) {
					System.out.println("An IOException has occured try again");
				} // catch

			} // my big option =1 or 2 if
		} // while (option != 4)
	}// parseMenu

	// runtime for this method is constant O(1) as it only opens the input
	// stream
	// it is not linear as it does not do any computation/manipulation of the
	// file as I left that to another method
	public static BufferedReader parseFile(String inputName) {
		try {
			br = new BufferedReader(new FileReader(inputName));// Initialize br
																// for file
		} catch (FileNotFoundException e) {
			System.out.println("Error File Not found !\n PLEASE NOTE all files must have .txt prefix !");
			option = 0;
		} // catch
		return br;
	}// ParseFile

	// As with the parseFile()method runtime for this method is constant O(1) as
	// it only opens the input stream
	// it is not linear as it does not do any computation/manipulation of the
	// file as I left that to another method
	public static BufferedReader parseUrl(String inputName) {
		try {
			URL url = new URL(inputName);
			br = new BufferedReader(new InputStreamReader(url.openStream()));// Initialize
																				// br
																				// fpr
																				// URL
		} catch (IOException e) {
			System.out.println("Error URL Not found");
			option = 0;
		} // catch
		return br;
	}// ParseFile

	// Runtime for this method is linear O(n)
	// This is because the while although controlled by a constant, will change
	// depend on the length of the sentence entered
	// the length of the sentence is taken in before the while loop so that as
	// the sentence increases in length it still only has to use the length()
	// method once
	public static void encryptSent(String sentance, String cipherKey) {
		int pos = 0;
		BufferedWriter myBufferWriter;
		try {
			myBufferWriter = new BufferedWriter(new FileWriter("EncryptedSentance.txt"));
			int sentLength = sentance.length();
			while (pos < sentLength) {// while end of sentence not reached

				char letter = PortaCipher.encrypt(Character.toUpperCase(sentance.charAt(pos)), cipherKey);// pass
																											// letter
																											// to
																											// be
																											// encrypted
																											// tp
																											// encrypt()
				myBufferWriter.write(letter);// write encrypted letter to file
				pos++;
			} // while
			myBufferWriter.close();

			// calculate running time
			endTime = System.currentTimeMillis();
			long timeTaken = endTime - startTime;

			// output footer
			System.out.println("Encryption Took : " + timeTaken + " ms");
			System.out.println(
					"Your Encrypted sentence has been out outputted to 'EncryptedSentance.txt' \nMake sure to take note of your encryption key for decryption");
		} catch (IOException e) {
			e.printStackTrace();
		} // catch

	}// encryptSent

}// TextParser
