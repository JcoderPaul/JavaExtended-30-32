package Less_31_ch_6_FilesPathWrite;
/*
Работа метода Files.write();
*/
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Less_31_FilesPathWrite_Step1 {
    public static void main(String[] args) throws IOException {
        // Прописали путь к файлу
        Path fileForWrite = Paths.get("src\\Less_31_ch_6_FilesPathWrite\\FolderForWork\\FileForWrite.txt");
        // Создали если его нет
        if(!Files.exists(fileForWrite)){
            Files.createFile(fileForWrite);
        }
        // Строка для записи в файл
        String m_g_monolog =
                "Стекло не лед, но так же холодит\n" +
                "Когда его касаешься рукою\n" +
                "И лед как сталь способна жизнь отнять\n" +
                "Хотя растаяв будет лишь водою\n" +
                "\n" +
                "И кто сокрыт за маскою твоей,\n" +
                "Богиня страсти или дьявол искуситель\n" +
                "Очаг бездонный, пламенных страстей\n" +
                "Иль просто бездны хладная обитель.\n" +
                "\n" +
                "Слова лишь ветер, образ лишь туман\n" +
                "Но и они способны стать живыми\n" +
                "Дать силу, или силу ту отнять\n" +
                "Сквозь них для всех мы кажемся другими.\n";
        // Применяем метод, записываем
        Files.write(fileForWrite, m_g_monolog.getBytes(StandardCharsets.UTF_8));
    }
}
