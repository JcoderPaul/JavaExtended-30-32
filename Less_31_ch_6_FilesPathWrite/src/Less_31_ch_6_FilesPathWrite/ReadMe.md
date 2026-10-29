- [Files.write()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#write-java.nio.file.Path-byte:A-java.nio.file.OpenOption...-)

### Метод Files.write()

**Синтаксис:**

- `public static Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption) throws IOException`
- `public static Path write(Path path, Iterable<? extends CharSequence> lines, OpenOption... options) throws IOException`

Где входные параметры:
- **path** - путь к файлу;
- **lines** - объект для перебора последовательностей символов;
- **cs** - кодировка, используемая для кодирования;

Во втором случае, по умолчанию, символы кодируются в байты с помощью расширения - UTF-8 charset, как если бы мы применили: 
`Files.write(path, lines, StandardCharsets.UTF_8, options);`

- **options** - параметры, определяющие способ открытия файла.

Пример применения:

```java
  Path path = ...
  byte[] bytes = ...
  Files.write(path, bytes, StandardOpenOption.APPEND);
```

Методы возвращает: [Path](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html)

**Возможные исключения:**
- [IOException](https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html) - если возникает ошибка ввода-вывода при записи или создании файла;
- [UnsupportedOperationException](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html) - если указан неподдерживаемый вариант;
- [SecurityException](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityException.html) - в случае провайдера по умолчанию и установленного менеджера безопасности [checkWrite](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityManager.html#checkWrite-java.lang.String-) метод вызывается для проверки доступа на запись к файлу.

Записывает байты в файл. Параметр options указывает, как файл создается или открывается. Если параметры отсутствуют, этот метод работает так, 
как если бы присутствовали параметры: [CREATE](https://docs.oracle.com/javase/8/docs/api/java/nio/file/StandardOpenOption.html#CREATE), [TRUNCATE_EXISTING](https://docs.oracle.com/javase/8/docs/api/java/nio/file/StandardOpenOption.html#TRUNCATE_EXISTING) или [WRITE](https://docs.oracle.com/javase/8/docs/api/java/nio/file/StandardOpenOption.html#WRITE). 
Другими словами, он открывает файл для записи, создает файл, если он не существует, или первоначально усекает существующий [regular-file](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#isRegularFile-java.nio.file.Path-java.nio.file.LinkOption...-) до размера 0.

Запись строк текста в файл. Каждая строка представляет собой последовательность символов и записывается в файл последовательно, 
причем каждая строка завершается разделителем строк платформы, как определено системным свойством line.separator.

Все байты массива байтов записываются в файл. Этот метод гарантирует, что файл будет закрыт, когда все байты будут записаны (или 
возникнет ошибка ввода-вывода или другое исключение времени выполнения).

Если возникает ошибка ввода-вывода, это может произойти после того, как файл был создан или усечен, или после того, как в файл 
было записано несколько байтов.

---
**Доп. материал:**
- [Class Files](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)
- [Interface Path](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html)
- [Interface OpenOption](https://docs.oracle.com/javase/8/docs/api/java/nio/file/OpenOption.html)
- [Interface Iterable<T>](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)
- [Interface CharSequence](https://docs.oracle.com/javase/8/docs/api/java/lang/CharSequence.html)
- [Class Charset](https://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html)

---
- [Java – Write to File](https://www.baeldung.com/java-write-to-file)
- [Java’s Files.write() Method Explained](https://medium.com/@AlexanderObregon/javas-files-write-method-explained-288e75dfc721)
- [Java Write To Files](https://www.w3schools.com/java/java_files_write.asp)
- [Writing Files in Java](https://hyperskill.org/university/java/writing-files-in-java)
- [How do I create a file and write to it?](https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it)
- [File Handling in Java: Read and Write](https://blog.devgenius.io/file-handling-in-java-read-and-write-66eefb0dccd7)
- [Writing Files with NIO and IO in Java](https://medium.com/@vusal.guliyev.313/writing-files-with-nio-and-io-in-java-bc60b06a413a)
- [Java Write to File - 4 Ways to Write File in Java](https://www.digitalocean.com/community/tutorials/java-write-to-file)
- [Write Byte Array to File in Java: Files.write and Streams](https://howtodoinjava.com/java/io/write-byte-array-to-file/)
- [Java - Writing to File](https://www.tutorialspoint.com/java/java_write_file.htm)
- [Java Program to Write into a File](https://www.geeksforgeeks.org/java/java-program-to-write-into-a-file/)
- [Java Create/Write Files](https://codepractice.in/programming-language/java/java-create-write-files)
- [Java Write To File Examples](https://devqa.io/java-write-to-file/)
- [Reading and writing files in Java (Input/Output) - Tutorial](https://www.vogella.com/tutorials/JavaIO/article.html)
- [Java create and write to a file](https://mkyong.com/java/java-how-to-create-and-write-to-a-file/)
- [Java Create & Write Files](https://www.datacamp.com/doc/java/create-&-write-files)
