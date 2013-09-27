package com.tec.primerproyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NewsDataBase extends SQLiteOpenHelper{
	
	String sQLCreator = "CREATE TABLE tNews "
			+ "("
				+ "idPost			INTEGER,"
				+ "head				TEXT,"
				+ "idUser			INTEGER,"
				+ "postDate			TEXT,"
				+ "postDescription	TEXT,"
				+ "cordinateX		DOUBLE PRECISION,"
				+ "cordinateY		DOUBLE PRECISION"
			+ ");";

	public NewsDataBase(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sQLCreator);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXITS tNews");
		db.execSQL(sQLCreator);
	}

}
