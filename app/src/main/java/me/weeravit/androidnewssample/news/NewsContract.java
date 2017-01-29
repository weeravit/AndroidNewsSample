package me.weeravit.androidnewssample.news;

import java.util.List;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public interface NewsContract {

    interface View {
        void showLoading(boolean enable);
        void showNewsList(List<News> newsList);
        void showError(String message);
    }

    interface Presenter {
        void loadNews(int page);
    }

}
