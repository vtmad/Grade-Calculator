package org.mad.app.hokiehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;




// -------------------------------------------------------------------------
/**
 *  Main (home) screen of the app.
 *
 *  @author Brandon
 *  @version Sep 20, 2012
 */
public class GPAHome extends Activity {

    /** Called when the activity is first created. */
    // some comment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /*
        findViewById(R.id.startGPATermAdd).setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(GPAHome.this, GPATermAdd.class);
    			startActivity(i);
        	}
        });
        */

        findViewById(R.id.startGPATermCalc).setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(GPAHome.this, GPATermCalc.class);
    			startActivity(i);
        	}
        });

        findViewById(R.id.startGPAOverAdd).setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(GPAHome.this, GPAOverAllAdd.class);
    			startActivity(i);
        	}
        });
    } // end onCreate

}// end GPAHome class