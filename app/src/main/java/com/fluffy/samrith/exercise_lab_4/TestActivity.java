package com.fluffy.samrith.exercise_lab_4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView textView;
    public Button button;
    public EditText edt;
    public int request_code =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("on Create");

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        edt = (EditText)findViewById(R.id.editText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.setText("On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText("On Resume");
    }


    @Override
    protected void onPause() {

        super.onPause();
        textView.setText("On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.setText("On Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView.setText("On Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView.setText("On Destroy");
    }


    @Override
    public void onClick(View view) {

        //get the data from editText
        edt.getText();

        Intent i = new Intent(this,AnotherActivity.class);
        i.putExtra("dataFromActivityOne",edt.getText().toString());
        startActivityForResult(i,request_code);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request_code){
          if(resultCode==RESULT_OK){
              Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
          }
        }
    }
}
