package me.weeravit.androidnewssample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;

import me.weeravit.androidnewssample.R;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class NewsView extends FrameLayout {

    private String mTitle;
    private String mImageUrl;
    private CardView mCardView;
    private AppCompatImageView mImageView;
    private AppCompatTextView mTextTitle;

    public NewsView(Context context) {
        super(context);
        init(null);
    }

    public NewsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public NewsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NewsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.widget_news, this);
        initView();
        initStyleable(attrs);
    }

    private void initView() {
        mCardView = (CardView) findViewById(R.id.card_view);
        mImageView = (AppCompatImageView) findViewById(R.id.image_view);
        mTextTitle = (AppCompatTextView) findViewById(R.id.text_title);
    }

    private void initStyleable(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.NewsView);
            mTitle = typedArray.getString(R.styleable.NewsView_title);
            mImageUrl = typedArray.getString(R.styleable.NewsView_imageUrl);
            typedArray.recycle();
        }
    }

    public void setOnNewsClickListener(OnClickListener listener) {
        mCardView.setOnClickListener(listener);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        mTextTitle.setText(mTitle);
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String url) {
        mImageUrl = url;
        Glide.with(getContext())
                .load(mImageUrl)
                .centerCrop()
                .into(mImageView);
    }

}
