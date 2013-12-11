package com.things01.firstandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;

public class Flipper extends Activity implements OnClickListener{

	ViewFlipper vfp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);
		
		vfp = (ViewFlipper)findViewById(R.id.viewFlipper1);
		vfp.setOnClickListener(this);
		vfp.setFlipInterval(1000);
		vfp.startFlipping();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		vfp.showNext();
	}

}
