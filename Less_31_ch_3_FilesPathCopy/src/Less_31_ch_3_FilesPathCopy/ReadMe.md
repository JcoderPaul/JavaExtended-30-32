- [Copying a File or Directory](https://docs.oracle.com/javase/tutorial/essential/io/copy.html)
- [Files.copy метод](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#copy-java.nio.file.Path-java.nio.file.Path-java.nio.file.CopyOption...-)

### Копирование файла или каталога

Мы можем скопировать файл или каталог, используя [метод copy(Path, Path, CopyOption...)](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#copy-java.nio.file.Path-java.nio.file.Path-java.nio.file.CopyOption...-). Копия завершается ошибкой, если целевой файл существует, и если `REPLACE_EXISTING` не указан в качестве параметра - CopyOption.

```
  public static Path copy(Path source, Path target, CopyOption... options) throws IOException
```

Этот метод копирует файл в целевой файл, при этом options параметр определяет способ копирования. По умолчанию копирование завершается неудачей, если целевой файл 
уже существует или является символической ссылкой, за исключением случаев, когда источником и целью является сам файл; в этом случае метод завершается без копирования 
файла. Атрибуты файла не обязательно копировать в целевой файл. Если поддерживаются символические ссылки, и файл является символической ссылкой, то копируется конечный 
целевой объект ссылки. Если файл является каталогом, то в целевом местоположении создается пустой каталог (записи в каталоге не копируются). Этот метод можно использовать 
вместе с методом walkFileTree копирования каталога и всех записей в каталоге или всего дерева файлов, если это необходимо.

**!!! Особенность копирования каталогов !!!**
Каталоги легко можно копировать, при помощи метода `*.copy()`, однако файлы внутри каталога
не будут копироваться, поэтому новый каталог будет пуст, даже если исходный каталог содержит 
какие-то файлы.

При копировании символической ссылки копируется цель ссылки. Если мы хотим скопировать саму
ссылку, а не содержимое ссылки, нужно указать параметр `NOFOLLOW_LINKS` или `REPLACE_EXISTING`.

Метод `*.copy()` принимает аргумент varargs. Параметры `StandardCopyOption` и `LinkOption` могут принимать значения:

- REPLACE_EXISTING – выполняет копирование, даже если целевой файл уже существует. Если целью является символическая ссылка, копируется сама ссылка (а не цель ссылки). Если целью является непустой каталог,
копирование завершается с ошибкой [DirectoryNotEmptyException](https://docs.oracle.com/javase/8/docs/api/java/nio/file/DirectoryNotEmptyException.html).

- COPY_ATTRIBUTES – копирует атрибуты файла, связанные с файлом, в целевой файл. Точные поддерживаемые атрибуты файла зависят от файловой системы и платформы, но last-modified-time поддерживаются на разных
платформах и копируются в целевой файл.

- NOFOLLOW_LINKS – указывает, что символические ссылки не следует использовать. Если копируемый файл является символической ссылкой, копируется ссылка (а не цель ссылки).

Ниже показано, как использовать метод:

```java
  Files.copy(source, target, REPLACE_EXISTING);
```

Реализация данного интерфейса может поддерживать дополнительные параметры, специфичные для конкретной реализации.

Копирование файла не является атомарной операцией. Если возникает исключение - [IOException](https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html), это может означать, что целевой файл неполный 
или некоторые его атрибуты не были скопированы из исходного файла. Если указана опция `REPLACE_EXISTING` и целевой файл существует, то целевой файл заменяется. Проверка существования файла и создание нового 
файла могут быть не атомарными по отношению к другим действиям файловой системы.

В дополнение к копированию файла Files класс также определяет методы, которые можно использовать для копирования между файлом и потоком.

Метод copy(InputStream, Path, CopyOptions...) можно использовать для копирования всех байтов из входного потока в файл.

Метод copy(Path, OutputStream) можно использовать для копирования всех байтов из файла во выходной поток.

Пример:

```java
  import java.nio.file.Files;
  import java.nio.file.Path;
  import java.nio.file.Paths;
  import java.io.IOException;
  
  public class CopyFileExample {
      public static void main(String[] args) {
          Path sourcePath = Paths.get("source.txt");
          Path targetPath = Paths.get("target.txt");
          try {
              Files.copy(sourcePath, targetPath);
              System.out.println("File copied successfully: " + targetPath.toAbsolutePath());
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
```

---
**Доп. материал:**
- [Files copy() Method in Java with Examples **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/files-copy-method-in-java-with-examples/)
- [Manipulating Files and Directories **(from dev.java)**](https://dev.java/learn/api/io/java-io/file-system/move-copy-delete/)
- [Basic I/O - The Java™ Tutorials **(by ORACLE)**](https://docs.oracle.com/javase/tutorial/essential/io/index.html)
- [Java’s Files.copy() Method Explained](https://medium.com/@AlexanderObregon/javas-files-copy-method-explained-aba9aeb73486)
- [How to Copy a File with Java **(from baeldung.com)**](https://www.baeldung.com/java-copy-file)
- [How to copy file from one location to another location?](https://stackoverflow.com/questions/16433915/how-to-copy-file-from-one-location-to-another-location)
- [Java Copy File - 4 Ways to Copy File in Java](https://www.digitalocean.com/community/tutorials/java-copy-file)
- [How to Copy a File in Java Program - Example Tutorial](https://javarevisited.blogspot.com/2012/05/how-to-copy-file-in-java-program.html)
- [How to Copy, Move, and Delete Files and Directories (Java Files Tutorial)](https://www.happycoders.eu/java/how-to-list-directory-contents-move-copy-delete-files/)
- [4 Ways to Copy File in Java](https://examples.javacodegeeks.com/java-development/core-java/io/file/4-ways-to-copy-file-in-java/)
- [Different Ways to Copy Files in Java](https://www.tutorialspoint.com/article/different-ways-to-copy-files-in-java)
- [Copy a Directory in Java](https://www.baeldung.com/java-copy-directory)
- [Different Ways to Copy Files in Java **(from geeksforgeeks.org)**](https://www.geeksforgeeks.org/java/different-ways-to-copy-files-in-java/)
- [How to Copy a File to another File in Java](https://beginnersbook.com/2014/05/how-to-copy-a-file-to-another-file-in-java/)
- [Copy File with Files.copy() Method in Java](https://www.javaguides.net/2019/07/java-copy-file-with-filescopy-api.html)
