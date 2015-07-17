package com.example.carferryfareapp;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	double costPerTicket = 18.00;
	int numberOfTickets;
	double totalCost;
	String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets = (EditText)findViewById(R.id.txtTickets);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new OnClickListener() {
        	final TextView result = ((TextView)findViewById(R.id.txtResult));
        	
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				numberOfTickets = Integer.parseInt(tickets.getText().toString());
				totalCost = costPerTicket * numberOfTickets;
				DecimalFormat currency  = new DecimalFormat("$###,###.##");
				groupChoice = group.getSelectedItem().toString();
				result.setText("Total cost for a one way trip " + groupChoice + " is " + currency.format(totalCost));
				
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
