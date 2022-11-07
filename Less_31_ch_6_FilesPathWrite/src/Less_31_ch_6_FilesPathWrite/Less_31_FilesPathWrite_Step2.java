package Less_31_ch_6_FilesPathWrite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Less_31_FilesPathWrite_Step2 {
    public static void main(String[] args) {
        try {
            List<String> list_for_write = new ArrayList<>();
            for(int i = 0; i < 1100; i++){
                list_for_write.add(Integer.toString(i));
            }
            /*
            Если в первом примере мы готовили все заранее, т.е. создавали файл,
            в данном случае, метод сразу создает файл и записывает информацию в
            него.
            */
            Files.write(
                    Paths.get("src\\Less_31_ch_6_FilesPathWrite\\FolderForWork\\FileForWriteTwo.txt"),
                    list_for_write);

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
