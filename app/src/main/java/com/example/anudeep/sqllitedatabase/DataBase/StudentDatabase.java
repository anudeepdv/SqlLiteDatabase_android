package com.example.anudeep.sqllitedatabase.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.anudeep.sqllitedatabase.Model.StudentModel;

import java.util.ArrayList;

/**
 * Created by anudeep on 01/07/17.
 */

public class StudentDatabase extends SQLiteOpenHelper {

   public static  String DATA_BASE = "COLLEGE_DATABASE";

    public static  int DATA_VERSION = 1;

    String TABLE_NAME = "student_table";
    String PHONE_NO = "ph_no";
    String NAME = "name";



    public StudentDatabase(Context context) {
        super(context, DATA_BASE, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //String createtable = " CREATE TABLE " + TABLE_NAME + "(" + PHONE_NO + " TEXT, " + NAME + " TEXT" + ")" ;

       // db.execSQL(createtable);


        String CREATE_MEASSAGES_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + PHONE_NO + " TEXT,"
                + NAME + " TEXT" + ")";
        db.execSQL(CREATE_MEASSAGES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String updatequery = "DROP TABLE IF EXISTS" + TABLE_NAME ;

        db.execSQL(updatequery);
        onCreate(db);

    }

    public void insertrecords(ArrayList<StudentModel> arrayList) {

        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i < arrayList.size(); i++)
        {

            ContentValues cv = new ContentValues();
        cv.put(PHONE_NO, arrayList.get(i).getPhnum());
        cv.put(NAME, arrayList.get(i).getName());

        db.insert(TABLE_NAME, null, cv);
    }
        db.close();
    }

    public ArrayList<StudentModel> readdatabase() {


        String readata =  "SELECT * FROM " + TABLE_NAME ;


        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<StudentModel> arraylist;

        arraylist = new ArrayList<>();
       Cursor c = db.rawQuery(readata , null);

        if (c.moveToFirst())
           do{
               StudentModel stdb = new StudentModel();

               stdb.setPhnun(c.getString(0));
               stdb.setName(c.getString(1));
               arraylist.add(stdb);


           } while (c.moveToNext());


        return arraylist;
    }
}
