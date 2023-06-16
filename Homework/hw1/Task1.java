/* 
 * Дано целое число N из отрезка [1; 1000].
Также даны N целых чисел Ai из отрезка [1; 1000000].
Требуется для каждого числа Ai вывести количество различных делителей этого числа.
В этой задаче несколько верных решений, попробуйте найти наиболее оптимальное.
Для полученного решения укажите сложность в О-нотации.
 */

package Homework.hw1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner user_data_input = new Scanner(System.in);
        Random rnd = new Random();
        System.out.print("Введите число - ");
        int n_num = user_data_input.nextInt(); // [1; 1_000]
        int ai_num = 0;  // [1; 1_000_000]
        ArrayList<Integer> numbers_list = new ArrayList<Integer>();
        ArrayList<Integer> count_numbers_list = new ArrayList<Integer>();
        for (int i = 0; i < n_num; i++) {
            ai_num = rnd.nextInt(1_000_000);
            numbers_list.add(ai_num);
            count_numbers_list.add(division_counter(ai_num));
        }
        System.out.printf("кроме самого числа,\n");
        for (int i = 0; i < n_num; i++) {
            System.out.printf("у числа %d - %d делителя(ей)\n", numbers_list.get(i), count_numbers_list.get(i));
        }
    }

    public static int division_counter(int number) {
        int counter = 0;
        for (int i = 1; i <= (number / 2); i++) {
            if (number % i == 0) {
                ++counter;
            }
        }
        return counter;
    }
}
