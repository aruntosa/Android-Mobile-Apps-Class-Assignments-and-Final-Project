package com.example.bodymassindex;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	double conversionValue = 703.0;
	double weightEntered;
	double heightEntered;
	double calculatedBmi;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final EditText height = (EditText) findViewById(R.id.txtHeight);
        
        Button convert = (Button) findViewById(R.id.btnCompute);
        convert.setOnClickListener(new OnClickListener() {
        	final TextView Result = ((TextView)findViewById(R.id.txtResult));
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				weightEntered = Double.parseDouble(weight.getText().toString());
				heightEntered = Double.parseDouble(height.getText().toString());
				DecimalFormat tenth = new DecimalFormat("#.#");
				
				calculatedBmi = (weightEntered * conversionValue) / (heightEntered * heightEntered);
				Result.setText(tenth.format(calculatedBmi));
				
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
