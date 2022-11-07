package Less_30_ch_1_ChanelBufferRead;
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

public class Less_30_ChanelBufferRead_Step1 {
    public static void main(String[] args) {
        // Прописываем путь к файлу
        String file_path = "src\\Less_30_ch_1_FileChanelByteBuffer\\FilesForRead\\verse.txt";
        /*
        Инициализируем класс RandomAccessFile, в параметры передаем путь к файлу
        и модификатор, который говорит, что файл откроется для чтения и записи.

        *** Шаг. 1 Открыли файл для чтения-записи ***
        */
        try(RandomAccessFile myFile = new RandomAccessFile(file_path,"rw");
            /*
            Получаем экземпляр класса FileChannel, используя метод RandomAccessFile.

            *** Шаг. 2 Открыли канал для чтения-записи ***
            */
            FileChannel myChanel = myFile.getChannel()){
            /*
            Наш файл имеет небольшой размер, поэтому считать мы его можем за один раз,
            выделив под буфер нужный размер, передав в качестве аргумента в метод
            *.allocate((int) myChanel.size()). Если мы так сделаем, то создадим буфер
            необходимого размера на основании размера нашего канала (файла).

            Но мы легких путей не ищем (т.к. учимся...постоянно) фиксируем размер руками,
            пусть будет 150. И так, мы создали буфер определенного размера.

            *** Шаг. 3 Создали буфер для работы с данными ***
            */
            ByteBuffer myBuffer = ByteBuffer.allocate(150);
            // Создаем объект StringBuilder для работы с данными
            StringBuilder myStrBilder = new StringBuilder();
            /*
            Записываем данные из канала в буфер и определяем его размер

            *** Шаг. 4 Записываем данные в буфер ***
            */
            int myByteRead = myChanel.read(myBuffer);
            // До тех пор, пока размер буфера не 0
            while (myByteRead > 0){
                // Выводим сведения о заполненности нашего буфера данными
                System.out.println("Read " + myByteRead);
                /*
                Переключаем режим буфера с записи на режим чтения. Метод *.flip() также
                устанавливает позицию обратно в ноль и устанавливает лимит, в котором
                позиция была во время записи.

                *** Шаг. 5 Готовимся читать данные из буфера ***
                */
                myBuffer.flip();
                /*
                Записываем прочитанное текущее содержимое буфера в наш StringBuilder
                методом *.append() с аргументом кастомизированным к (char) myBuffer.get().
                Метод *.get() - метод буфера, который используется для чтения данных из него.

                В условиях цикла применяется метод унаследованный класса java.nio.Buffer -
                *.hasRemaining() - метод говорит, есть ли какие-либо элементы между текущей
                позицией и пределом. Возвращает true только если в этом буфере остался хотя
                бы один элемент.
                */
                while (myBuffer.hasRemaining()){
                    /*
                    *** Шаг. 6 Читаем данные из буфера и сбрасываем в наш StringBuilder ***
                    */
                    myStrBilder.append((char) myBuffer.get());
                }
                /*
                Метод *.clear() - устанавливает позицию в ноль и ограничивает ее до емкости.
                В этом методе данные в буфере не очищаются, только маркеры инициализируются
                повторно. Т.е. мы вывели позицию в 0 и ждем дальнейших действий.

                *** Шаг. 7 Переводим указатель Position в 0 ***
                */
                myBuffer.clear();
                /*
                Записываем данные из канала в буфер. Т.е. снова с нулевой позиции идет запись,
                пока не закончится файл, т.е. метод *.read() не выкинет -1 и основной цикл
                закончится.

                *** Шаг. 8 Записываем данные в буфер ***
                */
                myByteRead = myChanel.read(myBuffer);
            }
            System.out.println("-------------------------------------------------------");
            System.out.println(myStrBilder);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
