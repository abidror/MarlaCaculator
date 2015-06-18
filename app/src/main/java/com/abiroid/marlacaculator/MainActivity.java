package com.abiroid.marlacaculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edInput, edResult;
    Button btnConvert, btnClear, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        edInput = (EditText)findViewById(R.id.edInput);
        edResult = (EditText)findViewById(R.id.edResult);

        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnExit = (Button)findViewById(R.id.btnExit);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( edInput.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Provide Square Feets", Toast.LENGTH_LONG).show();
                }
                else
                {
                    int sqFt = Integer.parseInt(edInput.getText().toString());
                    int marlas = sqFt / 272;
                    edResult.setText("" + marlas);
                    edResult.requestFocus();
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edInput.setText("");
                edResult.setText("");
                edInput.requestFocus();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.this.finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
