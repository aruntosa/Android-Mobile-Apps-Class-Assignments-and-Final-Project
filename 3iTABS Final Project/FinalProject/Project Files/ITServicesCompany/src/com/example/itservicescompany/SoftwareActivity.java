package com.example.itservicescompany;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SoftwareActivity extends Activity 
{
	//Variable initializations
	float numHours;
	float onsiteRate = 80;
	float remoteRate = 60;
	float finalRate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.softwareactivity);
		
		//initialize and reference widgets
		final EditText hours = (EditText) findViewById(R.id.txtHours);
		final RadioButton onsite = (RadioButton) findViewById(R.id.radOnsite);
		final RadioButton remote = (RadioButton) findViewById(R.id.radRemote);
		Button btCalculate = (Button) findViewById(R.id.btnCalculate);
		
		//shared preference object is instantiated
		final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		btCalculate.setOnClickListener(new OnClickListener() 
		{			
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				numHours = Float.parseFloat(hours.getText().toString());
		
				//checking radio button for toast message
				if (onsite.isChecked() || remote.isChecked()) 
				{
					if (onsite.isChecked()) 
					{
						finalRate = onsiteRate * numHours;
					}
					else	
					{
						finalRate = remoteRate * numHours;
					}
				
						//editor providing a method to add preference content
						SharedPreferences.Editor editor = sharedPref.edit();
						editor.putFloat("key", finalRate);
						editor.putFloat("key1", numHours);
					
						//saving the values to xml file
						editor.commit();
						startActivity(new Intent(SoftwareActivity.this, CostActivity.class));					
				}
				else
					{
					//display toast message if the radio button is not selected	
					Toast.makeText(SoftwareActivity.this, "Please select from, Onsite or Remote options ", Toast.LENGTH_LONG).show();
					}	
			}
		});
					}
}
