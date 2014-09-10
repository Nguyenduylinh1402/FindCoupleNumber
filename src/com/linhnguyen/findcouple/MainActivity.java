package com.linhnguyen.findcouple;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText edt1, edt2;
	TextView txvResult, txv;
	Button btnCount, btnClear;
	public static ArrayList<String> playerList = new ArrayList<String>();
	public static ArrayList<String> reSult = new ArrayList<String>();

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
				playerList.clear();
				reSult.clear();

				String first = edt1.getText().toString();
				String firstArray[] = first.split(" ");

				String second = edt2.getText().toString();
				String secondArray[] = second.split(" ");

				// int size = min(firstArray.length, secondArray.length);
				int firstlength = firstArray.length;
				int secondlength = secondArray.length;
				int size = Math.min(firstlength, secondlength - 1);
				// int[] secondIntArray = convert(secondArray, size);
				int[] secondIntArray = convert(secondArray, secondlength);

				for (int i = 0; i < size; i++) {
					final int temp1 = Integer.parseInt(firstArray[i]);
					// String a = ("(" + i + ",");
					for (int j = i + 1; j < secondlength; j++) {
						int temp2 = secondIntArray[j];

						if (temp1 > temp2) {
							String str = new StringBuilder("(")
									.append(i).append(",").append(j)
									.append(")").toString();
							
							//String abc = str.toString();
							
							playerList.add(str);
							// reSult.add("(" + temp1 + "," + temp2 + ")");

						}
					}
				}

				txvResult.setText(playerList.toString());
				// txv.setText(reSult.toString());
			}
		});
		btnClear = (Button) findViewById(R.id.btnClear);
		btnClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				edt1.setText(null);
				edt2.setText(null);
				playerList.clear();
				reSult.clear();
				txvResult.setText("");
				txv.setText("");
			}
		});
	}

	private void test() {
		final int count = 10000;

		String result1 = "start";
		for (int idx = 0; idx < count; idx++) {
			result1 = new StringBuilder(result1).append("blah").toString();
		}

		
		
		
		String linh = "L" + "i" + "n" + "h";
		String linh1 = new StringBuilder("L").append("i").append("n")
				.append("h").toString();
		
		
		
		String binh = "B";
		binh = binh + "i";
		binh = binh + "n";
		binh = binh + "h";
		
		String binh1 = "B";
		binh1 = new StringBuilder(binh1).append("i").toString();
		binh1 = new StringBuilder(binh1).append("n").toString();
		binh1 = new StringBuilder(binh1).append("h").toString();
		
		
		
		

		StringBuilder result2 = new StringBuilder("start");
		for (int idx = 0; idx < count; idx++) {
			result2.append("blah");
		}
	}

	private int[] convert(String[] tring, int length) { // Note the [] after the
														// String.
		int number[] = new int[length];

		for (int i = 0; i < length; i++) {
			number[i] = Integer.parseInt(tring[i]);
		}
		return number;
	}

	public int min(int a, int b) {
		if (a < (b - 1)) {
			return a;
		} else
			return (b - 1);
	}

}
