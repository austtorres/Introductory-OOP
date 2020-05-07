//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P01 Shopping Cart
// Files: ShoppingCart.java and ShoppingCartTests.java
// Course: CS300 Spring 2019
//
// Author: Austin Torres
// Email: artorres3@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: N/A
// Partner Email: N/A
// Partner Lecturer's Name: N/A
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: 
//  Aaron Hernandez - tutor; gave a review lesson on arrays,
// perfect size vs. oversize arrays, changing references, and formatting.
//
//  Jack Donnelly - friend; he took this class last semester and helped me understand parsing, 
// how to call information from previous methods using for loops, and scanners.
//
// Varsity tutors: Dennis - tutor; private tutor taught me how to add values of arrays and skip
// unwanted characters. I used what he taught me and applied it to getting the subtotal by skipping
// the '$' in the index of market items.
//
// Online Sources: 
// https://www.youtube.com/watch?v=25kUc_ammbw "Basic Menu System in Java"; learned how to make
// simple menus and applied some of the techniques to this ShoppingCart program
//
// https://www.youtube.com/watch?v=HM7L1V4r5F8 "Making a Store's Menu pt. 2 (CMD)"; I learned more
// techniques for making a menu that can be interacted with by a user
//
// https://www.youtube.com/watch?v=fwse3oz-XKQ "Java101: Master the java.util.Scanner Class!";
// This video taught me about how to efficiently implement scanners
//
// https://www.youtube.com/playlist?list=PLiwphLky56kA0uz5G3pR9VVrL1rNZsfOr Playlist of videos for
// how to translate from Python to Java. This playlist was linked on the CS300 website, and I used
// it because I took CS301 instead of CS200
//
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class is a program that acts as a shopping cart. A command menu is displayed where customers
 * can add/remove/display items in a shopping cart, view a catalog of available items, and check out
 * the items in their cart with the subtotal and final total displayed
 * 
 * @author aus10
 * 
 */

import java.util.Scanner;
import java.util.Arrays;

public class ShoppingCart {

  // Define final parameters
  private static final int CART_CAPACITY = 20; // shopping cart max capacity
  private static final double TAX_RATE = 0.05; // sales tax
  // a perfect-size two-dimensional array that stores the available items in the market
  // MARKET_ITEMS[i][0] refers to a String that represents the description of the item
  // identified by index i
  // MARKET_ITEMS[i][1] refers to a String that represents the unit price of the item
  // identified by index i in dollars.
  public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
      {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
      {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
      {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
      {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
      {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
      {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

  /**
   * adds the item with the given identifier index at the end of the cart. If the count of items is
   * >= 20 when the user tries to add an item, a warning message is displayed and the user cannot
   * add any more items.
   * 
   * @param index of the item within the marketItems array
   * @param cart  shopping cart
   * @param count number of items present within the cart before this add method is called
   * @return the number of items present in the cart after the item with identifier index is added
   */
  public static int add(int index, String[] cart, int count) {
    // Checks if cart has space to add more items
    if (count < cart.length) {
      cart[count] = (getItemDescription(index));
      count++;
    }
    // Displays warning if cart is full
    else {
      System.out.println("WARNING: The cart is full. You cannot add any new item.");
    }
    return count;
  }

  /**
   * Returns how many occurrences of the item with index itemIndex are present in the shopping cart
   * 
   * @param itemIndex identifier of the item to count its occurrences in the cart
   * @param cart      shopping cart
   * @param count     number of items present within the cart
   * @return the number of occurrences of item in the cart
   */

  public static int occurrencesOf(int itemIndex, String[] cart, int count) {
    int occurrences = 0;
    // i represents index of item in shopping cart
    for (int i = 0; i < count; i++) {
      if (cart[i].equals(getItemDescription(itemIndex))) {
        occurrences++;
      }
    }
    return occurrences;
  }

  /**
   * returns the item description (String) given its index (int)
   * 
   * @param index index of item in MARKET_ITEMS array
   * @return returns item description
   */
  private static String getItemDescription(int index) {
    return MARKET_ITEMS[index][0];
  }


  /**
   * Removes the first (only one) occurrence of itemToRemove if found and returns the number of
   * items in the cart after remove operation is completed either successfully or not
   * 
   * @param itemToRemove the item to be taken out of the cart
   * @param cart         shopping cart
   * @param count        number of items present within the cart
   * @return returns number of items in cart after item is removed
   */
  public static int remove(String itemToRemove, String[] cart, int count) {
    int indexToRemove = indexOf(itemToRemove, cart, count);
    // check to see if item is found in the cart
    if (indexToRemove != -1) {
      // Swaps reference of removed item to the last item's reference
      cart[indexToRemove] = cart[count - 1];
      // Sets the last item's reference to null (removing it)
      cart[count - 1] = null;
      count--;
    } else {
      // print warning
      System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
    }
    return count;
  }

  /**
   * Returns the index of an item within the shopping cart
   * 
   * @param item  description
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return index of the item within the shopping cart, and -1 if the item does not exist in the
   *         cart
   */
  private static int indexOf(String item, String[] cart, int count) {
    // i represents the current item index of the shopping cart
    for (int i = 0; i < count; i++) {
      if (cart[i].equals(item)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * returns the total value (cost) of the cart without tax in $ (double) by iterating through the
   * cart and adding the item's price to the subtotal
   * 
   * @param cart
   * @param count
   * @return subtotal of items
   */
  public static double getSubTotalPrice(String[] cart, int count) {
    // return variable to represent subtotal
    double subtotal = 0.0;
    for (int i = 0; i < count; i++) {
      // set current item in loop equal to currentItemString
      String currentItemString = cart[i];
      // iterate through MARKET_ITEMS
      for (int x = 0; x < MARKET_ITEMS.length; x++) {
        if (MARKET_ITEMS[x][0].contentEquals(currentItemString)) {
          // remove '$' from price in MARKET_ITEMS and set new variable price equal to a double
          // price
          double price = Double.valueOf(MARKET_ITEMS[x][1].substring(1));
          subtotal += price;

        }
      }
    }
    return subtotal;
  }

  /**
   * prints the Market Catalog (item identifiers, description, and unit prices) This still prints
   * the market catalog even when changes are made to the catalog (sales, adding an item, etc.)
   * 
   */
  public static void printMarketCatalog() {
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Item id \tDescription \t Price");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

    // loop through and print market items with associated prices
    for (int i = 0; i < MARKET_ITEMS.length; i++) {
      System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t " + MARKET_ITEMS[i][1]);
    }
    System.out.print("+++++++++++++++++++++++++++++++++++++++++++++");
  }


  /**
   * Displays the cart content (items separated by commas)
   * 
   * @param cart
   * @param count
   */
  public static void displayCartContent(String[] cart, int count) {
    System.out.print("Cart Content: ");
    // Loops through cart and prints each item with ", " after
    for (int i = 0; i < count; i++) {
      System.out.print(cart[i] + ", ");
    }
    System.out.print("\n");

  }

  /**
   * Main method that creates an application allowing a customer to interact with a menu and
   * navigate the store using the methods throughout the program
   *
   * @param args
   */
  public static void main(String args[]) {
    // Create new Scanner Object scanner
    Scanner scnr = new Scanner(System.in);
    System.out.print("=============   Welcome to the Shopping Cart App   =============\n\n\n");
    // String variable to hold user input created
    String userInput;
    String[] cart = new String[CART_CAPACITY];
    int count = 0;
    int userInt;
    // Starts application loop
    while (true) {
      System.out.print("COMMAND MENU:\n" + " [P] print the market catalog\n"
          + " [A <index>] add one occurrence of an item to the cart given its identifier\n"
          + " [C] checkout\n" + " [D] display the cart content\n"
          + " [O <index>] number of occurrences of an item in the cart given its identifier\n"
          + " [R <index>] remove one occurrence of an item from the cart given its identifier\n"
          + " [Q]uit the application\n\n" + "ENTER COMMAND: ");
      userInput = scnr.nextLine().toLowerCase();
      // Option to quit application
      if (userInput.charAt(0) == ('q')) {
        break;
      } else if (userInput.charAt(0) == 'p') {
        // Option to display market catalog
        printMarketCatalog();
        //option to add items to cart
      } else if (userInput.charAt(0) == 'a') {
        // Parse the integer from the second index of userInput
        try {
          userInt = Integer.valueOf(userInput.substring(2));
        } catch (Exception e) {
          // If parsing causes an exception, restart the application loop
          continue;
        }
        // If parsing causes no exceptions, add number of items in cart to count
        count = add(userInt, cart, count);
      } else if (userInput.charAt(0) == 'c') {
        // Option to check out and see price broken down into subtotal and applied tax
        double subtotal = getSubTotalPrice(cart, count);
        // Calculating amount of tax applied
        double tax = subtotal * TAX_RATE;
        System.out.printf("#items: " + count + " Subtotal: $%.2f Tax: $%.2f TOTAL: $%.2f" + "\n",
            subtotal, tax, (tax + subtotal));
        //option to display what is currently in the cart
      } else if (userInput.charAt(0) == 'd') {
        displayCartContent(cart, count);
      } else if (userInput.charAt(0) == 'o') {
        //Parse integer from second index of userInput
        try {
          userInt = Integer.valueOf(userInput.substring(2));
        } catch (Exception e) {
          continue;
        }
        // If parsing doesn't cause an exception, print frequency of item in cart
        System.out.print("The number of occurrences of " + MARKET_ITEMS[userInt][0] + " (id #"
            + userInt + ") is: " + occurrencesOf(userInt, cart, count) + "\n");
      } else if (userInput.charAt(0) == 'r') {
        // Option to remove desired item from cart
        try {
          userInt = Integer.valueOf(userInput.substring(2));
        } catch (Exception e) {
          continue;
        }
        // Prevent IndexOutOfBoundsException 
        if (userInt < 0 || userInt > MARKET_ITEMS.length) {
          continue;
        }
        count = remove(MARKET_ITEMS[userInt][0], cart, count);
      }
      System.out.print("\n");
    }
    // Print thank you message when user quits application
    System.out.println("=============  Thank you for using this App!!!!!  =============");
  }


}
