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
 * This class should define and implement the following instance public and private static methods
 * with exactly the following signatures.
 * 
 * Note that duplicate words are NOT allowed. addWord() method defined in the Dictionary interface
 * MUST return false if is called with word input parameter that has a match in the stored
 * dictionary words.
 * 
 * We note also that the private helper methods defined in the following MUST be recursive. Each
 * public method should make call to the recursive helper method with the corresponding name to
 * operate. No additional fields or public methods (either instance or static) should be added to
 * this class.
 * 
 * It is also worth to highlight that all the comparisons that may be made in this assignments to
 * compare Strings (either words or their corresponding meanings) should be CASE INSENSITIVE.
 * 
 * The height() method returns the height of the dictionaryBST counting the number of nodes and NOT
 * the number of edges from the root to the deepest leaf.
 * 
 * @author Austin Torres
 *
 */

import java.util.NoSuchElementException;
import java.util.ArrayList;

public class DictionaryBST implements Dictionary {

  private DictionaryWord root; // root of the BST

  // This should be the only constructor of this class.
  // Creates an empty dictionaryBST.
  public DictionaryBST() {
    root = null;
  }

  // Methods defined in the Dictionary interface
  public boolean isEmpty() {
    return root == null;
  }

  public boolean addWord(String word, String meaning) {
    // tree is empty
    if (isEmpty()) {
      DictionaryWord newWord = new DictionaryWord(word, meaning);
      root = newWord;
    } else {
      return addWordHelper(new DictionaryWord(word, meaning), root);
    }
    return true;
  }

  // Returns the meaning of the word s if it is present in this dictionary
  // Throws a NoSuchElementException if the word s was not found in this dictionary
  public String lookup(String s) {
    return lookupHelper(s, root);

  }

  // Returns the number of words stored in this dictionary
  public int size() {
    return (isEmpty() ? 0 : sizeHelper(root));
  }

  // Public methods not defined in the Dictionary interface
  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    if (isEmpty()) {
      return 0;
    } else {
      return heightHelper(root);
    }
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {
    if (isEmpty()) {
      return new ArrayList<String>();
    } else {
      return getAllWordsHelper(root);
    }
  }

  // Recursive private helper methods
  // Each public method should make call to the recursive helper method with the
  // corresponding name

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
    // If new word should be a left child
    if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
      // If no left child exists
      if (current.getLeftChild() == null) {
        current.setLeftChild(newWordNode);
      }
      // traverse recursively
      else {
        return addWordHelper(newWordNode, current.getLeftChild());
      }
      return true;
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) {
      if (current.getRightChild() == null) {
        current.setRightChild(newWordNode);
      }
      // traverse recursively
      else {
        return addWordHelper(newWordNode, current.getRightChild());
      }
      return true;
    }
    // if word already exists
    return false;


  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current)
      throws NoSuchElementException {
    if (current == null) {
      throw new NoSuchElementException("No definition found for the word " + s);
    }
    // go left if desired word is less than current word
    else if (s.compareToIgnoreCase(current.getWord()) < 0) {
      return lookupHelper(s, current.getLeftChild());
    }
    // go right if desired word is greater than current word
    else if (s.compareToIgnoreCase(current.getWord()) > 0) {
      return lookupHelper(s, current.getRightChild());
    }
    return current.getMeaning(); // once word has been found
  }


  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null) {
      return 0;
    }
    // count the nodes in the tree
    return sizeHelper(current.getLeftChild()) + sizeHelper(current.getRightChild()) + 1;
  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    // Check height of left and right trees by traversing recursively down left and right paths
    if (current == null) {
      return 0;
    } else {
      return Math.max(heightHelper(current.getLeftChild()), heightHelper(current.getRightChild()))
          + 1;
    }

    // choose higher subtree
    // if (leftHeight > rightHeight) {
    // return (leftHeight + 1);
    // } else
    // return rightHeight + 1;
    // }

  }



  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    ArrayList<String> wordArray = new ArrayList<>();
    // in order traversal
    if (current.getLeftChild() != null) {
      // add everything in left subtree
      wordArray.addAll(getAllWordsHelper(current.getLeftChild()));
    }
    // add root
    wordArray.add(current.getWord());

    if (current.getRightChild() != null) {
      wordArray.addAll(getAllWordsHelper(current.getRightChild()));
    }
    return wordArray;
  }
}
