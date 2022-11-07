package Less_32_ch_2_WalkFileTreeCopyDir;
/*
В текущем примере-напоминалке мы используем тот же
метод Files.walkFileTree(), для обхода директории
или дерева файлов.

Еще раз, сам метод Files.walkFileTree предназначен
для обхода некоего, выбранного нами каталога,
вглубь, не более.

А вот конкретную реализацию того, что будет делать
метод при обходе дерева файлов, определяет разработчик.

Например, в напоминалке Less_32_ch_1_WalkFileTree метод
просто обходил дерево и выводил данные о содержимом на
экран. Но этот функционал в него заложили мы, через
методы интерфейса FileVisitor.

В данном примере используя этот же метод, но уже для
копирования файлов из одной папки в другую. Т.е. мы
задаем тот функционал, что нужен нам в данной ситуации.

При этом в качестве параметра 'визитера' уже используется
класс наследник от SimpleFileVisitor, предоставляющий
для наших целей те же методы, что и интерфейс FileVisitor.

public class SimpleFileVisitor<T> extends Object implements FileVisitor<T>
Если коротко - простой посетитель файлов с поведением по
умолчанию для посещения всех файлов и повторного выдачи
ошибок ввода-вывода.

Методы этого класса могут быть переопределены в соответствии
с их общим контрактом.
*/
import Less_32_ch_2_WalkFileTreeCopyDir.MyClasses.CopySimpleFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_32_WalkFileTreeCopyDir_Step1 {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("src\\Less_32_ch_2_WalkFileTreeCopyDir\\FolderForCopy");
        Path destination = Paths.get("src\\Less_32_ch_2_WalkFileTreeCopyDir\\CopyHere");
        // Создаем папку куда будем копировать данные
        Files.createDirectory(destination);


        Files.walkFileTree(source, new CopySimpleFileVisitor(source, destination));
    }
}
