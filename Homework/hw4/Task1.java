package Homework.hw4;

class Tree{
    private Node root;
    
    class Node{
        int value;
        Node left;
        Node right;

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
        root.color = Color.BLACK;
    }

    private void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                   node.right.color = Color.RED;
                }else{
                    insert(node.right, value);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
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

        Tree tree = new Tree();
        for(int i=1; i<=5; i++)
            tree.insert(i);

    }
}