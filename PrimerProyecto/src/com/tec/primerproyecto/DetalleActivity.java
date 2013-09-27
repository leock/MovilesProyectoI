package com.tec.primerproyecto;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		MainActivity instance = new MainActivity();
		
		Intent intent = getIntent();
		String sIndex = intent.getStringExtra(MainActivity.INDEX);
		int index = Integer.parseInt(sIndex);
		
		TextView tvTD =(TextView) findViewById(R.id.tituloDetalles);
		tvTD.setText(instance.newsList.get(index).head);
		
		
		
		TextView tvId = (TextView) findViewById(R.id.idDetalles);
		tvId.setText(String.valueOf(instance.newsList.get(index).idPost));
		
		TextView tvDetalles = (TextView) findViewById(R.id.detallesDetalles);
		tvDetalles.setText(instance.newsList.get(index).postDescription);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return menuSelecciona(item);
	}
	
	
	private boolean menuSelecciona(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "Has precionado home", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			this.finish();
			return true;
		}
		return false;
	}

}
