package Sem.Sem4;

class HashMap {
    class Entity{
        int key;
        int value;
    }
    class Basket{
        Node head;
        class Node{
            Entity entity;
            Node next;
        }

        private boolean push(Entity entity){
            Node node = new Node();
            node.entity = entity;

            if(head == null){
                head = node;
            }else{
                Node cur = head;
                while(cur != null){
                    if(cur.entity.key == entity.key){
                        return false;
                    }
                    if(cur.next == null){
                        cur.next = node;
                        return true;
                    }
                    cur = cur.next;
                }
            }

            return true;
        }

        private Integer find(int key){
            Node cur = head;
            while(cur != null){
                if(cur.entity.key == key){
                    return cur.entity.value;
                }
                cur = cur.next;
            }
            return null;
        }

        private boolean remove(int key){
            if(head != null){
                if(head.entity.key == key){
                    head = head.next;
                    return true;
                }else {
                    Node cur = head;
                    while (cur.next != null) {
                        if (cur.next.entity.key == key) {
                            cur.next = cur.next.next;
                            return true;
                        }
                        cur = cur.next;
                    }
                }
            }
            return false;
        }
    }

    static final int INIT_SIZE = 16; // фиксированный размер - для примера

    Basket[] baskets;

    public HashMap(){ // конструктор, который по умолчанию 16
        this(INIT_SIZE);
    }
    public HashMap(int size){
        baskets = new Basket[size];
    }

    private int getIndex(int key){
        return (key % baskets.length + baskets.length) % baskets.length; // [0, length - 1]
        // key = 22, getIndex(22) = 22 % 16 = 6
    }

    public boolean push(int key, int value){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    public Integer find(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket != null){
            return basket.find(key);
        }
        return null;
    }

    public boolean remove(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if(basket != null){
            return basket.remove(key);
        }
        return false;
    }
}

class Tree{
    private Node root;
    
    class Node{
        int value;
        Node left;
        Node right;

        //boolean color; // true = RED, false = BLACK
        Color color;
    }

    enum Color{
        BLACK,
        RED
    }

    public void insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
        }else{
            insert(root, value);
            root = balance(root);
        }
        //root.color = Color.BLACK;
        //root.color = false;
    }

    private void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                   //node.right.color = RED;
                }else{
                    insert(node.right, value);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    //node.left.color = RED;
                }else{
                    insert(node.left, value);
                }
            }
        }
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if(node == null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        if(node.value < value) {
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
       HashMap map = new HashMap();

       map.push(-1, 2);
       map.push(17, 3);
       map.push(3, 4);

       System.out.println(map.find(-1));
       System.out.println(map.find(17));
       System.out.println(map.find(3));
       System.out.println(map.find(5));

       map.remove(17);
       System.out.println(map.find(17));

        // Tree tree = new Tree();
        // for(int i=1; i<=5; i++)
        //     tree.insert(i);

    }
}
