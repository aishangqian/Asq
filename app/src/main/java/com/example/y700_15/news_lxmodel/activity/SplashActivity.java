package com.example.y700_15.news_lxmodel.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.example.y700_15.news_lxmodel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        initData();
    }

    private void initData(){
        //隐藏标题栏
        getSupportActionBar().hide();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        //屏幕高度
        int height = displayMetrics.heightPixels;
        //缩放
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(iv,"scaleX",2,1);
        //渐变
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(iv,"alpha",0,1);
        //旋转0
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(iv,"rotation",0,360);
        //移动
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(iv,"translationY",0,height/2-iv.getHeight()/2);

        //组合动画
        AnimatorSet set = new AnimatorSet();
        //设置连续
        set.play(objectAnimator1).with(objectAnimator2).with(objectAnimator3).with(objectAnimator4);
        //动画运行时间
        set.setDuration(3000);
        set.start();

        /**
         * 动画执行过程中监听
         */
        set.addListener(new Animator.AnimatorListener() {
            //开始
            @Override
            public void onAnimationStart(Animator animation) {

            }
            //结束
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this,Main2Activity.class));
            }
            //取消
            @Override
            public void onAnimationCancel(Animator animation) {

            }
            //重复
            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
