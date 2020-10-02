package org.itstep;

import org.itstep.List.List;
import java.util.Scanner;

public class Algorithms01 {
    public static void main(String[] args) {
        List notMy = new List();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ");
        int value = scanner.nextInt();
        notMy.addFict(value);
        notMy.show();

    }

}
