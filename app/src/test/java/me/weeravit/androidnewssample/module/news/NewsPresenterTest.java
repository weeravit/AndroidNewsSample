package me.weeravit.androidnewssample.module.news;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by weeravit on 2/4/2017 AD.
 */

public class NewsPresenterTest {

    private static final List<News> NEWS_LIST = Lists.newArrayList(
            new News(1, "Android Unit Test Part 1",
                    "http://asdf.co/blabla.png",
                    "http://asdf.co/123"),
            new News(2, "Android Unit Test Part 2",
                    "http://asdf.co/blabla.png",
                    "http://asdf.co/124")
    );

    @Mock
    private NewsRepository mRepository;
    @Mock
    private NewsContract.View mView;
    @Captor
    private ArgumentCaptor<NewsRepository.Callback> mCallbackCaptor;

    private NewsPresenter mPresenter;

    @Before
    public void setupNotesPresenter() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new NewsPresenter(mView, mRepository);
    }

    @Test
    public void loadNewsFromRepositoryAndLoadIntoView() {
        int page = 1;

        mPresenter.loadNews(page);

        verify(mRepository).getNews(eq(page), mCallbackCaptor.capture());
        mCallbackCaptor.getValue().onSuccess(NEWS_LIST);

        InOrder inOrder = Mockito.inOrder(mView);
        inOrder.verify(mView).showLoading(true);
        inOrder.verify(mView).showLoading(false);

        verify(mView).showNewsList(NEWS_LIST);
    }

    @Test
    public void clickOnNewsItem() {
        News news = NEWS_LIST.get(0);

        mPresenter.openNews(news);
        verify(mView).showNews(news);
    }

}
