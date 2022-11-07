### ******** NIO API ********

Основное отличие между двумя подходами к организации ввода/вывода заключается в том,
что IO API — потоко-ориентированное, а NIO API — буферо-ориентированное. Главные понятия
в этом случае — понятия буфера (buffer) и канала (channel).

Канал — это логический портал, через которые осуществляется ввод/вывод данных, а буфер
является источником или приёмником этих переданных данных. При организации вывода данные,
которые мы хотим отправить, помещаются в буфер, а он передает их в канал. При вводе, данные
из канала помещаются в буфер.

По-другому буфер — это блок памяти, в который мы можем записывать информацию и из которого
мы можем читать информацию, канал — это шлюз, который позволяет получить доступ к устройствам
ввода/вывода,таким, как файл или сокет.

Каналы очень похожи на потоки в пакете java.io. Все данные, которые идут во вне или из вне,
должны проходить через объект канала.

Т.е. чтобы использовать систему NIO, мы получаем канал к устройству ввода/вывода и буфер для
хранения данных. Затем мы работаем с буфером, вводя или выводя данные по мере необходимости.

Особенность в том, что мы можетм двигаться по буферу вперед и назад, то есть, “гулять” по нему,
чего не могли делать в потоках ввода-вывода. Это дает больше гибкости при обработке данных.

- [Less_30_ch_1_ChanelBufferRead](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_30_ch_1_ChanelBufferRead/src/Less_30_ch_1_ChanelBufferRead) - примеры использования классов и методов io.RandomAccessFile, 
nio.ByteBuffer, nio.channels.FileChannel для чтения данных из файла (применение методов 
*.getChannel(), *.allocate(), *.read(), *.flip(), *.hasRemaining(), *.clear(), *.get(), 
*.read(myBuffer))

- [Less_30_ch_2_ChanelBufferWrite](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_30_ch_2_ChanelBufferWrite/src/Less_30_ch_2_ChanelBufferWrite) - примеры использования классов и методов io.RandomAccessFile, 
nio.ByteBuffer, nio.channels.FileChannel для записи данных из файла (применение метода 
*.wrap(), *.write(), *.put())

- [Less_30_ch_3_ChanelBufferMethods](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_30_ch_3_ChanelBufferMethods/src/Less_30_ch_3_ChanelBufferMethods) - примеры использования классов и методов io.RandomAccessFile, 
nio.ByteBuffer, nio.channels.FileChannel для работы с буфером данных, чтение элементов буфера, 
перемещение по элементам буфера, уплотнение буфера, установка маркера, возврат к маркированной
позиции буфера (применение методов *.get() *.rewind(), *.compact(), *.mark(), *.reset())

- [Less_31_ch_1_Path](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_1_Path/src/Less_31_ch_1_Path) - примеры использования методов интерфейса Path:
  - [Less_31_Path_Step1](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_1_Path/src/Less_31_ch_1_Path/Less_31_Path_Step1.java) - методы *.getFileName(), *.getParent(), *.getRoot(), *.isAbsolute(), *.toAbsolutePath();
  - [Less_31_Path_Step2](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_1_Path/src/Less_31_ch_1_Path/Less_31_Path_Step2.java) - методы *.toAbsolutePath().getParent(), *.toAbsolutePath().getRoot(), *.resolve(Path other);
  - [Less_31_Path_Step3](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_1_Path/src/Less_31_ch_1_Path/Less_31_Path_Step3.java) - метод *.relativize(Path other);

- [Less_31_ch_2_Files](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_2_Files/src/Less_31_ch_2_Files) - примеры использования методов класса Files:
  - [Less_31_Files_Step1](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_2_Files/src/Less_31_ch_2_Files/Less_31_Files_Step1.java) - методы *.createFile(), *.createDirectory();
  - [Less_31_Files_Step2](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_2_Files/src/Less_31_ch_2_Files/Less_31_Files_Step2.java) - методы *.isExecutable(Path path), *.isHidden(Path path), *.isReadable(Path path), *.isWritable(Path path);
  - [Less_31_Files_Step3](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_2_Files/src/Less_31_ch_2_Files/Less_31_Files_Step3.java) - метода *.isSameFile();
  - [Less_31_Files_Step4](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_2_Files/src/Less_31_ch_2_Files/Less_31_Files_Step4.java) - метода *.size();
  - [Less_31_Files_Step5](https://github.com/JcoderPaul/JavaExtended-30-32/blob/master/Less_31_ch_2_Files/src/Less_31_ch_2_Files/Less_31_Files_Step5.java) - методы *.getAttribute(), *.readAttributes();

- [Less_31_ch_3_FilesPathCopy](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_3_FilesPathCopy/src/Less_31_ch_3_FilesPathCopy) - пример применения метода Files.copy() при работе с файлами и 
папками (копирование файлов и папок)..

- [Less_31_ch_4_FilesPathMove](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_4_FilesPathMove/src/Less_31_ch_4_FilesPathMove) - пример применения метода Files.move() при работе с файлами и 
папками (перемещение и переименование файлов и папок).

- [Less_31_ch_5_FilesPathDelete](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_5_FilesPathDelete/src/Less_31_ch_5_FilesPathDelete) - пример применения метода Files.delete() удаление файлов 
и пустых папок, и Files.deleteIfExists() удаление файлов и пустых папок при их наличии.

- [Less_31_ch_6_FilesPathWrite](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_6_FilesPathWrite/src/Less_31_ch_6_FilesPathWrite) - примеры работы метода Files.write(), запись данных в файл.

- [Less_31_ch_7_FilesPathRead](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_31_ch_7_FilesPathRead/src/Less_31_ch_7_FilesPathRead) - пример работы с методом Files.readAllLines(), чтение всех 
строк текстового файла.

- [Less_32_ch_1_WalkFileTree](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_32_ch_1_WalkFileTree/src/Less_32_ch_1_WalkFileTree) - примеры работы с методом позволяющим обходить файловое дерево 
Files.walkFileTree(), особенности применения интерфейса FileVisitor при работе этого метода.

- [Less_32_ch_2_WalkFileTreeCopyDir](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_32_ch_2_WalkFileTreeCopyDir/src/Less_32_ch_2_WalkFileTreeCopyDir) - копирование (всего/определенного) содержимого заданной 
директории при помощи методы Files.walkFileTree() и класса наследника SimpleFileVisitor.

- [Less_32_ch_3_WalkFileTreeDeleteDir](https://github.com/JcoderPaul/JavaExtended-30-32/tree/master/Less_32_ch_3_WalkFileTreeDeleteDir/src/Less_32_ch_3_WalkFileTreeDeleteDir) - удаление (всего/определенного) содержимого заданной 
директории при помощи методы Files.walkFileTree() и класса наследника SimpleFileVisitor.
