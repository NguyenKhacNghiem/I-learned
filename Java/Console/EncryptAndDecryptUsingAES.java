import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAndDecryptUsingAES 
{
    private static SecretKeySpec secretKey; // khóa bí mật sử dụng chung cho quá trình mã hóa và giải mã
    private static byte[] key;

    public static void setKey(final String myKey) 
    {
        MessageDigest sha = null;

        try 
        {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) 
        {
            e.printStackTrace();
        }
    }

    public static String encrypt(final String plainText, final String key) 
    {
        try 
        {
            setKey(key);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }

        return null;
    }

    public static String decrypt(final String cipherText, final String key) 
    {
        try 
        {
            setKey(key);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }

        return null;
    }

    public static void main(String[] args)
    {
        // Khóa bí mật là gì cũng được
        final String secretKey = "nguyenkhacnghiem";
        EncryptAndDecryptUsingAES aes = new EncryptAndDecryptUsingAES();

        String originalText = "Hello World!";
        String cipherText = aes.encrypt(originalText, secretKey) ;
        String plainText = aes.decrypt(cipherText, secretKey) ;

        System.out.println(originalText);
        System.out.println(cipherText);
        System.out.println(plainText);
    }
}