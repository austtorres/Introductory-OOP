//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Iterating to Philosophy
// Files: TestDriver.java, EvenNumbers.java, InfiniteIterator.java, FiniteIterator.java,
// Generator.java, NextWikiLink.java
// Course: CS300 Spring 2019
//
// Author: Austin Torres
// Email: artorres3@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
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
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////import
//////////////////// java.util.Iterator;
import java.util.Iterator;

/**
 * Generates a sequence of even numbers started a specified starting point
 * 
 * @author Austin Torres
 *
 */
public class EvenNumbers implements Iterator<Integer> {
  private Integer evenNum;


  /**
   * The constructor for this class should take a single Integer parameter as input, and this
   * Integer should be returned from that EvenNumber object’s next() method on the first time that
   * it is called.
   * 
   * @param startEvenNumber
   */
  public EvenNumbers(Integer startEvenNumber) {
    evenNum = startEvenNumber;
  }


  /**
   * Returns the startEvenNumber the first time next() is called. Each subsequent call of the next()
   * method should return the smallest even number that is larger than the previously returned one.
   * This should continue for as many times as the next() method may be called
   *
   * @return the next numToReturn
   */
  public Integer next() {
    Integer numToReturn = evenNum;
    evenNum = evenNum + 2;
    return numToReturn;
  }

  /**
   * Always returns true as there is always a next even number that can be called.
   * 
   * @return true always
   */
  public boolean hasNext() {
    return true;
  }
}
