package homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class task1 {

    //1 уровень сложности: На этом занятии мы только разбирались с теорией коллекций + немного тренировались c arrayList,
//                     поэтому задание тоже будет чисто на тренировку
//
//  Создайте ArrayList, заполните его 100 случайными значениями, используя библиотеку Random
//      Решите две задачи и пришлите решение ссылкой на гитхаб
//
//
//  1) Выведите все элементы списка, которые больше предыдущего элемента этого же списка.
//      Пример, если список выглядит так - 1 5 2 4 3
//      То мы выведем - 5 4
//
//
//  2) Выведите значение наименьшего из всех положительных элементов в списке.
//      Пример, если список выглядит так - 5 -4 3 -2 1
//      То мы выведем - 1
    public static void main(String[] args) {
        int listSize = 100;
        final int MAX_VALUE = 1000;

        ArrayList<Integer> list = arrayListGenerator(listSize, MAX_VALUE);
        System.out.println(list);

        printNextBigger(list);

        int min = minPositiveOfArrayList(list);
        System.out.println(min);
    }

    public static ArrayList<Integer> arrayListGenerator(int arrayListSize, int maxValue) {
        ArrayList<Integer> intArrayList = new ArrayList<>(arrayListSize);
        Random random = new Random();
        for (int i = 0; i < arrayListSize; i++) {
            intArrayList.add(random.nextInt(-maxValue, maxValue));
        }
        return intArrayList;
    }

    public static void printNextBigger(ArrayList<Integer> intArrayList) {
        for (int i = 1; i < intArrayList.size(); i++) {
            if (intArrayList.get(i) > intArrayList.get(i - 1)) {
                System.out.print(intArrayList.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static int minPositiveOfArrayList(ArrayList<Integer> intArrayList) {
        intArrayList.sort(Comparator.naturalOrder());
        for (int number: intArrayList) {
            if (number > 0) {
                return number;
            }
        }
        return 0;
    }
}
