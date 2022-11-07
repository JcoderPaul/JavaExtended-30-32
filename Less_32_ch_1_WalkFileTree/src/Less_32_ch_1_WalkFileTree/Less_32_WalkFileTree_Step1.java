package Less_32_ch_1_WalkFileTree;

import Less_32_ch_1_WalkFileTree.MyClasses.MyFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_32_WalkFileTree_Step1 {
    public static void main(String[] args) throws IOException {
        Path path_for_scan = Paths.get("src\\Less_32_ch_1_WalkFileTree\\WorkingFolder\\");

        Files.walkFileTree(path_for_scan, new MyFileVisitor());
    }
}
