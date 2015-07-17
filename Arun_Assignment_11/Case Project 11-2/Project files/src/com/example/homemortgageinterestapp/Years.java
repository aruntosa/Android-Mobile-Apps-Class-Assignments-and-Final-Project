package com.example.homemortgageinterestapp;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.BaseBundle;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Years extends Activity {
	double dblTotalInterest;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.years);
		TextView result = (TextView)findViewById(R.id.txtResult);
		ImageView image = (ImageView)findViewById(R.id.imgYears);
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		float intmp = sharedPref.getFloat("key1", 0);
		int intnoy = sharedPref.getInt("key2", 0);
		int intpla = sharedPref.getInt("key3",  0);
		dblTotalInterest = ((intmp * (intnoy * 12)) - intpla);
		DecimalFormat currency = new DecimalFormat("$###,###.##");
				
		if (intnoy == 10) {
			image.setImageResource(R.drawable.ten);
			result.setText("Total Interest Paid " + currency.format(dblTotalInterest));
		}
		else if (intnoy == 20) {
			image.setImageResource(R.drawable.twenty);
			result.setText("Total Interest Paid " + currency.format(dblTotalInterest));
		}
		else if (intnoy == 30) {
			image.setImageResource(R.drawable.thirty);
			result.setText("Total Interest Paid " + currency.format(dblTotalInterest));
		}
	}
}
