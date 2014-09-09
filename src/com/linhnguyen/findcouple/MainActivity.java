package com.linhnguyen.findcouple;

<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> b9dbf87a121a319a5593bdb93d4a1d3ac67c6e6c
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
<<<<<<< HEAD
				// String a = abc[0];
				// String b = abc[1];
				// int c = abc.length;
				for (int i = 0; i < firstArray.length - 1; i++) {
					int temp = Integer.parseInt(firstArray[i]);
					for (int j = i + 1; j < secondArray.length - 1; j++) {
						if (temp > Integer.parseInt(secondArray[j])) {

							txvResult.setText(i + "," + j);
=======

				// int size = min(firstArray.length, secondArray.length);

				int size = Math.min(firstArray.length, secondArray.length - 1);
				//int[] secondIntArray = convert(secondArray, size);
				int[] secondIntArray = convert(secondArray, secondArray.length);
				

				for (int i = 0; i < size; i++) {
					final int temp1 = Integer.parseInt(firstArray[i]);
					String a = ("(" + i + ",");
					for (int j = i + 1; j < size; j++) {
						int temp2 = secondIntArray[j];
						if (temp1 > temp2) {
							playerList.add(a + j + ")");
							reSult.add("(" + temp1 + "," + temp2 + ")");

>>>>>>> b9dbf87a121a319a5593bdb93d4a1d3ac67c6e6c
						}
					}
				}

				txvResult.setText(playerList.toString());
				txv.setText(reSult.toString());
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
