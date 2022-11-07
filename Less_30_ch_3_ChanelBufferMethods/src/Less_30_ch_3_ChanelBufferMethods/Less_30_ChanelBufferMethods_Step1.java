package Less_30_ch_3_ChanelBufferMethods;
/*
Методы, унаследованные от класса java.nio.Buffer:
capacity, clear, flip, hasRemaining, isReadOnly, limit,
limit, mark, position, position, remaining, reset, rewind.
Естественно эти методы легко могут применяться с ByteBuffer.

Более подробно рассмотрены:
- *.rewind();
- *.compact();
- *.mark();
- *.reset();
*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Less_30_ChanelBufferMethods_Step1 {
    public static void main(String[] args) {
        String path_to_file = "src\\Less_30_ch_3_ChanelBufferMethods\\FileForRead\\stringfile.txt";

        try(RandomAccessFile myOnlyReadableFile = new RandomAccessFile(path_to_file, "r");
            FileChannel myFileChanel = myOnlyReadableFile.getChannel()){
            // Создали буфер заданной емкости
            ByteBuffer myBb = ByteBuffer.allocate(5);
            // Прочитали из канала данные в буфер
            myFileChanel.read(myBb);
            // Переключили буфер в режим чтения
            myBb.flip();
            /*
            Взяли из буфера 3-и элемента и вывели на экран,
            Position буфера сейчас указывает на - 3 (0, 1, 2)
            */
            System.out.print((char) myBb.get() + " ");
            System.out.print((char) myBb.get() + " ");
            System.out.print((char) myBb.get() + " ");
            /*
            Метод *.rewind() — своеобразная перемотка, используется, когда
            нам нужно заново прочитать содержимое буфера, так как он устанавливает
            Position (указатель позиции) в ноль и не изменяет значение лимита.
            */
            System.out.println("\n---------- After *.rewind() ----------");
            myBb.rewind();
            // Прочитали снова первый символ, и позиция сместилась на 1
            System.out.print((char) myBb.get() + " ");
            System.out.println("\n---------- After *.compact() ----------");
            /*
            Метод *.compact() как бы перемещает не прочитанный нами символы
            по буферу в начало (их у нас осталось 4-и) и освобождает последнюю
            ячейку буфера (последний байт), туда же теперь указывает Position.
            Если мы захотим записать в буфер данные, то предыдущие 4-и не затрутся,
            а заполниться последний байт.
            */
            myBb.compact();
            // Читаем файл и пишем в буфер
            myFileChanel.read(myBb);
            // Переключились в режим чтения
            myBb.flip();
            while (myBb.hasRemaining()){
                System.out.print((char) myBb.get() + " ");
            }
            System.out.println("\n------------------------------------------------");
            // Перевели Position в 0
            myBb.clear();
            // Записали остатки информации из файла (из FileChanel) в буфер
            myFileChanel.read(myBb);
            // Перешли в режим чтения из буфера
            myBb.flip();
            // Вывели на экран нулевой элемент буфера, Position указывает на 1
            System.out.print((char) myBb.get() + " ");
            System.out.println("\n---------- After *.mark() и *.reset() ----------");
            /*
            Метод mark() - используется для обозначения (маркировки) текущей позиции
            курсора. При желании мы можем в будущем вернуться к этой метке.
            */
            myBb.mark();
            System.out.print((char) myBb.get() + " ");
            System.out.print((char) myBb.get() + " ");
            System.out.println(" ");
            /*
            Метод *.reset() - сбрасывает значение Position этого буфера в ранее отмеченную
            позицию (мы использовали метод *.mark()). Вызов метода *.reset() не изменяет и
            не отбрасывает значение метки. Метод унаследован от Class Buffer - java.nio.Buffer.
            */
            myBb.reset();
            System.out.print((char) myBb.get() + " ");
            System.out.print((char) myBb.get() + " ");
            System.out.println("\n---------- Окончательный вывод на экран остатков файла ----------");
            // Еще раз вернемся к метке и выведем содержимое буфера на экран
            myBb.reset();
            while (myBb.hasRemaining()){
                System.out.print((char) myBb.get() + " ");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
