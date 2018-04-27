package com.epam.java_fundamentals.intro;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    private static int lengthOfFloatAfterComma(double f) {
        return String.valueOf(f).split("\\.")[1].length();
    }

    private static String format (double eps){
        int d = lengthOfFloatAfterComma(eps);
        String format = "0.";
        for (int i = 0; i <= d; i++){
            format += "0";
        }
        return format;
    }

    private static int task_2 (double eps){

        String format = format(eps);
        double a = eps;
        int n;
        System.out.print("Члены последовательности: ");
        for (n = 1; a >= eps; n++){
            a = 1/Math.pow(n + 1, 2);
            System.out.print(new DecimalFormat(format).format(a) + " ");
        }

        System.out.println();
        System.out.print("Номер члена последовательности < e: " + n);
        return n;
    }

    private static void task_3 (double a, double b, double h){

        System.out.println("  x    f(x)");

        double f;
        for (double i = a; i <= b; i+=h){
            f = Math.tan(2*i) - 3;

            System.out.print(new DecimalFormat("0.00").format(i) + "  ");
            System.out.println(new DecimalFormat("0.00").format(f));
        }
    }

    private static void task_4 (int arraySize){

        ArrayList<Integer> array = new ArrayList<Integer>();

        for (int i = 0; i < arraySize; i++) {
            array.add((int) (Math.random() * 21) - 10);
        }

        System.out.print("Исходный массив: ");
        System.out.print(array.toString());
        System.out.println();

        int max = array.get(0) + array.get(arraySize-1);
        for (int i = 0; i < arraySize/2; i++){
            int element = array.get(i) + array.get(arraySize - i - 1);
            System.out.print(element + ", ");
            if(element > max) {
                max = element;
            }
        }
        System.out.println();
        System.out.print("max = " + max);
    }

    private static void task_5(int arraySize){

        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < arraySize; i++){
            array.add(new ArrayList<Integer>());
            for (int j = 0; j < arraySize; j++){
                array.get(i).add(j, 0);
            }
            array.get(i).set(i, 1);
            array.get(i).set(arraySize-1-i, 1);
        }

        for (int i = 0; i < arraySize; i++) {
            System.out.print(array.get(i).toString());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Задание 2");
        task_2(0.002);
        System.out.println();
        System.out.println();

        System.out.println("Задание 3");
        task_3(0, 1, 0.1);
        System.out.println();
        System.out.println();

        System.out.println("Задание 4");
        task_4(9);
        System.out.println();
        System.out.println();

        System.out.println("Задание 5");
        task_5(10);
    }
}
