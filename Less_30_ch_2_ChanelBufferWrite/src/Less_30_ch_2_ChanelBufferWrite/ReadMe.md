- [Java NIO (from Core Libraries by ORACLE)](https://docs.oracle.com/en/java/javase/25/core/java-nio.html)
- [Пакет java.nio](https://docs.oracle.com/javase/8/docs/api/java/nio/package-summary.html)
- [Пакет java.io](https://docs.oracle.com/javase/8/docs/api/java/io/package-summary.html)

---
### NIO API

Основное отличие между двумя подходами к организации ввода/вывода заключается в том, что IO API — потоко-ориентированное, 
а NIO API — буферо-ориентированное. Главные понятия в этом случае — понятия буфера (buffer) и канала (channel).

**Канал — это логический портал, через которые осуществляется ввод/вывод данных, а буфер является источником или приёмником 
этих переданных данных.** При организации вывода данные, которые мы хотим отправить, помещаются в буфер, а он передает их в 
канал. При вводе, данные из канала помещаются в буфер.

По-другому буфер — это блок памяти, в который мы можем записывать информацию и из которого мы можем читать информацию, 
канал — это шлюз, который позволяет получить доступ к устройствам ввода/вывода,таким как файл или сокет. Каналы очень похожи 
на потоки в [пакете java.io](https://docs.oracle.com/javase/8/docs/api/java/io/package-summary.html). Все данные, которые 
идут во вне или из вне, должны проходить через объект канала.

Т.е. чтобы использовать систему NIO, мы получаем канал к устройству ввода/вывода и буфер для хранения данных. Затем мы 
работаем с буфером, вводя или выводя данные по мере необходимости.

**Особенность в том, что мы можем двигаться по буферу вперед и назад, то есть, “гулять” по нему, чего не могли делать в 
потоках ввода-вывода. Это дает больше гибкости при обработке данных.**

В стандартной библиотеке [`java.nio`](https://docs.oracle.com/javase/8/docs/api/java/nio/package-summary.html) буфер представлен 
абстрактным классом и множеством наследников. Основное отличие наследников — тип данных, который они будут хранить — byte, int, 
long и т.д.

- [Buffer](https://docs.oracle.com/javase/8/docs/api/java/nio/Buffer.html);
- [ByteBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html);
- [CharBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/CharBuffer.html)
- [ShortBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ShortBuffer.html)
- [IntBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/IntBuffer.html)
- [FloatBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/FloatBuffer.html)
- [DoubleBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/DoubleBuffer.html)
- [LongBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/LongBuffer.html)

---
### Свойства буфера

У буфера есть четыре основных свойства. Это емкость, лимит, позиция и маркер.

- **Емкость (Capacity)** — максимальный объем данных/байт, который может быть сохранен в буфер. Емкость буфера не может быть изменена.
Как только буфер заполнен, его следует очистить перед записью в него следующей информации.

- **Лимит (Limit)** — в режиме записи буфера Лимит равен емкости, что показывает максимальное количество данных, которые могут быть
записаны в буфер. В режиме чтения буфера Лимит означает максимальное количество данных, которые можно прочитать из буфера.

- **Позиция (Position)** — указывает на текущую позицию курсора в буфере. Первоначально устанавливается на 0 в момент создания буфера.
Иными словами, это индекс элемента, который должен быть прочитан или записан.

- **Маркер (Mark)** — используется для маркировки текущей позиции курсора. В процессе манипуляций с буфером позиция курсора постоянно
изменяется, но мы всегда можем вернуть его в маркированную раннее позицию.

**Методы для работы с буфером:**

Теперь давайте рассмотрим основной набор методов, которые позволяют работать с буфером для чтения и записи данных в каналы и из каналов:

- `allocate (int capacity)` - метод используется для выделения нового буфера с емкостью в качестве параметра. Метод allocate() выдает исключение [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) в случае, если переданная емкость является отрицательным целым числом.
- `capacity()` - возвращает емкость (capacity) текущего буфера.
- `position()` - возвращает текущую позицию курсора. Как операции чтения, так и записи перемещают курсор в конец буфера. Возвращаемое значение всегда меньше или равно limit.
- `limit()` - возвращает лимит текущего буфера.
- `mark()` - используется для обозначения (маркировки) текущей позиции курсора.
- `reset()` - вернет курсор в ранее отмеченную (маркированную) позицию.
- `clear()` - устанавливает позицию в ноль и ограничивает ее до емкости. В этом методе данные в буфере не очищаются, только маркеры инициализируются повторно.
- `flip()` - переключает режим буфера с режима записи на режим чтения. Он также устанавливает позицию обратно в ноль и устанавливает лимит, в котором позиция была во время записи.
- `read()` - метод чтения канала используется для записи данных из канала в буфер,
- `put()` - метод буфера, который используется для записи данных в буфер.
- `write()` - метод записи канала используется для записи данных из буфера в канал
- `get()` - метод буфера, который используется для чтения данных из буфера.
- `rewind()` — метод перемотки. Используется, когда требуется перечитывание, так как он устанавливает позицию в ноль и не изменяет значение лимита.

Более подробно о классе и его методах: 
- [Class Buffer](https://docs.oracle.com/javase/8/docs/api/java/nio/Buffer.html)
- [Class ByteBuffer](https://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html)
- [java.nio.file package](https://www.geeksforgeeks.org/java/java-nio-file-package/)

---
### Свойства канала

- [Пакет java.nio.channels](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/package-summary.html)

Наиболее важными реализациями канала в Java NIO выступают следующие классы:
- [FileChannel](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/FileChannel.html) - канал для чтения и записи данных в файл.
- [DatagramChannel](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/DatagramChannel.html) — считывает и записывает данные по сети через UDP (UserDatagram Protocol).
- [SocketChannel](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/SocketChannel.html) — канал для считывания и записи данныx по сети через TCP(Transmission Control Protocol).
- [ServerSocketChannel](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/ServerSocketChannel.html) — канал для чтения и записи данных через TCP-соединения, так же, как это делает веб-сервер. Для каждого входящего соединения создается SocketChannel

**[FileChannel Java NIO](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/FileChannel.html)** — это канал, подключенный к файлу. 
Используя файловый канал, вы можете читать данные из файла и записывать данные в файл. Класс Java NIO FileChannel — это альтернатива NIO 
чтению файлов с помощью стандартного [Java IO API](https://docs.oracle.com/javase/tutorial/essential/io/). FileChannel не может быть установлен 
в неблокирующий режим. Он всегда работает в режиме блокировки.

**Работа с FileChannel:**

- **Открытие (создание) FileChannel:** Прежде чем использовать файл в FileChannel мы должны открыть его. Мы не можете открыть FileChannel напрямую.
Нам необходимо получить FileChannel через InputStream, OutputStream или RandomAccessFile.

Вот как мы открываем FileChannel через RandomAccessFile:

```java
  RandomAccessFile openFile = new RandomAccessFile("open_file.txt", "rw");
  FileChannel inChannel = openFile.getChannel();
```

- **Чтение данных из FileChannel:** Чтобы прочитать данные из FileChannel, мы вызываем один из методов read().

Например так:

```java
  ByteBuffer my_buffer = ByteBuffer.allocate(48);
  int bytesRead = inChannel.read(my_buffer);
```
Сначала выделяется Buffer (ByteBuffer). Затем данные, полученные из FileChannel, считываются в Buffer. Переменная int bytesRead получает информацию 
сколько байтов было записано в Buffer. Т.е. метод read() не только записывает данные но и фиксирует состояние буфера, если возвращается -1, достигнут 
конец файла.

- **Запись данных в FileChannel:** Запись данных в FileChannel выполняется с помощью метода `FileChannel.write()`, который принимает Buffer
в качестве параметра.

См. пример:

```java
  String newData = "New String to write to file..." + System.currentTimeMillis();
  
  ByteBuffer my_buffer = ByteBuffer.allocate(48);
  my_buffer.clear();
  my_buffer.put(newData.getBytes());
  
  my_buffer.flip();
  
  while(my_buffer.hasRemaining()) {
      channel.write(buf);
  }
```

Метод `FileChannel.write()` вызывается внутри цикла while. Нет гарантии того, сколько байтов write() метод записывает в FileChannel. поэтому мы повторяем 
write() вызов до тех пор, пока в Buffer не закончатся байты для записи.

- **Закрытие FileChannel:** Когда мы закончили использовать FileChannel, мы должны закрыть его.

Вот как это делается:

```java
  channel.close();
```

- **FileChannel Position:** Чтение или запись по FileChannel мы делаем из определенной позиции. Мы можем получить текущую позицию FileChannel объекта,
вызвав метод `*.position()`. Мы так же можем установить положение FileChannel, вызвав метод `*.position(long pos)`.

Примеры:

```
  long pos channel.position();
  channel.position(pos +123);
```

Если мы установим позицию на конец файла и попытаемся прочитать из канала, то получим `-1`, т.е. маркер конца файла.
Если мы установим позицию после конца файла и запишем данные в канал, файл будет расширен, чтобы соответствовать позиции 
и записанным данным. Это может привести к «дыре в файле», когда физический файл на диске имеет пробелы в записанных данных.

- **FileChannel Size:** Метод `size()` объекта FileChannel возвращает размер файла, к которому подключен канал.

Вот простой пример:

```java
  long fileSize = channel.size();
```

- **FileChannel Truncate:** Мы можем обрезать файл, вызвав `FileChannel.truncate()` метод. Когда мы усекаем файл, мы обрезаем его по заданной длине.

Пример:

```java
  channel.truncate(1024);
```

В этом примере файл (канал) усекается до 1024 байт.

- **FileChannel Force:** Метод `FileChannel.force()` сбрасывает все незаписанные данные из FileChannel на диск. Операционная система может кэшировать
данные в памяти из соображений производительности, поэтому нам не гарантируется, что данные, записываемые в FileChannel, действительно записываются на диск,
пока мы не вызовем метод `*.force()`.

Метод `*.force()` принимает логическое значение в качестве параметра, указывающего, следует ли также очищать метаданные файла (разрешения и т. д.).

Пример, который очищает как данные, так и метаданные:

```java
  channel.force(true);
```

**Более подробно:**
- [Class FileChannel](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/FileChannel.html)
- [Guide to Java FileChannel](https://www.baeldung.com/java-filechannel)
- [Java NIO FileChannel](https://jenkov.com/tutorials/java-nio/file-channel.html)
- [Guide to FileOutputStream vs. FileChannel](https://www.javacodegeeks.com/guide-to-fileoutputstream-vs-filechannel.html)
- [Reading/Writing to/from Files using FileChannel and ByteBuffer in Java](https://www.javacodegeeks.com/2016/01/readingwriting-tofrom-files-using-filechannel-bytebuffer-java.html)
- [Java FileChannel transferTo() and transferFrom() Examples](https://howtodoinjava.com/java/nio/transfer-data-between-channels/)
- [Reading/Writing to/from Files using FileChannel and ByteBuffer in Java - Example Tutorial](https://javarevisited.blogspot.com/2016/01/reading-writing-files-using-filechannel-bytebuffer-example.html)
- [FileChannel with Examples](https://programming-tips.jp/archives/a1/33/index.html)
- [Guide to FileOutputStream vs. FileChannel](https://www.baeldung.com/java-fileoutputstream-filechannel-differences)
- [AsynchronousFileChannel in Java NIO](https://www.geeksforgeeks.org/java/asynchronousfilechannel-in-java-nio/)

---
**Доп. материал:**
- [Java 25 Core Libraries - Java NIO (by ORACLE)](https://docs.oracle.com/en/java/javase/25/core/java-nio.html)
- [The Java™ Tutorials - Basic I/O (by ORACLE DOC)](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Java NIO Tutorials](https://www.javacodegeeks.com/java-nio-tutorials)
- [Introduction to Java NIO with Examples](https://www.geeksforgeeks.org/java/introduction-to-java-nio-with-examples/)
- [Difference between Java IO and Java NIO](https://www.geeksforgeeks.org/java/difference-between-java-io-and-java-nio/)
- [Java NIO](https://medium.com/@kaustubh.saha/java-nio-2d64e57f8d3f)
- [Introduction to the Java NIO2 File API](https://www.baeldung.com/java-nio-2-file-api)
- [Java NIO Tutorial](https://jenkov.com/tutorials/java-nio/index.html)
- [Introduction to Java nio](https://dev.to/sadiul_hakim/introduction-to-java-nio-mln)
- [Java NIO](https://www.educba.com/java-nio/)
- [Uses of Package java.nio](https://download.java.net/java/early_access/panama/docs/api/java.base/java/nio/package-use.html)
- [Java IO vs NIO](https://www.baeldung.com/java-io-vs-nio)

---
- [Java FileChannel: Read, Write, Memory-Mapped Files, Locks](https://www.happycoders.eu/java/filechannel-memory-mapped-io-locks/)
- [Java – Write to File](https://www.baeldung.com/java-write-to-file)
- [File Handling in Java](https://www.geeksforgeeks.org/java/file-handling-in-java/)
- [Java – Write to File](https://codegym.cc/groups/posts/java-write-to-file)
- [Java Write to File: Files.writeString, BufferedWriter and More](https://howtodoinjava.com/java/io/java-write-to-file/)
- [Java File writing I/O performance](https://tmsvr.com/java-file-writing-i-o-performance/)
- [Java write to File Example](https://examples.javacodegeeks.com/java-write-to-file-example/)
