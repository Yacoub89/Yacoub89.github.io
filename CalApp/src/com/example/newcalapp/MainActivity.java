package com.example.newcalapp;



import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 
public class MainActivity extends Activity {
	public String str ="";
	public String strTemp ="";
	 Character op = 'q';
	 int i;
	 float num;
	 EditText showResult;
	float numtemp;
	 EditText showInput;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	      
	        showResult = (EditText)findViewById(R.id.result);
	        showInput = (EditText)findViewById(R.id.result_id);
	              
	    }
	    
	    
	    public void btnDotClicked(View v){
	    	insertDot(".");
		        
		      }
	    public void btnZeroClicked(View v){
		       insert(0);
		        
		      }
		       
	      public void btn1Clicked(View v){
	       insert(1);
	        
	      }
	       
	 public void btn2Clicked(View v){
	       insert(2);
	        
	      }
	      public void btn3Clicked(View v){
	       insert(3);
	        
	      }
	      public void btn4Clicked(View v){
	       insert(4);
	        
	      }
	      public void btn5Clicked(View v){
	       insert(5);
	        
	      }
	      public void btn6Clicked(View v){
	       insert(6);
	      }
	      public void btn7Clicked(View v){
	       insert(7);
	        
	      }
	      public void btn8Clicked(View v){
	       insert(8);
	        
	      }
	      public void btn9Clicked(View v){
	       insert(9);
	        
	      }
	      public void btnplusClicked(View v){
	       perform("+");
	       op = '+';
	    
	      }
	       
	 public void btnminusClicked(View v){
	    perform("-");
	         op = '-';
	    
	      }
	      public void btndivideClicked(View v){
	       perform("/");
	       op = '/';
	    
	      }
	      public void btnmultiClicked(View v){
	       perform("*");
	       op = '*';
	      
	      }
	      public void btnequalClicked(View v){
	       calculate();
	        
	      }
	       
	 public void btnclearClicked(View v){
	       reset();
	      }
	      private void reset() {
	  // TODO Auto-generated method stub
	   strTemp = "";
	   str ="";
	   op ='q';
	   num = 0;
	   numtemp = 0;
	   showResult.setText("");
	   showInput.setText("");
	 }
	 private void insert(int j) {
	    // TODO Auto-generated method stub
		
	       str = str +  Integer.toString(j);
	       num =  Float.parseFloat(str);
	       strTemp = strTemp + Integer.toString(j);
	       showInput.setText(strTemp);
	   }
	 
	 private void insertDot(String j) {
		    // TODO Auto-generated method stub
		       str = str +  j;
		       strTemp = strTemp + j;
		       showInput.setText(strTemp);
		        
		   }
	      private void perform(String op) {
	    // TODO Auto-generated method stub
	    strTemp = strTemp + op;
	    showInput.setText(strTemp);
	    str = "" ;
	    numtemp = num;
	   }
	      private void calculate() {
	    // TODO Auto-generated method stub
	    if(op == '+')
	     num = numtemp + num;
	    else if(op == '-')
	     num = numtemp-num;
	    else if(op == '/')
	     num = numtemp/num;
	    else if(op == '*')
	     num = numtemp*num;
	    
	    
	    String s = Float.toString(num);
	    String temp = s.substring(s.length() - 1);
	    
	    showResult.setText(" test"+temp);
	    strTemp = temp;
	    int tempInt = Integer.parseInt(temp);
	    
	    if (tempInt > 0)
	    {
	    	showResult.setText(""+num);
		    showInput.setText(""+num);
	    	
	    }
	    else{
	    	 temp = s.substring(0,s.length() - 2);
	    	 strTemp = temp;
	    	
	    	showResult.setText(""+temp);
		    showInput.setText(""+temp);
	    }
	    	
	   }
}

