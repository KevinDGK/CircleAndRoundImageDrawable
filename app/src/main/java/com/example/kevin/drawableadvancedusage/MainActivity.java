package com.example.kevin.drawableadvancedusage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevin.drawableadvancedusage.view.CircleImageDrawable;
import com.example.kevin.drawableadvancedusage.view.RoundImageDrawable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView miv0 = (ImageView) findViewById(R.id.iv0);
        ImageView miv1 = (ImageView) findViewById(R.id.iv1);
        ImageView miv2 = (ImageView) findViewById(R.id.iv2);
        ImageView miv3 = (ImageView) findViewById(R.id.iv3);
        ImageView miv4 = (ImageView) findViewById(R.id.iv4);

        /**
         * 步骤：
         * 1.将图片资源解析成Bitmap
         *
         * 2.使用Bitmap创建圆形/矩形图片Drawable
         *   内部使用bitmapShader实现的！！！
         *
         * 3.将生成的Drawable设置成ImageView背景
         *   注：如果多个ImageView同时使用同一个生成的Drawable，如果在xml中设置scaleType属性，
         *      会造成所有使用该Drawable的ImageView产生相同的scaleType属性，为啥暂时不清楚。
         *      所以，如果要产生不同的scaleType效果，可以使用不同的Drawable。
         */

        // 将图片解析成Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.mv);

        // 矩形图片
        RoundImageDrawable roundImageDrawable = new RoundImageDrawable(bitmap);
        miv0.setImageDrawable(roundImageDrawable);
        miv1.setImageDrawable(roundImageDrawable);

        // 作为文字背景
        // 此处就是步骤3中阐述的bug，因为在xml中ImageView设置了ScaleType属性，
        // 所以不要使用上面生成的roundImageDrawable，自己另外new一个
        miv4.setImageDrawable(new RoundImageDrawable(bitmap));

        // 圆形图片
        CircleImageDrawable circleImageDrawable = new CircleImageDrawable(bitmap);
        miv2.setImageDrawable(circleImageDrawable);
        miv3.setImageDrawable(circleImageDrawable);



    }
}
