package com.aiheping.mzbannerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ssss)
    TextView ssss;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        ButterKnife.bind(this);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
        ssss.setText("《穿越大半个中国去睡你   ___余秀华》\n" +
                "其实，睡你和被你睡是差不多的，无非是两具肉体碰撞的力，\n" +
                "无非是这力催开的花朵\n" +
                "无非是这花朵虚拟出的春天让我们误以为生命被重新打开\n" +
                "大半个中国，什么都在发生：火山在喷，河流在枯\n" +
                "一些不被关心的政治犯和流民\n" +
                "一路在枪口的麋鹿和丹顶鹤\n" +
                "我是穿过枪林弹雨去睡你\n" +
                "我是把无数的黑夜摁进一个黎明去睡你\n" +
                "我是无数个我奔跑成一个我去睡你\n" +
                "当然我也会被一些蝴蝶带入歧途\n" +
                "把一些赞美当成春天\n" +
                "把一个和横店类似的村庄当成故乡\n" +
                "而它们\n" +
                "都是我去睡你必不可少的理由\n ");
    }

    /*
     * banner模式
     * */
    public void onBanner(View view) {
        startActivity(new Intent(this, MZModeBannerActivity.class));

    }

    /*
     * 仿魅族banner模式
     * */
    public void onMbanner(View view) {

        startActivity(new Intent(this, MZModeNotCoverActivity.class));
    }

    /*
     * 普通banner模式
     * */
    public void onPBanner(View view) {
        startActivity(new Intent(this, NormalViewPagerActivity.class));
    }


}
