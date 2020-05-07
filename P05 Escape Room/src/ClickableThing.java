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
 * This class represents objects that can be interacted with by clicking on them in the Escape Room
 * game
 * 
 * @author Austin Torres
 *
 */
public class ClickableThing extends VisibleThing {

  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

  // initializes this new object
  public ClickableThing(String name, int x, int y, Action action) {
    super(name, x, y);
    this.action = action;
    this.mouseWasPressed = false;
  }

  // calls VisibleThing update, then returns action only when mouse is first clicked
  @Override
  public Action update() {
    super.update();
    if (Thing.getProcessing().mousePressed == true
        && isOver(Thing.getProcessing().mouseX, Thing.getProcessing().mouseY)
        && mouseWasPressed == false) {
      this.mouseWasPressed = true;
      return this.action;
    }
    return null;
  }

}
