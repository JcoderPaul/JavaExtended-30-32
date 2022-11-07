package Less_31_ch_3_FilesPathCopy;
/*
Пример работы метода Files.copy() на папках.
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Less_31_FilesPathCopy_Step2 {
    public static void main(String[] args) throws IOException {
        String file_one = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FileOne.txt";
        String file_two = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyTo\\FileTwo.txt";
        String file_three = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FileThree.txt";

        String dir_copy_from = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom";
        String dir_copy_to = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyTo";
        String dir_for_copy = "src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FolderForCopy";

        Path path_to_file_one = Paths.get(file_one);
        Path path_to_file_two = Paths.get(file_two);
        Path path_to_file_three = Paths.get(file_three);
        Path path_copy_from = Paths.get(dir_copy_from);
        Path path_copy_to = Paths.get(dir_copy_to);
        Path path_to_folder_for_copy = Paths.get(dir_for_copy);

        /*
        Как и в примере с файлами, нам нужен явный конкретный источник, и самое главное,
        явный конкретный (со своим именем, либо старым - тот что копируем, либо новый)
        пункт назначения.

        В нашем примере:
        1. из папки: 'src\Less_31_ch_3_FilesPathCopy\FolderCopyFrom'
        2. папка: 'FolderForCopy'
        3. копируется в папку: 'src\Less_31_ch_3_FilesPathCopy\FolderCopyTo'
        4. с именем: 'CopiedFolderFour'

        Хотя мы могли при копировании сохранить старое имя 'FolderForCopy' просто
        прописав его в адресе назначении. См. пример ниже с методом *.resolve()

        !!! Теперь необходимо обратить внимание, на результаты работы метода
        *.copy() !!! Содержимое копируемой папки не копируется, т.е. в нашем
        примере, файл 'TestFileInFolderForCopy.txt' из папки 'FolderForCopy'
        остался на месте и не скопировался в новое место вместе с папкой.
        !!! При копировании папок копируется только папка, а не ее содержимое !!!
        */
        Files.copy(Paths.get("src\\Less_31_ch_3_FilesPathCopy\\FolderCopyFrom\\FolderForCopy"),
                   Paths.get("src\\Less_31_ch_3_FilesPathCopy\\FolderCopyTo\\CopiedFolderFour"),
                   REPLACE_EXISTING);

        /*
        Как и в примере Less_31_FilesPathCopy_Step1 методом *.resolve() мы
        соединяем 'путь + имя папки' и получаем пункт назначения, куда копируем.
        */
        System.out.println("Путь к папке которую копируем -> " + path_to_folder_for_copy);
        System.out.println("Имя папки которую копируем: " + path_to_folder_for_copy.getFileName());
        System.out.println("Папка куда копируем -> " + path_copy_to);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Итоговый путь назначения: " + path_copy_to.
                                                    resolve(path_to_folder_for_copy.getFileName()));

        Files.copy(path_to_folder_for_copy,
                   path_copy_to.resolve(path_to_folder_for_copy.getFileName()),
                   REPLACE_EXISTING);

    }
}
