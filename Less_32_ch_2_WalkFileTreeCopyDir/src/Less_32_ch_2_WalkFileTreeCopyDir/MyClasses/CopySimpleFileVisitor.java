package Less_32_ch_2_WalkFileTreeCopyDir.MyClasses;
/*
В данном классе мы наследуем от класса SimpleFileVisitor, а не подписаны на
интерфейс FileVisitor, что позволяет использовать (переписать) только необходимые
нам методы. Хотя сам класс:

public class SimpleFileVisitor<T> extends Object implements FileVisitor<T>

Методы (FileVisitor) :
- FileVisitResult postVisitDirectory(T dir, IOException exc) - вызывается
для каталога после посещения записей в каталоге и всех их потомков;
- FileVisitResult preVisitDirectory (каталог T, атрибуты BasicFileAttributes) - вызывается
для каталога перед посещением записей в каталоге.
- FileVisitResult visitFile (файл T, атрибуты BasicFileAttributes) - вызывается
для файла в каталоге.
- FileVisitResult visitFileFailed (T-файл, исключение IOException) - вызывается
для файла, который не удалось посетить.
*/
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopySimpleFileVisitor extends SimpleFileVisitor<Path> {
    Path source;
    Path destination;

    public CopySimpleFileVisitor(Path source, Path destination) {
        this.source = source; // Задаем путь откуда будут копироваться файлы
        this.destination = destination; // Задаем путь куда будут копироваться файлы
    }
    /*
    Данный метод реализует, последовательность наших действий при копировании папок,
    при этом метод работает, как бы "перед тем как мы посетим директорию".
    */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        /*
        Поскольку, мы задаем только стартовую папку (источник) с которой будет начат обход дерева
        файлов-каталогов и финишную папку (назначение), но не знаем о содержимом (вложенных папках
        и файлах) папки источника, нам нужно соответствующим образом получить все пути, всех файлов
        и подкаталогов. Далее нам нужно сопоставить им соответствующие папки и файлы в папке куда
        мы планируем копировать данные.

        Например, содержимое папки FolderForCopy (см. путь к одной из папок):
        E:\JavaExtended\Less_32_ch_2_WalkFileTreeCopyDir\src\Less_32_ch_2_WalkFileTreeCopyDir\FolderForCopy\DirOne
        должен быть скопирован в CopyHere (пример пути, если мы не планируем переименовывать файлы и
        папки при копировании):
        E:\JavaExtended\Less_32_ch_2_WalkFileTreeCopyDir\src\Less_32_ch_2_WalkFileTreeCopyDir\CopyHere\DirOne
        Для большей наглядности мы добавили подробный вывод на экран.
        */
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Папка (путь) откуда копируем (source) -> " + source);
        System.out.println("Папка (путь) куда копируем (destination) -> " + destination);
        System.out.println("Папка (путь) которую обходим сейчас -> " + dir);
        System.out.println("Выделяем относительный путь, методом source.relativize(dir) -> \n" +
                source.relativize(dir));

        Path newDestination = destination.resolve(source.relativize(dir));
        System.out.println("Получаем окончательный путь куда копировать текущую папку " +
                "метод destination.resolve(source.relativize(dir)) -> \n" +
                newDestination);
        // Папку, которую обходим сейчас dir, копируем в папку newDestination, с тем же именем
        Files.copy(dir, newDestination, REPLACE_EXISTING);
        // Продолжаем обход дерева
        return FileVisitResult.CONTINUE;
    }

    // Данный метод реализует, последовательность наших действий при копировании файлов
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Папка из которой копируем (source) -> " + source);
        System.out.println("Папка (путь) куда копируем файл (destination) -> " + destination);
        System.out.println("Файл который обходим сейчас -> " + file);
        System.out.println("Выделяем относительный путь, методом source.relativize(file) -> \n" +
                source.relativize(file));
        Path newDestination = destination.resolve(source.relativize(file));
        System.out.println("Получаем окончательный путь куда копировать текущий файл " +
                "метод destination.resolve(source.relativize(file)) -> \n" +
                newDestination);
        // Файл, который обходим сейчас file, копируем в папку newDestination, с тем же именем
        Files.copy(file, newDestination, REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}