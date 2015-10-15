package com.example.testingagame;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.testingagame.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fullscreen);
		
		
	}
		
	public  void menuLayout(View view){
			Intent secondIntent = new Intent(this, MenuList.class);
		 startActivityForResult(secondIntent,0	);	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.movies, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
		 switch (item.getItemId()) {
	        case R.id.action_search:
	        	Intent secondIntent = new Intent(this, MenuList.class);
				 startActivityForResult(secondIntent,0);
	            return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
