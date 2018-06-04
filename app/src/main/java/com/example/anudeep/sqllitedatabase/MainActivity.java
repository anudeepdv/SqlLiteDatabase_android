package com.example.anudeep.sqllitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anudeep.sqllitedatabase.DataBase.StudentDatabase;
import com.example.anudeep.sqllitedatabase.Model.StudentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_read,btn_insert;
    StudentModel stdmodel;


    ArrayList<StudentModel> arrayList ;

    StudentDatabase student_db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_read = (Button) findViewById(R.id.btn_read);
        btn_insert = (Button) findViewById(R.id.btn_insert);

        btn_read.setOnClickListener(this);
        btn_insert.setOnClickListener(this);
        arrayList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_read :

                readrecords();



                break;

            case R.id.btn_insert :

                insertrecords();



                break;
        }

    }

    private void  readrecords(){

        student_db = new StudentDatabase(getApplicationContext());
        ArrayList<StudentModel> adapter = student_db.readdatabase();

        for (int i = 0 ; i<adapter.size() ; i++) {

            String name = adapter.get(i).getPhnum().toString();
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();

        }

    }

    private  void  insertrecords() {

        arrayList.add(new StudentModel("9740990170","anudeep"));
        arrayList.add(new StudentModel("9888888888","ravi"));
        arrayList.add(new StudentModel("9777777777","anirudh"));

        student_db = new StudentDatabase(getApplicationContext());
        student_db.insertrecords(arrayList);


    }
}
