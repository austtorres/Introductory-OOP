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
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * The generic FiniteIterator class implements the Iterator interface to retrieve a fixed number of
 * elements from any InfiniteIterator
 * 
 * @author Austin Torres
 *
 * @param <T> type of input
 */
public class FiniteIterator<T extends Comparable<T>> implements Iterator<T> {

  // New ints and iterator
  private int length;
  InfiniteIterator<T> testInfinite;
  private int caller = 0;

  /**
   * Constructor for FiniteIterator
   * 
   * @param infiniteIt
   * @param length
   */
  public FiniteIterator(InfiniteIterator<T> infiniteIt, int length) {
    this.testInfinite = infiniteIt;
    this.length = length;
  }

  /**
   * After the first "length" calls of the FiniteIterator’s next() method have been made, it's
   * hasNext() method should begin returning false instead of true
   * 
   * @Return true unless the sequence has reached the specified length
   */
  @Override
  public boolean hasNext() {
    if (caller < length) {
      return true;
    }
    return false;
  }

  /**
   * Return the value returned from a call to the provided InfiniteIterator's next() method.
   * 
   * @Return the value
   */
  @Override
  public T next() {
    if (caller == length) {
      return null;
    }
    caller++;
    T returned = testInfinite.next();
    return returned;
  }

}
