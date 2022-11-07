package Less_31_ch_1_Path;
/*
Рассмотрены методы Path:
- *.getFileName();
- *.getParent();
- *.getRoot();
- *.isAbsolute();
- *.toAbsolutePath();
*/
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_31_Path_Step1 {
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

        System.out.println("--------------------------- *.getFileName() ---------------------------");
        /*
        Метод getFileName() - возвращает имя файла или каталога,
        обозначенного текущим путем, как Path объект.
        */
        System.out.println("pathToFile.getFileName() -> " + pathToFile.getFileName());
        System.out.println("pathToDir.getFileName() -> " + pathToDir.getFileName());
        System.out.println("pathToEmptyDir.getFileName() -> " + pathToEmptyDir.getFileName());
        System.out.println("pathToNoFile.getFileName() -> " + pathToNoFile.getFileName());
        System.out.println("--------------------------- *.getParent() ---------------------------");
        /*
        Метод getParent() - возвращает родительский путь или,
        null если текущий путь не имеет родителя.
        */
        System.out.println("pathToFile.getParent() -> " + pathToFile.getParent());
        System.out.println("pathToDir.getParent() -> " + pathToDir.getParent());
        System.out.println("pathToEmptyDir.getParent() -> " + pathToEmptyDir.getParent());
        System.out.println("pathToNoFile.getParent() -> " + pathToNoFile.getParent());
        System.out.println("--------------------------- *.getRoot() ---------------------------");
        /*
        Метод getRoot() - возвращает корневой компонент текущего пути в
        виде Path объекта или, null если текущий путь не имеет корневого
        компонента.
        */
        System.out.println("pathToFile.getRoot() -> " + pathToFile.getRoot()); // null - т.к. путь относительный
        System.out.println("pathToDir.getRoot() -> " + pathToDir.getRoot()); // null - т.к. путь относительный
        System.out.println("pathToEmptyDir.getRoot() -> " + pathToEmptyDir.getRoot()); // Корневой диск:\
        System.out.println("pathToNoFile.getRoot() -> " + pathToNoFile.getRoot()); // null - т.к. там вообще пусто
        System.out.println("--------------------------- *.isAbsolute() ---------------------------");
        /*
        Метод isAbsolute() - сообщает, является ли текущий путь абсолютным.
        */
        System.out.println("pathToFile.isAbsolute() -> " + pathToFile.isAbsolute()); // false
        System.out.println("pathToDir.isAbsolute() -> " + pathToDir.isAbsolute()); // false
        System.out.println("pathToEmptyDir.isAbsolute() -> " + pathToEmptyDir.isAbsolute()); // true
        System.out.println("pathToNoFile.isAbsolute() -> " + pathToNoFile.isAbsolute()); // false
        System.out.println("--------------------------- *.toAbsolutePath() ---------------------------");
        /*
        Метод toAbsolutePath() - возвращает объект Path, представляющий абсолютный путь.
        */
        System.out.println("pathToFile.toAbsolutePath() -> " + pathToFile.toAbsolutePath());
        System.out.println("pathToDir.toAbsolutePath() -> " + pathToDir.toAbsolutePath());
        System.out.println("pathToEmptyDir.toAbsolutePath() -> " + pathToEmptyDir.toAbsolutePath());
        System.out.println("pathToNoFile.toAbsolutePath() -> " + pathToNoFile.toAbsolutePath());
    }
}
