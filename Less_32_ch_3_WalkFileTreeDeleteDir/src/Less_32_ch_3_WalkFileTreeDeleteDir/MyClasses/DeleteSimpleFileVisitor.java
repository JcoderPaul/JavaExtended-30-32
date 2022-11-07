package Less_32_ch_3_WalkFileTreeDeleteDir.MyClasses;
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

В данном примере используя наш класс MySimpleFileVisitor мы будем удалять
дерево файлов и для этого нам понадобятся только два метода.
*/
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteSimpleFileVisitor extends SimpleFileVisitor<Path> {
    Path source; // Определяем папку для удаления

    public DeleteSimpleFileVisitor(Path source) {
        this.source = source;
    }
    /*
    Папку нельзя удалить если она содержит внутри себя информацию (вложения),
    поэтому мы используем метод *.postVisitDirectory(), в отличие от
    предыдущего примера (см. Less_32_ch_2_WalkFileTreeCopyDir, где применяли
    метод *.preVisitDirectory()) т.к. он вызывается для каталога после
    посещения записей в каталоге и всех их потомков.

    Значит, сначала будет использован метод *.visitFile() в котором прописан
    код для удаления файлов дерева, которое мы обходим. И уже затем метод
    *.postVisitDirectory() в котором прописан код для удаления вложенных
    директорий. Которые будут уже пустыми к этому моменту.
    */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Удаляем директорию -> " + dir.getFileName());
        Files.delete(dir);
        // Продолжаем обход дерева
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Удаляем файл ->" + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }
}