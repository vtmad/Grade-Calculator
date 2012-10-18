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

//-------------------------------------------------------------------------
/**
*  Users select grades from a drop-down spinner.
*
*  @author Brandon
*  @version Sep 20, 2012
*/

public class GPATermCalc extends Activity implements OnClickListener{


	String[] gradeArray= {"F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A"};
	int[] creditHours = {1,2,3,4,5,6};
	Button btnRow;
	Button btnCalc;
	int counter = 1;
	//TableLayout table = (TableLayout)findViewById(R.id.TableLayout01);

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpatermcalc);

        //gradeArray = new String[]{"F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A"};
        //creditHours = new int[]{1,2,3,4,5,6};

        Intent i = getIntent();

        btnRow = (Button) findViewById(R.id.btnAddRow);
        btnRow.setOnClickListener(this);

        findViewById(R.id.startGPATermFinal).setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(GPATermCalc.this, GPATermFinal.class);

        		// Get information from TableLayout R.id.TableLayout01
        		TableLayout tbl = (TableLayout) findViewById(R.id.TableLayout01);
        		int[][] arr = new int[tbl.getChildCount()][2];
        		TableRow tblRow;
        		Spinner spnr;
        		for(int n = 0; n < tbl.getChildCount(); n++){ // Iterates through TableRows
        			tblRow = (TableRow) tbl.getChildAt(n);
        			for(int x = 1; x < tblRow.getChildCount(); x++){ // Iterates through Course Number, Grades Spinner, and GPA Spinner
        				spnr = (Spinner) tblRow.getChildAt(x);
        				arr[n][x-1] = spnr.getSelectedItemPosition();
        			}// end for x
        		}// end for n

        		// Calculate GPA
        		double totalQualityCredits = 0;
        		double totalCreditHours = 0;
        		for(int n = 0; n < arr.length; n++){
        			totalQualityCredits += getGradeValue(arr[n][0]) * (arr[n][1] + 1); // hours * credits
        			totalCreditHours += arr[n][1]+1;
        		}// end for n
        		double gpa = totalQualityCredits/totalCreditHours;
        		double gpa1 = gpa*100.0;
        		int gpa2 = (int) gpa1;
        		double gpa3 = (double)gpa2/100; // rounded to two decimal places


        		i.putExtra("GPA", gpa3);
    			startActivity(i);
        	}
        });

    }// end onCreate method

	private static String getGradeLetter(int position){
		switch(position){
			case 0: return "A";
			case 1: return "A-";
			case 2: return "B+";
			case 3: return "B";
			case 4: return "B-";
			case 5: return "C+";
			case 6: return "C";
			case 7: return "C-";
			case 8: return "D+";
			case 9: return "D";
			case 10: return "D-";
			case 11: return "F";
			default: return "ERROR";
		}
	}// end method getGradeeLtter

	private static double getGradeValue(int position){
		switch(position){
			case 0: return 4.0; // A
			case 1: return 3.7; // A-
			case 2: return 3.3; // B+
			case 3: return 3.0; // B
			case 4: return 2.7; // B-
			case 5: return 2.3; // C+
			case 6: return 2.0; // C
			case 7: return 1.7; // C-
			case 8: return 1.3; // D+
			case 9: return 1.0; // D
			case 10: return 0.7; //D-
			case 11: return 0.0; //F
			default: return 10000.0;//"ERROR";
		}
	}// end method getGradeeLtter

	//@Override
	// run when the "add row" (rowBtn) button is clicked
	public void onClick(View arg0) {
		// count the counter up by one
		counter++;

		// get a reference for the TableLayout
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        //table.setId(counter);

        // create a new TableRow
        TableRow row = new TableRow(this);

        // create a new TextView
        TextView number = new TextView(this);
        // set the text to "text xx"
        number.setText("" + counter);

        Spinner grade = new Spinner(this); //(Spinner) findViewById(R.id.TableRow2_2);
        String[] grades = {"A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, grades);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		grade.setAdapter(adapter1);

		Spinner credit = new Spinner(this);//(Spinner) findViewById(R.id.TableRow2_3);
        String[] credits = {"1","2","3","4","5","6"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, credits);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		credit.setAdapter(adapter2);

        // add the indexing number and spinners to the new tablerow
        row.addView(number);
        row.addView(grade);
        row.addView(credit);

        // add the TableRow to the TableLayout
        table.addView(row,new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

	}// end onClick method

}// end GPATermCalc class
