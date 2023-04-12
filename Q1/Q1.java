//-----------------------------------------------------
// Title: Programming Assignment 3 - Question 1 Q1.java
// Author: Burak Güçlü
// Description: This class is the main class of our 
// program that works to print necessary outputs and
// does the operations related to txt file's inputs.
//-----------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {

		Scanner fileScanner = new Scanner(System.in);
		// In order to get the file name as an input, we use Scanner object.

		String filename = fileScanner.next();
		// To reach the file in the VPL, we take the name of txt file from the input.

		ProductTree tree = new ProductTree();
		// We use binary search tree to store our product objects.
		// We choose "ProductTree" as the name of tree.
		// Program use this object to call methods from its class.

		System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");

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

				case "Add_product":
					// The program checks if the input is "Add_product".
					// It is used for to add a product to product tree.

					int id1 = s.nextInt();
					// In the txt file, next input is the ID of the product. So, it keeps it as
					// integer variable to call the method with it.

					String product_name = s.next();
					// In the txt file, next input is the name of the product. So, it keeps it as
					// String variable to call the method with it.

					int piece = s.nextInt();
					// In the txt file, next input is the piece of the product. So, it keeps it as
					// integer variable to call the method with it.

					// ------ This part is printing the necessary information ------ //
					System.out.println("Create Product:");
					System.out.println();
					System.out.println("\t\t\tID: " + id1);
					System.out.println("\t\t\tName: " + product_name);
					System.out.println("\t\t\tPiece: " + piece);
					// ------ This part is printing the necessary information ------ //

					tree.add_a_product(product_name, id1, piece);
					// In this part, we call the method in the ProductTree class to add the product
					// into the tree with the specific information that is taken as input.

					break; // Leave the case.

				case "Is_Available":
					// The program checks if the input is "Is_Avaiable".
					// It is used for checking the number of products available.

					int id2 = s.nextInt();
					// In the txt file, next input is the ID of the product. So, it keeps it as
					// integer variable to call the method with it.

					tree.isAvailable(id2);
					// In this part, we call the method in the ProductTree class to check the number
					// of product is available with the specific information that is taken as input.

					System.out.println();

					break; // Leave the case.

				case "Quit":
					// The program checks if the input is "Quit".
					// It is used for stopping the program.

					System.out.println();

					tree.quit();
					// In this part, we call the method in the ProductTree class to stop the
					// program.

					break; // Leave the case.
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}