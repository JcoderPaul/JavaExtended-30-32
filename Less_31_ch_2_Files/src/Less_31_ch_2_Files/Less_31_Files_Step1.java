package Less_31_ch_2_Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Примеры использования методов класса Files
*.createFile();
*.createDirectory();

*/
public class Less_31_Files_Step1 {
    public static void main(String[] args) throws IOException {
        // Задаем пути будущих, пока не существующих файла и папки
        String file_to_create = "src\\Less_31_ch_2_Files\\DirTwo\\TestTwo.txt";
        String dir_to_create = "src\\Less_31_ch_2_Files\\DirTwo\\DirThree";
        // Превращаем их в объекты Path
        Path path_to_file = Paths.get(file_to_create);
        Path path_to_dir = Paths.get(dir_to_create);
        // Проверяем их реальное существование
        boolean fileExist = Files.exists(path_to_file);
        boolean dirExist = Files.exists(path_to_dir);
        // Если файлы и папки есть не создаем, нет их создаем
        if(!fileExist){
            Files.createFile(path_to_file);
        }

        if(!dirExist){
            Files.createDirectory(path_to_dir);
        }
    }
}
