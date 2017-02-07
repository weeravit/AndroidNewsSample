package me.weeravit.androidnewssample.module.news;

import java.util.List;

import me.weeravit.androidnewssample.manager.NetworkManager;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class NewsRepositoryImpl implements NewsRepository {

    @Override
    public void getNews(int page, final Callback callback) {
        NetworkManager.getInstance()
                .getApiService()
                .getNews(page)
                .enqueue(new retrofit2.Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        if (response.isSuccessful()) {
                            callback.onSuccess(response.body());
                        } else {
                            try {
                                String message = response.errorBody().string();
                                throw new Exception(message);
                            } catch (Exception e) {
                                onFailure(call, e);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {
                        callback.onFail(t.getMessage());
                    }
                });
    }

}
