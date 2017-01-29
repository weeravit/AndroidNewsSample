package me.weeravit.androidnewssample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;

import icepick.Icepick;
import icepick.State;
import me.weeravit.androidnewssample.R;
import me.weeravit.androidnewssample.databinding.WidgetNewsBinding;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class NewsView extends FrameLayout {

    @State
    private String mTitle;
    @State
    private String mUrl;

    private WidgetNewsBinding mBinding;

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
        initStyleable(attrs);
        initViews();
    }

    private void initStyleable(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.NewsView);
            mTitle = typedArray.getString(R.styleable.NewsView_title);
            mUrl = typedArray.getString(R.styleable.NewsView_imageUrl);
            typedArray.recycle();
        }
    }

    private void initViews() {
        mBinding = WidgetNewsBinding.inflate(LayoutInflater.from(getContext()));

        setTitle(mTitle);
        setUrl(mUrl);
    }

    public void setOnNewsClickListener(OnClickListener listener) {
        mBinding.cardView.setOnClickListener(listener);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        mBinding.textTitle.setText(mTitle);
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
        Glide.with(getContext())
                .load(mUrl)
                .centerCrop()
                .into(mBinding.imageView);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return Icepick.saveInstanceState(this, super.onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state));
    }

}
