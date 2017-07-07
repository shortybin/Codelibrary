package utils.encrypt;

import android.util.Base64;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/07
 *     desc   : DES加密
 *     version: 1.0
 * </pre>
 */

public class DESUtil {

    private static String DESKEY;

    public static String initKey() throws NoSuchAlgorithmException {
        if (DESKEY==null){
            SecureRandom secureRandom = null;
            secureRandom = new SecureRandom();

            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(secureRandom);
            SecretKey secretKey = kg.generateKey();
            DESKEY=new String(Base64.encode(secretKey.getEncoded(),Base64.NO_PADDING));
        }
        return DESKEY;
    }

    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        String strs = new String(Base64.encode(bt,Base64.NO_PADDING));
        return strs;
    }

    public static String decrypt(String data, String key) throws Exception {
        if(data == null) {
            return null;
        } else {
            byte[] buf = Base64.decode(data.getBytes(),Base64.NO_PADDING);
            byte[] bt = decrypt(buf, key.getBytes());
            return new String(bt);
        }
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, securekey, sr);
        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, securekey, sr);
        return cipher.doFinal(data);
    }

}
