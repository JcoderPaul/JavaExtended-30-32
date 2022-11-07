package Less_31_ch_1_Path;
/*
Рассмотрены методы и их совместная работа Path:
- *.toAbsolutePath().getParent();
- *.toAbsolutePath().getRoot();
- *.resolve(Path other);
*/
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_31_Path_Step2 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_31_ch_1_PathAndFiles\\MyFiles\\FileTest.txt";
        String path_to_dir = "src\\Less_31_ch_1_PathAndFiles\\DirectoryTwo\\NestedDirSecond";
        String path_to_empty_dir =
                "E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles\\EmptyThirdDir\\";
        String path_to_no_file = "NoFileAnywhere.txt";

        Path pathToFile = Paths.get(path_to_file);
        Path pathToDir = Paths.get(path_to_dir);
        Path pathToEmptyDir = Paths.get(path_to_empty_dir);
        Path pathToNoFile = Paths.get(path_to_no_file);

        System.out.println("------------------------ *.toAbsolutePath().getParent() ------------------------");
        /*
        Метод toAbsolutePath() - возвращает объект Path, представляющий абсолютный путь.
              getParent() - возвращает родительский путь или, null если текущий путь не
                            имеет родителя.
        */
        System.out.println("pathToFile.toAbsolutePath().getParent() -> " +
                            pathToFile.toAbsolutePath().getParent());
        System.out.println("pathToDir.toAbsolutePath().getParent() -> " +
                            pathToDir.toAbsolutePath().getParent());
        System.out.println("pathToEmptyDir.toAbsolutePath().getParent() -> " +
                            pathToEmptyDir.toAbsolutePath().getParent());
        System.out.println("pathToNoFile.toAbsolutePath().getParent() -> " +
                            pathToNoFile.toAbsolutePath().getParent());
        System.out.println("------------------------ *.toAbsolutePath().getRoot() ------------------------");
        /*
        Метод toAbsolutePath() - возвращает объект Path, представляющий абсолютный путь.
              getRoot() - возвращает корневой компонент текущего пути в виде Path объекта
              или, null если текущий путь не имеет корневого компонента.
        */
        System.out.println("pathToFile.toAbsolutePath().getRoot() -> " +
                            pathToFile.toAbsolutePath().getRoot()); // Корневой диск:\
        System.out.println("pathToDir.toAbsolutePath().getRoot() -> " +
                            pathToDir.toAbsolutePath().getRoot()); // Корневой диск:\
        System.out.println("pathToEmptyDir.toAbsolutePath().getRoot() -> " +
                            pathToEmptyDir.toAbsolutePath().getRoot()); // Корневой диск:\
        System.out.println("pathToNoFile.toAbsolutePath().getRoot() -> " +
                            pathToNoFile.toAbsolutePath().getRoot()); // Корневой диск:\
        System.out.println("------------------------ *.resolve(Path other) ------------------------");
        /*
        Метод resolve(Path other) - разрешить данный путь против текущего пути, по факту, метод
                                    отобразит, как это могло бы быть.
        Например, мы можем задать (смоделировать), несуществующий путь + несуществующий файл и
        затем, через другой метод создать этот файл по указанному пути.

        Или применить при копировании файла в некую директорию и для этого мы применяем метод:
        'директория куда хотим скопировать'.resolve('имя файла') см. пример Less_31_FilesPathCopy_Step1
        */
        System.out.println("pathToFile.resolve(pathToNoFile) -> " + pathToFile.resolve(pathToNoFile));
        System.out.println("pathToDir.resolve(pathToEmptyDir) -> " + pathToDir.resolve(pathToEmptyDir));
        System.out.println("pathToEmptyDir.resolve(pathToDir) -> " + pathToEmptyDir.resolve(pathToDir));
        System.out.println("pathToNoFile.resolve(pathToFile) -> " + pathToNoFile.resolve(pathToFile));

    }
}
