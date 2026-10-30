- [Files.walkFileTree()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#walkFileTree-java.nio.file.Path-java.nio.file.FileVisitor-)
- [Interface FileVisitor<T>](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html)
- [The Java™ Tutorials - Walking the File Tree (by ORACLE)](https://docs.oracle.com/javase/tutorial/essential/io/walk.html)

---
### Метод walkFileTree класса Files - Обход дерева файлов (каталогов)

Для решения задачи по обходу дерева каталогов (файлов) в Java существует метод `Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)`,
который позволяет исследовать в глубину содержимое, заданной стартовой папки Path start, при этом реализуя некие действия при достижении вложенного
объекта файла или папки (простой просмотр, копирование, удаление и т.д.) за счет нашей собственной реализации методов интерфейса [FileVisitor](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html).

Метод имеет две реализации:

---
```java
public static Path walkFileTree(Path start,
                                Set<FileVisitOption> options,
                                int maxDepth,
                                FileVisitor<? super Path> visitor)
                  throws IOException
```

**Параметры:**
- `start` - стартовый файл (каталог);
- `options` - варианты настройки обхода;
- `maxDepth` - максимальное количество вложенных подкаталогов для посещения
- `visitor` - класс реализующий методы интерфейса FileVisitor - 'посетитель' вызывается для каждого файла (папки) при обходе.

**Возвращает:** Метод возвращает начальный файл (папку).

**Ошибки при работе метода:**
- [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) - если maxDepth параметр отрицательный;
- [SecurityException](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityException.html) - если менеджер безопасности запрещает доступ к стартовому файлу. В случае поставщика по умолчанию [checkRead](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityManager.html#checkRead-java.lang.String-) метод вызывается для проверки доступа на чтение к каталогу;
- [IOException](https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html) - если ошибка ввода/вывода вызвана [методом FileVisitor](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html#visitFile-T-java.nio.file.attribute.BasicFileAttributes-).

Метод просматривает дерево файлов с корнем в заданном начальном файле (папке) Path start. Обход дерева файлов осуществляется в глубину, при
этом реализации методов интерфейса [FileVisitor](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html) вызывается для 
каждого обнаруженного файла или папки. Обход дерева файлов завершается, когда все доступные файлы (папки) в дереве были посещены или один из 
методов [FileVisitor](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html) возвращает 
результат [TERMINATE](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitResult.html#TERMINATE).

Если метод посещения [FileVisitor](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html) завершается из-за IOException,
не перехваченной ошибки или исключения времени выполнения, тогда обход завершается, и ошибка или исключение распространяются на вызывающую
сторону этого метода.

Для каждого обнаруженного файла метод walkFileTree пытается прочитать его атрибуты [BasicFileAttributes](https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributes.html). 
Если файл не является каталогом, вызывается реализация метода [*.visitFile()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html#visitFile-T-java.nio.file.attribute.BasicFileAttributes-) 
интерфейса FileVisitor с атрибутами файла. Если атрибуты файла не могут быть прочитаны из-за исключения ввода-вывода, то вызывается метод [*.visitFileFailed](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html#visitFileFailed-T-java.io.IOException-), этого же интерфейса, с исключением ввода-вывода.

Если файл является каталогом, и каталог не может быть открыт, то активируется метод *.visitFileFailed(), который вызывается с исключением
ввода-вывода, после чего обход дерева файлов продолжается по умолчанию в следующем одноуровневом каталоге.

Если каталог успешно открыт, то посещаются записи в каталоге и их потомки. Когда все записи были посещены или во время итерации каталога возникает
ошибка ввода-вывода, каталог закрывается и вызывается реализация метода [*.postVisitDirectory()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html#postVisitDirectory-T-java.io.IOException-). 
Затем обход файлового дерева по умолчанию продолжается со следующего родственного каталога.

По умолчанию символические ссылки не следуют этому методу автоматически. Если параметр 'options' содержит параметр [FOLLOW_LINKS](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitOption.html#FOLLOW_LINKS), выполняется переход по символическим ссылкам. При переходе по ссылкам атрибуты цели не могут быть прочитаны, тогда этот метод пытается получить 
BasicFileAttributes ссылки. Если их можно прочитать, то вызывается метод *.visitFile() с атрибутами ссылки (в противном случае вызывается метод 
*.visitFileFailed(), как указано выше).

Если параметр 'options' содержит параметр  [FOLLOW_LINKS](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitOption.html#FOLLOW_LINKS), 
то метод *.walkFileTree() отслеживает посещенные каталоги, чтобы можно было обнаружить циклы.

Цикл возникает, когда в каталоге есть запись, которая является предком каталога. Обнаружение циклов выполняется путем записи файловых ключей - [file-key](https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributes.html#fileKey--) каталогов или, если файловые ключи недоступны, путем 
вызова метода [*.isSameFile()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#isSameFile-java.nio.file.Path-java.nio.file.Path-) для 
проверки того, является ли каталог тем же файлом, что и предок.

При обнаружении цикла он обрабатывается как ошибка ввода-вывода, и вызывается [метод *.visitFileFailed()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html#visitFileFailed-T-java.io.IOException-) 
с экземпляром [FileSystemLoopException](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystemLoopException.html).

Параметр 'maxDepth' — это максимальное количество уровней директорий для посещения. Значение 0 означает, что посещается только начальный файл, если это не 
запрещено администратором безопасности. Значение [MAX_VALUE](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#MAX_VALUE) может использоваться 
для указания того, что все уровни должны быть посещены.

Метод *.visitFile() интерфейса FileVisitor вызывается для всех файлов, включая каталоги, обнаруженные в maxDepth, за исключением случаев, когда основные 
атрибуты файла не могут быть прочитаны, и в этом случае вызывается метод *.visitFileFailed().

Если FileVisitor возвращает нулевой результат, генерируется исключение NullPointerException.

Когда менеджер безопасности установлен и запрещает доступ к файлу (или каталогу), он игнорируется, и FileVisitor не вызывается для этого файла (или каталога).

---
```java
public static Path walkFileTree(Path start,
                                FileVisitor<? super Path> visitor)
                   throws IOException
```

**Параметры:**
- `start` - стартовый файл;
- `visitor` - класс реализующий интерфейс FileVisitor, методы которого вызываются для каждого файла (папки) при обходе;

**Возвращает:** начальный файл

**Исключения:**
- [SecurityException](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityException.html) - если менеджер безопасности запрещает доступ к стартовому файлу. В случае поставщика по умолчанию [checkRead метод](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityManager.html#checkRead-java.lang.String-) вызывается для проверки доступа на чтение к каталогу.
- [IOException](https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html) - если ошибка ввода/вывода вызвана методом посетителя.

Такой синтаксис эквивалентен работе метода со следующими параметрами:

```java
  walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);
```

Т.е. он не переходит по символическим ссылкам, а посещает все уровни файлового дерева.

---
**Более подробно про FileVisitor и Files.walkFileTree():**
- [Files.walkFileTree()](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#walkFileTree-java.nio.file.Path-java.nio.file.FileVisitor-)
- [Interface FileVisitor<T>](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html)
- [The Java™ Tutorials - Walking the File Tree **(by ORACLE)**](https://docs.oracle.com/javase/tutorial/essential/io/walk.html)

---
- [Java’s Files.walkFileTree() Method Explained **(by Alexander Obregon)**](https://medium.com/@AlexanderObregon/javas-files-walkfiletree-method-explained-6660bebfa626)
- [List Directory Contents in Java: Files.list(), walk(), walkFileTree(), find()](https://www.happycoders.eu/java/java-list-files-in-directory/)
- [Walking the File Tree **(from dev.java)**](https://dev.java/learn/api/io/java-io/file-system/walking-tree/)
- [List Files in a Directory in Java **(from baeldung.com)**](https://www.baeldung.com/java-list-directory-files)
- [What is the difference between Files.list and Files.walkFileTree and Files.walk with maxdepth = 1?](https://stackoverflow.com/questions/37858082/what-is-the-difference-between-files-list-and-files-walkfiletree-and-files-walk)

---
**by [Lewis Coosner](https://incusdata.com/blog-author/lsc)**
- [Walking a File Tree in Java](https://incusdata.com/blog/walking-a-file-tree-in-java)
- [Walking a File Tree in Java – Part 2](https://incusdata.com/blog/walking-a-file-tree-in-java-part-2)
- [Walking a File Tree in Java – Part 3](https://incusdata.com/blog/walking-a-file-tree-in-java-part-3)

---
- [Files WalkFileTree **(from javadevcentral.com)**](https://javadevcentral.com/files-walk-file-tree/)
- [Разбор утилиты `Files.walkFileTree();`](https://habr.com/ru/articles/437694/)
- [Java IO & NIO - Files.walkFileTree() Examples](https://logicbig.com/how-to/code-snippets/jcode-java-io-files-walkfiletree.html)
- [Java Program to Traverse in a Directory](https://www.geeksforgeeks.org/java/java-program-to-traverse-in-a-directory/)
- [Find Files by Extension in Specified Directory in Java](https://www.baeldung.com/java-recursive-search-directory-extension-match)
- [Use walkFileTree to Show Your Java Files](https://www.linkedin.com/pulse/use-walkfiletree-show-your-java-files-cecil-westerhof)
- [Walk File Tree with Java NIO](https://javapapers.com/java/walk-file-tree-with-java-nio/)
- [A Guide To NIO2 FileVisitor **(from baeldung.com)**](https://www.baeldung.com/java-nio2-file-visitor)
- [The Java™ Tutorials - Finding Files **(by ORACLE)**](https://docs.oracle.com/javase/tutorial/essential/io/find.html)
- [How to Traverse All Files from a Folder in Java](https://www.javacodegeeks.com/how-to-traverse-all-files-from-a-folder-in-java.html)

---
-[Alexander Obregon’s Substack Blog](https://alexanderobregon.substack.com/)
