package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button one = findViewById(R.id.btn1);
        one.setOnClickListener(this);
        Button two = findViewById(R.id.btn2);
        two.setOnClickListener(this);
        Button three = findViewById(R.id.btn3);
        three.setOnClickListener(this);
        Button four = findViewById(R.id.btn4);
        four.setOnClickListener(this);
        Button five = findViewById(R.id.btn5);
        five.setOnClickListener(this);
        Button six = findViewById(R.id.btn6);
        six.setOnClickListener(this);
        Button seven = findViewById(R.id.btn7);
        seven.setOnClickListener(this);
        Button eight = findViewById(R.id.btn8);
        eight.setOnClickListener(this);
        Button nine = findViewById(R.id.btn9);
        nine.setOnClickListener(this);
        Button zero = findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        Button plus = findViewById(R.id.btnplus);
        plus.setOnClickListener(this);
        Button minus = findViewById(R.id.btnminus);
        minus.setOnClickListener(this);
        Button divide = findViewById(R.id.btndivide);
        divide.setOnClickListener(this);
        Button multiply = findViewById(R.id.btnmultiply);
        multiply.setOnClickListener(this);
        Button percent = findViewById(R.id.btnpercent);
        percent.setOnClickListener(this);
        Button del = findViewById(R.id.btndel);
        del.setOnClickListener(this);
        Button AC = findViewById(R.id.btnAC);
        AC.setOnClickListener(this);
        Button equals = findViewById(R.id.btnequals);
        equals.setOnClickListener(this);
        Button dot = findViewById(R.id.btndot);
        dot.setOnClickListener(this);
        Button negative = findViewById(R.id.btnneg);
        negative.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView textView = findViewById(R.id.textView);
        switch (view.getId()) {
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
//                textView.setText(getResources().getString(R.string._text) + "xd");
//                textView.append("xd");
                Button b = (Button) view;
                String buttonText = b.getText().toString();
                textView.append(buttonText);
//                textView.append(view.getResources().getResourceName(view.getId()).substring(view.getResources().getResourceName(view.getId()).length()-1, ));
                break;
            case R.id.btnplus:
                // do your code
                break;
            case R.id.btnminus:
                // do your code
                break;
            case R.id.btnmultiply:
                // do your code
                break;
            case R.id.btndivide:
                // do your code
                break;
            case R.id.btnpercent:
                // do your code
                break;
            case R.id.btndel:
                if (textView.getText().toString().length() != 0) {
                    textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length()-1));
                }
                break;
            case R.id.btnAC:
                if (textView.getText().toString().length() != 0) {
                    textView.setText(getString(R.string._text));
                }
                break;
            case R.id.btnequals:
                // do your code
                break;
            case R.id.btndot:
                // do your code
                break;
            case R.id.btnneg:
                // do your code
                break;
            default:
                break;
        }
    }
}