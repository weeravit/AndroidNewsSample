package me.weeravit.androidnewssample.module.news.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import me.weeravit.androidnewssample.databinding.ItemNewsBinding;
import me.weeravit.androidnewssample.module.news.News;
import me.weeravit.androidnewssample.module.news.NewsActivity;
import me.weeravit.androidnewssample.util.CustomViewHolder;

/**
 * Created by weeravit on 2/3/2017 AD.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<News> mNewsList;
    private NewsActivity.NewsOnClickListener mNewsOnClickListener;

    public NewsAdapter(List<News> newsList, NewsActivity.NewsOnClickListener newsOnClickListener) {
        mNewsList = newsList;
        mNewsOnClickListener = newsOnClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemNewsBinding binding = ItemNewsBinding.inflate(inflater, parent, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CustomViewHolder viewHolder = (CustomViewHolder) holder;
        ItemNewsBinding binding = (ItemNewsBinding) viewHolder.getViewDataBinding();
        binding.setItem(mNewsList.get(position));
        binding.setListener(mNewsOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void updateList(List<News> newsList) {
        NewsDiffCallback diffCallback = new NewsDiffCallback(mNewsList, newsList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        diffResult.dispatchUpdatesTo(this);
    }

}
