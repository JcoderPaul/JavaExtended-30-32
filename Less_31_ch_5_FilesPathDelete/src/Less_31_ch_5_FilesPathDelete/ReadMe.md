**См. оригинал (ENG):**
- [Deleting a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/delete.html)
- [Files.delete()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#delete-java.nio.file.Path-)

### Удаление файла или каталога

В некоторых реализациях может потребоваться проверить файл, чтобы определить, является ли он каталогом. Следовательно, этот метод может 
быть не атомарным по отношению к другим операциям файловой системы. Если файл является символической ссылкой, то удаляется сама символическая 
ссылка, а не конечный объект ссылки.

Если файл является каталогом, то каталог должен быть пустым. В некоторых реализациях каталог содержит записи для специальных файлов или 
ссылок, которые создаются при создании каталога. В таких реализациях каталог считается пустым, если существуют только специальные записи. 
Этот метод можно использовать вместе с методом [walkFileTree](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#walkFileTree-java.nio.file.Path-java.util.Set-int-java.nio.file.FileVisitor-) 
удаления каталога и всех записей в каталоге или всего дерева файлов , если это необходимо.

В некоторых операционных системах удаление файла может быть невозможно, если он открыт и используется данной виртуальной машиной Java или другими программами.

[Класс Files](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html) предоставляет два метода удаления:

- `delete(Path)` - удаляет файл или выдает исключение, если удаление не удается:
  - [NoSuchFileException](https://docs.oracle.com/javase/8/docs/api/java/nio/file/NoSuchFileException.html) - если файл не существует (необязательное исключение)
  - [DirectoryNotEmptyException](https://docs.oracle.com/javase/8/docs/api/java/nio/file/DirectoryNotEmptyException.html) - если файл является каталогом и его нельзя удалить иным способом, поскольку каталог не пуст (необязательное специальное исключение)
  - [IOException](https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html) - если возникает ошибка ввода-вывода
  - [SecurityException](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityException.html) - В случае использования поставщика по умолчанию и установки менеджера безопасности [SecurityManager.checkDelete(String)](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityManager.html#checkDelete-java.lang.String-) вызывается метод для проверки доступа на удаление файла.

Мы можем поймать исключение, чтобы определить, почему удаление не удалось:

```java
  try {
      Files.delete(path);
  } catch (NoSuchFileException x) {
      System.err.format("%s: no such" + " file or directory%n", path);
  } catch (DirectoryNotEmptyException x) {
      System.err.format("%s not empty%n", path);
  } catch (IOException x) {
      // File permission problems are caught here.
      System.err.println(x);
  }
```

- `deleteIfExists(Path)` - метод также удаляет файл, но если файл не существует, исключение не выбрасывается.

Такая проверка перед удалением полезна, когда у нас есть несколько потоков,
удаляющих файлы, и мы не хотим создавать исключение только потому, что один
поток сделал это первым.

**См. более подробно:**
- [Deleting a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/delete.html)
- [Files.delete()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#delete-java.nio.file.Path-)
- [Files delete() method in Java with Examples](https://www.geeksforgeeks.org/java/files-delete-method-in-java-with-examples/)
- [Java – Delete a File](https://www.baeldung.com/how-to-delete-a-file-in-java)
- [Java Delete Files](https://www.datacamp.com/doc/java/delete-files)
- [Java’s Files.deleteIfExists() Method Explained](https://medium.com/@AlexanderObregon/javas-files-deleteifexists-method-explained-bab2b8f34e39)
- [Java - Delete File](https://www.tutorialspoint.com/java/java_delete_file.htm)
- [Java Delete Files](https://www.w3schools.com/java/java_files_delete.asp)
- [Java – How to Delete Files and Folders?](https://www.javacodegeeks.com/2021/04/java-how-to-delete-files-and-folders.html)
- [File delete() method in Java with Examples](https://www.geeksforgeeks.org/java/file-delete-method-in-java-with-examples/)
- [Delete a file in Java](https://codegym.cc/groups/posts/delete-a-file-in-java)
- [How to Delete File in Java?](https://data-flair.training/blogs/how-to-delete-file-in-java/)
- [How to delete file in Java – delete() Method](https://beginnersbook.com/2014/01/how-to-delete-file-in-java-delete-method/)
- [How to delete a directory with files in Java - Example](https://javarevisited.blogspot.com/2015/03/how-to-delete-directory-in-java-with-files.html)
- [Java Delete Directory Recursively: Files.walk() and More](https://howtodoinjava.com/java/io/delete-directory-recursively/)
- [Delete a File Using Java](https://www.geeksforgeeks.org/java/delete-file-using-java/)
