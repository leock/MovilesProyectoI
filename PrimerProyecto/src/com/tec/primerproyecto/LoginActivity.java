package com.tec.primerproyecto;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
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
		MenuItem item1 = menu.add(0, 0, 0, "Registrar");{
			item1.setIcon(R.drawable.user);
			item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		MenuItem item2 = menu.add(0, 1, 1, "RegistrarFacebook");{
			item2.setIcon(R.drawable.logof);
			item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
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
			Toast.makeText(this, "Has pulsado el item1", Toast.LENGTH_SHORT).show();
			Intent intentRegistro = new Intent(this,RegistroActivity.class);
			startActivity(intentRegistro);
			this.finish();
			return true;
		case 1:
			Toast.makeText(this, "Has pulsado el item2", Toast.LENGTH_SHORT).show();
			return true;
		case android.R.id.home:
			Toast.makeText(this, "Has precionado home", Toast.LENGTH_SHORT).show();;
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			this.finish();
			return true;
		}
		return false;
	}
	
	public void ingresar(View v){
		EditText eTUsuario = (EditText) findViewById(R.id.LETUser);
		EditText eTClave = (EditText) findViewById(R.id.LETClave);
		String usuario = eTUsuario.getText().toString();
		String clave = eTClave.getText().toString();
		if (usuario.equals("") || clave.equals("")){
			TextView tVError = (TextView) findViewById(R.id.LTVError);
			tVError.setText("Error");
		}else{
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}
	}

}
