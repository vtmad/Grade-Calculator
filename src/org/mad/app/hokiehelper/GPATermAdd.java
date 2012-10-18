package org.mad.app.hokiehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


// -------------------------------------------------------------------------
/**
 *  CLASS NO LONGER USED --> DELETE
 *
 *  @author Brandon
 *  @version Sep 20, 2012
 */

public class GPATermAdd extends Activity {


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpatermadd);

        Intent i = getIntent();

        findViewById(R.id.startGPATermCalc).setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(GPATermAdd.this, GPATermCalc.class);
        		/*
        		EditText text = (EditText)findViewById(R.id.startGPATermCalc);
        		int courses = text.getText().charAt(0);
        		i.putExtra("firstMessage", courses);
        		*/
    			startActivity(i);
        	}
        });

    }// end onCreate

}// end GPATermAdd class
