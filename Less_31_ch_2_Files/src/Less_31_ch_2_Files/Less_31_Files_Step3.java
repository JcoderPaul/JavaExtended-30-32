package Less_31_ch_2_Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Примеры использования методов класса Files
*.isSameFile();
*/
public class Less_31_Files_Step3 {
    public static void main(String[] args) throws IOException {
        // Задаем пути будущих, пока не существующих файла и папки
        String file_to_work = "src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt";
        String dir_to_work = "src\\Less_31_ch_2_Files\\DirWithFile";
        // Желательно перед запуском их все же создать через Less_31_Files_Step1
        String file_to_create = "src\\Less_31_ch_2_Files\\DirTwo\\TestTwo.txt";
        String dir_to_create = "src\\Less_31_ch_2_Files\\DirTwo\\DirThree";
        // Оставим пару путей относительными
        Path relative_path_to_file = Paths.get(file_to_work);
        Path relative_path_to_dir = Paths.get(dir_to_work);
        // Превращаем их в объекты Path с абсолютным путем
        Path path_to_file = relative_path_to_file.toAbsolutePath();
        Path path_to_dir = relative_path_to_dir.toAbsolutePath();
        Path path_to_file_2 = Paths.get(file_to_create).toAbsolutePath();
        Path path_to_dir_2 = Paths.get(dir_to_create).toAbsolutePath();

        // Проверяем их реальное существование
        boolean fileExist = Files.exists(path_to_file);
        boolean dirExist = Files.exists(path_to_dir);
        boolean file2Exist = Files.exists(path_to_file_2);
        boolean dir2Exist = Files.exists(path_to_dir_2);
        System.out.println("-------------------------------- *.exists() --------------------------------");
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt существует -> " + fileExist);
        System.out.println("src\\Less_31_ch_2_Files\\DirWithFile существует -> " + dirExist);
        System.out.println("src\\Less_31_ch_2_Files\\DirTwo\\TestTwo.txt существует -> " + file2Exist);
        System.out.println("src\\Less_31_ch_2_Files\\DirTwo\\DirThree существует -> " + dir2Exist);
        System.out.println(" ");
        System.out.println("-------------------------------- *.isSameFile --------------------------------");
        /*
        boolean isSameFile(Path path, Path path2) - проверяет, находят ли два пути один и тот же файл.
        */
        System.out.println("'src\\Less_31_ch_2_Files\\DirWithFile' \n" +
                           "и \n" +
                           "'E:\\JavaExtended\\Less_31_ch_2_Files\\src\\Less_31_ch_2_Files\\DirWithFile\\'\n" +
                           "указывают на одну и ту же директорию -> " +
                           Files.isSameFile(relative_path_to_dir, path_to_dir));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("'src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt' \n" +
                "и \n" +
                "'E:\\JavaExtended\\Less_31_ch_2_Files\\src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt'\n" +
                "указывают на один и тот же файл -> " +
                Files.isSameFile(relative_path_to_file, path_to_file));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("'src\\Less_31_ch_2_Files\\DirWithFile\\TestFile.txt' \n" +
                "и \n" +
                "'src\\Less_31_ch_2_Files\\DirTwo\\TestTwo.txt'\n" +
                "указывают на один и тот же файл -> " +
                Files.isSameFile(path_to_file_2, path_to_file));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("'src\\Less_31_ch_2_Files\\DirWithFile' \n" +
                "и \n" +
                "'src\\Less_31_ch_2_Files\\DirTwo\\DirThree'\n" +
                "указывают на одну и ту же директорию -> " +
                Files.isSameFile(path_to_dir, path_to_dir_2));


    }
}
