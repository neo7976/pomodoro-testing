package com.dimon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * -w 1 -b 1 -count 1
 */
public class Pomodoro {
    public static void main(String[] args) {
        System.out.println("Ehi pomodoro. Напиши пожалуйста команду");
        String[] cmd = new Scanner(System.in).nextLine().split(" ");
//        System.out.println(Arrays.toString(cmd));

        int workMin = 25;
        int breakMin = 5;
        int count = 1;


        for (int i = 0; i < cmd.length; i++) {
            switch (cmd[i]) {
                case "--help":
                    System.out.println("Меню помощи");
                    break;
                case "-w":
                    workMin = Integer.parseInt(cmd[++i]);
                    break;
                case "-b":
                    breakMin = Integer.parseInt(cmd[++i]);
                    break;
                case "-count":
                    count = Integer.parseInt(cmd[++i]);
                    break;
            }
        }
        System.out.printf("Парметры программы работаем %d min, отдыхаем %d min, " +
                "кол-во подходов %d", workMin, breakMin, count);
        //todo
    }
}
