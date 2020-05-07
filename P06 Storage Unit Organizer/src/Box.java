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

import java.util.Random;

/**
 * This class models a box to be stored in a Storage Unit using the StorageUnitOrganizer
 * application.
 * 
 * @author Austin Torres
 *
 */
public class Box implements Comparable<Box> {


  private static Random randGen = new Random(); // generator of random numbers



  // randomly select an integer between 1 (inclusive) and 31 (exclusive) to represent the weight of
  // a box
  public static int randomWeightRange(int min, int max) {
    return randGen.nextInt(max - min) + min;
  }

  // randomly select an integer to represent a color
  public static int randomColorRange() {
    return randGen.nextInt();
  }

  // color of this box
  private int color;

  // weight of this box in lbs
  private int weight;


  // Creates a new Box with a random color and a random weight. Recall that color can be any integer
  // and the weight must be an integer in the range of 1 inclusive and 31 exclusive.and initializes
  // its instance fields color and weight to
  // random values
  public Box() {
    int maxWeight = 31;
    int minWeight = 1;
    color = randomColorRange();
    weight = randomWeightRange(minWeight, maxWeight);
  }

  // Creates a new Box and initializes its instance fields color and weight to the
  // specified values
  // Throws IllegalArgumentException if the provided weight value is out of the
  // range of [1..30]
  public Box(int color, int weight) throws IllegalArgumentException {
    if (weight < 1 || weight > 30) {
      throw new IllegalArgumentException("Provided input out of range");
    }
    this.color = color;
    this.weight = weight;
  }

  // returns true if the specified other object is a Box and this box and other have the same color
  // and same weight. Otherwise, it returns false
  @Override
  public boolean equals(Object other) {
    if (other instanceof Box) {
      if (((Box) other).getColor() == this.color && ((Box) other).getWeight() == this.weight) {
        return true;
      }
    }
    return false;
  }

  // returns a negative integer, a positive integer, or zero as this box is lighter than, heavier
  // than, or has the same weight as the specified otherBox.
  @Override
  public int compareTo(Box otherBox) {
    return this.weight - (otherBox).getWeight();
  }

  // Getter for the instance field color of this box
  public int getColor() {
    return this.color;
  }

  // Getter for the instance field weight of this box
  public int getWeight() {
    return this.weight;
  }
}
