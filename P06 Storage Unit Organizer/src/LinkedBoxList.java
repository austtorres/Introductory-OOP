//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Storage Unit Organizer
// Files: Box.java, Button.java, ClearButton.java, DropBoxButton.java, GraphicBox.java,
// LinkedBoxList.java, LinkedBoxNode.java, StorageUnitPrganizer.java, StorageUnitTests.java
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
 * This class models a dynamic list to store box objects sorted in a descendant order with respect
 * to their weights
 * 
 * @author Austin Torres
 *
 */
public class LinkedBoxList {

  // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private LinkedBoxNode head;

  // number of boxes already stored in this list
  private int size;

  // capacity of this LinkedBoxList
  // maximum number of box elements that this LinkedBoxList
  // can store
  private int capacity;

  // Creates an empty LinkedBoxList with a given initial capacity
  public LinkedBoxList(int capacity) {
    size = 0;
    this.capacity = capacity;
    head = null;

  }

  // Returns the size of this list
  public int size() {
    return this.size;
  }

  // Return the capacity of this list
  public int getCapacity() {
    return this.capacity;
  }

  // Expands the capacity of this LinkedBoxList with the specified number a of
  // additional elements
  public void expandCapacity(int a) {
    this.capacity += a;
  }

  // Checks whether this LinkedBoxList is empty
  // returns true if this LinkedBoxList is empty, false otherwise
  public boolean isEmpty() {
    return this.size == 0;
  }

  // Checks whether this LinkedBoxList is full
  // Returns true if this list is full, false otherwise
  public boolean isFull() {
    return this.size == capacity;
  }

  // Adds a new box into this sorted list
  // Throws IllegalArgumentException if newBox is null
  // Throws IllegalStateException if this list is full
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {

    if (newBox == null) {
      throw new IllegalArgumentException("The new box you are trying to add does not exist");
    } else if (isFull()) {
      throw new IllegalStateException("The storage unit is full");
    } else if (head == null) {
      this.head = new LinkedBoxNode(newBox);
      size += 1;
      return;
    }

    // create a previous node for reference
    LinkedBoxNode previous = null;

    // create a new node
    LinkedBoxNode newNode = new LinkedBoxNode(newBox);


    LinkedBoxNode runner = head;

    while (runner != null) {

      // runner is heavier
      if (runner.getBox().compareTo(newBox) >= 0) {
        previous = runner;
        runner = runner.getNext();
      }
      // runner is lighter
      else if (runner.getBox().compareTo(newBox) < 0) {
        if (previous != null) {
          previous.setNext(newNode);
          newNode.setNext(runner);
        } else {
          LinkedBoxNode oldHead = this.head;
          this.head = newNode;
          this.head.setNext(oldHead);

        }
        size += 1;
        return;
      }

    }
    if (previous != null) {
      previous.setNext(newNode);
      size += 1;
    }



  }


  // Checks if this list contains a box that matches with (equals) a specific box object
  // Returns true if this list contains findBox, false otherwise
  public boolean contains(Box findBox) {
    LinkedBoxNode runner = this.head;
    while (runner != null) {
      if (runner.getBox().equals(findBox)) {
        return true;
      }
      runner.setNext(runner.getNext());
    }
    return false;

  }

  // Returns a box stored in this list given its index
  // Throws IndexOutOfBoundsException if index is out of the range 0..size-1
  public Box get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > capacity) {
      throw new IndexOutOfBoundsException("The index you selected does not exist");
    } else {
      LinkedBoxNode runner = head;
      int i = 0;
      while (i < index) {
        runner = runner.getNext();
        i++;
      }
      return runner.getBox();

    }

  }



  // Removes and returns the box stored at index from this LinkedBoxList
  // Throws IndexOutOfBoundsException if index is out of bounds. index should be in
  // the range of [0.. size()-1]
  public Box remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > capacity) {
      throw new IndexOutOfBoundsException("The index you selected does not exist");
      // if trying to remove head
    } else if (index == 0 && head != null) {
      // save old head so that it can be returned
      LinkedBoxNode oldHead = this.head;
      this.head = head.getNext();

      size -= 1;
      return oldHead.getBox();
    }
    // trying to remove any other box between head and end of list
    else if (index > 0 && index < size) {
      LinkedBoxNode previous = head;
      LinkedBoxNode current = previous.getNext();
      int i = 1;
      // move current forward until index is reached and sets previous as the new current
      while (i != index) {
        previous = current;
        current = current.getNext();
        i++;
      }
      // set previous's next to the current box's next before it is removed
      previous.setNext(current.getNext());
      size -= 1;
      return current.getBox();
    }
    // trying to remove last box
    else {
      return null;
    }

  }



  // Removes all the boxes from this list
  public void clear() {
    head = null;
    size = 0;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}
