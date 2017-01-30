package me.weeravit.androidnewssample.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.github.nitrico.lastadapter.LastAdapter;

import java.util.List;

import me.weeravit.androidnewssample.BR;
import me.weeravit.androidnewssample.Injection;
import me.weeravit.androidnewssample.R;
import me.weeravit.androidnewssample.databinding.ActivityNewsBinding;

public class NewsActivity extends AppCompatActivity implements NewsContract.View {

    private ActivityNewsBinding mBinding;
    private NewsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        initInstances();
        setupRecyclerView();
    }

    private void initInstances() {
        mPresenter = new NewsPresenter(this, Injection.provideNewsRepository());
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(layoutManager);
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
        LastAdapter.with(newsList, BR.item)
                .map(News.class, R.layout.item_news)
                .into(mBinding.recyclerView);
    }

    @Override
    public void showError(String message) {

    }

}
