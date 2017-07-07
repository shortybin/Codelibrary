package utils.encrypt;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/07
 *     desc   : MD5加密
 *     version: 1.0
 * </pre>
 */

public class MD5Util {

    /**
     * MD5加密
     * @param data 需要加密的数据
     * @return
     */
    public static String MD5Encry(String data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data.getBytes());
            return new String(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 先MD5加密后base64加密   保证都是字符串
     * @param data 需要加密的数据
     * @return
     */
    public static String base64AndMD5(String data){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data.getBytes());
            return new String(Base64.encode(md5.digest(),Base64.NO_PADDING));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
