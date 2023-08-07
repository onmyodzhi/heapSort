import java.util.*;


/*
Что-то не копируется...
*/

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {9, 2, 5, 1, 7, 4, 8, 3, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        heapSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));

    }

    public static void heapSort(int[] array) {
        int length = array.length;

        // Построение max-кучи (упорядочивание массива)
        // Начинаем с последнего родителя и переходим к корню
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // Извлечение элементов из кучи и упорядочивание
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Перестроение max-кучи на оставшейся части массива
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int length, int root) {
        int largest = root; // Предполагаем, что самый большой элемент находится в корне
        int leftChild = 2 * root + 1; // Индекс левого ребенка в массиве
        int rightChild = 2 * root + 2; // Индекс правого ребенка в массиве

        // Если левый ребенок больше корня
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Если правый ребенок больше корня
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Если самый большой элемент не находится в корне
        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;

            // Рекурсивно вызываем heapify для поддерева
            heapify(array, length, largest);
        }
    }
}