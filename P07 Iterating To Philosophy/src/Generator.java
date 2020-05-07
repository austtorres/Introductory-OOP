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
 * This class is capable of generating finite and infinite sequences of values by generating
 * iterators
 * 
 * @author Austin Torres
 *
 * @param <T>
 */
public class Generator<T extends Comparable<T>> implements Iterable<T> {


  private Integer length;
  private Function<T, T> function;
  private T first;
  private InfiniteIterator<T> infinite;
  private FiniteIterator<T> finite;

  /**
   * Making use of this method returns a new InfiniteIterator that makes use of the provided
   * firstValue and generateNextFromLast
   * 
   * @param firstValue
   * @param generateNextFromLast
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast) {
    this.first = firstValue;
    this.function = generateNextFromLast;
  }

  /**
   * Using this method creates and returns a new FiniteIterator using the specified length
   * 
   * @param firstValue
   * @param generateNextFromLast
   * @param length
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
    this.first = firstValue;
    this.function = generateNextFromLast;
    this.length = length;
  }

  /**
   * New Iterator that first confirms that finite is not null, and then returns finite or infinite
   * depending on the length
   */
  public Iterator<T> iterator() {
    if (finite != null) {
      return finite;
    }
    if (this.length != null) {
      infinite = new InfiniteIterator<T>(first, function);
      finite = new FiniteIterator<T>(infinite, length);
      return finite;
    } else {
      infinite = new InfiniteIterator<T>(first, function);
      return infinite;
    }
  }


}
