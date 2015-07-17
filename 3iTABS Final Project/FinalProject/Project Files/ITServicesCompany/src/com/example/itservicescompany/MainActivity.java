package com.example.itservicescompany;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] services = {"Software", "Hardware", "Full Website", "Contact Us"};
		setListAdapter (new ArrayAdapter<String>(this, android.R.layout. simple_list_item_1, services));
	}
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch(position) {
		case 0:
			startActivity(new Intent(MainActivity.this, SoftwareActivity.class));
			break;
		case 1:
			startActivity(new Intent(MainActivity.this, HardwareActivity.class));
			break;
		case 2:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.3itabs.com/")));
			break;
		case 3:
			startActivity(new Intent(MainActivity.this, ContactActivity.class));
			break;
		}
	}
}
