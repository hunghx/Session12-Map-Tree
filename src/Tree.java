import bst.BST;

import java.util.TreeMap;
import java.util.TreeSet;

public class Tree {
    public static Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        root = new Node(60);
        // node trái
        root.left = new Node(55);
        // node phải :
        root.right = new Node(100);
        root.left.left = new Node(45);
        root.left.right = new Node(57);
        root.left.left.left = new Node(24);
        root.left.left.right = new Node(46);
        root.left.right.left = new Node(56);
        root.left.right.right = new Node(58);


        bst.BST<Integer> tree  = new BST<>(new Integer[]{20,14,30,24,18,27,46,35,44});
        tree.inorder();
        tree.delete(35);
        boolean check = tree.delete(44);
        System.out.println(check);
        System.out.println();
   tree.inorder();



//        inOrder(root); // tăng dần
//        System.out.println();
//        preorder(root); // tăng dần
//        System.out.println();
//        postorder(root); // tăng dần

    }

    public static boolean search(int value, Node current) {
        // node hiện tại đang xet là current
        if (current == null)
            return false;
        if (current.value > value)
            return search(value,current.left);
        if (value > current.value)
            return search(value, current.right);
        return true;
    }
    public static boolean searchNoDeQuy(int value, Node current) {
        // node hiện tại đang xet là current
        while (current != null){
            if(current.value==value)
                return true;
            if (current.value>value)
                current =current.left;
            else current= current.right;
        }
        return false;

    }
    public static void inOrder(Node curr) { // trái gốc phải
        if(curr !=  null) {
            inOrder(curr.left);
            //Visit the node by Printing the node data
            System.out.printf("%d ",curr.value);
            inOrder(curr.right);
        }
    }
    public static void preorder(Node root) { // hiện tâij , tái phải
        if(root !=  null) {
            //Visit the node by Printing the node data
            System.out.printf("%d ",root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void postorder(Node root) { // trái, phải, hiện tại
        if(root !=  null) {
            //Visit the node by Printing the node data
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%d ",root.value);
        }
    }


}
