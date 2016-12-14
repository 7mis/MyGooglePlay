package com.oliver.mygoogleplay.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Process;

import com.oliver.mygoogleplay.base.BaseApplication;


/**
 * @desc 和 UI 相关的工具类
 * @auther Oliver
 * @time 2016/12/14 21:55
 */
public class UIUtils {

    /**
     * @return 上下文
     */
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    /**
     * @return Resources 对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * @return string.xml 中的字符
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * @return string.xml 中的字符数组
     */
    public static String[] getStringArr(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * @return color.xml 中的颜色值
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * @return 应用程序的包名
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * @return 主线程的 Id
     */
    public static long getMianThreadId() {
        return BaseApplication.getMainThreadId();
    }

    /**
     * @return 主线程的 Handler
     */
    public static Handler getMianThreadHandler() {
        return BaseApplication.getHandler();
    }

    /**
     * @return 安全吧的执行一个 task
     */
    public static void postTaskSafely(Runnable task) {
        int curThreadId = Process.myTid();
        long mainThreadId = getMianThreadId();
        if (curThreadId == mainThreadId) {
            /**当前线程 == 主线程， 直接执行任务*/
            task.run();
        } else {
            /**当前线程 == 子线程，通过消息机制，把任务交给主线程 Handler 去执行*/
            getMianThreadHandler().post(task);
        }
    }


}
