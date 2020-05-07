//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Help Desk
// Files: HelpDesk.java, SupportTicket.java, HelpDeskTestSuite.java, HelpDeskInterface.java
//
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
 * Test suite for HelpDesk.java
 * 
 * @author Austin Torres
 *
 */
public class HelpDeskTestSuite extends HelpDesk {

  public HelpDeskTestSuite(int capacity) {
    super(capacity);

  }



  public static void main(String[] args) {
    System.out.println("checkNextTicket is functional? " + checkNextTicketTest());
    System.out.println("closeNextTicket is funcional? " + closeNextTicketTest());
    System.out.println("parentOf is functional? " + parentOfTest());
    System.out.println("leftChildOf is functional? " + leftChildOfTest());
    System.out.println("rightChildOf is functional? " + rightChildOfTest());
    System.out.println("Can remove single element? " + removeSingleElementTest());
    System.out.println("swap is functional? " + swapTest());
    System.out.println("propagateUp is functional? " + propagateUpTest());
  }



  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean checkNextTicketTest() {
    HelpDesk test = new HelpDesk(10);
    try {
      test.checkNextTicket();
      return false;
    } catch (IllegalStateException e) {
    } catch (Exception anyOther) {
      return false;
    }
    // create new tickets
    test.createNewTicket("Z");
    test.createNewTicket("a");
    test.createNewTicket("A");
    test.createNewTicket("Y");
    test.createNewTicket("ab");

    if (test.checkNextTicket().equals("ab")) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean closeNextTicketTest() {
    HelpDesk test = new HelpDesk(10);
    try {
      test.closeNextTicket();
      return false;
    } catch (IllegalStateException e) {
    } catch (Exception anyOther) {
      return false;
    }

    // create new tickets
    test.createNewTicket("Z");
    test.createNewTicket("a");
    test.createNewTicket("A");
    test.createNewTicket("Y");
    test.createNewTicket("ab");


    if (test.closeNextTicket().equals("ab") && test.checkNextTicket().equals("a")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean parentOfTest() {
    HelpDesk test = new HelpDesk(10);
    // create new tickets
    test.createNewTicket("Z");
    test.createNewTicket("a");
    test.createNewTicket("A");
    test.createNewTicket("Y");
    test.createNewTicket("ab");

    if (parentOf(3) == (3 - 1) / 2) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean leftChildOfTest() {
    HelpDesk test = new HelpDesk(10);
    // create new tickets
    test.createNewTicket("Z");
    test.createNewTicket("a");
    test.createNewTicket("A");
    test.createNewTicket("Y");
    test.createNewTicket("ab");

    if (leftChildOf(2) == 2 * 2 + 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean rightChildOfTest() {
    HelpDesk test = new HelpDesk(10);
    // create new tickets
    test.createNewTicket("Z");
    test.createNewTicket("a");
    test.createNewTicket("A");
    test.createNewTicket("Y");
    test.createNewTicket("ab");

    if (rightChildOf(1) == 1 * 2 + 2) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean removeSingleElementTest() {
    HelpDesk test = new HelpDesk(10);
    test.createNewTicket("Z");
    if (test.closeNextTicket() == "Z" && test.size == 0) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean swapTest() {
    HelpDesk test = new HelpDesk(10);
    // create new tickets
    test.array[0] = new SupportTicket("Z");
    test.array[1] = new SupportTicket("a");

    test.swap(0, 1);
    if (test.array[0].toString().equals("a") && test.array[1].toString().equals("Z")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test functionality of described method
   * 
   * @return true if test passes, false otherwise
   */
  public static boolean propagateUpTest() {
    HelpDesk test = new HelpDesk(10);
    // create new tickets
    test.array[0] = new SupportTicket("Z");
    test.array[1] = new SupportTicket("a");

    test.propagateUp(1);

    if (test.array[0].toString().equals("a") && test.array[1].toString().equals("Z")) {
      return true;
    } else {
      return false;
    }

  }

}
