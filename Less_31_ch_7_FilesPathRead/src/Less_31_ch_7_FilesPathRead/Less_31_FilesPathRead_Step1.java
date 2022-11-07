package Less_31_ch_7_FilesPathRead;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Less_31_FilesPathRead_Step1 {
    public static void main(String[] args) throws IOException {
        Path file_for_read =
                Paths.get("src\\Less_31_ch_7_FilesPathRead\\FolderForReadingFile\\verse.txt");

        List<String> readingLine = Files.readAllLines(file_for_read);
        readingLine.forEach(System.out::println);

    }
}
