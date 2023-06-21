// Реализация односвязного списка LinkedList-LIFO(stack)

package Sem.Sem3;

import Homework.hw3.List;

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
        Node next = cur.next;
        Node after;
        Node before = null;

        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        // Node next = cur.next;
        // Node after = next.next;

        // head = next;
        for (int i = 1; i < size; i++) {
            
        
            boolean isFirstLoop = true;

        // while (cur.next != null) {
            for (int j = 1; j <= size - i; j++) {
                if (head == cur) {
                    head = next;
                } 

                next = cur.next;
                after = next.next;

                cur.next = after;
                next.next = cur;
                if (!isFirstLoop) {
                    before.next = next;
                }
                before = next;
                isFirstLoop = false;
            }
        }


        // if (cur != null) {

        //     cur = cur.next;

        //     cur.next = head;
            
        //     head = cur;



        // }
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
        my_list.print();
        // System.out.println(my_list.size());
        my_list.reverse();
        my_list.print();
    }
}
