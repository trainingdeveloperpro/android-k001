package com.example.lesson7giang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class AddNewStudent extends AppCompatActivity {
    public static String EXTRA_USER_NAME = "NAME";
    public static String EXTRA_USER_AGE = "AGE";
    public static String EXTRA_USER_PHONE = "PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        getSupportActionBar().hide();
    }

    public void addStudent(View view){
        Intent intentResult = new Intent();

        EditText name = findViewById(R.id.edtName);
        EditText age = findViewById(R.id.edtAge);
        EditText phone = findViewById(R.id.edtPhone);


        if (TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(age.getText()) || TextUtils.isEmpty(phone.getText())){
            setResult(RESULT_CANCELED, intentResult);
        }
        else {
            intentResult.putExtra(EXTRA_USER_NAME, name.getText().toString());
            intentResult.putExtra(EXTRA_USER_AGE, age.getText().toString());
            intentResult.putExtra(EXTRA_USER_PHONE, phone.getText().toString());
            setResult(RESULT_OK, intentResult);
        }

        finish();
    }
}
