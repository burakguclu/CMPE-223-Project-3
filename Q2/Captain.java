//-----------------------------------------------------
// Title: Programming Assignment 3 - Question 2 Captain.java
// Author: Burak Güçlü
// Description: This class is used for creating different 
// Captain objects that will be used to store some data.
// They will be used to create a binary search tree.
//-----------------------------------------------------

public class Captain {

	int ID;
	String name;
	String availability;
	int rating_star;
	Captain left, right;
	// Necessary variables are ID, name, availability and rating star for a captain.
	// Since we will create a binary search tree, every node will have two children
	// which can be represented as left and right.

	public Captain(String captain_name, int captain_id) {
		// --------------------------------------------------------
		// Summary: This constructor method is being used for creating
		// Captain objects.
		// Precondition: captain_name is a String variable which will
		// be initialized as the name of the captain. captain_id is an
		// integer variable which will be initialized as the ID of the
		// captain.
		// Postcondition: It creates Captain object with the specified
		// information.
		// --------------------------------------------------------

		ID = captain_id;
		name = captain_name;
		availability = "True"; // Initial condition for availability is True.
		rating_star = 0; // Initial condition for rating star is 0.
	}
}
