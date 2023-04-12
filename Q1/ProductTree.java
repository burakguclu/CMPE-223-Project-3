//-----------------------------------------------------
// Title: Programming Assignment 3 - Question 1 ProductTree.java
// Author: Burak Güçlü
// Description: This class is used for creating binary 
// search tree. It will be consist of some nodes which 
// is called Product.
//-----------------------------------------------------

public class ProductTree {

	private Product root;
	// There must be a root of every tree, so we create a temporary root first.

	public Product get(Integer product_id) {
		// --------------------------------------------------------
		// Summary: This method is being used for reaching the Product
		// object which is chosen by ID in the tree.
		// Precondition: product_id is an Integer object which will be
		// used for compareTo method.
		// Postcondition: It will return Product object with the given ID.
		// --------------------------------------------------------

		Product x = root; // Starting from the top of the tree.
		while (x != null) { // Visiting every element which is not null.
			int cmp = product_id.compareTo(x.ID);
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

	public void add_a_product(String product_name, int product_id, int piece) {
		// --------------------------------------------------------
		// Summary: This method is being used for adding a Product
		// object which is given by name, ID and piece value.
		// Precondition: product_name is a String variable which will
		// be initialized as the name of the product. product_id is
		// an integer variable which will be initialized as the ID of
		// to product. piece is an integer variable which will be initialized
		// as the count of the product.
		// Postcondition: It will call the recursive add_a_product method
		// by starting from the root.
		// --------------------------------------------------------

		root = add_a_product(root, product_name, product_id, piece);
	}

	private Product add_a_product(Product x, String product_name, Integer product_id, int piece) {
		// --------------------------------------------------------
		// Summary: This method is being used for adding a Product
		// object which is given by name, ID and piece value. It is
		// a recursive method, so it will add the Product object as
		// the child of given Product object.
		// Precondition: x is a Product object which will be the parent
		// of new object in the tree. product_name is a String variable
		// which will be initialized as the name of the product. product_id is
		// an Integer variable which will be initialized as the ID of
		// to product. piece is an integer variable which will be initialized
		// as the count of the product.
		// Postcondition: It will find the best place to add the new object into
		// the tree. It will create it by given parameters and put it into the
		// found place. It will return the object to assign it to the root.
		// --------------------------------------------------------

		if (x == null)
			return new Product(product_name, product_id, piece);
		// When the place is found for the new object, it will be created and put it
		// there.

		int cmp = product_id.compareTo(x.ID);
		// Comparing the IDs to find the best place for the new object.

		if (cmp < 0) // If ID is smaller than the current one, go left.
			x.left = add_a_product(x.left, product_name, product_id, piece);

		else if (cmp > 0) // If ID is larger than the current one, go right.
			x.right = add_a_product(x.right, product_name, product_id, piece);

		else if (cmp == 0)
			x.ID = product_id;
		// If ID is equal to current one, there is already a object with the same ID.
		// We are differentiating the products with their IDs.

		return x;
	}

	public void isAvailable(int product_id) {
		// --------------------------------------------------------
		// Summary: This method is being used to check for the number
		// of the product with the given ID.
		// Precondition: product_id is an integer variable to find the
		// specific Product object.
		// Postcondition: It will print the number of product.
		// --------------------------------------------------------

		Product temp = get(product_id);
		// Reaching the product with the given ID by using get method.

		if (temp == null || temp.piece <= 0)
			System.out.println("The product is out of stock!!!");
		// If there is no product with the given ID or there is no piece left for the
		// product it will print the message.

		else if (temp.piece > 0)
			System.out.println("There are " + temp.piece + " products");
		// If there is at least one piece for the product it will print the number of
		// product.
	}

	public void quit() {
		// --------------------------------------------------------
		// Summary: This method is being used for quitting the program
		// by writing a message to screen.
		// --------------------------------------------------------
		System.out.println("Thank you for using ITS, Good Bye!");
		System.exit(0);
	}

}
