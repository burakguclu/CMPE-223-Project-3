//-----------------------------------------------------
// Title: Programming Assignment 3 - Question 1 Product.java
// Author: Burak Güçlü
// Description: This class is used for creating different 
// Product objects that will be used to store some data.
// They will be used to create a binary search tree.
//-----------------------------------------------------

public class Product {

	int ID;
	String name;
	int piece;
	Product left, right;
	// Necessary variables are ID, name and piece for a product.
	// Since we will create a binary search tree, every node will have two children
	// which can be represented as left and right.

	public Product(String product_name, int product_id, int product_piece) {
		// --------------------------------------------------------
		// Summary: This constructor method is being used for creating
		// Product objects.
		// Precondition: product_name is a String variable which will
		// be initialized as the name of the product. product_id is an
		// integer variable which will be initialized as the ID of the
		// product. product_piece is an integer variable which will be
		// initialized as the count of the product.
		// Postcondition: It creates Product object with the specified
		// information.
		// --------------------------------------------------------

		ID = product_id;
		name = product_name;
		piece = product_piece;
	}

}
