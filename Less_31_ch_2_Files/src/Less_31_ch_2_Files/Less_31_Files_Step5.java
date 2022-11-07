package Less_31_ch_2_Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

/*
Примеры использования методов класса Files
*.getAttribute();
*.readAttributes('*');
*/
public class Less_31_Files_Step5 {
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
        System.out.println("-------------------------------- *.getAttribute() --------------------------------");
        /*
        Object getAttribute(Path path, String 'attribute', LinkOption... options) - считывает значение
        атрибута файла.
        */
        System.out.println("Смотрим атрибуты 'TestFile.txt' :");
        System.out.println("Последние изменения -> " + Files.getAttribute(path_to_file,"lastModifiedTime"));
        System.out.println("Время создания -> " + Files.getAttribute(path_to_file,"creationTime"));
        System.out.println("Размер -> " + Files.getAttribute(path_to_file,"size"));
        System.out.println("Это папка -> " + Files.getAttribute(path_to_file,"isDirectory"));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Смотрим атрибуты 'src\\Less_31_ch_2_Files\\DirWithFile' :");
        System.out.println("Последние изменения -> " + Files.getAttribute(path_to_dir,"lastModifiedTime"));
        System.out.println("Время создания -> " + Files.getAttribute(path_to_dir,"creationTime"));
        System.out.println("Размер -> " + Files.getAttribute(path_to_dir,"size"));
        System.out.println("Это папка -> " + Files.getAttribute(path_to_dir,"isDirectory"));
        System.out.println();
        System.out.println("-------------------------------- *.readAttributes('*') --------------------------------");
        System.out.println("Смотрим все атрибуты 'TestFile.txt' :");
        Map<String, Object> fileAttributes = Files.readAttributes(path_to_file,"*");
        for (Map.Entry<String, Object> atrEntry : fileAttributes.entrySet()) {
            System.out.println(atrEntry.getKey() + " : " + atrEntry.getValue());
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Смотрим все атрибуты 'src\\Less_31_ch_2_Files\\DirWithFile' :");
        Map<String, Object> dirAttributes = Files.readAttributes(path_to_dir,"*");
        for (Map.Entry<String, Object> atrEntry : dirAttributes.entrySet()) {
            System.out.println(atrEntry.getKey() + " : " + atrEntry.getValue());
        }

    }
}
