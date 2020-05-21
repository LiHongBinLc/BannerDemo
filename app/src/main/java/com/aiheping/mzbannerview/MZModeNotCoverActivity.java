package com.aiheping.mzbannerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aiheping.mzbanner.MZBannerView;

import com.aiheping.mzbanner.holder.MZHolderCreator;
import com.aiheping.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;
import static com.aiheping.mzbannerview.MZModeBannerActivity.RES;
import static com.aiheping.mzbannerview.MZModeBannerActivity.BANNER;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MZModeNotCoverActivity extends AppCompatActivity {
    @BindView(R.id.banner)
    MZBannerView banner;
    @BindView(R.id.banner_normal)
    MZBannerView bannerNormal;
    List<Integer> list;
    List<Integer> bannerList;
    public static final String TAG = "MZModeNotCoverActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mz_mode_not_cover);
        ButterKnife.bind(this);
        inData();
        init();
    }
    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
    public static class BannerPaddingViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item_padding,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    public void init() {
        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(MZModeNotCoverActivity.this,"click page:"+position,Toast.LENGTH_LONG).show();
            }
        });
        banner.addPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG,"----->addPageChangeLisnter:"+position + "positionOffset:"+positionOffset+ "positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG,"addPageChangeLisnter:"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        banner.setIndicatorVisible(false);
        banner.setPages(bannerList, new MZHolderCreator<MZModeNotCoverActivity.BannerViewHolder>() {
            @Override
            public MZModeNotCoverActivity.BannerViewHolder createViewHolder() {
                return new MZModeNotCoverActivity.BannerViewHolder();
            }
        });
        bannerNormal.setIndicatorRes(R.color.colorAccent,R.color.colorPrimary);
        bannerNormal.setPages(list, new MZHolderCreator<BannerPaddingViewHolder>() {
            @Override
            public MZModeNotCoverActivity.BannerPaddingViewHolder createViewHolder() {
                return new MZModeNotCoverActivity.BannerPaddingViewHolder();
            }
        });

    }

    public void inData() {
        list = new ArrayList<>();
        for(int i=0;i<RES.length;i++){
            list.add(RES[i]);
        }

        bannerList = new ArrayList<>();
        for(int i=0;i<BANNER.length;i++){
            bannerList.add(BANNER[i]);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        banner.pause();
        bannerNormal.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();
        bannerNormal.start();
    }
}
