package Less_31_ch_2_Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Примеры использования методов класса Files
*.isExecutable(Path path);
*.isHidden(Path path);
*.isReadable(Path path);
*.isWritable(Path path);
*/
public class Less_31_Files_Step2 {
    public static void main(String[] args) throws IOException {
        // Задаем пути будущих, пока не существующих файла и папки
        String file_to_work = "src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt";
        String dir_to_work = "src\\Less_31_ch_2_Files\\DirWithFile";
        // Превращаем их в объекты Path
        Path path_to_file = Paths.get(file_to_work);
        Path path_to_dir = Paths.get(dir_to_work);
        // Проверяем их реальное существование
        boolean fileExist = Files.exists(path_to_file);
        boolean dirExist = Files.exists(path_to_dir);
        System.out.println("-------------------------------- *.exists() --------------------------------");
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt существует -> " + fileExist);
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile существует -> " + dirExist);
        System.out.println(" ");
        System.out.println("------ *.isReadable() -- *.isWritable() -- *.isExecutable() -- *.isHidden() ------");
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt читается -> " +
                Files.isReadable(path_to_file));
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile читается -> " +
                Files.isReadable(path_to_dir));
        System.out.println(" ");
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt доступен для записи -> " +
                Files.isWritable(path_to_file));
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile доступна для записи -> " +
                Files.isWritable(path_to_dir));
        System.out.println(" ");
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt скрыт ли -> " +
                Files.isHidden(path_to_file));
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile скрыта ли -> " +
                Files.isHidden(path_to_dir));
        System.out.println(" ");
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt запускаем -> " +
                Files.isExecutable(path_to_file));
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile запускаема -> " +
                Files.isExecutable(path_to_dir));








    }
}
