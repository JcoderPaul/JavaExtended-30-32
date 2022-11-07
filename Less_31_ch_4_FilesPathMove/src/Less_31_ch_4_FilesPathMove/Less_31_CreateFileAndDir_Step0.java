package Less_31_ch_4_FilesPathMove;
/*
Повторяем пройденный материал создаем папки
и файлы для работы с методом *.move()
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Less_31_CreateFileAndDir_Step0 {
    public static void main(String[] args) throws IOException {

        // Создаем папки откуда будут происходить перемещения
        Path dirMoveFrom = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom");
        if(!Files.exists(dirMoveFrom)){
            Files.createDirectory(dirMoveFrom);
        }
        Path dirForMove = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\DirForMove");
        if(!Files.exists(dirForMove)){
            Files.createDirectory(dirForMove);
        }
        Path dir2ForMove = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\Dir2ForMove");
        if(!Files.exists(dir2ForMove)){
            Files.createDirectory(dir2ForMove);
        }

        // Создаем папку куда будет проходить перемещение
        Path dirMoveTo = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveTo");
        if(!Files.exists(dirMoveTo)){
            Files.createDirectory(dirMoveTo);
        }

        // Создаем папку в которой работа будет происходить внутри нее
        Path dirForRenameTest = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile");
        if(!Files.exists(dirForRenameTest)){
            Files.createDirectory(dirForRenameTest);
        }
        Path dirForRename = Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile\\DirForRename");
        if(!Files.exists(dirForRename)){
            Files.createDirectory(dirForRename);
        }

        // Создаем файлы для работы
        Path fileMoveFrom1 =
                Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\FileForMove.txt");
        if(!Files.exists(fileMoveFrom1)){
            Files.createFile(fileMoveFrom1);
        }
        Path fileMoveFrom2 =
                Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\File2ForMove.txt");
        if(!Files.exists(fileMoveFrom2)){
            Files.createFile(fileMoveFrom2);
        }
        Path file2ForMove =
                Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderRenameFile\\Rename_1_file.txt");
        if(!Files.exists(file2ForMove)){
            Files.createFile(file2ForMove);
        }
        Path fileInnerMoveFromDir1 =
                Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\DirForMove\\FileInFolder.txt");
        if(!Files.exists(fileInnerMoveFromDir1)){
            Files.createFile(fileInnerMoveFromDir1);
        }
        Path fileInnerMoveFromDir2 =
                Paths.get("src\\Less_31_ch_4_FilesPathMove\\FolderMoveFrom\\Dir2ForMove\\FileInFolder2.txt");
        if(!Files.exists(fileInnerMoveFromDir2)){
            Files.createFile(fileInnerMoveFromDir2);
        }

    }
}
