import java.util.*;
/**
 * This is the class representing the complete MerkleTree.
 * @author Andy Pan
 */
public class MerkleTree {
    /**
     * value representing the root of the tree.
     */
    public static MerkleTreeNode root;

    /**
     * value representing the number of files.
     */
    public int numberOfFiles;

    /**
     * ArrayList that contains the leaves of the tree.
     */
    public ArrayList<MerkleTreeNode> leaves;

    /**
     * method that constructs a merkle tree by using the array of string files as leaves.
     * @param files the string array of files
     * @return the root of the leaves
     */
    public String constructMerkleTree(String[] files) {
        if (files == null) {
            throw new IllegalArgumentException();
        }
        this.numberOfFiles = files.length;
        this.leaves = new ArrayList<>();
        ArrayList<MerkleTreeNode> tree = new ArrayList<>();
        int depth = (int)(Math.log(files.length)/Math.log(2));
        // adds the leaves into the leaves list
        for (int i = 0; i < numberOfFiles; i++) {
            MerkleTreeNode node = new MerkleTreeNode();
            node.setStr(files[i]);
            leaves.add(node);
            tree.add(node);
        }
        // constructs the body of the tree
        for (int m = depth; m > 0; m--) {
            int len = tree.size();
            for (int j = 0; j < len/2; j++) {
                MerkleTreeNode parent = new MerkleTreeNode();
                parent.setLeft(tree.get(0));
                parent.setRight(tree.get(1));
                parent.setStr(Hashing.cryptHash(parent.getLeft().getStr()+parent.getRight().getStr()));
                tree.get(0).setParent(parent);
                tree.get(1).setParent(parent);
                tree.remove(1);
                tree.remove(0);
                tree.add(parent);
            }
        }
        root = tree.get(0);
        return root.getStr();
    }

    /**
     * method that sends an Authentication pairs route to root based on the index of a leaf in the tree.
     * @param fileIndex the index of the leaf in the leaves list
     * @return an ArrayList containing sibling pairs that lead to the root starting from the leaf and its sibling as the first element
     */
    public ArrayList<SiblingPair<String>> sendAprr(int fileIndex) {
        if (fileIndex > numberOfFiles-1 || fileIndex < 0) {
            throw new IllegalArgumentException();
        }
        int level = (int)(Math.log(numberOfFiles)/Math.log(2));
        ArrayList<SiblingPair<String>> appr = new ArrayList<SiblingPair<String>>();
        MerkleTreeNode node = leaves.get(fileIndex);
        // iterates from leaf to root node
        for (int i = level; i > 0; i--) {
            node = node.getParent();
            SiblingPair<String> element = new SiblingPair<String>(node.getLeft().getStr(), node.getRight().getStr());
            appr.add(element);
        }
        node = root;
        SiblingPair<String> rootpair = new SiblingPair<String>(node.getStr(), null);
        appr.add(rootpair);
        return appr;
    }

    /**
     * method that verifies the integrity of the Authentication route to root.
     * @param aprr the route to be verified
     * @return boolean indicating whether or not the route is valid or not
     */
    public static boolean verifyIntegrity(ArrayList<SiblingPair<String>> aprr, String rootValue) {
        if (aprr == null || rootValue == null) {
            throw new IllegalArgumentException();
        }
        if (!(rootValue.equals(root.getStr()))) {
            return false;
        }
        for (int i = 0; i < aprr.size()-1; i++) {
            if (Hashing.cryptHash(aprr.get(i).getLeftSibling()+aprr.get(i).getRightSibling()).equals(aprr.get(i+1).getLeftSibling())) {
                continue;
            }
            else if (Hashing.cryptHash(aprr.get(i).getLeftSibling()+aprr.get(i).getRightSibling()).equals(aprr.get(i+1).getRightSibling())) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * method that replaces a file in leaves, then updates the tree with the new hash values.
     * @param fileIndex the index to be replaced in the leaves list
     * @param updatedFile the new String to be used
     * @return the new String value of the root of the tree
     */
    public String replaceFile(int fileIndex, String updatedFile) {
        if (updatedFile == null || fileIndex < 0 || fileIndex > numberOfFiles) {
            throw new IllegalArgumentException();
        }
        int depth = (int)(Math.log(numberOfFiles)/Math.log(2));
        leaves.get(fileIndex).setStr(updatedFile);
        MerkleTreeNode node = leaves.get(fileIndex);
        // iterates through the tree and updating the values after replacing a new file
        for (int i = depth; i > 0; i--) {
            node.getParent().setStr(Hashing.cryptHash(node.getParent().getLeft().getStr() + node.getParent().getRight().getStr()));
            node = node.getParent();
        }
        root.setStr(Hashing.cryptHash(root.getLeft().getStr()+root.getRight().getStr()));
        return root.getStr();
    }
}
