package me.weeravit.androidnewssample.module.news.adapter;

import android.support.v7.util.DiffUtil;

import java.util.List;

import me.weeravit.androidnewssample.module.news.News;

/**
 * Created by weeravit on 2/3/2017 AD.
 */

public class NewsDiffCallback extends DiffUtil.Callback {

    private List<News> oldNewsList;
    private List<News> newNewsList;

    public NewsDiffCallback(List<News> oldNewsList, List<News> newNewsList) {
        this.oldNewsList = oldNewsList;
        this.newNewsList = newNewsList;
    }

    @Override
    public int getOldListSize() {
        return oldNewsList.size();
    }

    @Override
    public int getNewListSize() {
        return newNewsList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        News oldNews = oldNewsList.get(oldItemPosition);
        News newNews = newNewsList.get(newItemPosition);
        return oldNews.getId() == newNews.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        News oldNews = oldNewsList.get(oldItemPosition);
        News newNews = newNewsList.get(newItemPosition);
        return oldNews.equals(newNews);
    }

}
