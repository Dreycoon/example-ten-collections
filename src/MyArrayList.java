import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E>{
    private E[] data;
    private int size;


    public MyArrayList() {
        data = (E[]) new Object[10]; // массив размером 10
        size = 0; // изначально 0 элементов в массиве
    }

    // добавление элемента
    public void add(E element) {
        ensureCapacity(size + 1); // проверка места для добавления элемента
        data[size++] = element; // добавить элемент последним и добавить размер
    }

    // метод удаления элемента по значению
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) { // если данный элмент найден
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1]; // move the elements to the left to fill the gap
                }
                size--; // уменьшение кол-ва элементов
                return true;
            }
        }
        return false; // если элемент не найден
    }

    // метод для проверки налчиия элемента
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {   //создаём цикл
            if (data[i].equals(element)) {   // Проверяем равность элеметов
                return true;     // если равны возвращаем true
            }
        }
        return false;     // если нет то false
    }

    // метод получения элемента по индексу
    public E get(int index) {
        return data[index]; // возращаем элемент
    }

    // метод для проверки места
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length; // присваиваем нынешнему объёму длину массива
        if (minCapacity > oldCapacity) { // если требуемый объём больше нынешнего
            int newCapacity = (oldCapacity * 3) / 2 + 1; // увеличение мощности в 1.5 раза
            data = Arrays.copyOf(data, newCapacity); // создание нового массива с копированными элементами и новым объёмом
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }
    }
}
