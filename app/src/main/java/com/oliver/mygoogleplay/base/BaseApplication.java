package com.oliver.mygoogleplay.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * @desc 单例 全局的盒子 放置大家都可以用的东西
 * @auther Oliver
 * @time 2016/12/14 17:18
 */
public class BaseApplication extends Application {

    private long mMainThreadId;
    private Handler mHandler;
    private Context mContext;


    public long getMainThreadId() {
        return mMainThreadId;
    }

    public Handler getHandler() {
        return mHandler;
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * 程序的入口方法
     */

    @Override
    public void onCreate() {
        /**1. 上下文*/
        mContext = getApplicationContext();
        /**2. 放置一个主线程的 Handler*/
        mHandler = new Handler()

        ;
        /**3. 得到主线程的 Id*/
        mMainThreadId = android.os.Process.myTid();


        super.onCreate();
    }
}
