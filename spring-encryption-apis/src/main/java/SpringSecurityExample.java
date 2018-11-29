import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class SpringSecurityExample {


    public static void main(String[] args) {
        final String salt = KeyGenerators.string().generateKey();
        final String password = "mypassword";

        String encryptedText = SpringSecurityExample.encrypt("Hello World To Encrypt", password, salt);
        System.out.println("Encrypted data:");
        System.out.println(encryptedText);

        String decryptedText = SpringSecurityExample.decrypt(encryptedText, password, salt);

        System.out.println("Decrypted Data:");
        System.out.println(decryptedText);

    }

    public static String encrypt(String dataToEncrypt, String password, String salt){
        String encryptedData = null;
        TextEncryptor encryptor = Encryptors.text(password, salt);
        encryptedData = encryptor.encrypt(dataToEncrypt);
        return encryptedData;

    }

    public static String decrypt(String dataToDecrypt, String password, String salt){
        String decryptedData = null;

        TextEncryptor decryptor = Encryptors.text(password, salt);
        decryptedData = decryptor.decrypt(dataToDecrypt);
        return decryptedData;
    }
}
