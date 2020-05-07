//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////
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
 * This class implements a queue of Guest objects using circular indexing. The capacity of the array
 * holding these guest does NOT change or grow (not a dynamic array).
 * 
 * @author Austin Torres
 *
 */
public class ServingQueue {

  private Guest[] array;
  private int size;
  private int tableCapacity;
  private int enqueueTo;
  private int queueFront;

  /**
   * Creates a new array based queue with a capacity of "seatsAtTable" guests. This queue should be
   * initialized to be empty.
   * 
   * @param seatsAtTable the size of the array holding this queue data
   */
  public ServingQueue(int seatsAtTable) {
    this.tableCapacity = seatsAtTable;
    // new array with given capacity
    this.array = new Guest[tableCapacity];
    queueFront = 0;
  }

  /**
   * Checks whether there are any guests in this serving queue.
   * 
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {
    if (size == 0) {
      // return true if the queue is empty
      return true;
    }
    // return false if the queue is not empty
    return false;
  }

  private boolean isFull() {
    if (size < tableCapacity) {
      return false;
    }
    return true;
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that were previously added
   * to the queue).
   * 
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is full
   */
  public void add(Guest newGuest) throws IllegalStateException {
    if (isFull()) {
      throw new IllegalStateException("This table is full!");
    } else {
      // finds size of guest array and adds newGuest to the end of the queue
      array[enqueueTo] = newGuest;
      size++;
      // moves next index to the index + 1 of circular array, or back to the front if current index
      // is at the end of the array
      enqueueTo = (enqueueTo + 1) % array.length;
    }



  }

  /**
   * Accessor for the guest that has been in this queue for the longest. This method does not add or
   * remove any guests.
   * 
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest peek() throws IllegalStateException {
    if (isEmpty()) {
      throw new IllegalStateException("There are no guests in the queue!");
    }
    return array[queueFront];
  }

  /**
   * Removes the guest that has been in this queue for the longest.
   * 
   * @return a reference to the specific guest that is being removed.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest remove() throws IllegalStateException {
    if (isEmpty()) {
      throw new IllegalStateException("There are no guests in the queue!");
    }
    // temporary copy of data at this index
    Guest guestToRemove = array[(enqueueTo - size + array.length) % array.length];
    // remove the guestToRemove from the array by setting it to null
    array[(enqueueTo - size + array.length) % array.length] = null;
    // set new front of queue
    queueFront = (enqueueTo - size + array.length) % array.length + 1;
    // Wrap front of queue back to 0 if queueFront is out of the capacity's range
    if (queueFront >= tableCapacity) {
      queueFront = 0;
    }
    size--;
    return guestToRemove;

  }

  /**
   * The string representation of the guests in this queue should display each of the guests in this
   * queue (using their toString() implementation), and should display them in a comma separated
   * list that is surrounded by a set of square brackets. (this is similar to the formatting of
   * java.util.ArrayList.toString()). The order that these guests are presented in should be (from
   * left to right) the guest that has been in this queue the longest, to the guest that has been in
   * this queue the shortest. When called on an empty ServingQueue, returns "[]".
   * 
   * @return string representation of the ordered guests in this queue
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    if (isEmpty()) {
      return "[]";
    }
    String tmp = "[";
    // set starting point
    int tempIndex = queueFront;
    for (int i = 0; i < size; i++) {
      tmp += array[tempIndex].toString();
      tempIndex++;
      if (tempIndex >= tableCapacity) {
        tempIndex = 0;
      }
      if (i < size - 1) {
        // separate by comma until finished looping through list
        tmp += ", ";
      }
    }
    // finish list with "]"
    tmp += "]";
    return tmp;
  }
}
