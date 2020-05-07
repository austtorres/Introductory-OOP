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

import processing.core.PApplet;

/**
 * This class organizes the capabilities that are common to all interactive things in the Escape
 * Room game
 * 
 * @author Austin Torres
 *
 */
public class Thing {
  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with

  // initialize name, and set isActive to true
  public Thing(String name) {
    this.NAME = name;
    this.isActive = true;
  }

  // returns true only when contents of name equal NAME
  public boolean hasName(String name) {
    if (name.equals(NAME))
      return true;
    else
      return false;
  }

  // returns true only when isActive is true
  public boolean isActive() {
    if (isActive == true)
      return true;
    else
      return false;
  }



  // changes isActive to true
  public void activate() {
    this.isActive = true;
  }

  // changes isActive to false
  public void deactivate() {
    this.isActive = false;
  }

  // this method returns null
  // subclass types will override this update() method to do more interesting things
  public Action update() {
    return null;
  }

  private static PApplet processing = null;

  // initializes processing field
  public static void setProcessing(PApplet processing) {
    Thing.processing = processing;

  }

  // accessor method to retrieve this static field
  protected static PApplet getProcessing() {
    return processing;
  }
}
