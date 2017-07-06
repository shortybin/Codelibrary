package base;

import android.content.Context;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/06
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public abstract class BasePresenter<T,E>{
    public Context mContext;
    public E mModel;
    public T mView;

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart(){

    };

    public void onDestroy() {
        this.mModel=null;
        mContext=null;
    }
}
