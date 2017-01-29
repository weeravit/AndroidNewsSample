package me.weeravit.androidnewssample.manager;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class JsonManager {

    private Gson mGson;

    private static class Loader {
        static volatile JsonManager INSTANCE;
    }

    private JsonManager() {
        mGson = new Gson();
    }

    public static JsonManager getInstance() {
        if (Loader.INSTANCE == null) {
            Loader.INSTANCE = new JsonManager();
        }
        return Loader.INSTANCE;
    }

    public String getJsonStringFromAsset(String fileName) {
        // TODO: 1/29/2017 AD - Read from Asset folder
        return "";
    }

    public Gson getGson() {
        return mGson;
    }

}
