package me.weeravit.androidnewssample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;

import me.weeravit.androidnewssample.R;

/**
 * Created by weeravit on 1/29/2017 AD.
 */

public class ImageLoadView extends AppCompatImageView {

    private String mUrl;

    public ImageLoadView(Context context) {
        super(context);
        init(null);
    }

    public ImageLoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ImageLoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        initStyleable(attrs);
        loadImage();
    }

    private void initStyleable(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ImageLoadView);
            mUrl = typedArray.getString(R.styleable.ImageLoadView_ilv_url);
            typedArray.recycle();
        }
    }

    private void loadImage() {
        Glide.with(getContext())
                .load(mUrl)
                .centerCrop()
                .into(this);
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
