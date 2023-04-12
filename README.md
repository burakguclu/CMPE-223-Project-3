# CMPE 223 Project 3 - Tree/Search Tree Applications
As a homework assignment, we were expected to write some programs which run by using my own implementation of Tree Structure.

## Question 1

In this question, we were expected to implement a simple Inventory Tracking System using one of the search trees. In my implementation, for each product, I am keeping ID, name and piece in tree data structure.

Example Input/Output:

    --------------- WELCOME TO ITS ---------------
    Create Product:
        ID: 23
        Name: sweatshirt
        Piece: 1
        
    Create Product:
        ID: 56
        Name: skirt
        Piece: 2
        
    Create Product:
        ID: 95
        Name: hat
        Piece: 6
        
    There are 1 products
    
    There are 2 products
    
    The product is out of stock!!!
    
    Thank you for using ITS, Good Bye!

## Question 2

In this question, we assumed that a chauffeur-driven rental company (CDRC) asks us to write a management system code for their captains' salary increase. I wrote all necessary application in the program as methods and they are being called if any of them is necessary. Even though the program does not use any database system, it works almost like that.

Here is a list of methods used in the program:

`Add a captain:` This function generates a BST node for each captain in the tree. The function is followed by two values: the captain ID and the captain’s name. The default value for the rating stars will be “0” and the default value of available is “true”.

`Delete the captain:` This function has one value that represents the captain’s ID. The command will search for this captain in the tree then remove his/her node from the BST, and it will output the “The captain left CDRC” message. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number ” message.

`Print a captain’s information:` This function has one value which is the captain ID. It will output the name and the rating stars for the specified captain. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number ” message.

`Print all captain’s information:` This function prints all captain's IDs, names, available, and rating stars.

`Rent a car:` This function has one value which is the captain ID. The command will book a ride with the specified captain by changing the available to “false”. If the available for the specified captain is already “false”, then output the “The captain is not available. He is on another ride!” message. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number ” message.

`Finish the ride:` This function has two value which is the captain ID, and the rider satisfaction (0 or 1). This command will make the specified captain available again by changing the available to “true”. The rating stars will affect the captain rating stars. The rating stars will increase by one if the rider is satisfied and decrease by one otherwise. (Note: the rating stars is a value between 0 and 5 only). If the available for the specified captain is already “true”, then output the “The captain is 4 not in a ride!” message. If the specified captain is not found, it will output the “Couldn’t find any captain with ID number ” message.

`Quit:` This function must stop your program

Example Input/Output:

    --------------- WELCOME TO CDRC SYSTEM ---------------
    Add Captain: Add a new captain record in the System
            ID: 801
            Name: Burak
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Add Captain: Add a new captain record in the System
            ID: 802
            Name: Ahmet
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Add Captain: Add a new captain record in the System
            ID: 803
            Name: Ali
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Add Captain: Add a new captain record in the System
            ID: 804
            Name: Can
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Add Captain: Add a new captain record in the System
            ID: 805
            Name: Yasir
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Add Captain: Add a new captain record in the System
            ID: 806
            Name: Pelin
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Add Captain: Add a new captain record in the System
            ID: 807
            Name: Adem
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    IsAvailable: Reserve a new Ride with captain 801
    ----------------------------------------------------------------
    IsAvailable: Reserve a new Ride with captain 802
    ----------------------------------------------------------------
    IsAvailable: Reserve a new Ride with captain 803
    ----------------------------------------------------------------
    IsAvailable: Couldn't find any captain with ID number 814
    ----------------------------------------------------------------
    IsAvailable: The captain Ali is not available. He is on another ride!
    ----------------------------------------------------------------
    Display Captain: Couldn't find any captain with ID number 820
    ----------------------------------------------------------------
    Display Captain:
            ID: 802
            Name: Ahmet
            Available: False
            Rating star: 0
    ----------------------------------------------------------------
    Finish: Finish ride with captain 801
            ID: 801
            Name: Burak
            Available: True
            Rating star: 0
    ----------------------------------------------------------------
    Finish: Finish ride with captain 802
            ID: 802
            Name: Ahmet
            Available: True
            Rating star: 1
    ----------------------------------------------------------------
    Finish: The captain Adem is not in a ride
    ----------------------------------------------------------------
    Finish: Couldn't find any captain with ID number 811
    ----------------------------------------------------------------
    Delete Captain:The captain Can left CCR
    ----------------------------------------------------------------
    Delete Captain: Couldn't find any captain with ID number 814
    ----------------------------------------------------------------
    
    ----------ALL CAPTAINS----------
    --CAPTAIN:
            ID: 801
            Name: Burak
            Available: True
            Rating star: 0
    --CAPTAIN:
            ID: 802
            Name: Ahmet
            Available: True
            Rating star: 1
    --CAPTAIN:
            ID: 803
            Name: Ali
            Available: False
            Rating star: 0
    --CAPTAIN:
            ID: 805
            Name: Yasir
            Available: True
            Rating star: 0
    --CAPTAIN:
            ID: 806
            Name: Pelin
            Available: True
            Rating star: 0
    --CAPTAIN:
            ID: 807
            Name: Adem
            Available: True
            Rating star: 0
    
    Thank you for using CDRC, Good Bye!
