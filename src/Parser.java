import java.util.ArrayList;
import java.util.List;

public class Parser {
	// Extracts all the first level enclosed text of a string; If not correctly
	// enclosed, returns the error to true
	// Re-implementation of https://git.ozzuu.com/thisago/util/src/branch/master/src/util/forStr.nim#L404
	char open, close;
	int level;
	Parser(char open, char close, int level) {
		this.open = open;
		this.close = close;
		this.level = level;
	}
	Parser(char open, char close) {
		this(open, close, 0);
	}
	public String[] get(String text) {
		String curr = "";
		List<String> result = new ArrayList<String>();
		int currLevel = 0;
		if (this.open != this.close) {
			for(int i = 0, n = text.length() ; i < n ; i++) { 
				char ch = text.charAt(i);
				if (ch == this.open) {
				  currLevel++;
				  if (currLevel < this.level + 2) {
					  curr = "";
					  continue;
				  }
				} else if (ch == this.close) {
					currLevel--;
					if (curr.length() > 0 && currLevel == level) {
						result.add(curr);
						continue;
					}
				}
				curr += ch;
			}			
		} else {
			boolean opened = false;
			for(int i = 0, n = text.length(); i < n ; i++) { 
				char ch = text.charAt(i);
				if (ch == this.open) {
					if (currLevel < this.level + 1)
						currLevel++;
					else
						currLevel--;
					if (curr.length() > 0 && currLevel == this.level) {
						result.add(curr);
						curr = "";
					}
					continue;
				} else {
					if (currLevel < this.level + 1)
						currLevel = 0;
					if (currLevel == this.level + 1)
						curr += ch;
				}
			}
		}
		String[] finalResult = new String[result.size()];
		result.toArray(finalResult);
		
		return finalResult;
	}
}
