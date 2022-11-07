package Less_31_ch_4_FilesPathMove;
/*
Пример работы метода Files.move()

!!! Помним, что данный метод позволяет перемещать файлы и
папки с новым именем, что равносильно переименованию !!!

Отдельного метода Files.rename() вроде, как нет.
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Less_31_FilesPathMove_Step2 {
    public static void main(String[] args) throws IOException {
        Path dir_for_move = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\DirForMove");
        Path dir_2_for_move = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\Dir2ForMove");
        Path path_move_to = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveTo");

        System.out.println("Папка и имя файла для перемещения -> " + dir_for_move);
        System.out.println("Имя файла для перемещения: " + dir_for_move.getFileName());
        System.out.println("Папка назначения -> " + path_move_to);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Результат работы метода *.resolve() -> " +
                                     path_move_to.resolve(dir_for_move.getFileName()));
        Files.move(dir_for_move,
                   path_move_to.resolve(dir_for_move.getFileName()),
                   REPLACE_EXISTING);

        Files.move(dir_2_for_move,
                   path_move_to.resolve("AnotherDir2InAnotherFolder"),
                   REPLACE_EXISTING);
        // Простое переименование внутри одной папки
        Files.move(Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile\\DirForRename"),
                   Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile\\RenamingDir"),
                   REPLACE_EXISTING);
    }
}
