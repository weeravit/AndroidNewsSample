package me.weeravit.androidnewssample.module.news;

import java.util.List;

import me.weeravit.androidnewssample.common.BaseView;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public interface NewsContract {

    interface View  extends BaseView {
        void showNewsList(List<News> newsList);
        void showNews(News news);
    }

    interface Presenter {
        void loadNews(int page);
        void openNews(News news);
    }

}
