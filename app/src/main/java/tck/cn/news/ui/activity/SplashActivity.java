package tck.cn.news.ui.activity;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;
import tck.cn.news.R;
import tck.cn.news.base.BaseActivity;
import tck.cn.news.util.SpUtil;
import tck.cn.news.widget.MyVideoView;

public class SplashActivity extends BaseActivity {

    private static final String KEY_FIRST = "first";
    @BindView(R.id.videoview)
    MyVideoView mVideoview;
    @BindView(R.id.play)
    Button mPlay;

    @Override
    protected void iniData() {
        mVideoview.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));
        //当视频播放完毕，继续播放
        mVideoview.setOnCompletionListener(mp -> {
            mVideoview.start();
        });

    }

    @Override
    protected void initView() {
        StatusBarUtil.setColor(this, Color.GRAY);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.play)
    public void onClick() {
        //判断当前是否是第一次进入，如果是先进入引导界面，否则直接进入首页
        Boolean first = SpUtil.getBoolean(KEY_FIRST, true);
        if (first) {
            startActivity(new Intent(this, GuideActivity.class));
            SpUtil.saveBoolean(KEY_FIRST, false);
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }

        //停止播放视频，并销毁界面
        if (mVideoview != null && mVideoview.isPlaying()) {
            mVideoview.stopPlayback();
        }
        finish();
    }
}
