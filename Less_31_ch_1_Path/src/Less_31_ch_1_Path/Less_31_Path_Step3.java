package Less_31_ch_1_Path;
/*
Рассмотрен метод Path:
- *.relativize(Path other);
*/
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_31_Path_Step3 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_31_ch_1_PathAndFiles\\MyFiles\\FileTest.txt";
        // Небольшие изменения относительно первых двух примеров
        String path_to_dir =
          "E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles";
        String path_to_double_nesting_dir =
          "E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles\\EmptyThirdDir\\FourthDir";
        String path_to_no_file = "NoFileAnywhere.txt";

        Path pathToFile = Paths.get(path_to_file);
        Path pathToDir = Paths.get(path_to_dir);
        Path pathToDoublNestDir = Paths.get(path_to_double_nesting_dir);
        Path pathToNoFile = Paths.get(path_to_no_file);

        System.out.println("------------------------ *.relativize(Path other) ------------------------");
        /*
        Метод relativize(Path other) - создает относительный путь между текущим путем и заданным путем.
                                       Для правильной работы метода необходимо сопоставлять пути одного
                                       типа: "относительный с относительным" либо "абсолютный с абсолютным"
                                       иначе хапнем: IllegalArgumentException: 'other' is different type of Path
        */
        System.out.println("'src\\Less_31_ch_1_PathAndFiles\\MyFiles\\FileTest.txt' \n" +
                           ".relativize \n ('NoFileAnywhere.txt') -> " +
                           pathToFile.relativize(pathToNoFile));
        System.out.println(" ----------------------------------------------------------------------- ");
        System.out.println("'NoFileAnywhere.txt' \n" +
                           ".relativize \n ('src\\Less_31_ch_1_PathAndFiles\\MyFiles\\FileTest.txt') -> " +
                           pathToNoFile.relativize(pathToFile));
        System.out.println(" ----------------------------------------------------------------------- ");
        System.out.println(
         "'E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles'\n" +
         ".relativize\n" +
         "('E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles\\EmptyThirdDir\\FourthDir') -> " +
         pathToDir.relativize(pathToDoublNestDir));
        System.out.println(" ----------------------------------------------------------------------- ");
        System.out.println(
         "'E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles\\EmptyThirdDir\\FourthDir' \n" +
         ".relativize \n(E:\\JavaExtended\\Less_31_ch_1_PathAndFiles\\src\\Less_31_ch_1_PathAndFiles) -> " +
         pathToDoublNestDir.relativize(pathToDir));
    }
}
