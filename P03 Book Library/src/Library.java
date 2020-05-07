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

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Austin
 *
 */
public class Library {

  /**
   * Main method that represents the driver for this application
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
    // create a new library object
    Library madisonLibrary = new Library("Madison, WI", "april", "abc");
    // read and process user command lines
    madisonLibrary.readProcessUserCommand(scanner);
    displayGoodByeLogoutMessage(); // display good bye message
    scanner.close();// close this scanner
  }

  // instance fields
  private String address; // Street address of this library
  private Librarian librarian; // this library's librarian. This library must have only ONE
                               // librarian
  private ArrayList<Book> books; // list of the books in this library
  private ArrayList<Subscriber> subscribers; // list of this library's subscribers

  /**
   * Creates a new Library and initializes all its instance fields. Initially both books and
   * subscribers lists are empty.
   * 
   * @param address           - Address of this Library
   * @param librarianUsername - username of the librarian of this book library
   * @param librarianLogin    - login of the librarian of this book library
   */
  /**
   * @param address
   * @param librarianUsername
   * @param librarianLogin
   */
  public Library(String address, String librarianUsername, String librarianLogin) {
    this.address = address;
    this.librarian = new Librarian(librarianUsername, librarianLogin);
    this.books = new ArrayList<Book>();
    this.subscribers = new ArrayList<Subscriber>();
  }

  /**
   * Reads and processes the user commands with respect to the menu of this application
   * 
   * @param scanner Scanner object used to read the user command lines
   */
  public void readProcessUserCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayMainMenu(); // display the library management system main menu
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
      switch (commands[0].trim().charAt(0)) {
        case '1': // login as librarian commands[1]: password
          if (this.librarian.checkPassword(commands[1])) {
            // read and process librarian commands
            readProcessLibrarianCommand(scanner);
          } else { // error password
            System.out.println("Error: Password incorrect!");
          }
          break;
        case '2': // login as subscriber commands[1]: card bar code
          Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
          if (subscriber != null) {
            if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
              // read and process subscriber commands
              readProcessSubscriberCommand(subscriber, scanner);
            else
              System.out.println("Error: Incorrect PIN.");
          }
          break;
      }
      // read and split next user command line
      displayMainMenu(); // display the library management system main menu
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }
  }



  /**
   * Returns the librarian of this library
   * 
   * @return the librarian
   */
  public Librarian getLibrarian() {
    return this.librarian;
  }

  /**
   * Returns the address of this library
   * 
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Returns a Book given a book identifier if found, and null otherwise. If the book is not found,
   * this method displays the following message: "Error: this book identifier didn't match any of
   * our books identifiers."
   * 
   * @param bookId - identifier of the book to find
   * @return reference to the Book if found and null otherwise
   */
  public Book findBook(int bookId) {
    // Loop through existing book IDs
    for (Book book : this.books) {
      if (book.getID() == bookId) {
        return book;

      }

    }
    // If book ID does not exist, print error message
    System.out.println("Error: this book identifier didn't match any of our books identifiers.");
    return null;

  }

  /**
   * Returns the list of books having a given title in this library. The comparison used by this
   * method is case insensitive
   * 
   * @param title - title of the book(s) to find
   * @return ArrayList of the books having a given title in this library (0 or more books can be
   *         found)
   */
  public ArrayList<Book> findBookByTitle(String title) {
    ArrayList<Book> list = new ArrayList<Book>();
    for (Book book : this.books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        list.add(book);
      }
    }
    return list;
  }

  /**
   * Returns the list of books having a given author. The comparison used by this method is case
   * insensitive
   * 
   * @param author - author of the book(s) to find
   * @return ArrayList of the books having a given author (0 or more books can be found)
   */
  public ArrayList<Book> findBookByAuthor(String author) {
    ArrayList<Book> list = new ArrayList<Book>();
    for (Book book : this.books) {
      if (book.getAuthor().equalsIgnoreCase(author)) {
        list.add(book);
      }
    }
    return list;
  }

  /**
   * Adds a new book to the library (to the books list). This method displays the following message:
   * "Book with Title " + title + " is successfully added to the library."
   * 
   * @param title  - title of the new book
   * @param author - author of the new book
   */
  public void addBook(String title, String author) {
    this.books.add(new Book(title, author));
    System.out.println("Book with Title " + title + " is successfully added to the library.");
  }

  /**
   * Removes a book given its identifier from the library (from books list)
   * 
   * @param bookId - identifier of the book to remove
   * @return a reference to the removed book, and null if the book is not found in this library
   */
  public Book removeBook(int bookId) {
    for (Book book : this.books) {
      if (book.getID() == bookId) {
        this.books.remove(book);
        return book;
      }
    }
    return null;
  }

  /**
   * Adds a new subscriber to this library (to subscribers list). This method displays the following
   * message: "Library card with bar code " + card bar code + " is successfully issued to the new
   * subscriber " + name + "."
   * 
   * @param name        - name of the new subscriber
   * @param pin         - 4-digit personal identifier number of the new subscriber
   * @param address     - address of the new subscriber
   * @param phoneNumber - phone number of the new subscriber
   */
  public void addSubscriber(java.lang.String name, int pin, String address, String phoneNumber) {
    Subscriber added = new Subscriber(name, pin, address, phoneNumber);
    this.subscribers.add(added);
    System.out.println("Library card with bar code " + added.getCARD_BAR_CODE()
        + " is successfully issued to the new subscriber " + added.getName() + ".");
  }

  /**
   * Finds a subscriber given its cardBarCode. This method displayed the following message: "Error:
   * this book identifier didn't match any of our books identifiers." and returns null if the
   * provided cardBarCode did not match with any of the subscribers' card bar codes
   * 
   * @param cardBarCode - of the subscriber to find
   * @return a reference to the subscriber if found, otherwise null
   */
  public Subscriber findSubscriber(int cardBarCode) {
    for (Subscriber sub : this.subscribers) {
      if (sub.getCARD_BAR_CODE() == cardBarCode) {
        return sub;
      }
    }
    System.out.println("Error: this card bar code didn't match any of our records.");
    return null;
  }

  /**
   * Displays a list of books
   * 
   * @param books - ArrayList of books
   */
  public static void displayBooks(ArrayList<Book> books) {
    // Traverse the list of books and display book id, title, author, and availability of each book
    for (int i = 0; i < books.size(); i++) {
      System.out.print("<Book ID>: " + books.get(i).getID() + " ");
      System.out.print("<Title>: " + books.get(i).getTitle() + " ");
      System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
      System.out.println("<Is Available>: " + books.get(i).isAvailable());
    }
  }

  /**
   * Displays the main menu for this book library application
   */
  private static void displayMainMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("     Welcome to our Book Library Management System");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <password>] Login as a librarian");
    System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
    System.out.println("[3] Exit"); // Exit the application
    System.out.println("--------------------------------------------------------");
  }



  /**
   * Displays the menu for the Librarian
   */
  private static void displayLibrarianMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Librarian's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <title> <author>] Add new Book");
    System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
    System.out.println("[3 <card bar code> <book ID>] Check out a Book");
    System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
    System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
    System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
    System.out.println("[7] Display All Books");
    System.out.println("[8 <book ID>] Remove a Book");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Display the Application GoodBye and logout message.
   */
  private static void displayGoodByeLogoutMessage() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("       Thanks for Using our Book Library App!!!!");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Reads and processes the librarian commands according to the librarian menu
   * 
   * @param scanner Scanner object used to read the librarian command lines
   */
  private void readProcessLibrarianCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayLibrarianMenu(); // display the librarian menu
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (commands[0].trim().charAt(0) != '9') { // '9': Logout
      switch (commands[0].trim().charAt(0)) {
        case '1': // Add new book to library
          addBook(commands[1], commands[2]);
          break;
        case '2': // Add subscriber
          addSubscriber(commands[1], Integer.parseInt(commands[2]), commands[3], commands[4]);
          break;

        case '3': // Check out book
          Subscriber subCheckout = findSubscriber(Integer.parseInt(commands[1]));
          Book book = findBook(Integer.parseInt(commands[2]));
          // check that subscriber and book exist
          if (subCheckout != null && book != null) {
            subCheckout.checkoutBook(book);
          }
          break;

        case '4': // Return a Book for a subscriber
          Subscriber subReturn = findSubscriber(Integer.parseInt(commands[1]));
          Book book2 = findBook(Integer.parseInt(commands[2]));
          // check that subscriber and book exist
          if (subReturn != null && book2 != null) {
            subReturn.returnBook(book2);
          }
          break;
        case '5': // Display Personal Info of a Subscriber
          Subscriber subInfo = findSubscriber(Integer.parseInt(commands[1]));
          if (subInfo != null) {
            subInfo.displayPersonalInfo();
          }
          break;
        case '6': // Display Books Checked out by a Subscriber
          Subscriber subCode = findSubscriber(Integer.parseInt(commands[1]));
          if (subCode != null) {
            subCode.displayBooksCheckedOut();
          }
          break;
        case '7': // Display All Books
          displayBooks(this.books);
          break;
        case '8': // Remove a Book
          removeBook(Integer.parseInt(commands[1]));
          break;


      }
      // read and split next user command line
      displayLibrarianMenu(); // display the librarian menu
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }
  }

  /**
   * Displays the menu for a Subscriber
   */
  private static void displaySubscriberMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Subscriber's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <book ID>] Check out a book");
    System.out.println("[2 <book ID>] Return a book");
    System.out.println("[3 <title>] Search a Book by title");
    System.out.println("[4 <author>] Search a Book by author");
    System.out.println("[5] Print list of books checked out");
    System.out.println("[6] Print history of returned books");
    System.out.println("[7 <address>] Update address");
    System.out.println("[8 <phone number>] Update phone number");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Reads and processes the subscriber commands according to the subscriber menu
   * 
   * @param subscriber Current logged in subscriber
   * @param scanner    Scanner object used to read the librarian command lines
   */
  private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayMainMenu(); // display the library management system main menu
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
      switch (commands[0].trim().charAt(0)) {
        case '1': // Check out book
          Book books = findBook(Integer.parseInt(commands[1]));
          if (books != null) {
            subscriber.checkoutBook(books);
          }

          break;
        case '2': // Return a book
          Book books2 = findBook(Integer.parseInt(commands[1]));
          if (books2 != null) {
            subscriber.returnBook(books2);
          }
          break;

        case '3': // Search a Book by title
          displayBooks(findBookByTitle(commands[1]));
          break;

        case '4': // Search a Book by author
          displayBooks(findBookByAuthor(commands[1]));
          break;
        case '5': // Print list of books checked out
          subscriber.displayBooksCheckedOut();
          break;
        case '6': // Print history of returned books
          subscriber.displayHistoryBooksReturned();
          break;
        case '7': // Update address
          subscriber.setAddress(commands[1]);
          break;
        case '8': // Update phone number
          subscriber.setPhoneNumber(commands[2]);
          break;


      }
      // read and split next user command line
      displayLibrarianMenu(); // display the librarian menu
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }
  }
}
