// Реализация односвязного списка LinkedList-LIFO(stack)

// В односвязном списке разворот медленный, за O(N^2). Можно за один проход по списку развернуть ссылки next и поменять в конце ссылку на head.
// В двусвязном списке разворот лучше, но операцию взятия размера списка можно оформить без прохода по списку (проход за O(N)), за O(1) c поддержанием счетчика в классе.

package Homework.hw3;

import java.util.Iterator;

class List {
    static Node head;

    static class Node {
        int value;
        Node next;    
    }

    static void push_front(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public static void pop_front() {
        if (head != null) {
            head = head.next;
        }
    }

    static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    // проверка вхождения элемента в список
    static Boolean contains(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    static void push_back(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    static void pop_back() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

    static void reverse() {
        Node cur = head;
        Node next = null;
        Node after = null;
        Node before = null;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        for (int i = 1; i < size; i++) {
            cur = head;
            next = cur.next;
            after = next.next;
            before = null;
            for (int j = 1; j <= size - i; j++) {
                if (head == cur) { head = next; } 
                next = cur.next;
                after = next.next;
                cur.next = after;
                next.next = cur;
                if (j != 1) { before.next = next; }
                before = next;
            }
        }
    }
}

public class Task1_LIFO {
    public static void main(String[] args) {
        List my_list = new List();
        my_list.push_front(1);
        my_list.push_front(3);
        my_list.push_front(2);
        my_list.push_front(4);
        my_list.push_front(9);
        my_list.push_front(7);
        my_list.push_front(8);
        my_list.push_front(5);
        my_list.print();
        my_list.reverse();
        my_list.print();
    }
}
