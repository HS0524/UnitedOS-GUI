package physicsGUI;

import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * A utility class for AES-based encryption and decryption of text data.
 * <p>
 * This class provides methods to:
 * <ul>
 * <li>Generate and store a secret AES key</li>
 * <li>Load a previously stored AES key</li>
 * <li>Encrypt text using the AES key</li>
 * <li>Decrypt encrypted text using the AES key</li>
 * </ul>
 *
 * <p>
 * It uses the {@code javax.crypto} package and Base64 encoding to safely store
 * and transmit encrypted data as strings.</p>
 *
 * @author Harshil Shah
 */
public class EncryptionUtils {

    private static final String KEY_FILE = "secretKey.key";

    /**
     * Generates a new AES secret key and stores it in a file on disk.
     * <p>
     * If the key file already exists, this method will overwrite it.
     *
     * @throws Exception if key generation or file writing fails
     */
    public static void generateAndStoreKey() throws Exception {
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        byte[] encoded = key.getEncoded();

        try (FileOutputStream fos = new FileOutputStream(KEY_FILE)) {
            fos.write(encoded);
        }
    }

    /**
     * Loads the AES secret key from the file system.
     * <p>
     * If the key file does not exist, a new key is generated and saved
     * automatically.
     *
     * @return the loaded AES {@code SecretKey}
     * @throws Exception if reading the key or generating a new one fails
     */
    public static SecretKey loadKey() throws Exception {
        File file = new File(KEY_FILE);
        if (!file.exists()) {
            generateAndStoreKey(); // Only generate if the key doesn't exist
        }

        byte[] encoded = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(encoded);
        }
        return new SecretKeySpec(encoded, "AES");
    }

    /**
     * Encrypts a given string using the specified AES key.
     *
     * @param data the plain text string to encrypt
     * @param key  the AES {@code SecretKey} used for encryption
     * @return the encrypted string encoded in Base64
     * @throws Exception if encryption fails
     */
    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8")); // Ensure encoding
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Decrypts a Base64-encoded encrypted string using the specified AES key.
     *
     * @param encryptedData the encrypted string encoded in Base64
     * @param key           the AES {@code SecretKey} used for decryption
     * @return the decrypted plain text string
     * @throws Exception if decryption fails
     */
    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes, "UTF-8"); // Ensure encoding
    }
}
