package Less_30_ch_2_ChanelBufferWrite;
/*
Методы, унаследованные от класса java.nio.Buffer:
capacity, clear, flip, hasRemaining, isReadOnly, limit,
limit, mark, position, position, remaining, reset, rewind.
Естественно эти методы легко могут применяться с ByteBuffer.
*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Less_30_ChanelBufferWrite_Step1 {
    public static void main(String[] args) {
        // Формируем путь к файлу для записи
        String path_to_file = "src\\Less_30_ch_2_ChanelBufferWrite\\FileForWrite\\AnotherVerse.txt";
        // Текст для записи в файл
        String text_for_write = "Когда рассвет приходит в этот мир,\n" +
                                "Мы ждём его с надеждой на спасенье,\n" +
                                "Что новый день способен принести\n" +
                                "Гнетущейся душе успокоенье.\n" +
                                "Луч солнца, что ласкает нам лицо,\n" +
                                "Невинный ангел, с лёгкими крылами,\n" +
                                "Коснётся, облегченье принеся,\n" +
                                "И упорхнёт, испуганный же нами.\n" +
                                "Дыханье затая, потом вдохнув,\n" +
                                "Прохладный воздух утреннего света,\n" +
                                "Мы будем ждать, что скажет новый день,\n" +
                                "Ведь утра миг оставил без ответа.";
        /*
        Инициализируем класс RandomAccessFile, в параметры передаем путь к файлу
        и модификатор, который говорит, что файл откроется для чтения и записи.

        *** Шаг. 1 Открыли файл для чтения-записи ***
        */
        try(RandomAccessFile file_fo_write = new RandomAccessFile(path_to_file,"rw");
            /*
            Получаем экземпляр класса FileChannel, используя метод RandomAccessFile.
            Канал работает в оба направления, и доступ к файлу тоже двунаправленный.

            *** Шаг. 2 Открыли канал для чтения-записи ***
            */
            FileChannel myChanel = file_fo_write.getChannel()) {

            /*
            Чтобы не задавать размер буфера вручную, и разместить весь текст для записи
            за один раз, находим размер нашего текста используя методы *.getBytes().length

            *** Шаг. 3 Создали буфер для работы с данными ***
            */
            ByteBuffer myBuffer = ByteBuffer.allocate(text_for_write.getBytes().length);
            /*
            Записываем данные в буфер используя метод *.put() - метод буфера, который
            используется для записи данных в буфер. В качестве аргумента передаем
            результат метода getBytes():
            - getBytes(String charsetName) – кодирует данную строку в последовательность
            байтов, используя charsetName (кодировку), сохраняет результат в новый массив
            байтов.
            - getBytes() – кодирует данную строку в последовательность байтов, по умолчанию
            с помощью платформы charset, сохраняет результат в новый массив байтов.

            *** Шаг. 4 Записали данные в буфер ***
            */
            myBuffer.put(text_for_write.getBytes());
            /*
            Метод *.flip() переключает режим буфера с режима записи на режим чтения.
            Он также устанавливает позицию (Position) обратно в ноль и устанавливает
            лимит, в котором позиция была во время записи.

            *** Шаг. 5 Подготовили буфер к чтению ***
            */
            myBuffer.flip();
            /*
            Метод класса FileChannel *.write() используется для записи данных из
            буфера в FileChannel. Т.е. мы читаем данные из буфера и тут же
            записываем их в файловый канал. Через файловый канал наша строка
            'text_for_write' попадает во внешний файл.

            *** Шаг. 6 Записываем прочитанные из буфера данные в FileChannel ***
            */
            myChanel.write(myBuffer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
