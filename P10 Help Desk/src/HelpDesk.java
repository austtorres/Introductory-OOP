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
 * Main HelpDesk class
 * 
 * @author Austin Torres
 *
 */
public class HelpDesk implements HelpDeskInterface {

  protected SupportTicket[] array; // zero-indexed max-heap
  protected int size;



  /**
   * constructor that takes the internal array capacity as an int parameter. This capacity is fixed,
   * and does not need to grow when filled
   * 
   * @param capacity
   */
  public HelpDesk(int capacity) {
    this.array = new SupportTicket[capacity];
  }


  /**
   * @see HelpDeskInterface#createNewTicket(java.lang.String)
   */
  @Override
  public void createNewTicket(String message)
      throws NullPointerException, IndexOutOfBoundsException {
    if (message == null) {
      throw new NullPointerException("WARNING: message is null");
    } else if (size == this.array.length) {
      throw new IndexOutOfBoundsException("WARNING: capacity reached");
    } else {
      // create new support ticket
      SupportTicket newTicket = new SupportTicket(message);
      // add ticket to help desk
      this.array[size] = newTicket;
      // reorder heap to correct order by comparing size to parents
      propagateUp(size);
      // increment size until at capacity
      size++;
    }

  }

  /**
   * @see HelpDeskInterface#checkNextTicket()
   */
  @Override
  public String checkNextTicket() throws IllegalStateException {
    if (size == 0) {
      throw new IllegalStateException("WARNING: Array is empty");
    } else
      // find and return string representation of root
      return this.array[0].toString();
  }

  /**
   * @see HelpDeskInterface#closeNextTicket()
   */
  @Override
  public String closeNextTicket() throws IllegalStateException {
    if (size == 0) {
      throw new IllegalStateException("WARNING: array is already empty");
    } else {
      SupportTicket temp = this.array[0];
      // set root as bottom child
      this.array[0] = this.array[size - 1];
      this.array[size - 1] = null;
      size--;
      // recursively call propagateDown to reorder heap
      propagateDown(0);
      return temp.toString();
    }
  }


  /**
   * Given an index into the heap array, this method returns that index's parent index
   * 
   * @param index
   * @return index's parent index
   */
  protected static int parentOf(int index) {
    return (index - 1) / 2;
  }

  /**
   * Given an index into the heap array, this method returns that index's right left index
   * 
   * @param index
   * @return left child
   */
  protected static int leftChildOf(int index) {
    return index * 2 + 1;
  }

  /**
   * Given an index into the heap array, this method returns that index's right child index
   * 
   * @param index
   * @return right child
   */
  protected static int rightChildOf(int index) {
    return index * 2 + 2;
  }

  /**
   * Given two indexes into the heap array, this method swaps the SupportTickets at those indexes
   * 
   * @param indexA
   * @param indexB
   */
  protected void swap(int indexA, int indexB) {
    // temporarily save indexA
    SupportTicket temp = this.array[indexA];
    // swap A with B
    this.array[indexA] = this.array[indexB];
    // Swap saved A into B
    this.array[indexB] = temp;
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets necessary
   * to enforce the heap's order property between this index and the heap's root.
   * 
   * @param index
   */
  protected void propagateUp(int index) {
    // prevent invalid index
    if (index > 0 && this.array[index].compareTo(this.array[parentOf(index)]) > 0) {
      // swap into correct order
      swap(index, parentOf(index));
      // run recursively until index is 0 (root is reached)
      propagateUp(parentOf(index));
    }
  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets necessary
   * to enforce the heap's order property between this index and it's children
   * 
   * @param index
   */
  protected void propagateDown(int index) {

    // keep propagating until leaves are reached

    if (index < size) {
      int leftChild = leftChildOf(index);
      int rightChild = rightChildOf(index);

      // make sure children exist in range and are not null
      if (leftChild < size && rightChild < size && this.array[rightChild] != null
          && this.array[leftChild] != null) {

        // find larger child to compare to parent

        // if right child is larger than left child or equal
        // goes down the right edge if children are equal
        if (this.array[leftChild].compareTo(this.array[rightChild]) <= 0) {
          if (this.array[index].compareTo(this.array[rightChild]) < 0) {
            // swap larger right child with parent
            swap(index, rightChild);

            // recursively propagate down heap
            propagateDown(rightChild);
          }
        }

        // if left child is larger than right child
        else if (this.array[leftChild].compareTo(this.array[rightChild]) > 0) {
          if (this.array[index].compareTo(this.array[leftChild]) < 0) {

            // swap larger left child with parent
            swap(index, leftChild);

            // recursively propagate down heap
            propagateDown(leftChild);
          }
        }
      }
      // if only one child exists
      else if (leftChild < size && this.array[leftChild] != null) {
        if (this.array[index].compareTo(this.array[leftChild]) < 0) {
          // swap larger left child with parent
          swap(index, leftChild);

          // recursively propagate down heap
          propagateDown(leftChild);
        }
      }
      // if no children exist
      else {
        return;
      }
    }
  }
}
