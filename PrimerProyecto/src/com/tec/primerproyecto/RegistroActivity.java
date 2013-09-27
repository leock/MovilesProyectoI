package com.tec.primerproyecto;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		Button bInsert = (Button) findViewById(R.id.BRInsertar);
		bInsert.setOnClickListener(verifyPassword);
	}

	private View.OnClickListener verifyPassword = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText etPasword = (EditText) findViewById(R.id.ETRClave);
			String password = etPasword.getText().toString();
			EditText etCPasword = (EditText) findViewById(R.id.ETRCClave);
			String cPassword = etCPasword.getText().toString();
			if (password.equals(cPassword)){
				Toast.makeText(RegistroActivity.this, R.string.successfulInsertion, Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
				startActivity(intent);
				RegistroActivity.this.finish();
			}else{
				Toast.makeText(RegistroActivity.this, R.string.differentPasswords, Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro, menu);
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
			Toast.makeText(this, "Has precionado home", Toast.LENGTH_SHORT).show();;
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			this.finish();
			return true;
		}
		return false;
	}
	

}
