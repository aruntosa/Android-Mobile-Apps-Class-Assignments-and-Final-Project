package com.example.serenitysoundsapp;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btWaterfall, btWaves;
	MediaPlayer mpWaterfall, mpWaves;
	int playing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btWaterfall = (Button) findViewById(R.id.btnWaterfall);
		btWaves = (Button) findViewById(R.id.btnWaves);
		btWaterfall.setOnClickListener(bWaterfall);
		btWaves.setOnClickListener(bWaves);
		mpWaterfall = new MediaPlayer();
		mpWaterfall = MediaPlayer.create(this,R.raw.waterfall);
		mpWaves = new MediaPlayer();
		mpWaves = MediaPlayer.create(this,R.raw.waves);
		playing = 0;
	}
	Button.OnClickListener bWaterfall = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(playing) {
			case 0:
				mpWaterfall.start();
				playing = 1;
				btWaterfall.setText("Pause Waterfall Music");
				btWaves.setVisibility(View.INVISIBLE);
				break;
			case 1:
				mpWaterfall.pause();
				playing = 0;
				btWaterfall.setText("Play Waterfall Music");
				btWaves.setVisibility(View.VISIBLE);
				break;
			}			
		}		
	};
	Button.OnClickListener bWaves = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(playing) {
			case 0:
				mpWaves.start();
				playing = 1;
				btWaves.setText("Pause Waves Music");
				btWaterfall.setVisibility(View.INVISIBLE);
				break;
			case 1:
				mpWaves.pause();
				playing = 0;
				btWaves.setText("Play Waves Music");
				btWaterfall.setVisibility(View.VISIBLE);
				break;
			}			
		}
	};	
}
