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
 * @author Austin Torres
 *
 */
public class DraggableThing extends VisibleThing {

  // similar to use in ClickableThing
  private boolean mouseWasPressed;

  // true when this object is being dragged by the user
  private boolean isDragging;

  // horizontal position of mouse during last update
  private int oldMouseX;

  // vertical position of mouse during last update
  private int oldMouseY;

  // initialize new thing
  public DraggableThing(String name, int x, int y) {
    super(name, x, y);


  }

  // calls VisibleThing update(), then moves according to mouse drag
  // each time isDragging changes from true to false, the drop() method below will be called once
  // and any action objects returned from that method should then be returned from update()
  @Override
  public Action update() {
    super.update();

    // update when DraggableThing is clicked
    if (getProcessing().mousePressed && !mouseWasPressed
        && super.isOver(getProcessing().mouseX, getProcessing().mouseY)) {
      oldMouseX = getProcessing().mouseX;
      oldMouseY = getProcessing().mouseY;

      isDragging = true;
      mouseWasPressed = true;
    }
    // update when mouse is clicked
    else if (getProcessing().mousePressed) {
      mouseWasPressed = true;
    } else {
      mouseWasPressed = false;
      isDragging = false;
      return drop();
    }
    // move DraggableThing when mouse is pressed over it and dragged
    if (isDragging) {
      super.move(getProcessing().mouseX - oldMouseX, getProcessing().mouseY - oldMouseY);
      oldMouseX = getProcessing().mouseX;
      oldMouseY = getProcessing().mouseY;
    }
    return null;
  }

  // this method returns null
  // subclass types will override this drop() method to do more interesting things
  protected Action drop() {
    return null;
  }

}
