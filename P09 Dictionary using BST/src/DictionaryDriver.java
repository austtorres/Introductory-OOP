import java.util.Scanner;

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
 * This class serves as the driver for P09
 * 
 * @author Austin Torres
 *
 */
public class DictionaryDriver {

  /**
   * This is the main method of the driver
   * 
   * @param args
   */

  // implemented methods from DictionaryBST


  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    DictionaryBST dict = new DictionaryBST();
    while (true) {
      String userInput;

      // Create menu after every choice until program has been quit
      printMenu();

      // Case insensitive and trimmed
      userInput = scnr.nextLine().toLowerCase().trim();

      // get rid of white space
      String[] input = userInput.split(" ");

      // Quit application
      if (input[0].equalsIgnoreCase("q")) {
        if (userInput.length() != 1) {
          System.out.println("WARNING: Syntax Error");
        } else {
          break;
        }
      }

      // Size
      else if (input[0].equalsIgnoreCase("s")) {
        if (input.length != 1) {
          System.out.println("WARNING: Syntax Error");
        } else {
          System.out.println(dict.size());
        }
      }

      // Height
      else if (input[0].equalsIgnoreCase("h")) {
        if (input.length != 1) {
          System.out.println("WARNING: Syntax Error");
        } else {
          System.out.println(dict.height());
        }
      }

      // Get all words
      else if (input[0].equalsIgnoreCase("g")) {
        if (input.length != 1) {
          System.out.println("WARNING: Syntax Error");
        } else if (dict.isEmpty()) {
          System.out.println("Dictionary is empty.");
        } else {
          System.out.println(dict.getAllWords());
        }
      }

      // Lookup
      else if (input[0].equalsIgnoreCase("l"))

      {
        if (input.length != 2) {
          System.out.println("WARNING: Syntax Error");
        } else if (dict.isEmpty()) {
          System.out.println("There are no definitions in this empty dictionary");
        } else {
          System.out.println(dict.lookup(input[1]));
        }
      }

      // Add a word
      else if (input[0].equalsIgnoreCase("a")) {
        if (input.length < 3) {
          System.out.println("WARNING: Syntax Error");
        } else {
          String meaning = "";
          for (int i = 2; i < input.length; i++) {
            meaning += input[i] + " ";
          }
          meaning = meaning.trim();
          dict.addWord(input[1], meaning);

        }

      }
    }

  }


  private static void printMenu() {
    String userCommands = "\n=========================== Dictionary ============================\n"
        + "Enter one of the following options:\n"
        + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n"
        + "[L <word>] to search a word in the dictionary and display its definition\n"
        + "[G] to print all the words in the dictionary in sorted order\n"
        + "[S] to get the count of all words in the dictionary\n"
        + "[H] to get the height of this dictionary implemented as a binary search tree\n"
        + "[Q] to quit the program\n"
        + "======================================================================\n";
    System.out.println(userCommands);


  }



}
