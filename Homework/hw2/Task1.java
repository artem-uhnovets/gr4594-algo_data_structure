package Homework.hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        // Integer[] numbers_arr = new Integer[] {4, 9, 10, 5, 16, 8, 2, 1, 11, 6};
        // Integer[] numbers_arr = new Integer[] {17, 10, 7, 3, 5, 16, 8, 9, 11, 15};
        // Integer[] numbers_arr = new Integer[] {1, 11, 11, 18, 17, 9, 12, 17, 12, 7};
        // Integer[] numbers_arr = new Integer[] {5, 4, 17, 9, 9, 3, 1, 5, 3, 12};
        // Integer[] numbers_arr = new Integer[] {11, 6, 5, 10, 9, 15, 17, 16, 14, 11};
        // Integer[] numbers_arr = new Integer[] {13, 8, 11, 18, 17, 6, 6, 13, 18, 1};
        ArrayList<Integer> numbers_list = create_ArrayList_random(10, 1, 999);
        // List<Integer> numbers_list = Arrays.asList(numbers_arr);
        Integer[] numbers_arr = new Integer[numbers_list.size()];
        // System.out.println(numbers_list);
        for (int i = 0; i < numbers_list.size(); i++) {
            numbers_arr[i] = numbers_list.get(i);
            System.out.printf("%d ", numbers_arr[i]);
        }
        System.out.println();

        int leaf_left = 0;
        int leaf_right = 0;
        int max_value_i = 0;
        int temp = 0;
        int count = 0;

        for (int j = (numbers_arr.length - 1); j > 0; j--) {
            // for (int i = ((j / 2) - 1); i >= 0; i--) {
            for (int i = ((j - 1) / 2); i >= 0; i--) {
                ++count;
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
            if (numbers_arr[0] > numbers_arr[j]) {
                ++count;
                temp = numbers_arr[0];
                numbers_arr[0] = numbers_arr[j];
                numbers_arr[j] = temp;
            }
        }
        // System.out.println(numbers_list);
        for (int i = 0; i < numbers_arr.length; i++) {
            System.out.printf("%d ", numbers_arr[i]);
        }

        System.out.printf("\nКоличество операций %d", count);
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