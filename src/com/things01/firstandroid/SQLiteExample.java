package com.things01.firstandroid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {
	
	Button sqlUpdate, sqlView;
	EditText sqlName, sqlHotness;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlliteexample);
		sqlUpdate = (Button)findViewById(R.id.bSQLUpdate);
		sqlView = (Button)findViewById(R.id.bSQLopenView);
		sqlName = (EditText)findViewById(R.id.etSQLName);
		sqlHotness = (EditText)findViewById(R.id.etSQLHotness);
		sqlUpdate.setOnClickListener(this);
		sqlView.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSQLUpdate:
			String name = sqlName.getText().toString();
			String hotness = sqlHotness.getText().toString();
			boolean didItWork = true;
			try{
			HotOrNot entry = new HotOrNot(SQLiteExample.this);
			entry.open();
			
			entry.createEntry(name, hotness);
			
			entry.close();
			}catch(Exception e){
				didItWork = false;
				Dialog d = new Dialog(this);
				d.setTitle("worked");
				TextView tv = new TextView(this);
				tv.setText(e.toString());
				d.setContentView(tv);
				d.show();
			}finally{
				if(didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("worked");
					TextView tv = new TextView(this);
					tv.setText("succeed");
					d.setContentView(tv);
					d.show();
				}
			}
			
			break;
		case R.id.bSQLopenView:
			Intent i = new Intent("com.things01.firstandroid.SQLVIEW");
			startActivity(i);
			break;
		}
	}

}
