package com.linhnguyen.findcouple;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText edt1, edt2;
	TextView txvResult, txv;
	Button btnCount;
	public static ArrayList<String> playerList = new ArrayList<String>();
	public static ArrayList<String> reSult = new ArrayList<String>();

	// String playerList[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edt1 = (EditText) findViewById(R.id.edt1);
		edt2 = (EditText) findViewById(R.id.edt2);
		txvResult = (TextView) findViewById(R.id.txvResult);
		txv = (TextView) findViewById(R.id.txv);
		btnCount = (Button) findViewById(R.id.btnCount);

		btnCount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String first = edt1.getText().toString();
				String firstArray[] = first.split(" ");

				String second = edt2.getText().toString();
				String secondArray[] = second.split(" ");

				// String a = abc[0];
				// String b = abc[1];
				// int c = abc.length;
				for (int i = 0; i < firstArray.length - 1; i++) {
					int temp1 = Integer.parseInt(firstArray[i]);
					for (int j = i + 1; j < secondArray.length - 1; j++) {
						if (temp1 > Integer.parseInt(secondArray[j])) {
							int temp2 = Integer.parseInt(secondArray[j]);
							// txvResult.setText("(" + i + "," + j + ")");
							playerList.add("(" + i + "," + j + ")");
							reSult.add("(" + temp1 + "," + temp2 + ")");
						}
					}
				}

				txvResult.setText(playerList.toString());
				txv.setText(reSult.toString());
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
