import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>{
    private Node head; // первый узел в списке
    private Node tail; // последний узел в списке
    private int size; // размер списка

    // Конструктор для инициализации
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node {
        private E data; //данные узла
        private Node next; // ссылка на следующий узел в списке

        // Конструктор для инициализации
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // Метод добавления
    public void add(E data) {
        Node newNode = new Node(data); // создание нового узла с данными
        if (head == null) { // если список пуст, устанавливаем начало и конец нового узла
            head = newNode;
            tail = newNode;
        } else { // иначе добавляем новый узел в конец списка
            tail.next = newNode;
            tail = newNode;
        }
        size++; // размер списка увеличиватся
    }

    // Метод удаления
    public boolean remove(E data) {
        Node current = head;  //начало с первого узла
        Node previous = null;  // предыдущий узел = null

        // Циклом проходим по списку в поиках узла с нужными данными
        while (current != null) {
            if (current.data.equals(data)) {
                if (previous != null) {
                    // обновить ссылку предыдущего узла, чтобы пропустить текущий
                    previous.next = current.next;
                } else {
                    // обновления первого узла предыдущим
                    head = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
            }
        return false;
    }

    // метод для проверки налчиия элемента
    public boolean contains(E data) {
        Node current = head;
        // цикл для нахождения узла с нужным элементом
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // метод получения элемента
    public E get(int index) {
        Node current = head;
        // цикл по индексу
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<E> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
