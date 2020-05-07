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
 * Creates support tickets and implements functionality
 * 
 * @author Austin Torres
 *
 */
public class SupportTicket implements Comparable<SupportTicket> {

  // Message returned by SupportTicket
  private String supportTicketMessage;

  /**
   * the natural ordering of support tickets corresponds to the length of the message inside them:
   * longer messages should be considered later in this natural ordering (aka larger)
   * 
   **/
  @Override
  public int compareTo(SupportTicket arg0) {
    // If strings match, compare directly
    if (this.supportTicketMessage.length() == arg0.toString().length()) {
      // compared by CompareTo method to return comparison
      return supportTicketMessage.compareTo(arg0.toString());
      // if lengths do not match
    } else if (this.supportTicketMessage.length() > arg0.toString().length()) {
      return 1;
    } else
      return -1;
  }


  /**
   * constructor that takes a String message in as input, and stores that string within an instance
   * field
   * 
   * @param supportTicketInput
   * @throws NullPointerException
   */
  public SupportTicket(String supportTicketInput) throws NullPointerException {
    if (supportTicketInput == null) {
      throw new NullPointerException("WARNING: input is null");
    } else {
      this.supportTicketMessage = supportTicketInput;
    }
  }

  /**
   * converts to string and returns supportTicketMessage
   **/
  public String toString() {
    return this.supportTicketMessage;
  }

  public static void main(String[] args) {
    SupportTicket test1 = new SupportTicket("AAA");
    SupportTicket test2 = new SupportTicket("AAA");
    System.out.println(test1.compareTo(test2));
  }
}
