//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P09 Dictionary Using BST
// Files: DictionaryTests.java, Dictionary.java, DictionaryWord.java, DictionaryBST.java,
// DictionaryDriver.java
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

/**
 * This interface models and abstract data type for a dictionary
 * 
 * @author Austin Torres
 *
 */
public interface Dictionary {

  // checks whether the dictionary is empty or not
  public boolean isEmpty();

  // adds this word definition (word and the provided meaning) to the dictionary
  // Returns true if the word was successfully added to this dictionary
  // Returns false if the word was already in the dictionary
  // Throws IllegalArgumentException if either word or meaning is null or an empty
  // String
  public boolean addWord(String word, String meaning);

  // Returns the meaning of the word s if it is present in this dictionary
  // Throws a NoSuchElementException if the word s was not found in this dictionary
  public String lookup(String s);

  // Returns the number of words stored in this dictionary
  public int size();
}
