//-----------------------------------------------------
// Title: Programming Assignment 3 - Question 2 BinaryCaptainTree.java
// Author: Burak Güçlü
// Description: This class is used for creating binary 
// search tree. It will be consist of some nodes which 
// is called Captain.
//-----------------------------------------------------

public class BinaryCaptainTree {

	private Captain root;
	// There must be a root of every tree, so we create a temporary root first.

	public Captain get(Integer captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for reaching the Captain
		// object which is chosen by ID in the tree.
		// Precondition: captain_id is an Integer object which will be
		// used for compareTo method.
		// Postcondition: It will return Captain object with the given ID.
		// --------------------------------------------------------

		Captain x = root; // Starting from the top of the tree.
		while (x != null) { // Visiting every element which is not null.
			int cmp = captain_id.compareTo(x.ID);
			// Compare the ID of the Product object with the expected one.

			if (cmp < 0) // If ID is smaller than the current one, go left.
				x = x.left;
			else if (cmp > 0) // If ID is larger than the current one, go right.
				x = x.right;
			else if (cmp == 0) // If ID is equal to the current one, it is found!
				return x;
		}
		return null; // If the Product object with the given ID is not in the tree, return null.
	}

	public void add_a_captain(String captain_name, int captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for adding a Captain
		// object which is given by name and ID value.
		// Precondition: captain_name is a String variable which will
		// be initialized as the name of the captain. captain_id is
		// an integer variable which will be initialized as the ID of
		// the captain.
		// Postcondition: It will call the recursive add_a_captain method
		// by starting from the root.
		// --------------------------------------------------------

		root = add_a_captain(root, captain_name, captain_id);
	}

	private Captain add_a_captain(Captain x, String captain_name, Integer captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for adding a Captain
		// object which is given by name and ID value. It is
		// a recursive method, so it will add the Captain object as
		// the child of given Captain object.
		// Precondition: x is a Captain object which will be the parent
		// of new object in the tree. captain_name is a String variable
		// which will be initialized as the name of the captain. captain_id is
		// an Integer variable which will be initialized as the ID of
		// to captain.
		// Postcondition: It will find the best place to add the new object into
		// the tree. It will create it by given parameters and put it into the
		// found place. It will return the object to assign it to the root.
		// --------------------------------------------------------

		if (x == null)
			return new Captain(captain_name, captain_id);
		// When the place is found for the new object, it will be created and put it
		// there.

		int cmp = captain_id.compareTo(x.ID);
		// Comparing the IDs to find the best place for the new object.

		if (cmp < 0)// If ID is smaller than the current one, go left.
			x.left = add_a_captain(x.left, captain_name, captain_id);

		else if (cmp > 0) // If ID is larger than the current one, go right.
			x.right = add_a_captain(x.right, captain_name, captain_id);

		else if (cmp == 0)
			x.ID = captain_id;
		// If ID is equal to current one, there is already a object with the same ID.
		// We are differentiating the captains with their IDs.

		return x;
	}

	private Captain deleteMin(Captain x) {
		// --------------------------------------------------------
		// Summary: This method is being used for deleting a node with the minimum value
		// from the tree. The main purpose of using it, is making binary search tree
		// appropriate again, after deleting a node in the middle of the tree. It is a
		// recursive method, so it will search for the Captain with the minimum ID
		// value and remove it from its place in the tree.
		// Precondition: x is a Captain object which will be the starting point
		// of the tree and it will be used to visit its children to find the captain
		// with the minimum ID value.
		// Postcondition: It will find the Captain object who has minimum ID value and
		// remove it from the tree. It will return a Captain object that will be used to
		// put an appropriate place for it.
		// --------------------------------------------------------

		if (x.left == null) // If there is no left child, it returns right child.
			return x.right;

		x.left = deleteMin(x.left);
		// It calls itself recursively to find the captain with the minimum ID value and
		// remove it.

		return x;
	}

	public void delete_the_captain(int captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for deleting a Captain
		// object which is given by ID value.
		// Precondition: captain_id is an integer variable which will be
		// used to found and delete the captain.
		// Postcondition: It will call the recursive delete_the_captain
		// method by starting from the root.
		// --------------------------------------------------------

		root = delete_the_captain(root, captain_id);
	}

	private Captain delete_the_captain(Captain x, Integer captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for deleting a Captain
		// object which is given by ID value. It is a recursive method, so it will
		// delete the Captain object and design the tree appropriately.
		// Precondition: x is a Captain object which will be the starting point
		// of the tree and it will be used to visit its children. captain_id is
		// an Integer variable which will be given for deleting the specific captain.
		// Postcondition: It will find the Captain object and remove it from the tree.
		// It will make some changes on the tree to make it a binary tree again.
		// --------------------------------------------------------

		if (x == null) {
			// If there is no captain with the given ID it will print a message.

			System.out.println("Delete Captain: Couldn't find any captain with ID number " + captain_id);
			return null;
		}

		int cmp = captain_id.compareTo(x.ID);
		// Comparing the IDs to find the deleting object.

		if (cmp < 0) // If ID is smaller than the current one, go left.
			x.left = delete_the_captain(x.left, captain_id);

		else if (cmp > 0) // If ID is larger than the current one, go right.
			x.right = delete_the_captain(x.right, captain_id);

		else { // It means that the captain with given ID is found.

			System.out.println("Delete Captain:The captain " + x.name + " left CCR");

			if (x.right == null) // If there is no right child return left child.
				return x.left;

			if (x.left == null) // If there is no left child return right child.
				return x.right;

			Captain t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
			// Since we removed a node from the tree, we should keep children of the node.
			// This part is used for making the appropriate changes on the tree to make it
			// stay like a binary tree.
		}
		return x;
	}

	private Captain min(Captain node) {
		// --------------------------------------------------------
		// Summary: This method is being used for finding the captain with the least ID
		// number.
		// Precondition: node is a Captain object which will be the root of the tree.
		// Postcondition: It will find the captain with the minimum ID value.
		// --------------------------------------------------------

		Captain current = node;
		while (current.left != null) {
			// Since we are using binary tree, the minimum node will be the leftmost item.
			current = current.left;
		}
		return current;
	}

	public void displayCaptain(int captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for printing information of the captain
		// with the given information.
		// Precondition: captain_id is a integer which will be used to find the captain.
		// Postcondition: It will print all of the information of the captain with the
		// given ID value.
		// --------------------------------------------------------

		Captain temp = get(captain_id);
		// Finding the captain in the tree by using get method.

		if (temp == null) { // If there is no captain with the given ID, it prints a message.
			System.out.print("Couldn't find any captain with ID number " + captain_id);
			System.out.println();
		} else {
			// If there is a captain with the given ID, it prints all the information of
			// him/her.
			System.out.println();
			System.out.println("\t\t\tID: " + temp.ID);
			System.out.println("\t\t\tName: " + temp.name);
			System.out.println("\t\t\tAvailable: " + temp.availability);
			System.out.println("\t\t\tRating star: " + temp.rating_star);
		}
	}

	public void display_all_Captains() {
		// --------------------------------------------------------
		// Summary: This method is being used for printing informations
		// of all of the captains in the tree. It calls a recursive method
		// which is called display_all_Captains.
		// --------------------------------------------------------

		display_all_Captains(root);
	}

	private void display_all_Captains(Captain node) {
		// --------------------------------------------------------
		// Summary: This method is being used for printing informations
		// of all of the captains in the tree. It is a recursive method.
		// Precondition: node is a Captain object which will be used to represent the
		// root of the tree and it will visit every node in it.
		// Postcondition: It will print all of the informations of the captains in the
		// tree. It uses inorder traversal.
		// --------------------------------------------------------

		if (node == null) // If there is no child anymore, return.
			return;

		display_all_Captains(node.left);
		// Firstly start from left child.

		System.out.println("--CAPTAIN:");
		displayCaptain(node.ID);
		// Write the information of the captain.

		System.out.println();

		display_all_Captains(node.right);
		// Then write the right child.
	}

	public void rent_a_car(int captain_id) {
		// --------------------------------------------------------
		// Summary: This method is being used to check for the captain
		// if he/she is available to take a ride.
		// Precondition: captain_id is an integer variable to find the
		// specific Captain object.
		// Postcondition: It will print the situation of the captain.
		// If captain is available, program changes his/her availability
		// into "False". If captain is not available, program prints a message.
		// --------------------------------------------------------

		Captain temp = get(captain_id);
		// Finding the captain in the tree by using get method.

		if (temp == null) // If there is no captain with the given ID, it prints a message.
			System.out.println("IsAvailable: Couldn't find any captain with ID number " + captain_id);

		else if (temp.availability.equals("False")) // If the captain is not available, it prints a message.
			System.out.println("IsAvailable: The captain " + temp.name + " is not available. He is on another ride!");

		else if (temp.availability.equals("True")) { // If the captain is availabe, it changes the availability.
			System.out.println("IsAvailable: Reserve a new Ride with captain " + temp.ID);
			temp.availability = "False";
		}
	}

	public void finish_the_ride(int captain_id, int satisfaction) {
		// --------------------------------------------------------
		// Summary: This method is being used for finishing the ride for the
		// captain with the given ID.
		// Precondition: captain_id is an integer variable to find the
		// specific Captain object. satisfaction is an integer variable
		// to give a point for the captain.
		// Postcondition: It will finish the ride for the captain and change
		// his/her availability into "True". Also, it will change rating star of the
		// captain depending on the satisfaction value.
		// --------------------------------------------------------

		Captain temp = get(captain_id);
		// Finding the captain in the tree by using get method.

		if (temp == null) { // If there is no captain with the given ID, it prints a message.
			System.out.print("Couldn't find any captain with ID number " + captain_id);
			System.out.println();
		}

		else if (temp.availability.equals("True")) // If the captain is not in a ride, it prints a message.
			System.out.println("The captain " + temp.name + " is not in a ride");

		else if (temp.availability.equals("False")) { // If the captain is in a ride, it makes some changes.
			System.out.println("Finish ride with captain " + temp.ID);

			temp.availability = "True";
			// It changes the availability of the captain.

			if (satisfaction == 0 && temp.rating_star != 0) // If satisfaction is 0, rating star decreases.
				temp.rating_star--;

			if (satisfaction == 1) // If satisfaction is 1, rating star increases.
				temp.rating_star++;

			displayCaptain(captain_id); // Printing information of the captain.
		}
	}

	public void quit() {
		// --------------------------------------------------------
		// Summary: This method is being used for quitting the program
		// by writing a message to screen.
		// --------------------------------------------------------
		System.out.println("Thank you for using CDRC, Good Bye!");
		System.exit(0);
	}

}
