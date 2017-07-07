package utils.encrypt;

import android.util.Base64;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/07
 *     desc   : Base64 加密
 *     version: 1.0
 * </pre>
 */

public class Base64Util {

    /**
     * 加密
     * @param data 需要加密的数据
     * @return
     */
    public static String encry(String data){
        return new String(Base64.encode(data.getBytes(),Base64.NO_PADDING));
    }

    /**
     * 解密
     * @param data 需要解密的数据
     * @return
     */
    public static String dencry(String data){
        return new String(Base64.decode(data.getBytes(),Base64.NO_PADDING));
    }

}
