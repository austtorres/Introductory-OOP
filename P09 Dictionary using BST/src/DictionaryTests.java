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
 * This class contains tests to assess the functionality of the methods written in P09. These test
 * methods must be public, static, and return a boolean evaluated to true if an implementation
 * passes the test and false otherwise
 * 
 * @author Austin Torres
 *
 */
/**
 * @author aus10
 *
 */
public class DictionaryTests {


  private static DictionaryBST testDictionary;

  /**
   * Main method to run the tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    testIsEmptyOnEmpty();
    testIsEmptyOnNotEmpty();
    testAddWord();
    testSize();
    testLookup();
  }


  /**
   * Test the functionality of the isEmpty() method when the dictionary is empty
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testIsEmptyOnEmpty() {
    DictionaryBST testDictionary = new DictionaryBST();
    if (testDictionary.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test the functionality of the isEmpty() method when the dictionary is not empty
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testIsEmptyOnNotEmpty() {
    DictionaryBST testDictionary = new DictionaryBST();
    testDictionary.addWord("word", "meaning");
    if (testDictionary.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }



  /**
   * Test the functionality of the addWord() method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testAddWord() {
    DictionaryBST testDictionary = new DictionaryBST();
    testDictionary.addWord("word", "meaning");
    if (!testDictionary.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Test the functionality of the size() method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testSize() {
    DictionaryBST testDictionary = new DictionaryBST();
    testDictionary.addWord("word", "meaning");
    testDictionary.addWord("word2", "meaning2");
    testDictionary.addWord("word3", "meaning3");
    if (testDictionary.size() != 3) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Test the functionality of the lookup() method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean testLookup() {
    DictionaryBST testDictionary = new DictionaryBST();
    testDictionary.addWord("word", "meaning");
    testDictionary.addWord("word2", "meaning2");
    testDictionary.addWord("word3", "meaning3");
    if (testDictionary.lookup("word3") != "meaning 3") {
      return false;
    } else {
      return true;
    }
  }

}
