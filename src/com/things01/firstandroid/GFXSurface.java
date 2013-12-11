package com.things01.firstandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GFXSurface extends Activity implements View.OnTouchListener{
	
	Things01Surface ourSurfaceView;
	float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaledX, scaledY;
	Bitmap test, flower;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ourSurfaceView = new Things01Surface(this);
		ourSurfaceView.setOnTouchListener(this);
		
		setContentView(ourSurfaceView);
		
		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		dX = dY = aniX = aniY = scaledX = scaledY = 0;
		test = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		flower = BitmapFactory.decodeResource(getResources(), R.drawable.flower3);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		Thread myThread = new Thread();
		try {
			myThread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			dX = dY = aniX = aniY = scaledX = scaledY = fX = fY = 0;
			sX = event.getX();
			sY = event.getY();
			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			dX = fX - sX;
			dY = fY - sY;
			scaledX = dX/30;
			scaledY = dY/30;
			x = y = 0;
			break;
		}
		
		return true;
	}
	public class Things01Surface extends SurfaceView implements Runnable{

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;
		
		public Things01Surface(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			ourHolder = getHolder();
		}
		
		public void pause(){
			isRunning = false;
			while(true){
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread=null;
		}
		
		public void resume(){
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(isRunning){
				if(!ourHolder.getSurface().isValid())
					continue;

				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawRGB(2, 2, 150);
				
				if(x!=0 && y!=0){
					canvas.drawBitmap(test, x-test.getWidth()/2, 
							y-test.getHeight()/2, null);
				}
				if(sX!=0 && sY!=0){
					canvas.drawBitmap(flower, sX-flower.getWidth()/2, 
							sY-flower.getHeight()/2, null);
				}
				if(fX!=0 && fY!=0){
					canvas.drawBitmap(flower, fX-flower.getWidth()/2, 
							fY-flower.getHeight()/2, null);
					canvas.drawBitmap(test, 
							fX - test.getWidth()/2 - aniX,
							fY - test.getHeight()/2 - aniY,
							null);
					try {
						ourThread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				aniX = aniX + scaledX;
				aniY = aniY + scaledY;
				
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
	}
}
