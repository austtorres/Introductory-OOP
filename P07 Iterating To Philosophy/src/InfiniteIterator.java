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
import java.util.function.Function;

/**
 * Instead of only returning sequences of even numbers, this class generates any sequence in which
 * the next term in the sequence can be calculated based on the previous term.
 * 
 * @author Austin Torres
 *
 */
public class InfiniteIterator<T extends Comparable<T>> implements Iterator<T> {

  private T startInfinite;
  private Function<T, T> function;

  /**
   * This constructor operates similarly to the constructor in EvenNumbers.java, but is able to take
   * a second parameter of generic type Function<T,T>, and then use that object to generate the next
   * value that this iterator returns.
   * 
   * @param startInfinite
   * @param nextPowerOfTwo
   */
  public InfiniteIterator(T startInfinite, Function<T, T> function) {
    this.startInfinite = startInfinite;
    this.function = function;
  }

  /**
   * Applies function and returns result
   *
   * @return next value of sequence
   */
  public T next() {
    T temp = startInfinite;
    startInfinite = function.apply(startInfinite);
    return temp;

  }

  /**
   * Always returns true since the function can always keep being applied to the generic value type
   * 
   * @return true always
   */
  public boolean hasNext() {
    return true;
  }


}


