package com.example.case_study_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = findViewById(R.id.textview_result);
        Button btn_get = findViewById(R.id.button_getInfo);

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name").toString();
            String birthYear = data.getStringExtra("birthYear").toString();

            String str = "";
            // str = "Ten: " + name + "\nNam sinh: " + birthYear;
            str += "Tên: " + name;
            str += "\nNăm sinh: " + birthYear;
            tv_result.setText(str);
        }
    }
}