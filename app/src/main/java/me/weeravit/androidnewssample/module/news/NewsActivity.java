package me.weeravit.androidnewssample.module.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import me.weeravit.androidnewssample.Injection;
import me.weeravit.androidnewssample.R;
import me.weeravit.androidnewssample.databinding.ActivityNewsBinding;
import me.weeravit.androidnewssample.module.news.adapter.NewsAdapter;

public class NewsActivity extends AppCompatActivity implements NewsContract.View {

    private NewsAdapter mAdapter;
    private NewsPresenter mPresenter;
    private ActivityNewsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
        setupInstance();
        setupRecyclerView();
    }

    private void setupView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
    }

    private void setupInstance() {
        mPresenter = new NewsPresenter(this, Injection.provideNewsRepository());
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mAdapter = new NewsAdapter(new ArrayList<News>(), mListener);

        mBinding.recyclerView.setLayoutManager(layoutManager);
        mBinding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadNews(1);
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

    }

    private Listener mListener = new Listener() {
        @Override
        public void onNewsClick(News news) {
            mPresenter.openNews(news);
        }
    };

    public interface Listener {
        void onNewsClick(News news);
    }

}
