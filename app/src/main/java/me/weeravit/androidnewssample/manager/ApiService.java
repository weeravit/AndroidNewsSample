package me.weeravit.androidnewssample.manager;

import java.util.List;

import me.weeravit.androidnewssample.module.news.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public interface ApiService {

    @GET("page/{page}.json")
    Call<List<News>> getNews(@Path("page") int page);

}
