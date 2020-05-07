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

import java.io.File;
import processing.core.PImage;

/**
 * This class represents a visible object with graphical representation in the Escape Room game
 * 
 * @author Austin Torres
 *
 */
public class VisibleThing extends Thing {
  private PImage image; // the graphical representation of this thing
  private int x; // the horizontal position (in pixels of this thing's left side)
  private int y; // the vertical position (in pixels of this thing's top side)

  // initialize this new thing
  // the image for this visible thing should be loaded from :
  // "images"+File.separator+ name +".png"
  public VisibleThing(String name, int x, int y) {
    super(name);
    this.image = getProcessing().loadImage(("images" + File.separator + name + ".png"));
    this.x = x; // check this
    this.y = y; // check this
  }

  // draws image at its position before returning null
  @Override
  public Action update() {
    getProcessing().image(image, x, y);
    return null;
  }

  // changes x by adding dx to it (and y by dy)
  public void move(int dx, int dy) {
    x = x + dx;
    y = y + dy;
  }

  // return true only when point x,y is over image
  public boolean isOver(int x, int y) {
    int x2 = this.image.width + this.x;
    int y2 = this.image.height + this.y;
    if (x > this.x && x < x2 && y > this.y && y < y2) {
      return true;
    }
    return false;
  }

  // return true only when other's image overlaps this one's
  public boolean isOver(VisibleThing other) {
    if (this.x < other.x + other.image.width && this.x + this.image.width > other.x
        && this.y < other.y + other.image.height && this.y + this.image.height > other.y) {
      return true;
    }
    return false;
  }

}
