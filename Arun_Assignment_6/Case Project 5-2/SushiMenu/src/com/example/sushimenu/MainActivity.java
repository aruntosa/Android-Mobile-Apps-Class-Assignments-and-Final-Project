package com.example.sushimenu;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] menu={"Seaweed Salad", "Salmon Sushi", "Mixed Sashimi", "Red Ginger Full Website"};
		setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_main, R.id.app_name, menu));		
	}
	protected void onListItemClick(ListView l, View v, int position, long id){
		switch(position){
		case 0:
		startActivity(new Intent(MainActivity.this, Seaweed.class));
			break;
		case 1:
			startActivity(new Intent(MainActivity.this, Salmon.class));
			break;
		case 2:
			startActivity(new Intent(MainActivity.this, Sashimi.class));
			break;		
		case 3:startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.eatatginger.com")));
		break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
