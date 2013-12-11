package com.things01.firstandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.view.View;

public class Things01 extends View{
	
	Bitmap gBall;
	float changingY;
	Typeface font;

	public Things01(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gBall = BitmapFactory.decodeResource(getResources(), 
				R.drawable.greenball);
		changingY=0;
		font = Typeface.createFromAsset(context.getAssets(),
				"G-Unit.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 255, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		canvas.drawText("01things.com", canvas.getWidth()/2, 100, textPaint);
		
		canvas.drawBitmap(gBall, canvas.getWidth()/2, changingY, null);
		
		if(changingY > canvas.getHeight()){
			changingY = 0;
		}
		changingY += 10;
		
		Rect middleRect = new Rect();
		middleRect.set(0, 300, canvas.getWidth(), 400);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		
		invalidate();
	}

}








