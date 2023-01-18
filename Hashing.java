/**
 * Hashing class that contains a method to hash a string into another value to be placed into the tree. 
 */
public class Hashing extends SHA512{
    /**
     * method that hash a string value and returns an output formatted in hexadecimal. 
     * @param s the String value input
     * @return hashed string value in hexadecimal
     */
    public static String cryptHash(String s) {
        String digest = hashSHA512(s);
        return digest.substring(0, 128);
    }
}