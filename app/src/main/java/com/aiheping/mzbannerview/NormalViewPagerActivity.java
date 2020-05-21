package com.aiheping.mzbannerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiheping.mzbanner.MZBannerView;
import com.aiheping.mzbanner.holder.MZHolderCreator;
import com.aiheping.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.aiheping.mzbannerview.MZModeBannerActivity.RES;


/**
 * Created by aiheping on 20/5/21.
 */

public class NormalViewPagerActivity extends AppCompatActivity {
    @BindView(R.id.mz_view_pager)
    MZBannerView mzViewPager;
    @BindView(R.id.normal_viewPager)
    MZBannerView normalViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_view_pager_layout);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {


        mzViewPager.setPages(mockData(), new MZHolderCreator<ViewPagerHolder>() {
            @Override
            public ViewPagerHolder createViewHolder() {
                return new ViewPagerHolder();
            }
        });

        normalViewPager.setIndicatorRes(R.drawable.dot_unselect_image, R.drawable.dot_select_image);
        normalViewPager.setPages(mockData(), new MZHolderCreator<ViewPagerHolder>() {
            @Override
            public ViewPagerHolder createViewHolder() {
                return new ViewPagerHolder();
            }
        });

    }


    public static final class ViewPagerHolder implements MZViewHolder<DataEntry> {
        private ImageView mImageView;
        private TextView mTitle;
        private TextView mDesc;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.normal_banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.normal_banner_image);
            mDesc = (TextView) view.findViewById(R.id.page_desc);
            return view;
        }

        @Override
        public void onBind(Context context, int position, DataEntry data) {
            mImageView.setImageResource(data.resId);
            mDesc.setText(data.desc);
        }
    }

    private List<DataEntry> mockData() {
        List<DataEntry> list = new ArrayList<>();
        DataEntry dataEntry = null;
        for (int i = 0; i < RES.length; i++) {
            dataEntry = new DataEntry();
            dataEntry.resId = RES[i];
            dataEntry.desc = "穿过大半个中国去睡你";
            list.add(dataEntry);
        }

        return list;
    }
}
