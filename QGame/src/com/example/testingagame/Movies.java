package com.example.testingagame;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Movies extends Activity {
	
	 List<Question> quesList;
	    int score=0;
	    int qid=0;
	    Question currentQ;
	    TextView txtQuestion,temp;
	    RadioButton rda, rdb, rdc;
	    Button butNext;
	    SQLiteDatabase dbase;
	    int movieCount, techCount;
	    int showCount;
	    int categ;
	   

	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_movies);
	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        
	        DbHelper db=new DbHelper(this);
	        
	        db.onUpgrade(db.getReadableDatabase(), 1, 2) ;
	        
	        Bundle b = getIntent().getExtras();
	        categ = b.getInt("categ");
	        
	        if (categ == 1) {
	        	quesList = db.getAllTechQuestions();
	        	techCount = db.techRowcount();
	        	this.setTitle("Technology");
	        }
	        else if (categ == 2){
	        	quesList=db.getAllShowsQuestions();
	        	showCount =  db.showRowcount();
	        	this.setTitle("Shows");
	        }
	        else if (categ == 3)
	        {
	        	quesList=db.getAllMovieQuestions();
	        	movieCount = db.moviesRowcount();
	        	this.setTitle("Movies");
	        	
	        }
	        
	        
	       //quesList=db.getAllMovieQuestions();
	        currentQ=quesList.get(qid);
	        txtQuestion=(TextView)findViewById(R.id.textView1);
	        temp=(TextView)findViewById(R.id.textView2);
	        rda=(RadioButton)findViewById(R.id.radio0);
	        rdb=(RadioButton)findViewById(R.id.radio1);
	        rdc=(RadioButton)findViewById(R.id.radio2);
	        butNext=(Button)findViewById(R.id.button1);
	        setQuestionView();
	               

	    }

	
	 
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.movies, menu);
	        
		    return super.onCreateOptionsMenu(menu);
	    }
	    private void setQuestionView()
	    {
	        txtQuestion.setText(currentQ.getQUESTION());
	        rda.setText(currentQ.getOPTA());
	        rdb.setText(currentQ.getOPTB());
	        rdc.setText(currentQ.getOPTC());
	        qid++;
	    }
	    
	    public void setStars()
	    {
	    	if (categ == 1) {
	    		
	    		if(qid < techCount){                    
	                currentQ = quesList.get(qid);
	                setQuestionView();
	            }
	            else
	            {
	           	 Intent intent = new Intent(Movies.this, ResultActivity.class);
		             Bundle b = new Bundle();
		             b.putInt("score", score); //Your score
		             intent.putExtras(b); //Put your score to your next Intent
		             startActivity(intent);
		             finish();
	            }
	        }
	        else if (categ == 2){
	        	if(qid<showCount){                    
	                currentQ=quesList.get(qid);
	                setQuestionView();
	            }
	            else
	            {
	           	 Intent intent = new Intent(Movies.this, ResultActivity.class);
		             Bundle b = new Bundle();
		             b.putInt("score", score); //Your score
		             intent.putExtras(b); //Put your score to your next Intent
		             startActivity(intent);
		             finish();
	            }
	        }
	    	
	        else if (categ == 3)
	        {
	        	if(qid < movieCount){                    
	                currentQ = quesList.get(qid);
	                setQuestionView();
	            }
	            else
	            {
	           	 Intent intent = new Intent(Movies.this, ResultActivity.class);
		             Bundle b = new Bundle();
		             b.putInt("score", score); //Your score
		             intent.putExtras(b); //Put your score to your next Intent
		             startActivity(intent);
		             finish();
	            }
	        	
	        }
	    	
	    }
	    
	    public void moveIntent()
	    {
	    	
	    	RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
	    	RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
	    	Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
	    	
	    	if(currentQ.getANSWER().equals(answer.getText()))
            {
                score++;
                Log.d("score", "Your score"+score);
                temp.setText("Your score: " + score);
            }
	    	
	    	setStars();   	
	    }
	    public void nextQuest(View v){
	    	
	    	
	    	moveIntent();
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
