//-----------------------------------------------------
// Title: Programming Assignment 3 - Question 2 Q2.java
// Author: Burak Güçlü
// Description: This class is the main class of our 
// program that works to print necessary outputs and
// does the operations related to txt file's inputs.
//-----------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {

		Scanner fileScanner = new Scanner(System.in);
		// In order to get the file name as an input, we use Scanner object.

		String filename = fileScanner.next();
		// To reach the file in the VPL, we take the name of txt file from the input.

		BinaryCaptainTree bct = new BinaryCaptainTree();
		// We use binary search tree to store our product objects.
		// We choose "BinaryCaptainTree" as the name of tree.
		// Program use this object to call methods from its class.

		System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------");

		File f = new File(filename);
		Scanner s;
		try {
			// Try-catch block is necessary not to have any error while working with File.

			s = new Scanner(f);
			while (s.hasNext()) {
				// While there is any data in the txt file, this while loop will be taking it as
				// input. It will stop when everything in the file is read.

				String input = s.next();
				// In this part, first word in the txt file is read and it will be compared to
				// methods in our system to decide which method is called.

				switch (input) {
				// We used switch-case statement to call the methods.

				case "Add_Captain":
					// The program checks if the input is "Add_Captain".
					// It is used for to add a caption to captain tree.

					int id1 = s.nextInt();
					// In the txt file, next input is the ID of the captain. So, it keeps it as
					// integer variable to call the method with it.

					String name = s.next();
					// In the txt file, next input is the name of the captain. So, it keeps it as
					// String variable to call the method with it.

					bct.add_a_captain(name, id1);
					// In this part, we call the method in the BinaryCaptainTree class to add the
					// captain into the tree with the specific information that is taken as input.

					// ------ This part is printing the necessary information ------ //
					System.out.println("Add Captain: Add a new captain record in the System");
					bct.displayCaptain(id1);
					// displayCaptain method is used to print information of the captain.
					System.out.println("----------------------------------------------------------------");
					// ------ This part is printing the necessary information ------ //

					break;// Leave the case.

				case "Is_Available":
					// The program checks if the input is "Is_Avaiable".
					// It is used for checking the if the captain is available.

					int id2 = s.nextInt();
					// In the txt file, next input is the ID of the captain. So, it keeps it as
					// integer variable to call the method with it.

					bct.rent_a_car(id2);
					// In this part, we call the method in the BinaryCaptainTree class to check if
					// the captain is available with the specific information that is taken as
					// input.

					System.out.println();
					System.out.println("----------------------------------------------------------------");

					break; // Leave the case.

				case "Display_captain":
					// The program checks if the input is "Display_captain".
					// It is used for printing the information of the captain.

					System.out.print("Display Captain: ");

					int id3 = s.nextInt();
					// In the txt file, next input is the ID of the captain. So, it keeps it as
					// integer variable to call the method with it.

					bct.displayCaptain(id3);
					// In this part, we call the method in the BinaryCaptainTree class to write
					// the information of the captain with the specific information that is taken as
					// input.

					System.out.println();
					System.out.println("----------------------------------------------------------------");

					break; // Leave the case.

				case "Finish":
					// The program checks if the input is "Finish".
					// It is used for finishing the ride with the captain.

					System.out.print("Finish: ");

					int id4 = s.nextInt();
					// In the txt file, next input is the ID of the captain. So, it keeps it as
					// integer variable to call the method with it.

					int satisfaction = s.nextInt();
					// In the txt file, next input is the rider satisfaction. So, it keeps it as
					// integer variable to call the method with it.

					bct.finish_the_ride(id4, satisfaction);
					// In this part, we call the method in the BinaryCaptainTree class to finish
					// the ride with the captain with the specific information that is taken as
					// input and it changes the stars of the captain by looking rider satisfaction.

					System.out.println("----------------------------------------------------------------");

					break; // Leave the case.

				case "Delete_captain":
					// The program checks if the input is "Delete_captain".
					// It is used for deleting the captain from the tree.

					int id5 = s.nextInt();
					// In the txt file, next input is the ID of the captain. So, it keeps it as
					// integer variable to call the method with it.

					bct.delete_the_captain(id5);
					// In this part, we call the method in the BinaryCaptainTree class to delete the
					// captain from the tree with the specific information that is taken as input.

					System.out.println("----------------------------------------------------------------");

					break; // Leave the case.

				case "Display_all_captains":
					// The program checks if the input is "Display_all_captains".
					// It is used for printing the information of all the captains.

					System.out.println("----------ALL CAPTAINS----------");

					bct.display_all_Captains();
					// In this part, we call the method in the BinaryCaptainTree class to write the
					// all informations of the captains in the tree.

					break; // Leave the case.

				case "Quit":
					// The program checks if the input is "Quit".
					// It is used for quitting the program.

					bct.quit();
					// In this part, we call the method in the BinaryCaptainTree class to stop the
					// program.

					break; // Leave the case.
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
