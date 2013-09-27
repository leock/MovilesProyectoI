package com.tec.primerproyecto;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final String INDEX = "INDEX";
	
	public static final ArrayList<PostObject> newsList = new ArrayList<PostObject>();
	
	public static NewsDataBase nDBHelper;
	
	static final int ID_CURRENT_USER = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		
		llenarLista();
		
		llenarListView();
	}
	
	private void llenarListView(){
		ListView lv = (ListView)findViewById(R.id.listaNoticias);
		
		lv.setAdapter(new ArrayAdapter<PostObject>(this,android.R.layout.simple_list_item_1, newsList));
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
				Intent intentD = new Intent(MainActivity.this, DetalleActivity.class);
				
				String st = String.valueOf(posicion);
				
				intentD.putExtra(INDEX, st);
				startActivity(intentD);
				/*Toast toast = Toast.makeText(MainActivity.this, "Has precionado" + newsList.get(posicion).head, Toast.LENGTH_LONG);
				toast.show();*/
				//Toast toast = Toast.makeText(this, "Has precionado home", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void llenarLista(){
		newsList.clear();
		nDBHelper = new NewsDataBase(this, "NEWS_DB", null, 1);
		SQLiteDatabase dB = nDBHelper.getReadableDatabase();
		//SQLiteDatabase dBI = nDBHelper.getWritableDatabase();
		/*try{
		dBI.execSQL("INSERT INTO tNews (idPost,head,idUser,postDate,postDescription,cordinateX,cordinateY) "
				+ "VALUES (10,'Se inundó el tec', 2,'', 'llovió mucho y el tec se lleno de agua de mierda y mas mierda', -1.555, 1.10101)");}catch(SQLiteException ex){}
		*/
		Cursor c = dB.rawQuery("SELECT * FROM tNews", null);
		PostObject row;
		if (c.moveToFirst()){
			do{
				row = new PostObject(c.getInt(0), c.getString(1), c.getInt(2), c.getString(3),
						c.getString(4), c.getDouble(5), c.getDouble(6));
				newsList.add(row);
			}while (c.moveToNext());
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		creaMenu(menu);
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void creaMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem item1 = menu.add(0, 0, 0, "Following");{
			item1.setIcon(R.drawable.follow);
			item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem item2 = menu.add(0, 1, 1, "Statistics");{
			item2.setIcon(R.drawable.statistics_);
			item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem item3 = menu.add(0, 2, 2, "New");{
			item3.setIcon(R.drawable.news);
			item3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem item4 = menu.add(0, 3, 3, "Sing Out");{
			item4.setIcon(R.drawable.login_lock);
			item4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return menuSelecciona(item);
		//return super.onOptionsItemSelected(item);
	}

	private boolean menuSelecciona(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 0:
			//Toast.makeText(this, "Has pulsado Following", Toast.LENGTH_SHORT).show();
			Intent intentF = new Intent(this,FollowingActivity.class);
			startActivity(intentF);
			this.finish();
			return true;
		case 1:
			//Toast.makeText(this, "Has pulsado Statistics", Toast.LENGTH_SHORT).show();
			Intent intentS = new Intent(this,StatisticsActivity.class);
			startActivity(intentS);
			this.finish();
			return true;
		case 2:
			//Toast.makeText(this, "Has pulsado Sing Out", Toast.LENGTH_SHORT).show();
			Intent intentN = new Intent(this,NewsActivity.class);
			startActivity(intentN);
			this.finish();
			return true;
		case 3:
			//Toast.makeText(this, "Has pulsado Sing Out", Toast.LENGTH_SHORT).show();
			Intent intentSO = new Intent(this,LoginActivity.class);
			startActivity(intentSO);
			this.finish();
			return true;
		case android.R.id.home:
			//Toast.makeText(this, "Has precionado home", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			this.finish();
			return true;
		}
		return false;
	}

}
