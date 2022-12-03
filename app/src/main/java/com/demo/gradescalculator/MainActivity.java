package com.demo.gradescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNumber3, etNumber, etNumber2, etSub ;
    String strNumber3, strNumber, strNumber2, strSub,  resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Calculating....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        etNumber3 = (EditText) findViewById(R.id.etNumber3);
        etNumber = (EditText) findViewById(R.id.etNumber);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);
        etSub = (EditText) findViewById(R.id.etSub);

        if(etSub.getText().toString().isEmpty() ||etNumber3.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() || etNumber2.getText().toString().isEmpty()){
            strNumber3 = "0";
            strNumber = "0";
            strNumber2 = "0";
            strSub = "0";
        }else{
            strNumber3 = etNumber3.getText().toString();
            strNumber = etNumber.getText().toString();
            strNumber2 = etNumber2.getText().toString();
            strSub = etSub.getText().toString();
        }
        double rawNumber3 = Double.parseDouble(strNumber3);
        double rawNumber = Double.parseDouble(strNumber);
        double rawNumber2 = Double.parseDouble(strNumber2);
        int rawSub = Integer.parseInt(strSub);
        int etSub = Integer.parseInt(strSub);

        switch(rawSub){
            case 1:
                rawSub = 2;
                break;
            case 2:
                rawSub = 3;
                break;
        }

        double result = (rawNumber + rawNumber2 + rawNumber3) / rawSub;
        // Casted result to int type, remove to show decimal value
        resultMessage = "Your average grade is" + result;

        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        Intent intent;

        if(result == 100){
            intent = new Intent(MainActivity.this, A.class);
            intent.putExtras(args);
            startActivity(intent);
        }
        if(result == 94.9){
            intent = new Intent(MainActivity.this, B.class);
            intent.putExtras(args);
            startActivity(intent);
        }
        if(result == 89.9){
            intent = new Intent(MainActivity.this, B.class);
            intent.putExtras(args);
            startActivity(intent);
        }
        if(result == 84.9){
            intent = new Intent(MainActivity.this, B.class);
            intent.putExtras(args);
            startActivity(intent);
        }
        if(result == 79.9){
            intent = new Intent(MainActivity.this, B.class);
            intent.putExtras(args);
            startActivity(intent);
        }
        if(result == 74){
            intent = new Intent(MainActivity.this, B.class);
            intent.putExtras(args);
            startActivity(intent);
        }



        clearEditText();

    }

    public void clearEditText(){
        etNumber.getText().clear();
        etNumber3.getText().clear();
        etNumber2.getText().clear();
        etSub.getText().clear();
        etSub.requestFocus();
    }
}

