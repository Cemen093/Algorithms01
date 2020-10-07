package org.itstep;


import org.itstep.List.List;
import java.util.Scanner;

public class Algorithms01 {
    public static void main(String[] args) {

        final int NUM_MENU_POINTS = 11;
        Scanner scaner = new Scanner(System.in);
        int choice;
        //Warning:(11, 19) Variable 'key' initializer '0' is redundant ???
        //На 39 строку он писал
        //Variable 'value' might not have been initialized
        //Хотя она бы инициализировалась, хоть и в if, а тут это, в чем логика?
        int value = 0;
        int index = 0;
        int key = 0;
        List list = new List();
        do {
            choice = corectInput(
                    "Выберете желанное действие:\n" +
                            "1. Добавить в начало списка\n" +
                            "2. Добавить элемент в спискок (по индексу)\n" +
                            "3. Добавить элемент в спискок (сортируя)\n" +
                            "4. Добавить элемент в конец списка\n" +
                            "5. Удалить элемент из начала списка\n" +
                            "6. Удалить элемент из списка (по индексу)\n" +
                            "7. Удалить первый элемент равный ключу\n" +
                            "8. Удалить все элементы равные ключу\n" +
                            "9. Удалить элемент из конца списка\n" +
                            "10. Вывести массив на экран\n" +
                            "11. Выход из программы\n" +
                            " >>  ",
                    1, NUM_MENU_POINTS);
            if (choice < 5){
                value = corectInput("Введите число\n >>  ");
            }if (choice == 7 || choice == 8){
                key = corectInput("Введите число\n >>  ");
            }
            if (choice == 2 || choice == 6){
                index = corectInput("Введите индекс числа\n >>  ");
            }
            switch (choice) {
                case 1:
                    // "1. Добавить в начало списка\n" +
                    list.addFist(value);
                    break;
                case 2:
                    // "2. Добавить элемент в спискок (по индексу)\n"
                    list.addOnList(value, index);
                    break;
                case 3:
                    // "3. Добавить элемент в спискок (сортируя)\n"
                    list.addOnList(value);
                    break;
                case 4:
                    // "4. Добавить элемент в конец списка\n"
                    list.addEnd(value);
                    break;
                case 5:
                    // "5. Удалить элемент из начала списка\n"
                    list.delFirst();
                    break;
                case 6:
                    // "6. Удалить элемент из списка (по индексу)\n"
                    list.delOnListIndex(index);
                    break;
                case 7:
                    // "7. Удалить первый элемент равный ключу\n"
                    list.delOnListKey(key);
                    break;
                case 8:
                    // "8. Удалить все элементы равные ключу\n"

                    list.delOnListAllKey(key);
                    break;
                case 9:
                    // "9. Удалить элемент из конца списка\n"
                    list.delLast();
                    break;
                case 10:
                    // "10. Вывести массив на экран\n"
                    list.show();
                    break;
                case 11:
                    // "11. Выход из программы\n"
                    break;
                default:
                    System.out.println("Даже не знаю как ты сюда попал,\n" +
                            "но исключение мы еще не проходили.");
                    break;
            }
        }while(choice != NUM_MENU_POINTS);


    }
    public static int corectInput(String s, int min, int max){
        int c;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(s);
            if(scanner.hasNextInt()) {
                c = scanner.nextInt();
                if (c <= max && c >= min) {
                    break;
                }
            }
            scanner.nextLine();
            System.out.printf("Не корректный ввод\n" +
                    "Введите целое число от %d до %d\n", min, max);
        } while (true);
        return c;
    }
    public static int corectInput(String s){
        return corectInput(s, -2147483647, 2147483647);
    }
}
