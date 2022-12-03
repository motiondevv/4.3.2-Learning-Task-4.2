package com.demo.gradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);

        Bundle extras = getIntent().getExtras();
        String result = extras.getString("result");
        setContentView(R.layout.a);

        Button btnReturn = findViewById(R.id.btn_return);
        TextView tvResult = findViewById(R.id.txt_result);
        tvResult.setText(result);
        btnReturn.setOnClickListener(this);
}

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(A.this, MainActivity.class);
        startActivity(intent);
    }
}