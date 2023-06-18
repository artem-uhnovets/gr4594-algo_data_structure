package Homework.hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task1_1 {
    public static void main(String[] args) {
        Integer[] numbers_arr = new Integer[] {4, 9, 10, 5, 16, 8, 2, 1, 11, 6};
        List<Integer> numbers_list = Arrays.asList(numbers_arr);
        System.out.println(numbers_list);

        int leaf_left = 0;
        int leaf_right = 0;
        int max_value_i = 0;
        int temp = 0;

        for (int j = (numbers_arr.length - 1); j > 0; j--) {
            for (int i = ((j - 1) / 2); i >= 0; i--) {
                leaf_left = 2 * i + 1;
                leaf_right = (2 * i + 2) <= j ? (2 * i + 2) : leaf_left;

                if (numbers_arr[leaf_left] >= numbers_arr[leaf_right]) {
                    max_value_i = leaf_left;
                } else { max_value_i = leaf_right; }

                if (numbers_arr[max_value_i] > numbers_arr[i]) {
                    temp = numbers_arr[i];
                    numbers_arr[i] = numbers_arr[max_value_i];
                    numbers_arr[max_value_i] = temp;
                }
            }
            System.out.println("```mermaid");
            System.out.println("flowchart TB");
            for (int i = 0; i < numbers_arr.length; i++) {
                System.out.printf("%d(\"%d\")\n", i, numbers_arr[i]);
            }
            System.out.printf("0-->1 & 2\n" + //
                              "1-->3 & 4\n" + //
                              "2-->5 & 6\n" + //
                              "3-->7 & 8\n" + //
                              "4-->9\n");
            System.out.printf("```\n");
            System.out.println("```mermaid");
            System.out.println("flowchart LR");
            for (int i = 0; i < numbers_arr.length; i++) {
                System.out.printf("%d(\"%d\")\n", i, numbers_arr[i]);
            }
            System.out.println("0-.-1-.-2-.-3-.-4-.-5-.-6-.-7-.-8-.-9");
            if (numbers_arr[0] > numbers_arr[j]) {
                temp = numbers_arr[0];
                numbers_arr[0] = numbers_arr[j];
                numbers_arr[j] = temp;
                System.out.printf("0<==>|рокируем|%d\n", j);
            } else { System.out.printf("0<==>|НЕ рокируем|%d\n", j); }
            System.out.printf("```\n");
        }
        System.out.println(numbers_list);
    }

    public static ArrayList<Integer> create_ArrayList_random(int length, int lower_num,int upper_num) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();
        int num_for_add = -1;
        for (int i = 0; i < length; i++) {
            num_for_add = -1;
            while (num_for_add < lower_num) {
            num_for_add = rnd.nextInt(upper_num);
            }
            numbers.add(num_for_add);
        }
        return numbers;
    }
}