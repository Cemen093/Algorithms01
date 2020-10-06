package org.itstep.Interface;

import java.util.Scanner;

public class Submenu {
    private String heading;
    private String[] points;

    public Submenu(){

    }
    public Submenu(String[] points){
        this.heading = heading;
        this.points = points;
    }
    public int start(){
        int answer = 0;
        do{
            System.out.println(heading);
            for (String pont: points){
                System.out.println(pont);
            }
            answer = corectInputInt("", 1, points.length);
        }while (answer == 0);
        return answer;
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
