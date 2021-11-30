package hk.edu.polyu.comp5112;

/**
 * @author HUANG Zuo
 * @version create_time：2021-11-30 20:24:40
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class InserBST {
    // Java program to demonstrate insert operation
// in binary search tree


    // BST node
//    static class Node {
//        int key;
//        Node left, right;
//    };

    // Utility function to create a new node
    static PrintBinaryTree.Node<Integer> newNode(int data)
    {
        PrintBinaryTree.Node<Integer> temp = new PrintBinaryTree.Node<Integer>();

        temp.data = data;

        temp.left = null;
        temp.right = null;

        return temp;
    }

    // A utility function to insert a new
// Node with given key in BST
    static PrintBinaryTree.Node<Integer> insert(PrintBinaryTree.Node<Integer> root, int key)
    {
        // Create a new Node containing
        // the new element
        PrintBinaryTree.Node<Integer> newnode = newNode(key);

        // Pointer to start traversing from root and
        // traverses downward path to search
        // where the new node to be inserted
        PrintBinaryTree.Node<Integer> x = root;

        // Pointer y maintains the trailing
        // pointer of x
        PrintBinaryTree.Node<Integer> y = null;

        while (x != null) {
            y = x;
            if (key < x.data)
                x = x.left;
            else
                x = x.right;
        }

        // If the root is null i.e the tree is empty
        // The new node is the root node
        if (y == null)
            y = newnode;

            // If the new key is less then the leaf node key
            // Assign the new node to be its left child
        else if (key < y.data)
            y.left = newnode;

            // else assign the new node its right child
        else
            y.right = newnode;

        // Returns the pointer where the
        // new node is inserted
        return y;
    }

    // A utility function to do inorder
// traversal of BST
//    static void Inorder(PrintBinaryTree.Node<Integer> root)
//    {
//        if (root == null)
//            return;
//        else {
//            Inorder(root.left);
//            System.out.print( root.data +" ");
//            Inorder(root.right);
//        }
//    }


    // Driver code
    public static void main(String args[])
    {
	/* Let us create following BST
			50
		/ \
		30	 70
		/ \ / \
	20 40 60 80 */

        PrintBinaryTree.Node<Integer> root = null;
        root = insert(root, 65);
        insert(root, 11);
        insert(root, 47);
        insert(root, 81);
        insert(root, 20);
        insert(root, 61);
        insert(root, 3);
        insert(root, 12);
        insert(root, 13);
        insert(root, 62);

        // Print inorder traversal of the BST
//        Inorder(root);
        PrintBinaryTree.BTreePrinter.printNode(root);
    }

//contributed by Arnab Kundu


}
