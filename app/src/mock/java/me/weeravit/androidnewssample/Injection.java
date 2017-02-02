package me.weeravit.androidnewssample;

import com.google.gson.Gson;

import me.weeravit.androidnewssample.manager.JsonManager;
import me.weeravit.androidnewssample.module.news.FakeNewsRepositoryImpl;
import me.weeravit.androidnewssample.module.news.NewsRepository;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class Injection {

    public static NewsRepository provideNewsRepository() {
        Gson gson = JsonManager.getInstance().getGson();
        FakeNewsRepositoryImpl repository = new FakeNewsRepositoryImpl(gson);
        return repository;
    }

}
