package me.weeravit.androidnewssample;

import me.weeravit.androidnewssample.module.news.NewsRepository;
import me.weeravit.androidnewssample.module.news.NewsRepositoryImpl;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class Injection {

    public static NewsRepository provideNewsRepository() {
        NewsRepositoryImpl repository = new NewsRepositoryImpl();
        return repository;
    }

}
