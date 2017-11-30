package com.fluffy.samrith.exercise_lab_4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btn;
    public EditText edtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
       btn = (Button)findViewById(R.id.btnBack);
       edtData = (EditText)findViewById(R.id.edtData);

       getDataFromActiviyOne();

       btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent data = new Intent();
        data.setData(Uri.parse( edtData.getText().toString()));
        setResult(RESULT_OK, data);
        finish(); }


    public void getDataFromActiviyOne(){
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("dataFromActivityOne","");
        Toast.makeText(this,text , Toast.LENGTH_SHORT).show();

    }
}
