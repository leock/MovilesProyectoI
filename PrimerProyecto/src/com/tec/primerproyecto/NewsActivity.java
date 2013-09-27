package com.tec.primerproyecto;

import java.util.Calendar;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewsActivity extends Activity {

	MainActivity instance = new MainActivity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		Button bInsert = (Button)findViewById(R.id.bInsertNew);
		bInsert.setOnClickListener(insertNew);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.news, menu);
		super.onCreateOptionsMenu(menu);
		creaMenu(menu);
		return true;
	}
	
	private void creaMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem item1 = menu.add(0, 0, 0, "Picture");{
			item1.setIcon(R.drawable.camera3);
			item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
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
			Toast.makeText(this, "Has pulsado Tomar una fotografia", Toast.LENGTH_SHORT).show();
			//Intent intentP = new Intent(this,FollowingActivity.class);
			//startActivity(intentP);
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

	public View.OnClickListener insertNew = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			SQLiteDatabase dBI = instance.nDBHelper.getWritableDatabase();
			EditText etTitle = (EditText)findViewById(R.id.etHeadNews);
			String title = etTitle.getText().toString();
			EditText etDescription = (EditText)findViewById(R.id.etDescriptionNews);
			String description = etDescription.getText().toString();
			
			LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
			Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (location == null){
				Toast.makeText(NewsActivity.this, "nulo", Toast.LENGTH_SHORT).show();
			}else{
				/*Criteria crit = new Criteria();
				crit.setAccuracy(Criteria.ACCURACY_FINE);
				crit.setPowerRequirement(Criteria.POWER_LOW);
				location = lm.getBestProvider(crit, true);*/
				double longitude = location.getLongitude();
				double latitude = location.getLatitude();
				Toast.makeText(NewsActivity.this, "longitud: " + String.valueOf(longitude), Toast.LENGTH_SHORT).show();
				Toast.makeText(NewsActivity.this, "latitude: " + String.valueOf(latitude), Toast.LENGTH_SHORT).show();
			}
			
			if (title.equals("")){
				Toast.makeText(NewsActivity.this, R.string.title_left, Toast.LENGTH_SHORT).show();
			}else{
				try{
					String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
					dBI.execSQL("INSERT INTO tNews (idPost, head,idUser,postDate, postDescription, "
							+ "cordinateX,cordinateY) "
							+ "VALUES (10,'"+ title +"', "+ instance.ID_CURRENT_USER +","
							+ "'"+ mydate +"', '"+ description +"', -1.555, 1.10101)");
					//Toast.makeText(NewsActivity.this, mydate, Toast.LENGTH_SHORT).show();
				}
				catch(SQLiteException ex){
					
				}
			}
		}
	};
	
}
