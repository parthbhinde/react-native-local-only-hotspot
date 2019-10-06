package com.reactlibrarylocalhotspot;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

import org.json.JSONException;
import org.json.JSONObject;

public class LocalOnlyHotspotModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private WifiManager wifiManager;
    private WifiManager.LocalOnlyHotspotReservation mReservation;
    public LocalOnlyHotspotModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        wifiManager = (WifiManager) reactContext.getApplicationContext().getSystemService(reactContext.WIFI_SERVICE);
    }

    @Override
    public String getName() {
        return "LocalOnlyHotspot";
    }

//    @ReactMethod
//    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
//        // TODO: Implement some actually useful functionality
//        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
//    }
    @ReactMethod
    public void start(final Callback onStart, final Callback onFailed){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            wifiManager.startLocalOnlyHotspot(new WifiManager.LocalOnlyHotspotCallback(){
                @Override
                public void onStarted(WifiManager.LocalOnlyHotspotReservation reservation) {
                    super.onStarted(reservation);
                    mReservation = reservation;
                    onStart.invoke(config());
                }

                @Override
                public void onFailed(int reason) {
                    super.onFailed(reason);
                    onFailed.invoke(reason);
                }
            },new Handler());
        }
    }

    @ReactMethod
    public void stop(Callback onStop){
        if (mReservation != null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mReservation.close();
                onStop.invoke("Stopped");
            }
        }
    }

    @ReactMethod
    public void getConfig(Callback callback){
        callback.invoke(config());
    }

    private WritableMap config(){
        WritableMap resultData = new WritableNativeMap();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && mReservation!=null) {
            resultData.putString("ssid",mReservation.getWifiConfiguration().SSID);
            resultData.putString("secret",mReservation.getWifiConfiguration().preSharedKey);
        }
        return resultData;
    }
}
