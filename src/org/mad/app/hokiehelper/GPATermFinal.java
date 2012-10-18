package org.mad.app.hokiehelper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 *  Displays the calculated GPA and navigates the user back to home screen.
 *
 *  @author Brandon
 *  @version Sep 20, 2012
 */


public class GPATermFinal extends Activity {


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpatermfinal);

		Intent i = getIntent();
		Bundle extras = i.getExtras();
		double gpa = (Double) extras.get("GPA");

		TextView txtGPA = (TextView) findViewById(R.id.finalGPA);
		txtGPA.setText(""+gpa);


		findViewById(R.id.finalMainMenuBtn).setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(GPATermFinal.this, GPAHome.class);
                startActivity(i);
            }
        });

	}// end onCreate method



}// end GPATermFinal
