package me.weeravit.androidnewssample.module.news;

import java.util.List;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public interface NewsRepository {

    interface Callback {
        void onSuccess(List<News> newsList);
        void onFail(String message);
    }

    void getNews(int page, Callback callback);

}
