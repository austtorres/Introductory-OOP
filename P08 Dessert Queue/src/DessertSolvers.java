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
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class removes guests from the queue when they are served, and by removing and then adding
 * back to this queue guests who are skipped over and continue waiting to be served
 * 
 * @author Austin Torres
 *
 */
public class DessertSolvers {

  /**
   * This method should take the number of guests at a party, create as many guests with an index
   * starting at one, simulate the serving of those guests, and then return a reference to the guest
   * that is served last.
   * 
   * @param numberOfGuests: guests at party
   * @param guestsSkipped: guests skipped in the serving order
   * @return a reference to the guest that is served last
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) {
    if (numberOfGuests <= 0) {
      throw new IllegalArgumentException("Number of guests must be positive");
    } else if (guestsSkipped < 0) {
      throw new IllegalArgumentException("Number of guests skipped cannot be negative");
    } else {
      // reset guest index to 1 before every iteration
      Guest.resetNextGuestIndex();
      // create new queue
      ServingQueue guestQueue = new ServingQueue(numberOfGuests);
      for (int i = 1; i <= numberOfGuests; i++) {
        // create new guest to arrive at table
        guestQueue.add(new Guest());
      }

      // last guest to be served
      Guest lastGuest = guestQueue.remove();
      while (!guestQueue.isEmpty()) {
        for (int i = 0; i < guestsSkipped; i++) {
          // adding front of queue to back of queue
          guestQueue.add(guestQueue.remove());
        }
        // prevent infinite loop if number of guests is 1
        lastGuest = guestQueue.remove();
      }
      return lastGuest;
    }
  }

  /**
   * This method takes the number of guests at a party, creates as many guests with an index
   * starting at one, simulates the serving of those guests through the specified number of courses,
   * and then returns a reference to the guest that is served last in the second to last course
   * (since this is the guest who will be served dessert first). If coursesServed is 1, then simply
   * return a guest #1 since they will be served their only course (dessert) first.
   * 
   * @param numberOfGuests: guests at a party
   * @param coursesServed: courses served to guests
   * @return a reference to the guest that is served last in the second to last course
   * @throws IllegalArgumentException
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed)
      throws IllegalArgumentException {
    if (numberOfGuests <= 0) {
      throw new IllegalArgumentException("Number of guests must be positive");
    } else if (coursesServed <= 0) {
      throw new IllegalArgumentException("Number of courses served must be positive");
      // if only one course has been served, return guest at index 1
    } else if (coursesServed == 1) {
      // reset guest index to 1
      Guest.resetNextGuestIndex();
      return new Guest();
    } else {
      // reset guest index to 1 before every iteration
      Guest.resetNextGuestIndex();
      ServingQueue guestQueue = new ServingQueue(numberOfGuests);
      for (int i = 1; i < numberOfGuests; i++) {
        // create new guest to arrive at table
        guestQueue.add(new Guest());
      }
      // last guest to be served
      Guest lastGuest = guestQueue.remove();
      ServingQueue secondaryQueue = new ServingQueue(numberOfGuests);
      for (int i = 1; i < coursesServed; i++) {
        // adding front of queue to back of queue
        guestQueue.add(guestQueue.remove());
      }
      // prevent infinite loop if number of guests is 1
      lastGuest = guestQueue.remove();
      return lastGuest;
    }

  }
}
