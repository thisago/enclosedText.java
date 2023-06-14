import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		Parser parser = new Parser('(', ')');
		
		String[] result = parser.get("Hello (simple) World!");
		System.out.println(result.length);
		
		for (String item : result) {
			System.out.println("\t" + item);			
		}
	}
}
