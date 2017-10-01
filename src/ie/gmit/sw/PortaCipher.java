// Author : Kevin Barry (G00339811)
//Program : Rapid Encryption using the Porta Cipher
//Course  : Software Development ,Year 2, Data Structure and Algorithms,Main Assignment
package ie.gmit.sw;

public class PortaCipher {
	
	static int keyLetter = 0;
	public static final String[][] tableau = {
			{ "KEYS", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
					"T", "U", "V", "W", "X", "Y", "Z" },
			{ "AB", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F", "G",
					"H", "I", "J", "K", "L", "M" },
			{ "CD", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "N", "M", "A", "B", "C", "D", "E", "F",
					"G", "H", "I", "J", "K", "L" },
			{ "EF", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "N", "O", "L", "M", "A", "B", "C", "D", "E",
					"F", "G", "H", "I", "J", "K" },
			{ "GH", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "N", "O", "P", "K", "L", "M", "A", "B", "C", "D",
					"E", "F", "G", "H", "I", "J" },
			{ "IJ", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "N", "O", "P", "Q", "J", "K", "L", "M", "A", "B", "C",
					"D", "E", "F", "G", "H", "I" },
			{ "KL", "S", "T", "U", "V", "W", "X", "Y", "Z", "N", "O", "P", "Q", "R", "I", "J", "K", "L", "M", "A", "B",
					"C", "D", "E", "F", "G", "H" },
			{ "MN", "T", "U", "V", "W", "X", "Y", "Z", "N", "O", "P", "Q", "R", "S", "H", "I", "J", "K", "L", "M", "A",
					"B", "C", "D", "E", "F", "G" },
			{ "OP", "U", "V", "W", "X", "Y", "Z", "N", "O", "P", "Q", "R", "S", "T", "G", "H", "I", "J", "K", "L", "M",
					"A", "B", "C", "D", "E", "F" },
			{ "QR", "V", "W", "X", "Y", "Z", "N", "O", "P", "Q", "R", "S", "T", "U", "F", "G", "H", "I", "J", "K", "L",
					"M", "A", "B", "C", "D", "E" },
			{ "ST", "W", "X", "Y", "Z", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "E", "F", "G", "H", "I", "J", "K",
					"L", "M", "A", "B", "C", "D" },
			{ "UV", "X", "Y", "Z", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "D", "E", "F", "G", "H", "I", "J",
					"K", "L", "M", "A", "B", "C" },
			{ "WX", "Y", "Z", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "C", "D", "E", "F", "G", "H", "I",
					"J", "K", "L", "M", "A", "B" },
			{ "YZ", "Z", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "B", "C", "D", "E", "F", "G", "H",
					"I", "J", "K", "L", "M", "A" } };// public static final

	//this method is running in constant time O(1) as it only encrypts one letter at a time
	//runtime will be slightly effected by the letters location in the row but not enough to make any noticeable difference to the runtime
	public static char encrypt(char letter, String cipherKey) {
		char newletter = letter;
		String key = cipherKey;

		int row = 0;
		int col = 0;

		if ((int) newletter > 64 && (int) newletter < 91) {

			for (int i = 1; i < 14; i++) {
				if (tableau[i][0].indexOf(key.charAt(keyLetter)) >= 0) {
					row = i;
					break;
				} // if
			} // for row
		
			//old code tp generate column,Removed as was too slow
			//Editing this drastically decrease the runtime from quadraticO(n^2) to 0(n) 
			////////////////////////////////////////////////////////////
			/*
			 * 
			 * for (int i = 1; i < 27; i++) {
			 * 
			 * if (tableau[0][i].indexOf(newletter) >= 0) {
			 * 
			 * 
			 * //col = i; break; } // if } // for col
			 */
			/////////////////////////////////////////////////////////////
			
			col = (((int) newletter) - 65) + 1;////// REPLACED code to generate column

			//increment keyLetters location in encryption key
			keyLetter++;
			if (keyLetter == key.length()) {
				keyLetter = 0;
			}
			newletter = tableau[row][col].charAt(0);
		};// if(newletter > 64 && newletter<91)
		return newletter;
	}// encrypt

}// PortCypher
