package com.example.kevin.drawableadvancedusage.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class RoundImageDrawable extends Drawable
{

	private Paint mPaint;
	private Bitmap mBitmap;

	private RectF rectF;

	public RoundImageDrawable(Bitmap bitmap)
	{
		mBitmap = bitmap;
		BitmapShader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP,
				TileMode.CLAMP);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setShader(bitmapShader);
	}

	@Override
	public void setBounds(int left, int top, int right, int bottom)
	{
		super.setBounds(left, top, right, bottom);
		rectF = new RectF(left, top, right, bottom);
	}

	@Override
	public void draw(Canvas canvas)
	{
		/**
		 * public void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
		 * 参数：
		 * rect-The rectangular bounds of the roundRect to be drawn
		 * rx-The x-radius of the oval used to round the corners 圆角的x半径
		 * ry-The y-radius of the oval used to round the corners 圆角的y半径
		 * paint-The paint used to draw the roundRect
		 *
		 * 可以通过修改这里的圆角半径的大小，来修改矩形图片的圆角的大小效果~~~
 		 */
		canvas.drawRoundRect(rectF, 100, 100, mPaint);
	}

	@Override
	public int getIntrinsicWidth()
	{
		return mBitmap.getWidth();
	}

	@Override
	public int getIntrinsicHeight()
	{
		return mBitmap.getHeight();
	}

	@Override
	public void setAlpha(int alpha)
	{
		mPaint.setAlpha(alpha);
	}

	@Override
	public void setColorFilter(ColorFilter cf)
	{
		mPaint.setColorFilter(cf);
	}

	@Override
	public int getOpacity()
	{
		return PixelFormat.TRANSLUCENT;
	}

}
