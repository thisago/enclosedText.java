# Enclosed Text (Java)

This is an re-implementation of my [`util.enclosedText`](https://git.ozzuu.com/thisago/util/src/branch/master/src/util/forStr.nim#L404) using Nim, but now in Java!

## Examples

[**Default**](src/ParserTest.java#L9)
```java
Parser parser = new Parser('(', ')'); // default is level 0
String[] res = parser.get("Hello (simple) World!");
Assert.assertEquals(1, res.length);
Assert.assertEquals("simple", res[0]);

res = parser.get("My (ugly) friend drank (too fast) a lot of (very) dirty water...");
Assert.assertEquals(3, res.length);
Assert.assertEquals(new String[]{"ugly", "too fast", "very"}, res);
```
[**Levels**](src/ParserTest.java#L20)
```java
Parser parser = new Parser('{', '}', 1);
String[] res = parser.get("Johnie {ate} a delicious {{food}} at {{location}} yesterday.");
Assert.assertEquals(2, res.length);
Assert.assertEquals(new String[]{"food", "location"}, res);
```
[**SameEnclosing**](src/ParserTest.java#L27)
```java
Parser parser = new Parser('*', '*');
String[] res = parser.get("In markdown, we can write *italic texts*! It's so simple! *Try it yourself!*");
Assert.assertEquals(2, res.length);
Assert.assertEquals(new String[]{"italic texts", "Try it yourself!"}, res);
```
[**SameEnclosingLevels**](src/ParserTest.java#L34)
```java
Parser parser = new Parser('*', '*', 1);
String[] res = parser.get("In markdown, we can write **bold texts**, but it's so hard... **Don't try at home!**");
Assert.assertEquals(2, res.length);
Assert.assertEquals(new String[]{"bold texts", "Don't try at home!"}, res);
```


## License

MIT
