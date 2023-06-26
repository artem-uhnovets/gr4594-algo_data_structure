// Реализация двусвязного списка LinkedList-LIFO(stack)

// В односвязном списке разворот медленный, за O(N^2). Можно за один проход по списку развернуть ссылки next и поменять в конце ссылку на head.
// В двусвязном списке разворот лучше, но операцию взятия размера списка можно оформить без прохода по списку (проход за O(N)), за O(1) c поддержанием счетчика в классе.

package Sem.Sem3;

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

    static void reverse() {
        Node h_cur = head;
        Node h_before = null;
        Node h_next = null;
        Node t_cur = tail;
        Node t_before = null;
        Node t_next = null;

        // находим количество итераций
        int size_loop = 0; // возможно начать с 1
        while (h_cur !=  null) {
            ++size_loop;
            h_cur = h_cur.next;
        }

        // переназначаем cur переменные на head и tail после подсчета size_loop
        h_cur = head;
        t_cur = tail;
        for (int i = 1; i <= (size_loop / 2); i++) {
            // при новой итерации будут переназначаться переменные после предыдущей итерации,
            // где "сдвигаются" cur позиции для рокировок
            h_before = h_cur.prev;
            h_next = h_cur.next;
            t_before = t_cur.prev;
            t_next = t_cur.next;

            // меняем свойства next и prev у "головных" узлов 
            h_cur.next = t_next;
            // воизбежании зацикленности при четном размере списка
            if ((h_next != t_cur) && (t_before != h_cur)) {
                h_cur.prev = t_before;
                t_cur.next = h_next;
            } else {
                h_cur.prev = t_cur; 
                t_cur.next = h_cur; 
            }
            t_cur.prev = h_before; 

            // меняем свойства next и prev у узлов рядом "стоящих" с h_cur
            // меняем свойство next у узла до h_cur
            if (h_before != null) { h_before.next = t_cur; }

            // условие, для четного размера списка,
            // т.к. в последней итерации может не быть узла между h_cur и t_cur
            if ((h_next != t_cur) && (t_before != h_cur)) {
                // меняем свойство prev у узла после h_cur
                h_next.prev = t_cur;
                
                // меняем свойства next и prev у узлов рядом "стоящих" с t_cur
                // меняем свойство next у узла до t_cur
                t_before.next = h_cur;
            }
            
            // меняем свойство prev у узла после t_cur
            if (t_next != null) { t_next.prev = h_cur; }

            // при первой итерации меняем tail и head после рокировки
            if (i == 1) {
                tail = h_cur;
                head = t_cur;
            }

            // переназначаем cur узлы на следуящие узлы
            h_cur = h_next;
            t_cur = t_before;     
        }        
    }
}

public class Task2_Deque {
    public static void main(String[] args) {
        dList my_list = new dList();
        my_list.push_front(1);
        my_list.push_front(3);
        my_list.push_front(2);
        my_list.push_front(4);
        my_list.push_front(6);
        my_list.push_front(9);
        my_list.push_front(7);
        my_list.push_front(8);
        my_list.push_front(5);
        my_list.print();
        my_list.reverse();
        my_list.print();
        
        
    }
}
