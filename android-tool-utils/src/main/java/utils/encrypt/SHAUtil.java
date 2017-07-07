package utils.encrypt;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/07
 *     desc   : SHA加密
 *     version: 1.0
 * </pre>
 */

public class SHAUtil {

    /**
     * SHA加密
     * @param data 需要加密的数据
     * @return
     */
    public static String encry(String data){
        try {
            MessageDigest sha=MessageDigest.getInstance("SHA");
            sha.update(data.getBytes());
            return new String(sha.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 先SHA加密  后Base64加密  保证是字符串
     * @param data 需要加密的数据
     * @return
     */
    public static String base64AndSHA(String data){
        try {
            MessageDigest sha=MessageDigest.getInstance("SHA");
            sha.update(data.getBytes());
            return new String(Base64.encode(sha.digest(),Base64.NO_PADDING));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
