package strategy;
/**  Паттерн Strategy позволяет определить семейство алгоритмов, инкапсулировать каждый
 * из них и делать их взаимозаменяемыми. Это позволяет изменять поведение
 * объекта во время выполнения программы, выбирая различные алгоритмы.
*/

// Интерфейс стратегии
interface SortingStrategy {
    void sort(int[] array);
}
// Конкретная стратегия - Сортировка пузырьком
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
// Конкретная стратегия - Сортировка выбором
class SelectionSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
// Класс контекста, который использует стратегию
class ArraySorter {
    private SortingStrategy sortingStrategy;
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
    public void sortArray(int[] array) {
        sortingStrategy.sort(array);
    }
}
// Пример использования паттерна Strategy
public class Strategy {
    public static void main(String[] args) {
        ArraySorter arraySorter = new ArraySorter();

        int[] array1 = {5, 2, 8, 1, 3};
        int[] array2 = {10, 6, 4, 7, 9};

        System.out.println("Сортировка пузырьком:");
        arraySorter.setSortingStrategy(new BubbleSort());
        arraySorter.sortArray(array1);
        printArray(array1);

        System.out.println("\nСортировка выбором:");
        arraySorter.setSortingStrategy(new SelectionSort());
        arraySorter.sortArray(array2);
        printArray(array2);
    }
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}