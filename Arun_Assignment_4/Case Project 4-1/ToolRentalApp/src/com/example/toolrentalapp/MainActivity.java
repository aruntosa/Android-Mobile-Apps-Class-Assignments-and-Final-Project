package com.example.toolrentalapp;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	double powerWasherCost = 55.99;
	double tillerCost = 68.99;
	double daysEntered;
	double finalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText days = (EditText) findViewById(R.id.txtDays);
        final RadioButton radPowerWasher = (RadioButton) findViewById(R.id.radPowerWasher);
        final RadioButton radTiller = (RadioButton) findViewById(R.id.radTiller);
        final TextView Result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnCost);
        
        convert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				daysEntered = Double.parseDouble(days.getText().toString());
				DecimalFormat currency = new DecimalFormat("$###,###.##");
				if(radPowerWasher.isChecked()){
					if (daysEntered <= 7){
						finalCost = daysEntered * powerWasherCost;
						Result.setText(currency.format(finalCost));
					}else {
						Toast.makeText(MainActivity.this, "Days must be less than 7",Toast.LENGTH_LONG).show();
					}
				}else {
					if (daysEntered <= 7){
						finalCost = daysEntered * tillerCost;
						Result.setText(currency.format(finalCost));
					}else {
						Toast.makeText(MainActivity.this, "Days must be less than 7",Toast.LENGTH_LONG).show();
					}
				}
				
			}
		});
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
