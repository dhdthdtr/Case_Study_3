package com.example.case_study_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText et_name = findViewById(R.id.edittext_name);
        EditText et_year = findViewById(R.id.edittext_birthYear);
        Button btn_submit = findViewById(R.id.button_submit);
        TextView alert = findViewById(R.id.textview_alert);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("name",et_name.getText().toString());
                intent.putExtra("birthYear",et_year.getText().toString());
                if(et_name.getText().toString().equals("") && et_year.getText().toString().equals("")){
                    alert.setText("Phải nhập đầy đủ thông tin!!");
                } else {
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}