package com.example.calculator_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNumber;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String CurrentNum;
    int OPERATION_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = findViewById(R.id.txtNumber);
        txtNumber.setText("0");
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void Enter0 (View v){
        if (!txtNumber.getText().toString().equals("0"))
            txtNumber.append("0");
    }

    public void Enter1 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("1");
    }

    public void Enter2 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("2");
    }

    public void Enter3 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("3");
    }

    public void Enter4 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("4");
    }

    public void Enter5 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("5");
    }

    public void Enter6 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("6");
    }

    public void Enter7 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("7");
    }

    public void Enter8 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("8");
    }

    public void Enter9 (View v){
        if (txtNumber.getText().toString().equals("0"))
            txtNumber.setText("");
        txtNumber.append("9");
    }

    public void ChooseOperation (View v){
        CurrentNum = txtNumber.getText().toString();

        if(CurrentNum.endsWith("+") || CurrentNum.endsWith("-") || CurrentNum.endsWith("x") || CurrentNum.endsWith("/"))
            Toast.makeText(getApplicationContext(), "Please Enter a number first!",Toast.LENGTH_SHORT).show();
        else if(CurrentNum.endsWith("/0"))
            Toast.makeText(getApplicationContext(), "Cannot divide by 0!",Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(this, Operations.class);
            intent.putExtra("NUMBER", CurrentNum);
            startActivityForResult(intent, OPERATION_REQUEST_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == OPERATION_REQUEST_CODE){
            if(resultCode == 1){
                String NewNum = data.getStringExtra("SELECTED_OPERATOR");
                txtNumber.setText(NewNum);
            }
        }
    }
}
