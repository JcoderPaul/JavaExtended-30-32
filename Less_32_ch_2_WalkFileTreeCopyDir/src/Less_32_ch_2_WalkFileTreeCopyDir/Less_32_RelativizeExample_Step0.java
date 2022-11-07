package Less_32_ch_2_WalkFileTreeCopyDir;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
Еще раз вспомним как работает метод *.relativize(Path other),
который создает относительный путь между текущим путем и заданным
путем. Для правильной работы метода необходимо сопоставлять пути
одного типа: "относительный с относительным" либо
"абсолютный с абсолютным" иначе хапнем:
IllegalArgumentException: 'other' is different type of Path
*/
public class Less_32_RelativizeExample_Step0 {
    public static void main(String[] args) {
        Path start_meth_path = Paths.get("E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir");
        Path start_meth_path2 = Paths.get("E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx");

        Path arg_for_meth_path1 = Paths.get("E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx\\DirForRelTest");
        Path arg_for_meth_path2 = Paths.get("E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx\\RelTest2.txt");

        Path arg_for_meth_path3 = Paths.get("E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx2\\DirForRelTest2");
        Path arg_for_meth_path4 = Paths.get("E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx2\\RelTest2.txt");

        System.out.print("'E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir'\n" + ".relativize(\n" +
                "'E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx\\DirForRelTest')" + " -> ");
        System.out.println(start_meth_path.relativize(arg_for_meth_path1));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("'E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir'\n" + ".relativize(\n" +
                "'E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx\\RelTest2.txt')" + " -> ");
        System.out.println(start_meth_path.relativize(arg_for_meth_path2));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print("'E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx'\n" + ".relativize(\n" +
                "'E:\\JavaExtended\\Less_32_ch_2_WalkFileTreeCopyDir\\" +
                "src\\Less_32_ch_2_WalkFileTreeCopyDir\\RelativizeEx2\\DirForRelTest2')" + " -> ");
        System.out.println(start_meth_path2.relativize(arg_for_meth_path3));
    }
}
