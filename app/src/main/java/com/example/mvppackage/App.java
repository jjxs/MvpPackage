package com.example.mvppackage;

import android.app.Application;

/**
 * Created by Fangzheng on 2017/9/21.
 */

public class App extends Application {

    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }

    public static App getContext(){
        return mContext;
    }
}
