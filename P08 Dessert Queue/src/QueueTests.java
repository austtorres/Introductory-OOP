//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 Dessert Queue
// Files: Guest.java, ServingQueue.java, QueueTests.java, and DessertSolvers.java
// Course: CS300 Spring 2019
//
// Author: Austin Torres
// Email: artorres3@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
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
// Persons: (identify each person and describe their help in detail)
// Online Sources:
// https://courses.cs.washington.edu/courses/cse332/12sp/section/week2/QueueTester.java
// Info on how to use Assert for testing
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * @author Austin Torres
 *
 */
public class QueueTests {

  /**
   * Main method for the QueueTests class that runs the tests and and displays feedback about which
   * tests have passed versus failed
   * 
   * @param args
   */
  public static void main(String[] args) {
    testIsEmptyOnEmpty();
    testIsEmptyOnNotEmpty();
    testAdd();

  }

  private static ServingQueue queue;

  /**
   * Test the functionality of the isEmpty() method in ServingQueue.java when the queue is empty
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testIsEmptyOnEmpty() {
    queue = new ServingQueue(5);
    if (!queue.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Test the functionality of the isEmpty() method in ServingQueue.java when the queue is not empty
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testIsEmptyOnNotEmpty() {
    queue = new ServingQueue(5);
    queue.add(new Guest());
    if (queue.isEmpty()) {
      return false;
    }
    return true;
  }

  /**
   * Test the functionality of the add() method in ServingQueue.java
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testAdd() {
    queue = new ServingQueue(5);
    queue.add(new Guest());
    if (!queue.isEmpty()) {
      return true;
    }
    return false;
  }


}
