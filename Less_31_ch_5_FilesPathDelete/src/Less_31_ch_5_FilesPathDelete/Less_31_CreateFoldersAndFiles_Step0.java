package Less_31_ch_5_FilesPathDelete;
/*
Повторение пройденного, создаем файлы и папки
для работы с методами:
*.delete();
*.deleteIfExists();
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_31_CreateFoldersAndFiles_Step0 {
    public static void main(String[] args) throws IOException {
        // Создаем папки и файлы для работы и тестирования метода *.delete()
        Path dirForWork =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork");
        if(!Files.exists(dirForWork)){
            Files.createDirectory(dirForWork);
        }
        Path dirForDel =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FolderForDel");
        if(!Files.exists(dirForDel)){
            Files.createDirectory(dirForDel);
        }
        Path dirForDel2 =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FolderForDel2");
        if(!Files.exists(dirForDel2)){
            Files.createDirectory(dirForDel2);
        }
        Path fileForDel =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FileForDel.txt");
        if(!Files.exists(fileForDel)){
            Files.createFile(fileForDel);
        }
        Path fileInFolderForDel =
                Paths.get("src\\Less_31_ch_5_FilesPathDelete\\DirForWork\\FolderForDel2\\FileForDel2.txt");
        if(!Files.exists(fileInFolderForDel)){
            Files.createFile(fileInFolderForDel);
        }
    }
}
