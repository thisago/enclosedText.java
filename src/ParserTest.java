import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class ParserTest {
	@Test
	void Default() {
		Parser parser = new Parser('(', ')'); // default is level 0
		String[] res = parser.get("Hello (simple) World!");
		Assert.assertEquals(1, res.length);
		Assert.assertEquals("simple", res[0]);
		
		res = parser.get("My (ugly) friend drank (too fast) a lot of (very) dirty water...");
		Assert.assertEquals(3, res.length);
		Assert.assertEquals(new String[]{"ugly", "too fast", "very"}, res);
	}
	@Test
	void Levels() {
		Parser parser = new Parser('{', '}', 1);
		String[] res = parser.get("Johnie {ate} a delicious {{food}} at {{location}} yesterday.");
		Assert.assertEquals(2, res.length);
		Assert.assertEquals(new String[]{"food", "location"}, res);
	}
	@Test
	void SameEnclosing() {
		Parser parser = new Parser('*', '*');
		String[] res = parser.get("In markdown, we can write *italic texts*! It's so simple! *Try it yourself!*");
		Assert.assertEquals(2, res.length);
		Assert.assertEquals(new String[]{"italic texts", "Try it yourself!"}, res);
	}
	@Test
	void SameEnclosingLevels() {
		Parser parser = new Parser('*', '*', 1);
		String[] res = parser.get("In markdown, we can write **bold texts**, but it's so hard... **Don't try at home!**");
		Assert.assertEquals(2, res.length);
		Assert.assertEquals(new String[]{"bold texts", "Don't try at home!"}, res);
	}
}
