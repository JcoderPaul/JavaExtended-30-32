package Less_31_ch_4_FilesPathMove;
/*
Пример работы метода Files.move()

!!! Помним, что данный метод позволяет перемещать файлы и
папки с новым именем, что равносильно переименованию !!!

Отдельного метода Files.rename() вроде, как нет.
*/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Less_31_FilesPathMove_Step1 {
    public static void main(String[] args) throws IOException {
        Path file_for_move = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\FileForMove.txt");
        Path file_2_for_move = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\File2ForMove.txt");
        Path path_move_to = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveTo");

        /*
        Как и в случае с копированием файлов см. Less_31_ch_3_FilesPathCopy, метод
        Files.move(PathFrom, PathTo, CopyOption...) имеет ряд четких и окончательных
        параметров:
        - PathFrom - откуда и что перемещать;
        - PathTo - куда и что перемещать;
        - CopyOption - на каких условиях перемещать.

        В нашем примере:
        PathFrom -> 'src\Less_31_ch_4_FilesPathMove\FolderMoveFrom\FileForMove.txt';
        PathTo -> 'src\Less_31_ch_4_FilesPathMove\FolderMoveTo\FileForMove.txt';
        При этом PathTo получился из:
        1. path_move_to = 'src\Less_31_ch_4_FilesPathMove\FolderMoveTo'
        2. file_for_move.getFileName() = FileForMove.txt
        3. *.resolve() вернул = 'src\Less_31_ch_4_FilesPathMove\FolderMoveTo\FileForMove.txt'
        */
        System.out.println("Папка и имя файла для перемещения -> " + file_for_move);
        System.out.println("Имя файла для перемещения: " + file_for_move.getFileName());
        System.out.println("Папка назначения -> " + path_move_to);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Результат работы метода *.resolve() -> " +
                                     path_move_to.resolve(file_for_move.getFileName()));
        Files.move(file_for_move,
                   path_move_to.resolve(file_for_move.getFileName()),
                   REPLACE_EXISTING);
        /*
        !!! Переименование !!!
        1. Переместим файл: 'File2ForMove.txt'
        2. в папку: 'src\Less_31_ch_4_FilesPathMove\FolderMoveTo'
        3. с новым именем: 'File2ForMove.txt'
        тут переименование с перемещением.
        */
        Files.move(file_2_for_move,
                   path_move_to.resolve("File2ForMove.txt"),
                   REPLACE_EXISTING);
        // Простое переименование внутри одной папки
        Files.move(Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile\\Rename_1_file.txt"),
                   Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile\\Rename_2_file.txt"),
                   REPLACE_EXISTING);

    }
}
