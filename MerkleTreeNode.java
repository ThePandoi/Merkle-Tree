/**
 * This class is used to represent nodes in the Merkle Tree. 
 * @author Andy Pan
 */
public class MerkleTreeNode {
    /**
     * value that represents the parent of the node.
     */
    private MerkleTreeNode parent;

    /**
     * value that represents the left child of the node.
     */
    private MerkleTreeNode left;

    /**
     * value that represents the right child of the node.
     */
    private MerkleTreeNode right;

    /**
     * value that represents the String value the node contains. 
     */
    private String str;

    /**
     * Default constructor of the Node of the MerkleTree that sets the instance values to null.
     */
    public MerkleTreeNode() {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.str = null;
    }

    /**
     * Constructor that initializes the parent, left, and right MerkleTreeNode objects.
     * @param parent the parent node of this node
     * @param left the left child node of this node
     * @param right the right child node of this node
     * @param str the value the node contains
     */
    public MerkleTreeNode(MerkleTreeNode parent, MerkleTreeNode left, MerkleTreeNode right, String str) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.str = str;
    }

    /**
     * getter for the parent node.
     * @return the parent node
     */
    public MerkleTreeNode getParent() {
        return parent;
    }

    /**
     * getter for the left child node.
     * @return the left child node
     */
    public MerkleTreeNode getLeft() {
        return left;
    }

    /**
     * getter for the right child node.
     * @return the right child node
     */
    public MerkleTreeNode getRight() {
        return right;
    }

    /**
     * getter for the string value contained in the node.
     * @return string value contained in the node
     */
    public String getStr() {
        return str;
    }

    /**
     * setter for the parent node.
     * @param parent the parent node
     */
    public void setParent(MerkleTreeNode parent) {
        if (parent == null) {
            throw new IllegalArgumentException();
        }
        this.parent = parent;
    }

    /**
     * setter for the left child node.
     * @param left the left child node
     */
    public void setLeft(MerkleTreeNode left) {
        if (left == null) {
            throw new IllegalArgumentException();
        }
        this.left = left;
    }

    /**
     * setter for the right child node.
     * @param right the right child node
     */
    public void setRight(MerkleTreeNode right) {
        if (right == null) {
            throw new IllegalArgumentException();
        }
        this.right = right;
    }

    /**
     * setter for the string value.
     * @param str value inside the node
     */
    public void setStr(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.str = str;
    }
}
