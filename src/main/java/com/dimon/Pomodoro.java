package com.dimon;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * -w 1 -b 1 -count 1 -t
 */
public class Pomodoro {

    static boolean isTest = false;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Ehi pomodoro. Напиши пожалуйста команду");
        String[] cmd = new Scanner(System.in).nextLine().split(" ");

        int workMin = 25;
        int breakMin = 5;
        int count = 1;

        //Кол-во палочек в прогресс баре
        int sizePrint = 30;

        boolean isCallHelp = false;

        for (int i = 0; i < cmd.length; i++) {
            switch (cmd[i]) {
                case "--help":
                    printMenuHelp();
                    isCallHelp = true;
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
                case "-t":
                    isTest= true;
            }
        }
        if (!isCallHelp)
            System.out.printf("Работаем с Вами %d min, отдыхаем %d min, " +
                    "кол-во подходов %d.\nУдачи!!!!\n", workMin, breakMin, count);
        long startTime = System.currentTimeMillis();
        //todo timer
        for (int i = 1; i <= count; i++) {
            timer(workMin, breakMin, sizePrint);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Pomodoro timer истёк: %2d min", (endTime - startTime) / (1000 * 60));
    }

    private static void timer(int workTime, int breakTime, int sizeProgressBar) throws InterruptedException {
        printProgress("Время вкалывать:: ", workTime, sizeProgressBar);

        printProgress("Время отдыхать:: ", breakTime, sizeProgressBar);
    }

    private static void printProgress(String process, int time, int size) throws InterruptedException {
        int length;
        int rep;
        length = 60 * time / size;
        rep = 60 * time / length;
        int stretchb = size / (3 * time);
        for (int i = 1; i <= rep; i++) {
            double x = i;
            x = 1.0 / 3.0 * x;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            double w = time * stretchb;
            double percent = (x / w) * 1000;
            x /= stretchb;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            percent = Math.round(percent);
            percent /= 10;
            System.out.print(process + percent + "% " + (" ").repeat(5 - (String.valueOf(percent).length())) + "[" + ("#").repeat(i) + ("-").repeat(rep - i) + "]    ( " + x + "min / " + time + "min )" + "\r");
            if (!isTest) {

                TimeUnit.SECONDS.sleep(length);
            }
        }
        System.out.println();
    }


    private static void printMenuHelp() {
        System.out.println("Меню помощи:");
        System.out.println(
                "       Pomodoro - помощник использовать твое время эффективнее!!!"
        );
        System.out.println(
                "       -w <time>: время работы."
        );
        System.out.println(
                "       -b <time>: время отдыха."
        );
        System.out.println(
                "       -count <count>: число подходов."
        );        System.out.println(
                "       -t: запуск режима тестировки.\n"
        );
        System.out.println(
                "       --help: Меню помощи."
        );
    }
}
