package com.example.testingagame;



import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;


public class MenuList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_list);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	
	public  void tech(View view){
		//Intent secondIntent = new Intent(this, Movies.class);
	// startActivityForResult(secondIntent,0	);	
	 Intent intent = new Intent(MenuList.this, Movies.class);
     Bundle b = new Bundle();
     b.putInt("categ",1);
     intent.putExtras(b); //Put your score to your next Intent
     startActivity(intent);
}

	
	public  void shows(View view){
//		Intent secondIntent = new Intent(this, Movies.class);
//	 startActivityForResult(secondIntent,0	);	
		 Intent intent = new Intent(MenuList.this, Movies.class);
	     Bundle b = new Bundle();
	     b.putInt("categ",2);
	     intent.putExtras(b); //Put your score to your next Intent
	     startActivity(intent);
}
	
	public  void movies(View view){
		//Intent secondIntent = new Intent(this, Movies.class);
	// startActivityForResult(secondIntent,0	);	
	 Intent intent = new Intent(MenuList.this, Movies.class);
     Bundle b = new Bundle();
     b.putInt("categ",3);
     intent.putExtras(b); //Put your score to your next Intent
     startActivity(intent);
}
	
	
	
	
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
	        case android.R.id.home:
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
