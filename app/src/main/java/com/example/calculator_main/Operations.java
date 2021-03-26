package com.example.calculator_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Operations extends AppCompatActivity {

    TextView txtOperation;
    Button btnAdd, btnSub, btnMul, btnDiv, btnEquals;
    String CurrentNum;
    String[] operators = new String[] {"+","-","x","/"};
    boolean isNegative = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        Intent i = getIntent();

        CurrentNum = i.getStringExtra("NUMBER");
        txtOperation = findViewById(R.id.txtOperation);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnEquals = findViewById(R.id.btnEquals);

        txtOperation.setText(CurrentNum);
    }

    public void Add(View v){
        isNegativeChecker();

        if(CurrentNum.contains("+") || CurrentNum.contains("-") || CurrentNum.contains("x") || CurrentNum.contains("/"))
            txtOperation.setText(calculateEquation(CurrentNum));
        txtOperation.append("+");

        Intent ResultIntent = new Intent();
        ResultIntent.putExtra("SELECTED_OPERATOR", txtOperation.getText().toString());
        setResult(1, ResultIntent);

        finish();
    }

    public void Subtract(View v){
        isNegativeChecker();

        if(CurrentNum.contains("+") || CurrentNum.contains("-") || CurrentNum.contains("x") || CurrentNum.contains("/"))
            txtOperation.setText(calculateEquation(CurrentNum));
        txtOperation.append("-");

        Intent ResultIntent = new Intent();
        ResultIntent.putExtra("SELECTED_OPERATOR", txtOperation.getText().toString());
        setResult(1, ResultIntent);

        finish();
    }

    public void Multiply(View v){
        isNegativeChecker();

        if(CurrentNum.contains("+") || CurrentNum.contains("-") || CurrentNum.contains("x") || CurrentNum.contains("/"))
            txtOperation.setText(calculateEquation(CurrentNum));
        txtOperation.append("x");

        Intent ResultIntent = new Intent();
        ResultIntent.putExtra("SELECTED_OPERATOR", txtOperation.getText().toString());
        setResult(1, ResultIntent);

        finish();
    }

    public void Divide(View v){
        isNegativeChecker();

        if(CurrentNum.contains("+") || CurrentNum.contains("-") || CurrentNum.contains("x") || CurrentNum.contains("/"))
            txtOperation.setText(calculateEquation(CurrentNum));
        txtOperation.append("/");

        Intent ResultIntent = new Intent();
        ResultIntent.putExtra("SELECTED_OPERATOR", txtOperation.getText().toString());
        setResult(1, ResultIntent);

        finish();
    }

    public void Equate(View v){
        isNegativeChecker();

        if(CurrentNum.contains("+") || CurrentNum.contains("-") || CurrentNum.contains("x") || CurrentNum.contains("/"))
            txtOperation.setText(calculateEquation(CurrentNum));

        Intent ResultIntent = new Intent();
        ResultIntent.putExtra("SELECTED_OPERATOR", txtOperation.getText().toString());
        setResult(1, ResultIntent);

        finish();
    }

    private String calculateEquation(String equation) {
        String operator = findOperator(equation);
        int NewNum = 0;
        String[] SplitNum;

        switch (operator){
            case "+":
                SplitNum = equation.split("\\+");
                if(isNegative){
                    NewNum = Integer.parseInt(SplitNum[1]) - Integer.parseInt(SplitNum[0]);
                    isNegative = false;
                }
                else
                    NewNum = Integer.parseInt(SplitNum[0]) + Integer.parseInt(SplitNum[1]);
            break;

            case "-":
                SplitNum = equation.split("-");
                if(isNegative){
                    NewNum = 0 - (Integer.parseInt(SplitNum[0]) + Integer.parseInt(SplitNum[1]));
                    isNegative = false;
                }
                else
                    NewNum = Integer.parseInt(SplitNum[0]) - Integer.parseInt(SplitNum[1]);
            break;

            case "x":
                SplitNum = equation.split("x");
                if(isNegative){
                    NewNum = 0 - Integer.parseInt(SplitNum[0]) * Integer.parseInt(SplitNum[1]);
                    isNegative = false;
                }
                else
                    NewNum = Integer.parseInt(SplitNum[0]) * Integer.parseInt(SplitNum[1]);
             break;

            case "/":
                SplitNum = equation.split("/");
                if(isNegative){
                    NewNum = 0 - Integer.parseInt(SplitNum[0]) / Integer.parseInt(SplitNum[1]);
                    isNegative = false;
                }
                else
                    NewNum = Integer.parseInt(SplitNum[0]) / Integer.parseInt(SplitNum[1]);

            break;
        }
        return String.valueOf(NewNum);
    }

    private String findOperator(String equation){
        for (String operator : operators) {
            if (equation.contains(operator) && equation.charAt(0) != '-') {
                return operator;
            }
        }
        return "invalid";
    }

    private void isNegativeChecker(){
        if(CurrentNum.charAt(0) == '-'){
            StringBuilder NegativeNum = new StringBuilder(CurrentNum);
            NegativeNum.deleteCharAt(0);
            CurrentNum = NegativeNum.toString();

            isNegative = true;
        }
    }
}
