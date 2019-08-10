package com.example.lesson6giang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    public static String EXTRA_USER_NAME = "NAME";
    public static String EXTRA_USER_AGE = "AGE";
    public static String EXTRA_USER_PHONE = "PHONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().hide();
    }

    public void add(View view){
        Intent resultIntent = new Intent();
        EditText name = findViewById(R.id.edtNameStudent);
        EditText age = findViewById(R.id.edtAge);
        EditText phone = findViewById(R.id.edtPhone);

        resultIntent.putExtra(EXTRA_USER_NAME, name.getText().toString());
        resultIntent.putExtra(EXTRA_USER_AGE, age.getText().toString());
        resultIntent.putExtra(EXTRA_USER_PHONE, phone.getText().toString());

        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
