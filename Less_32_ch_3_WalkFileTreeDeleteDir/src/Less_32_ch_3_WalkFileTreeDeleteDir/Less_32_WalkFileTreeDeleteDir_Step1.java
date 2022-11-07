package Less_32_ch_3_WalkFileTreeDeleteDir;
/*
Пример - напоминашка про удаление дерева файлов.
Основной код прописан в классе MySimpleFileVisitor.
*/
import Less_32_ch_3_WalkFileTreeDeleteDir.MyClasses.DeleteSimpleFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_32_WalkFileTreeDeleteDir_Step1 {
    public static void main(String[] args) throws IOException {
        // Путь для удаления (папка для удаления)
        Path dirForDel = Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel");
        /*
        Запускаем статический метод *.walkFileTree() в которую передаем два
        параметра:
        - объект класса Path (в нашем случае путь к папке для удаления);
        - объект 'Визитер', класс подписанный на интерфейс FileVisitor

        В 'Визитере' прописана логика конкретных действий при обходе дерева
        файлов-каталогов, в нашем случае, методы 'визитера' удаляют все до
        чего смогут дотянуться.
        */
        Files.walkFileTree(dirForDel, new DeleteSimpleFileVisitor(dirForDel));
    }
}
