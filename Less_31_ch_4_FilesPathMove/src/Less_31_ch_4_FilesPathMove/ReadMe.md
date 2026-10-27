- [Moving a File or Directory - The Java™ Tutorials (by ORACLE)](https://docs.oracle.com/javase/tutorial/essential/io/move.html)
- [Files.move](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#move-java.nio.file.Path-java.nio.file.Path-java.nio.file.CopyOption...-)

---
### Перемещение файла или каталога

Метод `*.move(PathFrom, PathTo, CopyOption...)` позволяет переместить файл или каталог. Перемещение завершается ошибкой, если целевой файл существует, 
если параметр REPLACE_EXISTING не указан явно.

Пустые каталоги можно перемещать. Если каталог не пуст, перемещение разрешено, если каталог можно переместить без перемещения содержимого этого каталога.
В системах UNIX перемещение каталога в пределах одного раздела обычно состоит из переименования каталога. В этой ситуации этот метод работает, даже если
каталог содержит файлы.

Метод `*.move()` принимает аргумент varargs — StandardCopyOption, поддерживаются следующие перечисления:
- `REPLACE_EXISTING` – выполняет перемещение, даже если целевой файл уже существует. Если целью является символическая ссылка, символическая ссылка
заменяется, но то, на что она указывает, не затрагивается.
- `ATOMIC_MOVE` – выполняет перемещение как атомарную файловую операцию. Если файловая система не поддерживает атомарное перемещение, генерируется
исключение. С помощью ATOMIC_MOVE мы можем переместить файл в каталог и гарантировать, что любой процесс, наблюдающий за каталогом, получит доступ к
полному файлу.

Синтаксис:
```java
  import static java.nio.file.StandardCopyOption.*;
  // some code
  Files.move(source, target, REPLACE_EXISTING);
```

---
**Доп. материал:**
- [Class Files](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)
- [Java’s Files.move() Method Explained](https://medium.com/@AlexanderObregon/javas-files-move-method-explained-7dee1287fa92)
- [Java – Rename or Move a File](https://www.baeldung.com/java-how-to-rename-or-move-a-file)
- [Moving a file from one directory to another using Java](https://www.geeksforgeeks.org/java/moving-file-one-directory-another-using-java/)
- [How do I move a file from one location to another in Java?](https://stackoverflow.com/questions/4645242/how-do-i-move-a-file-from-one-location-to-another-in-java)
- [How to Copy, Move, and Delete Files and Directories (Java Files Tutorial)](https://www.happycoders.eu/java/how-to-list-directory-contents-move-copy-delete-files/)
- [Rename or Move a File or Directory in Java (Files.move)](https://howtodoinjava.com/java/io/rename-move-file-directory/)
- [Manipulating Files and Directories](https://dev.java/learn/api/io/java-io/file-system/move-copy-delete/)
- [Java NIO Files](https://jenkov.com/tutorials/java-nio/files.html)
- [How to move file to another directory in Java](https://mkyong.com/java/how-to-move-file-to-another-directory-in-java/)
- [Moving a file from one directory to another using Java](https://www.tutorialspoint.com/article/moving-a-file-from-one-directory-to-another-using-java)
- [Java IO & NIO - Files.move() Examples](https://www.logicbig.com/how-to/code-snippets/jcode-java-io-files-move.html)
