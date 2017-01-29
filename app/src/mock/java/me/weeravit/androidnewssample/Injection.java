package me.weeravit.androidnewssample;

import me.weeravit.androidnewssample.news.FakeNewsRepositoryImpl;
import me.weeravit.androidnewssample.news.NewsRepository;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class Injection {

    public static NewsRepository provideNewsRepository() {
        FakeNewsRepositoryImpl repository = new FakeNewsRepositoryImpl();
        return repository;
    }

}
