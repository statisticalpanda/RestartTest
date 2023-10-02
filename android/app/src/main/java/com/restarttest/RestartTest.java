package com.storefulfillment;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;

import android.util.Log;
import android.content.Context;
import android.content.pm.PackageManager;

public class RestartTest extends ReactContextBaseJavaModule {

    RestartTest(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "RestartTest";
    }

    @ReactMethod
    private void restartApp() {
        Context ctx = this.getReactApplicationContext();
        Intent launchIntent = getReactApplicationContext().getPackageManager()
                .getLaunchIntentForPackage("com.restarttest");
        Intent mainIntent = Intent.makeRestartActivityTask(launchIntent.getComponent());
        ctx.startActivity(mainIntent);
        Runtime.getRuntime().exit(0);
    }
}