package me.weeravit.androidnewssample.module.news;

import java.util.List;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View mView;
    private NewsRepository mRepository;

    public NewsPresenter(NewsContract.View view, NewsRepository repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void loadNews(int page) {
        mView.showLoading(true);

        mRepository.getNews(page, new NewsRepository.Callback() {
            @Override
            public void onSuccess(List<News> newsList) {
                mView.showNewsList(newsList);
                mView.showLoading(false);
            }

            @Override
            public void onFail(String message) {
                mView.showError(message);
                mView.showLoading(false);
            }
        });
    }

    @Override
    public void openNews(News news) {
        mView.showNews(news);
    }

}
