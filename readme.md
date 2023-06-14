# Enclosed Text (Java)

This is an re-implementation of my [`util.enclosedText`](https://git.ozzuu.com/thisago/util/src/branch/master/src/util/forStr.nim#L404) using Nim, but now in Java!

## Examples

```java
Parser parser = new Parser('(', ')');
String[] res = parser.get("My (ugly) friend drank (too fast) a lot of (very) dirty water...");
Assert.assertEquals(3, res.length);
Assert.assertEquals(new String[]{"ugly", "too fast", "very"}, res);
```

## License

MIT
