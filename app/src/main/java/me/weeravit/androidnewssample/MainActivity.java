package me.weeravit.androidnewssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.weeravit.androidnewssample.news.NewsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goToNewsPage();
    }

    private void goToNewsPage() {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
        finish();
    }

}
