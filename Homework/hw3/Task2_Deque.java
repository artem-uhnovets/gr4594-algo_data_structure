// Реализация двусвязного списка LinkedList-LIFO(stack)

package Homework.hw3;

class dList {
    static Node head;
    static Node tail;

    static class Node {
        int value;
        Node next;    
        Node prev;
    }

    static void push_front(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            tail = node;
        } else{
            node.next = head; //node.next = null для fifo?!
            head.prev = node; //node.prev = head для fifo?!
        }
        head = node;
    }

    static void pop_front() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            }
            head = head.next;
            head.prev = null;

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
        if (tail == null) {
            head = node;
        } else{
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    static void pop_back() {
        if (tail != null) {
            if (tail.prev == null) {
                head = null;
                tail = null;
            }
            tail = tail.prev;
            tail.next = null;

        }
    }
    
    static void sort() {
        Boolean needSort = true;
        while (needSort) {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = next.next;

                    cur.next = after;
                    cur.prev = next;
                    next.next = cur;
                    next.prev = before;
                    if (before != null) {
                       before.next = next; 
                    } else {
                        head = next;
                    }

                    if (after != null) {
                        after.prev = cur;
                    } else {
                        tail = cur;
                    }

                    needSort = true;
                }
            node = node.next;
            }
        }
    }
}

public class Task2_Deque {
    public static void main(String[] args) {
        dList my_list = new dList();
        for (int i = 1; i <= 10; i++) {
            my_list.push_front(i);
        }
        
        // my_list.print();
        // my_list.pop_front();
        // my_list.pop_front();
        // my_list.print();
        // my_list.push_back(7);
        // my_list.print();
        // my_list.pop_back();
        // my_list.print();
        // my_list.push_front(9);
        // my_list.print();
        // my_list.sort();
        my_list.push_front(20);
        my_list.print();
        my_list.pop_back();
        my_list.print();
    }
}
