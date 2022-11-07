package Less_31_ch_3_FilesPathCopy;
/*
Пример работы метода Files.copy() на файлах.
*/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Less_31_FilesPathCopy_Step1 {
    public static void main(String[] args) throws IOException {
        String file_one = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FileOne.txt";
        String file_two = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyTo\\FileTwo.txt";
        String file_three = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FileThree.txt";

        String dir_copy_from = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom";
        String dir_copy_to = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyTo";

        Path path_to_file_one = Paths.get(file_one);
        Path path_to_file_two = Paths.get(file_two);
        Path path_to_file_three = Paths.get(file_three);
        Path path_copy_from = Paths.get(dir_copy_from);
        Path path_copy_to = Paths.get(dir_copy_to);

        /*
        Разберем, что тут написано (без практики забывается).

        Метод *.copy(Path, Path, CopyOption...) принимает на вход два адреса (пути),
        для того, чтобы превратить наши абсолютные пути к файлам из формата String
        используем метод *.get(), причем, в данном случае используем абсолютные пути.

        Источник должен быть точным, т.е. (путь к файлу + сам файл (имя файла)), пункт
        назначения тоже должен быть точным (путь к файлу + сам файл (имя файла, может
        быть тем же, или может быть другим, т.е. мы копируем файл с новым именем))

        Естественно, желательно, чтобы в папке куда копируется файл, файла с таким
        именем не было. Еще раз, имя файла в адресе назначения есть, например FileFive.txt,
        а самого файла в папке нет, иначе -> Exception java.nio.file.FileAlreadyExistsException
        !!! Либо явно указываем, что делать при наличии такового, в аргументах метода -
        REPLACE_EXISTING !!!
        */
        Files.copy(Paths.get("E:\\JavaExtended\\Less_31_ch_3_FilesPathCopy\\" +
                                 "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FileOne.txt"),
                   Paths.get("E:\\JavaExtended\\Less_31_ch_3_FilesPathCopy\\" +
                                 "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyTo\\FileFive.txt"),
                   REPLACE_EXISTING);

        // Посмотрим откуда мы копируем, адрес относительный
        System.out.println("Откуда и что копируем -> " + path_to_file_one);
        /*
        Пример работы метода path_copy_to.resolve(path_to_file_one.getFileName()):
        - path_copy_to = src\Less_31_ch_3_FilesPathCopy\FolderCopyTo
        - path_to_file_one = src\Less_31_ch_3_FilesPathCopy\FolderCopyFrom\FileOne.txt
        нам нужно получить четкий путь назначения с именем файла в конце, для этого
        мы используем метод .getFileName(), который извлекает имя файла FileOne.txt из
        адреса источника (мы хотим сохранить имя файла при копировании)
        */
        // Что хотим скопировать
        System.out.println("Имя копируемого файла: " + path_to_file_one.getFileName());
        /*
        И так папка (адрес папки) куда мы копируем у нас есть, имя файла тоже есть
        подключаем к работе метод объединяющий эти две переменные, в нашем примере:
        'src\Less_31_ch_3_FilesPathCopy\FolderCopyTo'.resolve('FileOne.txt')
        на выходе объект Path = src\Less_31_ch_3_FilesPathCopy\FolderCopyTo\FileOne.txt
        */
        // Куда и с каким именем (пусть с таким же)
        System.out.println("Куда и что копируем -> " + path_copy_to.resolve(path_to_file_one.getFileName()));
        /*
        Передаем все данные в метод Files.copy(PathFrom, PathTo, CopyOption...) опцию
        выставили REPLACE_EXISTING, если даже файл с таким именем есть в папке, все
        равно завершить операцию, с заменой файла получателя.
        */
        Files.copy(path_to_file_one,
                   path_copy_to.resolve(path_to_file_one.getFileName()),
                   REPLACE_EXISTING);
        /*
        Из папки: 'src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom'
        берем файл 'FileThree.txt', который имеет адрес:
        'src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FileThree.txt'

        и копируем в папку: 'src\Less_31_ch_3_FilesPathCopy\FolderCopyTo'
        присвоив ему имя: 'Сopy_File_Three.txt'
        метод *.resolve() вернет объект Path 'адрес + имя файла':
        'src\Less_31_ch_3_FilesPathCopy\FolderCopyTo\Сopy_File_Three.txt'

        Параметр: REPLACE_EXISTING - перезаписываем файлы в которые
        копируются исходные файлы.
        */
        Files.copy(path_to_file_three,
                   path_copy_to.resolve("Сopy_File_Three.txt"),
                   REPLACE_EXISTING);
    }
}
