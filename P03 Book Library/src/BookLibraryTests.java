//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Book Library
// Files: Book.java, Subscriber.java, Librarian.java, Library.java,
// BookLibraryTests.java
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
 * Test libary management system functions
 * 
 * @author Austin
 *
 */
public class BookLibraryTests {



  /**
   * checks whether the constructor of the Book class initializes correctly the new Book instance
   * fields: title, author, borrowerCardBarCode, ID, and increments nextID static field
   * 
   * @return true if test passes, false if test fails
   */
  public static boolean testBookConstructorGetters() {
    Book book = new Book("title", "author");
    boolean title = !book.getTitle().equals("title");
    boolean author = !book.getAuthor().equals("author");
    boolean barCode = !book.getBorrowerCardBarCode().equals("null");
    return false;
    
  }



  /**
   * checks whether returnBook() method defined within your Book class sets correctly the instance
   * field borrowerCardBarCode. A Book must be available after this instance method is called.
   * 
   * @return true if test passes, false if test fails
   */
  public static boolean testBookReturnBook() {
    return true;
  }

  /**
   * checks the good functioning of findBookByAuthor(String) method defined in the Library class
   * 
   * @return true if test passes, false if test fails
   */
  public static boolean testLibraryFindBookByAuthor() {
    return true;
  }

  /**
   * checks whether the checkoutBook() method defined within the Subscriber class works correctly
   * 
   * @return true if test passes, false if test fails
   */
  public static boolean testSubscriberCheckoutBook() {
    return true;

  }

  public static boolean testFindSubscriber() {
    return true;

  }
}
