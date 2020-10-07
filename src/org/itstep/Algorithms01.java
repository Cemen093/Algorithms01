package org.itstep;



import org.itstep.List.List;
import java.util.Scanner;

public class Algorithms01 {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int key;
        //Warning:(11, 19) Variable 'key' initializer '0' is redundant ???
        //На 39 строку он писал
        //Variable 'value' might not have been initialized
        //Хотя она бы инициализировалась, хоть и в if, а тут это, в чем логика?
        int value = 0;
        int index = 0;
        List list = new List();
        do {
            key = corectInput(
                    "Выберете желанное действие:\n" +
                            "1. Добавить в начало списка\n" +
                            "2. Добавить элемент в середину списка (по индексу)\n" +
                            "3. Добавить элемент в середину списка (сортируя)\n" +
                            "4. Добавить элемент в конец списка\n" +
                            "5. Удалить элемент из начала списка\n" +
                            "6. Удалить элемент из середины списка (по индексу)\n" +
                            "7. Удалить элемент из конца списка\n" +
                            "8. Вывести массив на экран\n" +
                            "9. Выход из программы\n" +
                            " >>  ",
                    1, 9);
            if (key < 5){
                value = corectInput("Введите число\n >>  ");
            }
            if (key == 2 || key == 6){
                index = corectInput("Введите индекс числа\n >>  ");
            }
            switch (key) {
                case 1:
                    list.addFist(value);
                    break;
                case 2:
                    list.addMiddle(value, index);
                    break;
                case 3:
                    list.addMiddle(value);
                    break;
                case 4:
                    list.addEnd(value);
                    break;
                case 5:
                    list.delFirst();
                    break;
                case 6:
                    list.delMiddle(index);
                    break;
                case 7:
                    list.delLast();
                    break;
                case 8:
                    list.show();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Даже не знаю как ты сюда попал\n");
                    break;
            }
        }while(key != 9);


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
