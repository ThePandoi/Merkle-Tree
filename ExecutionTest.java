import java.util.*;
/**
 * class that tests the construction of the Merkle tree and its values.
 */
public class ExecutionTest {
    /**
     * private method that prints the tree in order. 
     * @param root root of the tree
     */
    private static void inOrder(MerkleTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getStr()+" ");
        inOrder(root.getRight());
    }
    /**
     * main method for executing the Merkle tree.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String[] files = {"Ae", "Be", "Ce", "De"};
        String root = null;
        // constructing the tree 
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Constructing the MerkleTree with Ae: ");
        MerkleTree merkleTree = new MerkleTree();
        root = merkleTree.constructMerkleTree(files);
        System.out.println("The root value after constructing the MerkleTree is " + root);
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Finding the aprr from Ae");
        ArrayList<SiblingPair<String>> aprr1 = merkleTree.sendAprr(0);
        try {
            int size1 = aprr1.size();
            for (int i = 0; i < size1; i++) {
                System.out.println("The pair at position " + i + " is " + aprr1.get(i).leftSibling + " and " + aprr1.get(i).rightSibling);
            }
        }
        catch (Exception e){
            System.out.println("Error finding the aprr");
        }
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Finding the aprr from Be");
        ArrayList<SiblingPair<String>> aprr2 = merkleTree.sendAprr(1);
        try {
            int size2 = aprr2.size();
            for (int i = 0; i < size2; i++) {
                System.out.println("The pair at position " + i + " is " + aprr2.get(i).leftSibling + " and " + aprr2.get(i).rightSibling);
            }
        }
        catch (Exception e){
            System.out.println("Error finding the aprr");
        }
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Finding the aprr from Ce");
        ArrayList<SiblingPair<String>> aprr3 = merkleTree.sendAprr(2);
        try {
            int size3 = aprr3.size();
            for (int i = 0; i < size3; i++) {
                System.out.println("The pair at position " + i + " is " + aprr3.get(i).leftSibling + " and " + aprr3.get(i).rightSibling);
            }
        }

        catch (Exception e){
            System.out.println("Error finding the aprr");
        }
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Finding the aprr from De");
        ArrayList<SiblingPair<String>> aprr4 = merkleTree.sendAprr(3);
        // aprr 
        try {
            int size4 = aprr4.size();
            for (int i = 0; i < size4; i++) {
                System.out.println("The pair at position " + i + " is " + aprr4.get(i).leftSibling + " and " + aprr4.get(i).rightSibling);
            }
        }
        catch (Exception e){
            System.out.println("Error finding the aprr");
        }
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println();
        // verification 
        System.out.println("Verifying the aprr for Ae: It is " + MerkleTree.verifyIntegrity(aprr1, root));
        System.out.println("Verifying the aprr for Be: It is " + MerkleTree.verifyIntegrity(aprr1, root));
        System.out.println("Verifying the aprr for Ce: It is " + MerkleTree.verifyIntegrity(aprr1, root));
        System.out.println("Verifying the aprr for De: It is " + MerkleTree.verifyIntegrity(aprr1, root));
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("Printing the elements of the tree: ");
        inOrder(MerkleTree.root);
        System.out.println();
        System.out.println("****************************************************************************");
    }
}
