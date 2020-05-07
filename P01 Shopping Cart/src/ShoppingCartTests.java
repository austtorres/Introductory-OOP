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
 * @author Austin Torres
 * 
 */
public class ShoppingCartTests {

  /**
   * Checks whether the total number of items within the cart is incremented after adding one item
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
    boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                               // false otherwise
    String[] cart = new String[20]; // shopping cart
    int count = 0; // number of items present in the cart (initially the cart is empty)

    // Add an item to the cart
    count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
    // Check that count was incremented
    if (count != 1) {
      System.out.println("Problem detected: After adding only one item to the cart, "
          + "the cart count should be incremented. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether add and OccurrencesOf return the correct output when only one item is added to
   * the cart
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
    boolean testPassed = true; //evaluated to true if test passed without problems, false otherwise
    // define the shopping cart as an oversize array of elements of type String
    // we can set an arbitrary capacity for the cart - for instance 10
    String[] cart = new String[10]; // shopping cart
    int count = 0; // number of items present in the cart (initially the cart is empty)

    // check that OccurrencesOf returns 0 when called with an empty cart
    if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
      System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
          + "empty. The result should be 0. But, it was not.");
      testPassed = false;
    }

    // add one item to the cart
    count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
    // check that OccurrencesOf("Apples", cart, count) returns 1 after adding the
    // item with key 0
    if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
      System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
          + "OccurrencesOf to count how many of that item the cart contains should return 1. "
          + "But, it was not the case.");
      testPassed = false;
    }

    return testPassed;
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
        + testCountIncrementedAfterAddingOnlyOneItem());
    System.out.println(
        "testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
  }


  /**
   * Checks that when only one attempt to remove an item present in the cart is made, only one
   * occurrence of that item is removed from the cart
   * 
   * @return
   */
  // public static boolean testRemoveOnlyOneOccurrenceOfItem() {
  // boolean testPassed = true; // evaluated to true if test passed without problems, false
  // otherwise
  // String[] cart = new String[20]; // shopping cart
  // int count = 0;
  // }

  // Checks that remove returns false when the user tries to remove an item not present within the
  // cart
  // public static boolean testRemoveItemNotFoundInCart() {
  // boolean testPassed = true; // evaluated to true if test passed without problems, false
  // otherwise
  // String[] cart = new String[20]; // shopping cart
  // int count = 0;
  // return 0;
  // }
}
