package com.chenminglin.androidskindemo.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenminglin.androidskindemo.R;

import solid.ren.skinlibrary.SkinLoaderListener;
import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.skinlibrary.loader.SkinManager;

public class MainActivity extends SkinBaseActivity {
    final String TAG = getClass().getSimpleName();

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SkinManager.getInstance().loadSkin("skin.skin", new SkinLoaderListener() {
                            @Override
                            public void onStart() {
                                Log.d(TAG, "onStart");
                            }

                            @Override
                            public void onSuccess() {
                                Log.d(TAG, "onSuccess");
                            }

                            @Override
                            public void onFailed(String errMsg) {
                                Log.d(TAG, "onFailed msg = " + errMsg);
                            }

                            @Override
                            public void onProgress(int progress) {
                                Log.d(TAG, "onProgress = " + progress);
                            }
                        });

                    }
                });

        findViewById(R.id.button2)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SkinManager.getInstance().restoreDefaultTheme();

                    }
                });



        textView = findViewById(R.id.text_view4);
        textView.setTextColor(getResources().getColor(R.color.c1));

        final ImageView imageView = findViewById(R.id.imageview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AnimationDrawable a =  (AnimationDrawable)imageView.getBackground();
               a.start();
            }
        });
    }

    @Override
    public void onThemeUpdate() {
        super.onThemeUpdate();
        textView.setTextColor(SkinManager.getInstance().getResources().getColor(R.color.c1));
    }
}
