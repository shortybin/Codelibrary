package utils;

import android.util.Log;

import java.lang.reflect.ParameterizedType;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/06
 *     desc   : 获取类的泛型对象
 *     version: 1.0
 * </pre>
 */

public class TUtil {
    private static final String TAG = "TUtil";
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            Log.e(TAG, "getT: ",e );
        } catch (IllegalAccessException e) {
            Log.e(TAG, "getT: ",e );
        } catch (ClassCastException e) {
            Log.e(TAG, "getT: ",e );
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
