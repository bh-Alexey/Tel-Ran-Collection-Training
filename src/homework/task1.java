package homework;

import java.util.ArrayList;
import java.util.Comparator;

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
        int listCapacity = 100;
        final int RANGE_COEFICIENT = 100_000;

        ArrayList<Integer> list = arrayListGenerator(listCapacity, RANGE_COEFICIENT);
        System.out.println(list);

        printNextBigger(list);

        int min = minPositiveOfArrayList(list);
        System.out.println(min);

    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }

    public static ArrayList<Integer> arrayListGenerator(int arrayListCapacity, int digitsInNumber) {
        ArrayList<Integer> intArrayList = new ArrayList<>(arrayListCapacity);
        int minNumber = Integer.MIN_VALUE + arrayListCapacity;
        int maxNumber = Integer.MAX_VALUE - arrayListCapacity;
        for (int i = 0; i < arrayListCapacity; i++) {
            int number = getRandom(minNumber / digitsInNumber, maxNumber / digitsInNumber);
            intArrayList.add(number);
        }
        return intArrayList;
    }

    public static void printNextBigger(ArrayList<Integer> intArrayList) {
        for (int i = 0; i < intArrayList.size() - 1; i++) {
            if (intArrayList.get(i) < intArrayList.get(i + 1)) {
                System.out.print(intArrayList.get(i + 1) + " ");
            }
        }
        System.out.println();
    }

    public static int minPositiveOfArrayList(ArrayList<Integer> intArrayList) {
        ArrayList<Integer> positiveArrayList = new ArrayList<>();
        for (int i = 0; i < intArrayList.size(); i++) {
            if (intArrayList.get(i) > 0) {
                positiveArrayList.add(intArrayList.get(i));
            }
        }
        positiveArrayList.sort(Comparator.naturalOrder());
        return positiveArrayList.get(0);
    }
}