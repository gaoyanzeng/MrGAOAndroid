package com.things01.firstandroid;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{

	Button chkCmd;
	ToggleButton passTog;
	EditText input;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		iceCream();
		
		passTog.setOnClickListener(this);
		
		chkCmd.setOnClickListener(this);
	}

	private void iceCream() {
		// TODO Auto-generated method stub
		chkCmd = (Button)findViewById(R.id.bResults);
		passTog = (ToggleButton)findViewById(R.id.tbPassword);
		input = (EditText)findViewById(R.id.etCommand);
		display = (TextView)findViewById(R.id.tvResults);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bResults:
			String check = input.getText().toString();
			display.setText(check);
			if(check.contentEquals("left")){
				display.setGravity(Gravity.LEFT);
			}else if(check.contentEquals("right")){
				display.setGravity(Gravity.RIGHT);
			}else if(check.contentEquals("center")){
				display.setGravity(Gravity.CENTER);
			}else if(check.contentEquals("blue")){
				display.setTextColor(Color.BLUE);
			}else if(check.contains("haha")){
				Random crazy = new Random();
				display.setText("HAHA!!!");
				display.setTextSize(crazy.nextInt(100));
				display.setTextColor(Color.rgb(crazy.nextInt(256), crazy.nextInt(256), crazy.nextInt(256)));
				switch(crazy.nextInt(3)){
				case 0:
					display.setGravity(Gravity.LEFT);
					break;
				case 1:
					display.setGravity(Gravity.RIGHT);
					break;
				case 2:
					display.setGravity(Gravity.CENTER);
					break;
				}
			}else{
				display.setText("I don't konw the command");
				display.setTextColor(Color.BLACK);
				display.setGravity(Gravity.CENTER);
				display.setTextSize(20);
			}
			break;
		case R.id.etCommand:
			if(passTog.isChecked()){
				input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}else{
				input.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;
		}
	}
}
