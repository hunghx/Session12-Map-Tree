package bst;

public class BST<E extends Comparable<E>> extends AbstractTree<E>{
    // props
    private TreeNode<E> root;
    private int size;

    public BST() {
    }
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }
    public TreeNode<E> findTreeNodeByElement(E e){
        TreeNode<E> current = root;
        while (current!=null){
            if(current.element.compareTo(e)==0)
                return current;
            if (current.element.compareTo(e)>0)
                current=current.left;
            else current=current.right;
        }
        return null;
    };

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
       while (current!=null){
           if(current.element.compareTo(e)==0)
               return true;
           if (current.element.compareTo(e)>0)
               current=current.left;
           else current=current.right;
       }
       return false;
    }

    @Override
    public boolean insert(E e) {
        if(size==0){
            // chưa có node nào
            this.root = new TreeNode<>(e);
        }else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            boolean check =  true;
            while (current!=null){
                if(current.element.compareTo(e)==0)
                    return false;
                if (current.element.compareTo(e)>0) {
                    parent = current;
                    current = current.left;
                    check =false;
                }
                else {
                    parent=current;
                    current=current.right;
                    check=true;
                }
            }
            // thực hiện thêm mới
            if (check){
                parent.right = new TreeNode<>(e);
            }else {
                parent.left = new TreeNode<>(e);
            }

        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E e) {
        if (search(e)){
            root = delete_Recursive(root,e);
            return true;
        }else {
            return false;
        }
    }
    TreeNode<E> delete_Recursive(TreeNode<E> root, E key)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (key.compareTo(root.element)<0)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key.compareTo(root.element)>0)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            //  đây là node cần xóa
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.element = maxValue(root.left);

            // Delete the inorder successor
            root.left = delete_Recursive(root.left, root.element);
        }
        return root;
    }
    E maxValue(TreeNode<E> root)  {
        //initially minval = root
        E maxval = root.element;
        //find minval
        while (root.right != null)  {
            maxval = root.right.element;
            root = root.right;
        }
        return maxval;
    }
    @Override
    public void inorder() {
        inorderRec(root);
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    void inorderRec(TreeNode<E> root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.element + " ");
            inorderRec(root.right);
        }
    }
    @Override
    public void preorder() {

    }

    @Override
    public void postorder() {

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
            this.root = null;
            size=0;
    }
}
