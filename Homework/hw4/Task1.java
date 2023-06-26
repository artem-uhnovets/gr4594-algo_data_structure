package Homework.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Tree{
    private Node root;
    
    class Node{
        int value;
        Node left;
        Node right;
        Color color;

        @Override
        public String toString() {
            return "Node{value="+value+",color="+color+"}";  
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        return getSubNode(root,"",sb);  
    }

    private String getSubNode(Node node,String text,StringBuilder sb) {
    if (node == null) return sb.toString();
    else {
        getSubNode(node.right,text+"---",sb);
        sb.append(text+node+"\n");
        getSubNode(node.left,text+"---",sb);
    }
    return sb.toString();
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
                    node.right = balance(node.right);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                }else{
                    insert(node.left, value);
                    node.left = balance(node.left);
                }
            }
        }
    }

    private Node balance(Node node) {
        Node result = node;
        boolean needBalance = true;
        do {
            needBalance = false;
            // по часовой
            if ((result.left != null && result.left.color == Color.RED) && (result.left.left != null && result.left.left.color == Color.RED)) {
                needBalance = true;
                result = clockturn(result);
            }
            // против часовой
            if ((result.right != null && result.right.color == Color.RED) && (result.left == null || result.left.color == Color.BLACK)) {
                needBalance = true;
                result = counterclockturn(result);
            }
            // смена цвета
            if (result.left != null && result.right != null && result.color == Color.BLACK && result.left.color == Color.RED && result.right.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);
        return result;
        
    }

    private Node clockturn(Node node) {
        Node leftChild = node.left;
        Node oldLeftRightChild = node.left.right;
        leftChild.right = node;
        node.left = oldLeftRightChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node counterclockturn(Node node) {
        Node rightChild = node.right;
        Node oldRightLeftChild = node.right.left;
        rightChild.left = node;
        node.right = oldRightLeftChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private void colorSwap(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
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

    private static void print() {
        return "value - " + node.value + "color - " + node.color;
    }

}

public class Task1 {
    public static void main(String[] args) {

        

        // ArrayList<Integer> numbersArrList = createArrayListRandomUnique(10, 29);

        // printArrList(numbersArrList);

        Integer[] numbers = new Integer[] {11, 14, 6, 8, 27, 5, 26, 23, 1, 22};

        Tree tree = new Tree();
        
        for (int i = 0; i < numbers.length; i++) {
            tree.insert(numbers[i]);
        }

        System.out.println(tree);

    }

    private static void printArrList(ArrayList<Integer> numbersArrList) {
        for (Integer number : numbersArrList) {
            System.out.printf("%d ", number);
        }
        System.out.printf("\n");
    }

    private static ArrayList<Integer> createArrayListRandomUnique(int length, int upper_num) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();
        int num_for_add = -1;
        for (int i = 0; i < length; i++) {
            num_for_add = rnd.nextInt(upper_num);
            while (numbers.indexOf(num_for_add) != -1) {
            num_for_add = rnd.nextInt(upper_num);
            }
            numbers.add(num_for_add);
        }
        return numbers;
    }
}