package com.demo.gradescalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText  grade1, grade2, grade3;
    String  strgrade1, strgrade2, strgrade3, resultMessage;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    public void onClick(View v){
        Toast.makeText(this, "Multiplying numbers...", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        grade1 = (EditText) findViewById(R.id.etNumber);
        grade2 = (EditText) findViewById(R.id.etNumber2);
        grade3 = (EditText) findViewById(R.id.etNumber3);
        if(grade1.getText().toString().isEmpty() || grade2.getText().toString().isEmpty()|| grade3.getText().toString().isEmpty()){
            strgrade1 = "0";
            strgrade2 = "0";
            strgrade3 = "0";
        }
        else{
            strgrade1 = grade1.getText().toString();
            strgrade2 = grade2.getText().toString();
            strgrade3 = grade3.getText().toString();
        }
        double rawgrade1 = Double.parseDouble(strgrade1);
        double rawgrade2 = Double.parseDouble(strgrade2);
        double rawgrade3 = Double.parseDouble(strgrade3);

        double result = rawgrade1/3 + rawgrade2/3 + rawgrade3/3;

        switch((int) result){
            case 99:
                result = 99;
                break;
            case 94:
                result = 94;
                break;
            case 89:
                result = 89;
                break;
            case 84:
                result = 84;
                break;
            case 79:
                result = 79;
                break;
            case 74:
                result = 74;
                break;
        }



        resultMessage = (int) result + " is your final grade";

        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        Intent intent;


        if(result <= 74) {
            intent = new Intent(MainActivity.this, F.class);
        }
        else if (result <= 79) {
            intent = new Intent(MainActivity.this, E.class);
        }
        else if (result <= 84) {
            intent = new Intent(MainActivity.this, D.class);
        }
        else if (result <= 89) {
            intent = new Intent(MainActivity.this, C.class);
        }
        else if (result <= 94) {
            intent = new Intent(MainActivity.this, B.class);
        }
        else {
            intent = new Intent(MainActivity.this, A.class);
        }


        intent.putExtras(args);
        startActivity(intent);
        clearEditText();
    }

    public void clearEditText(){
        grade1.getText().clear();
        grade2.getText().clear();
        grade3.getText().clear();
        grade1.requestFocus();
    }

}
