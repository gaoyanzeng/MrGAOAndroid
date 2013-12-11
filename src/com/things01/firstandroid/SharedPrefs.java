package com.things01.firstandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener{

	EditText sharedData;
	TextView dataResults;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
		
		someData = getSharedPreferences(filename, 0);
	}

	private void setupVariables() {
		// TODO Auto-generated method stub
		Button save = (Button)findViewById(R.id.bSave);
		Button load = (Button)findViewById(R.id.bLoad);
		sharedData = (EditText)findViewById(R.id.etSharedPrefs);
		dataResults = (TextView)findViewById(R.id.tvLoadSharePrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSave:
			String stringData = sharedData.getText().toString();
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("sharedString", stringData);
			editor.commit();
			break;
		case R.id.bLoad:
			someData = getSharedPreferences(filename, 0);
			String strReturned = someData.getString("sharedString", "Couldn't load data!");
			dataResults.setText(strReturned);
			break;
		}
	}
}









