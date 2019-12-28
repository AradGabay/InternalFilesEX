package com.example.internalfilesex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText ET;
    TextView tV;
    String st="",line="",strrd="";








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET = findViewById(R.id.edt);
        tV= findViewById(R.id.tv);
        try {
            FileInputStream fis= openFileInput("String.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            line = br.readLine();
            while (line != null) {
                sb.append(line+'\n');
                line = br.readLine();
            }
            strrd=sb.toString();
            isr.close();
            tV.setText(""+strrd);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save(View view){
        st=st+ET.getText().toString();
        tV.setText(""+strrd+st);
        try {
            FileOutputStream fos = openFileOutput("String.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(st);
            bw.write(strrd);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reset(View view) {
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ET.setText("");
        st="";
        strrd="";
        tV.setText("");
    }

    public void exit(View view) {
        try {
            FileOutputStream fos = openFileOutput("String.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(st);
            bw.write(strrd);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("credits");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent si = new Intent(this,Main2Activity.class);
        startActivity(si);
        return true;
    }
}
