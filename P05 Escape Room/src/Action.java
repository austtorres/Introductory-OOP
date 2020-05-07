//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P05 Escape Room
// Files: EscapeRoom.java, Action,java, Thing.java, VisibleThing.java, ClickableThing.java,
// DraggableThing.java, DragAndDroppableThing.Java
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
// Persons: Aaron Hernandez (ULC Tutor) - he helped me understand how to properly use PApplet and
// load images
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////



/**
 * This class represents the response to an object being clicked or dragged onto another
 * 
 * @author Austin Torres
 *
 */
public class Action {

  // message printed by this action (or null to do nothing)
  private String message;

  // Action: print out a message
  public Action(String message) {
    this.message = message;
  }

  // when message is not null, message is printed to System.out
  public void act() {
    if (message != null) {
      System.out.println(message);
    }
  }

  public Action(Thing thing) {

  }

  public Action(String message, Thing thing) {

  }

}
