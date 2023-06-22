// Реализация двусвязного списка LinkedList-LIFO(stack)

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
        while ((h_cur.next !=  t_cur ) || (h_cur != t_cur)) {
            ++size_loop;
            h_cur = h_cur.next;
            t_cur = t_cur.prev;
        }

        // переназначаем cur переменные на head и tail
        h_cur = head;
        t_cur = tail;
        for (int i = 1; i <= size_loop; i++) {
            
            // при каждой новой итерации будут переназначаться переменные после предыдущей итерации,
            // где "сдвигаются" cur позиции у head и tail
            h_before = h_cur.prev;
            h_next = h_cur.next;
            t_before = t_cur.prev;
            t_next = t_cur.next;

            // меняем свойства next и prev у "головных" узлов 
            if (t_cur == tail) { // при 1ой итерации
                h_cur.next = null; 
            } else { h_cur.next = t_next; } // вроде только эту строку можно использовать
            h_cur.prev = t_before;

            // меняем свойства next и prev у "хвостатых" узлов 
            t_cur.next = h_next;
            if (h_cur == head) {
                t_cur.prev = null;
            } t_cur.prev = h_before;

            // меняем свойства next и prev у узлов рядом "стоящих" с h_cur
            // меняем свойство next у узла до h_cur
            if (h_before != null) {
                h_before.next = t_cur;
            }
            // меняем свойство prev у узла после h_cur
            h_next.prev = t_cur;
            
            // меняем свойства next и prev у узлов рядом "стоящих" с t_cur
            // меняем свойство next у узла до t_cur
            t_before.next = h_cur;
            // меняем свойство prev у узла после t_cur
            if (t_next != null) {
                t_next.prev = h_cur;
            }

            // при первой итерации меняем tail и head после рокировки
            if (i == 1) {
                tail = h_cur;
                head = t_cur;
            }

            // переназначаем cur узлы на следуящие узлы
            h_cur = h_next;
            t_cur = t_before;
            
            // h_cur = h_cur.next;
            // t_cur = t_cur.prev;        
        }        
    }
    
    // static void reverse() {
    //     Node h_cur = head;
    //     Node h_before = null;
    //     Node h_next = null;
    //     Node t_cur = tail;
    //     Node t_before = null;
    //     Node t_next = null;

    //     // находим количество итераций
    //     int size_loop = 0; // возможно начать с 1
    //     while ((h_cur.next !=  t_cur ) || (h_cur != t_cur)) {
    //         ++size_loop;
    //         h_cur = h_cur.next;
    //         t_cur = t_cur.prev;
    //     }

    //     // переназначаем cur переменные на head и tail
    //     h_cur = head;
    //     t_cur = tail;
    //     for (int i = 1; i <= size_loop; i++) {
            
    //         // при каждой новой итерации будут переназначаться переменные после предыдущей итерации,
    //         // где "сдвигаются" cur позиции у head и tail
    //         h_before = h_cur.prev;
    //         h_next = h_cur.next;
    //         t_before = t_cur.prev;
    //         t_next = t_cur.next;

    //         // меняем свойства next и prev у "головных" узлов 
    //         if (t_cur == tail) { // при 1ой итерации
    //             h_cur.next = null; 
    //         } else { h_cur.next = t_next; } // вроде только эту строку можно использовать
    //         h_cur.prev = t_before;

    //         // меняем свойства next и prev у "хвостатых" узлов 
    //         t_cur.next = h_next;
    //         if (h_cur == head) {
    //             t_cur.prev = null;
    //         } t_cur.prev = h_before;

    //         // меняем свойства next и prev у узлов рядом "стоящих" с h_cur
    //         // меняем свойство next у узла до h_cur
    //         if (h_before != null) {
    //             h_before.next = t_cur;
    //         }
    //         // меняем свойство prev у узла после h_cur
    //         h_next.prev = t_cur;
            
    //         // меняем свойства next и prev у узлов рядом "стоящих" с t_cur
    //         // меняем свойство next у узла до t_cur
    //         t_before.next = h_cur;
    //         // меняем свойство prev у узла после t_cur
    //         if (t_next != null) {
    //             t_next.prev = h_cur;
    //         }

    //         // при первой итерации меняем tail и head после рокировки
    //         if (i == 1) {
    //             tail = h_cur;
    //             head = t_cur;
    //         }

    //         // переназначаем cur узлы на следуящие узлы
    //         h_cur = h_next;
    //         t_cur = t_before;
            
    //         // h_cur = h_cur.next;
    //         // t_cur = t_cur.prev;        
    //     }        
    // }

    // static void reverse() {
    //     Node h_cur = head;
    //     Node h_before = head.prev;
    //     Node h_next = head.next;
    //     Node t_cur = tail;
    //     Node t_before = tail.prev;
    //     Node t_next = tail.next;

    //     // находим количество итераций
    //     int size_loop = 0; // возможно начать с 1
    //     while ((h_cur.next !=  t_cur )|| (h_cur != t_cur)) {
    //         ++size_loop;
    //         h_cur = h_cur.next;
    //         t_cur = t_cur.prev;
    //     }

    //     // меняем свойства next и prev у "головных" узлов 
    //     if (t_cur == tail) { // при 1ой итерации
    //         h_cur.next = null; 
    //     } else { h_cur.next = t_next; } // вроде только эту строку можно использовать
    //     h_cur.prev = t_before;

    //     // меняем свойства next и prev у "хвостатых" узлов 
    //     t_cur.next = h_next;
    //     if (h_cur == head) {
    //         t_cur.prev = null;
    //     } t_cur.prev = h_before;

    //     // меняем свойства next и prev у узлов рядом "стоящих" с h_cur
    //     // меняем свойство next у узла до h_cur
    //     if (h_before != null) {
    //         h_before.next = t_cur;
    //     }
    //     // меняем свойство prev у узла после h_cur
    //     h_next.prev = t_cur;
        
    //     // меняем свойства next и prev у узлов рядом "стоящих" с t_cur
    //     // меняем свойство next у узла до t_cur
    //     t_before.next = h_cur;
    //     // меняем свойство prev у узла после t_cur
    //     if (t_next != null) {
    //         t_next.prev = h_cur;
    //     }

    //     // if (i == 1) {
    //         tail = h_cur;
    //         head = t_cur;
    //     // }

    //     t_cur = tail;
    //     h_cur = head;
        
    //     t_cur = t_cur.next;        
    //     h_cur = h_cur.next;
        
    // }
}

public class Task2_Deque {
    public static void main(String[] args) {
        dList my_list = new dList();
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
