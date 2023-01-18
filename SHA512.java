import java.security.*;
import java.nio.charset.*;
/**
 * class that is extended by Hashing to generate the SHA-512 hash of a String.
 */ 
public class SHA512 {
    /**
     * Method that generates the hexadedecimal representation of the message. 
     * @param message to be converted to hexadecimal 
     * @return the string converted to hexadecimal 
     */
    protected static String hashSHA512(String message) {
        String sha512ValueHexa = "";
        try {
            MessageDigest digest512 = MessageDigest.getInstance("SHA-512");
            sha512ValueHexa = byteToHex(digest512.digest(message.getBytes(StandardCharsets.UTF_8)));
        }
        catch (NoSuchAlgorithmException exp) {
            exp.getMessage();
        }
        return sha512ValueHexa;
    }

    /**
     * method that converts bytes to hex.
     * @param digest bytes to be converted
     * @return String output in hexadecimal
     */
    public static String byteToHex(byte[] digest) {
        StringBuilder vector = new StringBuilder();
        for (byte c : digest) {
            vector.append(String.format("%02X", c));
        }
        String output = vector.toString();
        return output;
    }
}