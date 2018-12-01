package com.reunitefamilies.reunitefamilies.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import com.reunitefamilies.reunitefamilies.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by bukola on 5/7/2016.
 */
public class BaseApplication extends android.app.Application {

    private static Context sContext;
    private static BaseActivity sCurrentActivity;
    private static final String ENGLISH_US_LANG = "en-US";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {

        super.onCreate();
        //Fabric.with(this, new Crashlytics());
        setContext(getApplicationContext());
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    /**
     * get current activity.
     *
     * @return BaseActivity
     */
    public static BaseActivity getCurrentActivity() {
        return sCurrentActivity;
    }

    private static void setContext(final Context context) {
        sContext = context;
    }

    /**
     * BaseApplication's context.
     *
     * @return gloabl app context
     */
    public static Context getAppContext() {
        return sContext;
    }

    /**
     * Gettin String by Id.
     * @param id - String Id
     * @return - String from resources (R.string.ID)
     */
    @NonNull
    public static String getResourceString(final int id) {
        return sContext.getString(id);
    }
}
