package iterator;

import java.util.NoSuchElementException;
/** Паттерн Iterator позволяет последовательно обходить
 * элементы коллекции без раскрытия её внутренней реализации
 */
// Интерфейс итератора
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Пример реализации списка итератора для пользовательского списка
class CustomListIterator<T> implements Iterator<T> {
    private CustomList<T> customList;
    private int index;

    public CustomListIterator(CustomList<T> customList) {
        this.customList = customList;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < customList.size();
    }
    @Override
    public T next() {
        if (hasNext()) {
            return customList.get(index++);
        }
        throw new NoSuchElementException("No more elements in the collection.");
    }
}
// Пример пользовательского списка с возможностью обхода элементов с помощью итератора
class CustomList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        }
        throw new IndexOutOfBoundsException("Index out of range.");
    }
    public int size() {
        return size;
    }
    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
    public Iterator<T> getIterator() {
        return new CustomListIterator<>(this);
    }
}
// Пример использования пользовательского списка и итератора
public class IteratorExample {
    public static void main(String[] args) {
        CustomList<Integer> numbersList = new CustomList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);

        Iterator<Integer> iterator = numbersList.getIterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            System.out.print(number + " ");
        }
    }
}