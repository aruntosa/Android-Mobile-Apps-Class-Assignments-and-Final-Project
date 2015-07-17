package com.example.personalphotoapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	String[] Names = {"Anand", "Dhiya", "Hana", "Hana Anand", "JK Lee", "Kanakasabai", "Pugazh", "Saathvika"};
	Integer[] Photos = {R.drawable.anand, R.drawable.dhiya, R.drawable.hana, R.drawable.hanaanand, R.drawable.jklee, R.drawable.kanakasabai, R.drawable.pugazh, R.drawable.saathvika};
	ImageView pic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		GridView gr = (GridView)findViewById(R.id.gridView1);
		final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
		gr.setAdapter(new ImageAdapter(this));		
		gr.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), Names[+arg2], Toast.LENGTH_SHORT).show();					
				pic.setImageResource(Photos[arg2]);				
			}			
		});		
	}
	
	public class ImageAdapter extends BaseAdapter {
		private Context context;
		public ImageAdapter(Context c) {
			// TODO Auto-generated constructor stub
			context = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Photos.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			pic = new ImageView(context);
			pic.setImageResource(Photos[arg0]);
			pic.setScaleType(ImageView.ScaleType.FIT_XY);
			pic.setLayoutParams(new GridView.LayoutParams(188,200));
			return pic;
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
