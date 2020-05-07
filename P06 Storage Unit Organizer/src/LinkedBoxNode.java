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
 * This class models a linked node in the Storage Unit Organizer app
 * 
 * @author Austin Torres
 *
 */
public class LinkedBoxNode {

  private Box box; // box that represents the data for this Linked node

  private LinkedBoxNode next; // reference to the next Linked Box Node

  // constructors
  //
  // creates a new LinkedBoxNode object with a given
  // box and without referring to any next LinkedBoxNode
  public LinkedBoxNode(Box box) {
    this.box = box;
    this.next = null;
  }

  // creates a new LinkedBoxNode
  // object and sets its instance fields box and next to the specified ones
  public LinkedBoxNode(Box box, LinkedBoxNode next) {
    this.box = box;
    this.next = next;
  }

  // getters and setters methods
  //
  public LinkedBoxNode getNext() {
    return this.next;
  }

  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  public Box getBox() {
    return this.box;
  }

  public void setBox(Box box) {
    this.box = box;
  }
}
