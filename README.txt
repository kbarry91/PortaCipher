Author : Kevin Barry (G00339811)
Program : Rapid Encryption using the Porta Cipher
Course  : Software Development ,Year 2, Data Structure and Algorithms,Main Assignment

---Summary of program---
In order to have the program with low space and time complexity I made this project as stripped back and simple as possible.
The program consists of only four main classes :
							Runner.java (A simple runner to start the program)
							Menu.java (A simple CLI to navigate to the chosen methods)
							TextParser.java ( Deals with parse the file /URL or sentence)
							PortaCipher.java (This is the actual encryption using the Porta Cipher)
								
---How the Program Works---
When the program is ran you will be prompted with two options:
	1. Begin Encryption
	2. Close
Once you have chosen to begin the program you will be prompted to 'Enter Encryption key'. I did this so that the same key can be used 
to encrypt a file/URL and a sentence.You will then be prompted with 4 options:
	1.Encrypt a File		(Selecting this will prompt the user to 'Enter name of file to parse(.txt) ')
	2.Encrypt a URL			(Selecting this will prompt the user to 'Enter name of url to parse(www. --.com )')
	3.Encrypt a sentence	(Selecting this will prompt the user to 'Enter sentence to Encrypt :')
	4.Return to main menu	(Selecting this will return to main menu)
These 3 options all work in the same way (to the user)and once the user selects an option  and enters the source the encryption process starts immediately.
The start timer is now set.
When the encryption is complete the timer is stopped .You will see the runtime in milliseconds eg.'Encryption Took : 333 ms'.
At this stage the encrypted message has been outputted to either 'EncryptedFile.txt' or 'EncryptedSentence.txt' a message will appear stating the file name
The Encryption Process is now complete and you will return to the Encryption menu .

---To Decrypt---
! To decrypt the file you MUST use the same key !
Simply reboot the program and copy your outputted encrypted file text into a new file and run the programing selecting the file using the same encryption key

---Running from commandline---
	1. Naviagate to project directory
	2. Run Command java –cp ./porta.jar ie.gmit.sw.Runner

---Results of test using  WarAndPeace-LeoTolstoy.txt using AMD A8 processor---
file Size	(Sentences) 	Time taken milliseconds
Original	64927			333
x2			129854			642
x4			259707			1305
x8			519414			2429

---Conclusion of test findings---
I personally believe that the program is running fast and capable of encrypting files very quickly.
I have concluded that the runtime is linear and uses the O(n) notation because the time taken is directly proportional(on average sometimes even faster)to the size of the file 
											
										