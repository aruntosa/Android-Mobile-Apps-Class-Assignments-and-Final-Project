package com.example.photographystudioapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ListActivity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] photography = {"Family Photography", "Portrait Photography", "Full Website"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main,R.id.photo, photography));
    }
    	
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	switch(position){
    	case 0:
    		startActivity(new Intent(MainActivity.this, Family.class));
    		break;
    	case 1:
    		startActivity(new Intent(MainActivity.this, Portrait.class));
    		break;
    	case 2:
    		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://picturepeople.com/")));
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
