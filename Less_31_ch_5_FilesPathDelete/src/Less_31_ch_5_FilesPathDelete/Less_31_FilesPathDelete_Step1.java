package Less_31_ch_5_FilesPathDelete;
/*
Работа с методами:
*.delete();
*.deleteIfExists();
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_31_FilesPathDelete_Step1 {
    public static void main(String[] args) throws IOException {
        // Три пути для метода удалить, две папки и один файл
        Path dirForDel =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FolderForDel");
        Path fileForDel =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FileForDel.txt");
        Path notEmptyFolder =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FolderForDel2");

        // Удаляем пустую папку и файл
        Files.delete(dirForDel);
        Files.delete(fileForDel);
        /*
        Проверяем перед удалением, есть ли папка, файл (путь). Метод,
        кроме удаления, при наличии / отсутствии удаляемого объекта,
        возвращает true / false.
        */
        boolean yesOrNo = Files.deleteIfExists(
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\NotExistFolder"));
        System.out.println("Существует ли файл для удаления -> " + yesOrNo);
        // Удаляем папку не пустую, а с файлом внутри
        Files.delete(notEmptyFolder);
        /*
        Если в первом и втором случае, пустая папка и файл, удалились нормально,
        то в случае не пустой директории, метод Files.delete() выкидывает ->
        -> " Exception in thread "main" java.nio.file.DirectoryNotEmptyException:
        src\Less_31_ch_5_FilesPathDelete\DirForWork\FolderForDel2 "

        Т.е. перед удаление не пусто папки следует ее почистить или провести другие
        мероприятия...
        */

    }
}
