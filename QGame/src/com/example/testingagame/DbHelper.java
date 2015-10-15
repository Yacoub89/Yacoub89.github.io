package com.example.testingagame;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	
	private static int dbVersion = 1;
	private static final int DATABASE_VERSION = dbVersion;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_MOVIES = "Movies";
    // tasks Table Columns names
    private static final String KEY_ID = "id";    
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    
    //
    private static String SHOWS = "Shows";
    private static String MOVIES = "Movies";
    private static String TECH = "Tech";
    private SQLiteDatabase dbase;
    
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        
      
                
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_MOVIES + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ KEY_CATEGORY
                + " TEXT, " + KEY_QUES + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);
       // System.console().printf("DROP TABLE IF EXISTS " + TABLE_MOVIES);
        db.execSQL(sql);        
        addQuestions();
        addShowsQuestions();
        addTechQuestions();
        //db.close();
    }
    // chnage questions for movies ans shows
    private void addQuestions()
    {
        Question q1=new Question("Movies","Who has played the character os Steve Rogers" +
        "C.A in 'Captain America'?","Chris Evans","Sebastian Stan","Hgo Waving","Chris Evans");
        this.addQuestion(q1);
        Question q2=new Question("Movies","How many Academy awards did Tom Hanks win?","1","2","3","2");
        this.addQuestion(q2);
        Question q3=new Question("Movies","Which of these is the biggest box office hit?",
        		"To Catch a Thief","Catch Me if You Can","Summer Catch","Catch Me if You Can");
        this.addQuestion(q3);
        Question q4=new Question("Movies","What was the name of Jennifer Aniston's baby in 'Friends'?",
        		"Emily","Emma","Amy","Emma"); 
	    this.addQuestion(q4);
        Question q5=new Question("Movies","Which R-rated movie has the largest opening weekend?",
        		"X-Men: The Last Stand","300","The Matrix Reloaded","The Matrix Reloaded");
        this.addQuestion(q5);
        
    }
    
    
    private void addTechQuestions()
    {
    	 Question q1=new Question("Tech","Which company is the largest manufacturer" +
                 " of network equipment?","HP", "IBM", "CISCO", "CISCO");
         this.addQuestion(q1);
         Question q2=new Question("Tech","Which of the following is NOT " +
                 "an operating system?", "SuSe", "BIOS", "DOS", "BIOS");
         this.addQuestion(q2);
         Question q3=new Question("Tech","Which of the following is the fastest" +
                 " writable memory?","RAM", "FLASH","Register","Register");
         this.addQuestion(q3);
         Question q4=new Question("Tech","Which of the following device" +
                 " regulates internet traffic?",    "Router", "Bridge", "Hub","Router");
         this.addQuestion(q4);
         Question q5=new Question("Tech","Which of the following is NOT an" +
                 " interpreted language?","Ruby","Python","BASIC","BASIC");
         this.addQuestion(q5);
    }
    
    private void addShowsQuestions()
    {
        Question q1=new Question("Shows","What was the name of the evil" +
        		" priest of the seventh season Buffy the Vampire Slayer?","Angelus", "Caleb", "Riley", "Caleb");
        this.addQuestion(q1);
        Question q2=new Question("Shows","How many years were " +
        		"Gilligan's Island on the air?","5", "7", "3", "3");
        this.addQuestion(q2);
        Question q3=new Question("Shows","How Did Penny die in " +
        		"Charmed?","Julian", "Gwen", "Ivy", "Ivy");
        this.addQuestion(q3);
        Question q4=new Question("Shows","Who was Lurch of the Adam's Family?","The Butler", "Teacher", "The Doctor", "The Butler");
        this.addQuestion(q4);
        Question q5=new Question("Shows","On Dark Angel What Was The " +
        		"Name of the brother she had to kill?","Ben", "Mike", "Carol", "Ben");
        this.addQuestion(q5);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, quest.getCategory());
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_MOVIES, null, values);        
    }
    public List<Question> getAllMovieQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + MOVIES + "'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setCategory(cursor.getString(1));
                quest.setQUESTION(cursor.getString(2));
                quest.setANSWER(cursor.getString(3));
                quest.setOPTA(cursor.getString(4));
                quest.setOPTB(cursor.getString(5));
                quest.setOPTC(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    
    public List<Question> getAllTechQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        
        Log.i("List<Question> getAllShowsQuestions()", "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + TECH + "'");
        
        // Select All Query
        
        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + TECH + "'";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setCategory(cursor.getString(1));
                quest.setQUESTION(cursor.getString(2));
                quest.setANSWER(cursor.getString(3));
                quest.setOPTA(cursor.getString(4));
                quest.setOPTB(cursor.getString(5));
                quest.setOPTC(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    
    public SQLiteDatabase getDb(){
    	return  dbase;
    }
  
	public List<Question> getAllShowsQuestions() {
		List<Question> quesList = new ArrayList<Question>();
        
		 
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + SHOWS + "'";
       
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setCategory(cursor.getString(1));
                quest.setQUESTION(cursor.getString(2));
                quest.setANSWER(cursor.getString(3));
                quest.setOPTA(cursor.getString(4));
                quest.setOPTB(cursor.getString(5));
                quest.setOPTC(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
	}
	
	public int techRowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + TECH + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        Log.i("row", Integer.toString(row));
        return row;
    }
	
	  public int moviesRowcount()
	    {
	        int row=0;
	        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + MOVIES + "'";
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	        row=cursor.getCount();
	        Log.i("row", Integer.toString(row));
	        return row;
	    }
	  
	  public int showRowcount()
	    {
	        int row=0;
	        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES + " WHERE " +  KEY_CATEGORY + " = '" + SHOWS + "'";
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	        row=cursor.getCount();
	        Log.i("row", Integer.toString(row));
	        return row;
	    }

	

}
