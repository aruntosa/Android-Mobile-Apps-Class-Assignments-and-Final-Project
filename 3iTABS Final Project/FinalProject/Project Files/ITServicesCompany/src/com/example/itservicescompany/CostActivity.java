package com.example.itservicescompany;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class CostActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.costactivity);
		TextView result = (TextView) findViewById(R.id.txtResult);
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		
		//retrieving the data from the xml file
		float finalCost = sharedPref.getFloat("key", 0);
		float totalHours = sharedPref.getFloat("key1", 0);
		
		//formatting the data for currency
		DecimalFormat currency =  new DecimalFormat("$###,###.00");
		
		//formatting the data for time
		DecimalFormat time = new DecimalFormat("#.00");
		
		//displaying the result in the costactivity class
		result.setText("Your cost to acquire the services of our IT professionals for " + time.format(totalHours) + " hours would be " + currency.format(finalCost) + " USD");
	}
}
 