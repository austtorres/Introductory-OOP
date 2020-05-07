import java.text.ParseException;

public class ExceptionalBookLibraryTests {
  public static boolean testLibraryParseCardBarCode() {
    boolean tester = false;
    try {
      ExceptionalLibrary lib = new ExceptionalLibrary("Kenosha", "Professor", "2019");
      if (lib.parsePinCode("2019", 5) == 2019) {
        tester = true;
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return tester;
  }


  public static boolean testLibraryParseRunLibrarianCheckoutBookCommand() {
    boolean tester = false;
    String[] check = new String[] {"2019000001", "1"};
    ExceptionalLibrary lib = new ExceptionalLibrary("Kenosha", "Professor", "2019");
    lib.addBook("testTitle", "testAuthor");
    try {
      lib.parseRunLibrarianCheckoutBookCommand(check);
    } catch (ParseException e) {
      return !tester;
    }
    return tester;
  }

  public static boolean testLibraryParseRunSubscriberReturnBookCommand() {
    boolean tester = false;
    String[] check = new String[] {"2019000001", "1"};
    ExceptionalLibrary lib = new ExceptionalLibrary("Kenosha", "Professor", "2019");
    lib.addBook("testTitle", "testAuthor");
    try {
      lib.parseRunLibrarianReturnBookCommand(check);
    } catch (ParseException e) {
      return !tester;
    }
    return tester;
  }

  // TODO test

  // TODO test

}
