package me.weeravit.androidnewssample.module.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.weeravit.androidnewssample.Injection;
import me.weeravit.androidnewssample.R;
import me.weeravit.androidnewssample.databinding.ActivityNewsBinding;
import me.weeravit.androidnewssample.module.news.adapter.NewsAdapter;

public class NewsActivity extends AppCompatActivity implements
        NewsContract.View,
        NewsAdapter.Listener {

    public static final String PAGE_EXTRA = "page";
    public static final String LAYOUT_MANAGER_EXTRA = "layout_manager";

    private int mPage;
    private NewsAdapter mAdapter;
    private NewsPresenter mPresenter;
    private ActivityNewsBinding mBinding;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupInstance(savedInstanceState);
        setupView();
        setupRecyclerView();

        mPresenter.loadNews(mPage);
    }

    private void setupView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
    }

    private void setupInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mPage = savedInstanceState.getInt(PAGE_EXTRA, 1);
        } else {
            mPage = 1;
        }

        mPresenter = new NewsPresenter(this, Injection.provideNewsRepository());
    }

    private void setupRecyclerView() {
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new NewsAdapter(new ArrayList<News>(), this);

        mBinding.recyclerView.setLayoutManager(mLayoutManager);
        mBinding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onNewsClick(News news) {
        mPresenter.openNews(news);
    }

    @Override
    public void showLoading(boolean enable) {
    }

    @Override
    public void showNewsList(List<News> newsList) {
        mAdapter.updateList(newsList);
    }

    @Override
    public void showNews(News news) {
        Intent externalBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(news.getLink()));
        startActivity(externalBrowser);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mBinding.getRoot(), message, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.loadNews(mPage);
                    }
                })
                .show();
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(PAGE_EXTRA, mPage);
//        outState.putParcelable(LAYOUT_MANAGER_EXTRA, mLayoutManager.onSaveInstanceState());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        mPage = savedInstanceState.getInt(PAGE_EXTRA, 1);
//        savedInstanceState.getParcelable(LAYOUT_MANAGER_EXTRA);
//    }

}
