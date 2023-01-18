/**
 * This class is used to store each element in the Authentication Pairs Route to Root (APRR).
 * @author Maha Shamseddine
 * @param <X> Type of input of SiblingPair class
 */
public class SiblingPair<X> {
    /**
     * the left sibling in the pair.
     */
    public X leftSibling;

    /**
     * the right sibling in the pair.
     */
    public X rightSibling;

    /**
     * default constructor that initializes the left and right sibling objects.
     * @param leftS the left sibling of the node
     * @param rightS the right sibling of the node
     */
    public SiblingPair(X leftS, X rightS) {
        if (leftS == null) {
            throw new IllegalArgumentException();
        }
        leftSibling = leftS;
        rightSibling = rightS;
    }

    /**
     * default constructor that sets the sibling values to null.
     */
    public SiblingPair() {
        leftSibling = null;
        rightSibling = null;
    }

    /**
     * setter for left sibling.
     * @param leftS the left sibling
     */
    public void setLeftSibling(X leftS) {
        if (leftS == null) {
            throw new IllegalArgumentException();
        }
        leftSibling = leftS;
    }

    /**
     * setter for the right sibling.
     * @param rightS the right sibling
     */
    public void setRightSibling(X rightS) {
        if (rightS == null) {
            throw new IllegalArgumentException();
        }
        rightSibling = rightS;
    }
    
    /**
     * getter for the left sibling.
     * @return pointer to the left sibling
     */
    public X getLeftSibling() {
        return leftSibling;
    }

    /**
     * getter for the right sibling.
     * @return pointer to the right sibling
     */
    public X getRightSibling() {
        return rightSibling;
    }
}
