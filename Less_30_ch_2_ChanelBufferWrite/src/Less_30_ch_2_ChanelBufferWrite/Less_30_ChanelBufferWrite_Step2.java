package Less_30_ch_2_ChanelBufferWrite;
/*
Более короткий вариант записи некоего текста в файл.

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

public class Less_30_ChanelBufferWrite_Step2 {
    public static void main(String[] args) {
        // Формируем путь к файлу для записи
        String path_to_file = "src\\Less_30_ch_2_ChanelBufferWrite\\FileForWrite\\VerseTwo.txt";
        // Текст для записи в файл
        String text_for_write = "Хайку раз...Танку два...\n" +
                                "\n" +
                                "  1\n" +
                                ". . .\n" +
                                "Дорога позади,\n" +
                                "Дорога впереди,\n" +
                                "Я на пути . . .\n" +
                                "\n" +
                                "\n" +
                                "  2\n" +
                                ". . .\n" +
                                "Закат уж позади,\n" +
                                "Рассвета долго ждать,\n" +
                                "Дорога в свете фар . . .";
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
            Для записи данных в буфер используем метод *.wrap() - данный метод класса
            java.nio.ByteBuffer используется для переноса массива байтов в буфер.
            Новый буфер будет поддерживаться данным массивом байтов; то есть изменения
            в буфере вызовут изменение массива и наоборот. Емкость и предел нового буфера
            будут равны array.length, его позиция будет равна нулю, а его метка будет
            неопределенной.

            Его резервным массивом будет заданный массив, а его смещение массива будет
            равно нулю.

            Используя данный метод мы убрали из кода Less_30_ChanelBufferWrite_Step1,
            Шаг 4 - метод *.put() и Шаг 5. - метод *.flip().

            *** Шаг. 3 Создали буфер для работы с данными ***
            */
            ByteBuffer myBuffer = ByteBuffer.wrap(text_for_write.getBytes());
            /*
            Метод класса FileChannel *.write() используется для записи данных из
            буфера в FileChannel. Т.е. мы читаем данные из буфера и тут же
            записываем их в файловый канал. Через файловый канал наша строка
            'text_for_write' попадает во внешний файл.

            *** Шаг. 4 Записываем прочитанные из буфера данные в FileChannel ***
            */
            myChanel.write(myBuffer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
