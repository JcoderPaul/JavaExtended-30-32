package Less_32_ch_3_WalkFileTreeDeleteDir;
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

public class Less_32_CreateFoldersAndFiles_Step0 {
    public static void main(String[] args) throws IOException {
        // Создаем папки и файлы для работы и тестирования метода *.delete()
        Path dirForDel0 =
                Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel");
        if(!Files.exists(dirForDel0)){
            Files.createDirectory(dirForDel0);
        }
        Path dirForDel1 =
                Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel\\FolderForDel");
        if(!Files.exists(dirForDel1)){
            Files.createDirectory(dirForDel1);
        }
        Path dirForDel2 =
                Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel\\FolderForDel2");
        if(!Files.exists(dirForDel2)){
            Files.createDirectory(dirForDel2);
        }
        Path dirForDel3 =
                Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel\\FolderForDel2\\FolderForDel3");
        if(!Files.exists(dirForDel3)){
            Files.createDirectory(dirForDel3);
        }
        Path fileForDel =
                Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel\\FileForDel.txt");
        if(!Files.exists(fileForDel)){
            Files.createFile(fileForDel);
        }
        Path fileInFolderForDel =
                Paths.get("src\\Less_32_ch_3_WalkFileTreeDeleteDir\\FolderForDel\\FolderForDel2\\FileForDel2.txt");
        if(!Files.exists(fileInFolderForDel)){
            Files.createFile(fileInFolderForDel);
        }
    }
}
