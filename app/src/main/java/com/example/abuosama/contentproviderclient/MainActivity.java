package com.example.abuosama.contentproviderclient;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1,button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1= (EditText) findViewById(R.id.editext1);
        editText2= (EditText) findViewById(R.id.editext2);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        textView= (TextView) findViewById(R.id.tetxtview1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clent wnt to read data student deataisl into first First uri Student_Uri
                //prepare resolver
                ContentResolver contentResolver=getContentResolver();
                String name=editText1.getText().toString();
                String sub=editText2.getText().toString();
                //prepare content values
                ContentValues contentValues=new ContentValues();
                contentValues.put(UriProvider.NAME,name);
                contentValues.put(UriProvider.SUB,sub);
                //now insert
                contentResolver.insert(UriProvider.Student_URi,contentValues);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clent want t read data from frist Uri student_uri
                //prepare resoler
                ContentResolver contentResolver=getContentResolver();
                Cursor c=contentResolver.query(UriProvider.Student_URi,null,null,null,null);
                StringBuilder stringBuilder=new StringBuilder();
                if(c!=null){

                    while (c.moveToNext()){

                        int no=c.getInt(0);//this reds _id column vlaues
                        String name=c.getString(1);//this reads student name values
                        String sub=c.getString(2);//this reads student sub values
                        stringBuilder.append("no: "+no+"name: "+name+"sub: "+sub);


                    }
                    textView.setText(stringBuilder.toString());
                }


            }
        });
    }
}
