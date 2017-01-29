package me.weeravit.androidnewssample.manager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class NetworkManager {

    private static final String BASE_URL = "https://raw.githubusercontent.com/weeravit/json-mock/master/android-news/";

    private ApiService mApiService;

    private static class Loader {
        static volatile NetworkManager INSTANCE = new NetworkManager();
    }

    private NetworkManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    public static NetworkManager getInstance() {
        return Loader.INSTANCE;
    }

    public ApiService getApiService() {
        return mApiService;
    }

}
