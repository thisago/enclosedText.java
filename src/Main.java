import java.util.Iterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Inform the enclosing (Default: '()'):");
    String enclosing = sc.nextLine();
    if (enclosing.length() == 0)
      enclosing = "()";
    Parser parser = new Parser(enclosing.charAt(0), enclosing.charAt(1));

    System.out.println("Type you string:");
    String[] result = parser.get(sc.nextLine());
    System.out.println("Found " + result.length + " enclosing texts:");

    for (String item : result)
      System.out.println("\t" + item);
  }
}
