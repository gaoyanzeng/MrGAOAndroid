package com.things01.firstandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HotOrNot {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "persons_name";
	public static final String KEY_HOTNESS = "persons_hotness";

	private static final String DATABASE_NAME = "HotOrNotdb";
	private static final String DATABASE_TABLE = "peopleTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE "
						+ DATABASE_NAME + " ("
						+ KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT"
						+ KEY_NAME + " TEXT NOT NULL"
						+ KEY_HOTNESS + " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP_TABLE IF EXITS " + DATABASE_TABLE);
			onCreate(db);
		}
				
	}
	
	public HotOrNot(Context c){
		ourContext = c;
	}
	
	public HotOrNot open(){
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		
		return this;
	}
	
	public void close(){
		ourHelper.close();
	}

	public void createEntry(String name, String hotness) {
		// TODO Auto-generated method stub
		
	}
}