******* Class Files - Класс Files *******

Наследник: public final class Files extends Object
Входит в пакет: java.nio.file.Files

Этот класс состоит исключительно из статических методов, которые работают с файлами,
каталогами или другими типами файлов. В большинстве случаев определенные им методы
будут делегировать выполнение файловых операций соответствующему провайдеру файловой
системы.

Files — это утилитный класс, куда были вынесены статические методы из класса File.
Files — это примерно то же, что и Arrays или Collections, только работает он с файлами,
а не с массивами и коллекциями.

Класс сосредоточен на управлении файлами и директориями. Используя статические методы
класса Files, мы можем создавать, удалять и перемещать файлы и директории. Для этих
операций используются createFile() (для директорий — createDirectory()), move(),
delete() и др. подобные методы.

Внимание: так же, как и методы интерфейса Path, многие методы Files возвращают объект Path.
Большинство методов класса Files принимают на вход также объекты Path. Для работы с ними
активно пользуются Paths.get(). !! Самое главное у класса Files есть метод copy() !!

Методы класса Files:
*** МЕТОДЫ COPY ***

- long copy(InputStream in, Path target, CopyOption... options) - копирует все байты из входного потока
  в файл.
- long copy(Path source, OutputStream out) - копирует все байты из файла в выходной поток.
- Path copy(Path source, Path target, CopyOption... options) - копирует файл в целевой файл.

*** МЕТОДЫ CREATE ***

- Path createDirectories(Path dir, FileAttribute<?>... attrs) - создает каталог, сначала создавая все
  несуществующие родительские каталоги.

- Path createDirectory(Path dir, FileAttribute<?>... attrs) - создает новый каталог.

- Path createFile(Path path, FileAttribute<?>... attrs) - создает новый и пустой файл, терпит неудачу,
  если файл уже существует.

- Path createLink(Path link, Path existing) - создает новую ссылку (запись каталога) для существующего
  файла (дополнительная операция).

- Path createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs) - создает символическую
  ссылку на цель (дополнительная операция).

- Path createTempDirectory(Path dir, String prefix, FileAttribute<?>... attrs) - создает новый каталог
  в указанном каталоге, используя заданный префикс для создания его имени.

- Path createTempDirectory(String prefix, FileAttribute<?>... attrs) - создает новый каталог в каталоге
  временных файлов по умолчанию, используя заданный префикс для создания его имени.

- Path createTempFile(Path dir, String prefix, String suffix, FileAttribute<?>... attrs) - создает новый
  пустой файл в указанном каталоге, используя заданные строки префикса и суффикса для создания его имени.

- Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs) - создает пустой файл в
  каталоге временных файлов по умолчанию, используя заданный префикс и суффикс для создания его имени.

*** МЕТОДЫ DELETE ***

- void delete(Path path) - удаляет файл.
- boolean deleteIfExists(Path path) - удаляет файл, если он существует.

*** МЕТОДЫ EXIST ***

- boolean exists(Path path, LinkOption... options) - проверяет, существует ли файл.

*** МЕТОДЫ GET ***

- Object getAttribute(Path path, String 'attribute', LinkOption... options) - считывает значение
  атрибута файла.

Где 'attribute' может принимать и возвращать:
- "lastModifiedTime" - FileTime;
- "lastAccessTime" - FileTime;
- "creationTime" - FileTime;
- "size" - Long;
- "isRegularFile" - Boolean;
- "isDirectory" - Boolean;
- "isSymbolicLink" - Boolean;
- "isOther" - Boolean;
- "fileKey" - Object;

- <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) -
  возвращает представление атрибутов файла заданного типа.

- FileStore getFileStore(Path path) - возвращает FileStore представление хранилища файлов, в котором
  находится файл.

- FileTime getLastModifiedTime(Path path, LinkOption... options) - возвращает время последнего изменения файла.
- UserPrincipal getOwner(Path path, LinkOption... options) - возвращает владельца файла.
- Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... options) - возвращает права доступа
  к файлу POSIX.

*** МЕТОДЫ IS... ***

- boolean isDirectory(Path path, LinkOption... options) - проверяет, является ли файл каталогом.
- boolean isExecutable(Path path) - проверяет, является ли файл исполняемым.
- boolean isHidden(Path path) - сообщает, считается ли файл скрытым.
- boolean isReadable(Path path) - проверяет, доступен ли файл для чтения.

- boolean isRegularFile(Path path, LinkOption... options) - проверяет, является ли файл обычным
  файлом с непрозрачным содержимым.

- boolean isSameFile(Path path, Path path2) - проверяет, находят ли два пути один и тот же файл.
- boolean isSymbolicLink(Path path) - проверяет, является ли файл символической ссылкой.
- boolean isWritable(Path path) - проверяет, доступен ли файл для записи.

*** МЕТОДЫ MOVE ***

- Path move(Path source, Path target, CopyOption... options) - переместите или переименуйте файл
  в целевой файл.

*** МЕТОДЫ ВОЗВРАЩАЮЩИЕ КАНАЛЫ, БУФЕРЫ, ПОТОКИ ДАННЫХ ***

- BufferedReader newBufferedReader(Path path, Charset cs) - открывает файл для чтения, возвращая
  значение BufferedReader, которое можно использовать для эффективного чтения текста из файла.

- BufferedWriter newBufferedWriter(Path path, Charset cs, OpenOption... options) - открывает или
  создает файл для записи, возвращая значение BufferedWriter , которое можно использовать для
  эффективной записи текста в файл.

- SeekableByteChannel newByteChannel(Path path, OpenOption... options) - открывает или создает файл,
  возвращая доступный для поиска байтовый канал для доступа к файлу.

- SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) -
  открывает или создает файл, возвращая доступный для поиска байтовый канал для доступа к файлу.

- DirectoryStream<Path> newDirectoryStream(Path dir) - открывает каталог, возвращая DirectoryStream
  для перебора всех записей в каталоге.

- DirectoryStream<Path> newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) -
  открывает каталог, возвращая DirectoryStream для перебора записей в каталоге.

- DirectoryStream<Path> newDirectoryStream(Path dir, String glob) - открывает каталог, возвращая
  DirectoryStream для перебора записей в каталоге.

- InputStream newInputStream(Path path, OpenOption... options) - открывает файл, возвращая входной
  поток для чтения из файла.

- OutputStream newOutputStream(Path path, OpenOption... options) - открывает или создает файл,
  возвращая выходной поток, который можно использовать для записи байтов в файл.

*** МЕТОДЫ ТЕСТЕРЫ ***

- boolean notExists(Path path, LinkOption... options) - проверяет, не существует ли файл,
  расположенный по этому пути.

- String probeContentType(Path path) - проверяет тип содержимого файла.

*** МЕТОДЫ READ ***

- byte[] readAllBytes(Path path) - читает все байты из файла.
- List<String> readAllLines(Path path, Charset cs) - прочитать все строки из файла в List.

- <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) -
  считывает атрибуты файла как массовую операцию.

- Map<String,Object> readAttributes(Path path, String attributes, LinkOption... options) -
  считывает набор атрибутов файла как массовую операцию.

- Path readSymbolicLink(Path link) - читает цель символической ссылки (дополнительная операция).

*** МЕТОДЫ SET ***

- Path setAttribute(Path path, String attribute, Object value, LinkOption... options) - задает
  значение атрибута файла.

- Path setLastModifiedTime(Path path, FileTime time) - обновляет атрибут времени последнего
  изменения файла.

- Path setOwner(Path path, UserPrincipal owner) - обновляет владельца файла.
- Path setPosixFilePermissions(Path path, Set<PosixFilePermission> perms) - устанавливает разрешения
  POSIX для файла.

*** МЕТОДЫ SIZE ***

- long size(Path path) - возвращает размер файла (в байтах).

*** МЕТОДЫ WALK ***

- Path walkFileTree(Path start, FileVisitor<? super Path> visitor) - обходит файловое дерево.

- Path walkFileTree(Path start, Set<FileVisitOption> options, int maxDepth, FileVisitor<? super Path> visitor) -
  обходит файловое дерево.

*** МЕТОДЫ WRITE ***

- Path write(Path path, byte[] bytes, OpenOption... options) - записывает байты в файл.

- Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options) -
  запись строк текста в файл.

------------------------------------------------------------------------------------------------------------
Более подробно смотреть на: https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html