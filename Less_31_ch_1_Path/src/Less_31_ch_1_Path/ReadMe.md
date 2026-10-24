- [Interface Path](https://docs.oracle.com/javame/8.0/api/cldc/api/java/nio/file/Path.html)

---
### Interface Path - Интерфейс Path

```
  public interface Path
    extends Comparable<Path>, Iterable<Path>
```

Объект, который может использоваться для поиска файла в файловой системе. Обычно это путь к файлу, зависящий от системы. 
Path представляет собой иерархический путь, состоящий из последовательности элементов имени каталога(ов) и файла, разделенных 
специальным разделителем (разделителями). Также может присутствовать корневой компонент, определяющий иерархию файловой системы.

Элемент имени, наиболее удаленный от корня иерархии каталогов, является именем файла или каталога. Другие элементы имени — это 
имена подкаталогов. Path может представлять корень, корень и последовательность имен, или, просто один или несколько элементов имени.

Path считается пустым путем, если он состоит только из одного пустого элемента имени. Доступ к файлу с использованием пустого пути 
эквивалентен доступу к каталогу файловой системы по умолчанию.

**Path - это переработанный аналог [класса File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html).** Работать с ним 
значительно проще, чем с File.

- Во-первых, из него убрали многие утилитные (статические) методы, и перенесли их в [класс File](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html).
- Во-вторых, в Path были упорядочены возвращаемые значения методов. В классе File методы возвращали то String, то boolean, то File - это запутывало.

Например, был метод `getParent()`, который возвращал родительский путь для текущего файла в виде строки. Но при этом был метод 
`getParentFile()`, который возвращал то же самое, но в виде объекта File! Это явно избыточно.

Поэтому в интерфейсе Path метод `getParent()` и другие методы работы с файлами возвращают просто объект Path.

**Path представлен:**
- методами getFileName, getParent, getRoot, subpath для доступа к компонентам пути или подпоследовательности элементов его имени;
- методами resolve и resolveSibling для объединения путей;
- методом relativize, который можно использовать для построения относительного пути между двумя путями;
- методами сравнения compared и startsWith, endWith.

Интерфейс Path расширяет [Watchable интерфейс](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Watchable.html), так что каталог, 
расположенный по пути, может отслеживаться registeredс помощью [WatchService](https://docs.oracle.com/javase/8/docs/api/java/nio/file/WatchService.html) 
и записей в каталоге.

---
**ПРЕДУПРЕЖДЕНИЕ.** Этот интерфейс предназначен только для тех, кто разрабатывает собственные реализации файловой системы. 
В будущих версиях к этому интерфейсу могут быть добавлены методы.

---
**Доступ к файлам:**
Пути могут использоваться с классом Files для работы с файлами, каталогами и другими типами файлов. Например, мы хотим прочитать BufferedReader 
в котором записан текст из файла "access.log". Файл находится в каталоге "logs" относительно текущего рабочего каталога и имеет кодировку UTF-8.

```java
  Path path = FileSystems.getDefault().getPath("logs", "access.log");
  BufferReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
```

**Совместимость:**
Пути, связанные со значением по умолчанию provider, обычно совместимы с [классом java.io.File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html).
Пути, созданные другими провайдерами, вряд ли будут совместимы с абстрактными путями, представленными [java.io.File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html). 
Метод [toPath](https://docs.oracle.com/javase/8/docs/api/java/io/File.html#toPath--) может использоваться для получения Path из абстрактного имени пути, 
представленного объектом java.io.File. Полученный результат [Path](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html) можно использовать для 
работы с тем же файлом, что и объект java.io.File. Кроме того, метод toFile полезен для создания File из String представления объекта Path.

---
**Методы интерфейса:**
- `int compareTo(Path other)` - лексикографически сравнивает два абстрактных пути.
- `boolean endsWith(Path other)` - проверяет, заканчивается ли текущий путь заданным в аргументе путем.
- `boolean endsWith(String other)` - проверяет, заканчивается ли текущий путь, созданным с помощью String путем точно так, как указано в endsWith(Path) методе.
- `boolean equals(Object other)` - проверяет текущий путь на равенство с заданным объектом.
- `Path getFileName()` - возвращает имя файла или каталога, обозначенного текущим путем как Path объект.
- `FileSystem getFileSystem()` - возвращает файловую систему, создавшую текущий объект.
- `Path getName(int index)` - возвращает элемент имени текущего пути как Path объект.
- `int getNameCount()` - возвращает количество элементов имени в пути.
- `Path getParent()` - возвращает родительский путь или, null если текущий путь не имеет родителя.
- `Path getRoot()` - возвращает корневой компонент текущего пути в виде Path объекта или, null если текущий путь не имеет корневого компонента.
- `int hashCode()` - вычисляет хэш-код для текущего пути.
- `boolean isAbsolute()` - сообщает, является ли текущий путь абсолютным.
- `Iterator<Path> iterator()` - возвращает итератор по элементам имени текущего пути.
- `Path normalize()` - возвращает путь, который представляет собой текущий путь с удаленными избыточными элементами имени.
- `WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events)` - регистрирует файл, расположенный по текущему пути, в службе наблюдения.
- `WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers)` - регистрирует файл, расположенный по текущему пути, в службе наблюдения.
- `Path relativize(Path other)` - создает относительный путь между текущим путем и заданным путем. Для правильной работы метода необходимо сопоставлять пути одного типа:
"относительный с относительным" либо "абсолютный с абсолютным" иначе хапнем: IllegalArgumentException: 'other' is different type of Path
- `Path resolve(Path other)` - разрешить данный путь против текущего пути. По факту метод отобразит, как это могло бы быть. (см. пример [Less_31_Path_Step2](./Less_31_Path_Step2.java))
- `Path resolve(String other)` - преобразует заданную строку пути в Path и разрешает ее Path точно так, как указано в методе resolve. (см. пример [Less_31_Path_Step2](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_1_Path/src/Less_31_ch_1_Path/Less_31_Path_Step2.java))
- `Path resolveSibling(Path other)` - разрешает данный путь против текущего parent пути.
- `Path resolveSibling(String other)` - преобразует заданную строку пути в Path и разрешает ее относительно текущего parent пути точно так, как указано в методе resolveSiblin.
- `boolean startsWith(Path other)` - проверяет, начинается ли текущий путь с заданного пути.
- `boolean startsWith(String other)` - проверяет, начинается ли текущий путь с символа Path, созданного путем преобразования заданной строки пути точно так, как указано в методе startsWith(Path).
- `Path subpath(int beginIndex, int endIndex)` - возвращает подпапки Path, который является подпоследовательностью элементов имени текущего пути.
- `Path toAbsolutePath()` - возвращает объект Path, представляющий абсолютный путь.
- `File toFile()` - возвращает объект File, представляющий текущий путь.
- `Path toRealPath(LinkOption... options)` - возвращает реальный путь к существующему файлу.
- `String toString()` - возвращает строковое представление текущего пути.
- `URI toUri()` - возвращает URI для представления текущего пути.

---
**Доп. материалы:**
- [Interface Path](https://docs.oracle.com/javame/8.0/api/cldc/api/java/nio/file/Path.html)
- [Class Files](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)
- [Interface Watchable](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Watchable.html)
- [Class File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)

---
- [Java NIO Path](https://jenkov.com/tutorials/java-nio/path.html)
- [Working with Paths](https://dev.java/learn/api/io/java-io/file-system/path/)
- [Path](https://tech-learn.dev/java/java-nio/java-nio-path)
- [Java Files, Path](https://javarush.com/groups/posts/2275-files-path)
- [Java NIO Path](https://www.educba.com/java-nio-path/)
- [java.nio.file.Path Example](https://examples.javacodegeeks.com/java-development/core-java/nio/file-nio/path/java-nio-file-path-example/)
- [Java – Path vs File](https://www.baeldung.com/java-path-vs-file)
- [Uses of Interface java.nio.file.Path](https://javadoc.scijava.org/Java7/java/nio/file/class-use/Path.html)
