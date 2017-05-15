package com.example.dana.muzej;

import android.content.Context;
import android.support.multidex.MultiDex;

public class MyApplication extends Muzej {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
