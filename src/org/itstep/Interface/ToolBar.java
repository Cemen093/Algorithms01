package org.itstep.Interface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ToolBar {
    private String position;
    private String points;
    private ToolBar[] next;//ЄЄЄ, меню на рекурсии, дааа. Это вы научили маня плохому

    public ToolBar(String[] points){
        this.position = points[0];
        this.points = points[1];
        //Узнаем нужно ли создавать подменю
        if (points.length > 1){
            //Узнаем сколько подменю нужно создавать в этом подменю
            int colToolBar = 0;
            for (int i = 2; i < points.length; i += 2) {
                if (points[i].length() == position.length() + 2){
                    colToolBar++;
                }
            }
            //создадим необходимые подменю
            next = new ToolBar[colToolBar];
            int numberString = 2;
            for (int i = 0; i < colToolBar; i++) {
                //подсчитаем сколько строк необходимо передать в подменю (включая все подменю)
                int numTransLines = 0;
                while (numberString + numTransLines + 2 <= points.length - 1 && points[numberString].length() != points[numberString + numTransLines + 2].length()){
                    numTransLines += 2;
                }
                //next[i].set(new Arrays.copyOfRange(points, 3, points.length));
                //почему оно не работает?
                String[] arr;
                arr = Arrays.copyOfRange(points, numberString, numberString + 2 + numTransLines);
                next[i] = new ToolBar(arr);
                //перемеся к новому подменю
                numberString += numTransLines + 2;
            }
        }
    }
    private int corectInputInt(String s, int min, int max){
        if (min < -2147483647) min = -2147483647;
        if (max > 2147483647) max = 2147483647;
        Scanner scanner = new Scanner(System.in);
        int namber;
        do {
            System.out.print(s);
            if(scanner.hasNextInt()) {
                namber = scanner.nextInt();
                if (namber <= max && namber >= min) {
                    break;
                }
            }
            scanner.nextLine();
            System.out.printf("Не корректный ввод\n" +
                    "Введите целое число от %d до %d\n", min, max);
        } while (true);
        return namber;
    }
}
