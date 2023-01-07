package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

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
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        int counter = 0;
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
                textView.append(buttonText);
                break;
            case R.id.btnplus:
            case R.id.btnminus:
            case R.id.btnmultiply:
            case R.id.btndivide:
            case R.id.btnpercent:
                counter++;
                textView.append(buttonText);
                createNumber(counter);
                break;
            case R.id.btndot:
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
                break;
            case R.id.btnneg:
                // do your code
                break;
            default:
                break;
        }
    }
    public void createNumber(int count) {
        ArrayList<Integer> intnumbers = new ArrayList<>();
        TextView textView = findViewById(R.id.textView);
        String temp = textView.getText().toString();
        int repeat  = 0;
        int number = 0;
        char[] chtemp = new char[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            chtemp[i] = temp.charAt(i);
        }
        System.out.println("chtemp" + Arrays.toString(chtemp));
        ArrayList<Integer> digits = new ArrayList<>();
        for (char c : chtemp) {
            if (c != '-' && c != '+' && c != '*' && c != '/' && c != '%') {
                digits.add(Integer.parseInt(String.valueOf(c)));
            } else {
                for (int k = 0; k < digits.toArray().length; k++) {
                    repeat++;
                    number *= 10;
                    number += digits.get(k);
//                    digits.remove()
                }
                System.out.println("repeat" + repeat);
                intnumbers.add(number);
                digits.clear();
                System.out.println("number" + number);
            }


        }
        digits.clear();
        System.out.println("digits" + digits);
        System.out.println("intnumbers" + intnumbers);
//        if (temp.contains(",")) {
//            float newNumber = Float.parseFloat(temp);
//        } else {
//            int newNumber = Integer.parseInt(temp);
//        }

//        ArrayList<Character> arfs = new ArrayList<>();
//        ArrayList<Integer> arss = new ArrayList<>();
//        for (int i = 0; i < temp.length(); i++) {
//            if (temp.charAt(i) != '+' || temp.charAt(i) != '-' || temp.charAt(i) != '*' || temp.charAt(i) != '/' || temp.charAt(i) != '%') {
//                arfs.add(temp.charAt(i));
//            }
//            System.out.println(temp.charAt(i));
////            arfs.add(temp.charAt(i));
//            System.out.println(arfs);
//        }
//
//        for (int j = 0; j < arfs.size(); j++) {
//            int num = Integer.parseInt(String.valueOf(arfs));
//            arss.add(num);
//        }
//        System.out.println(arss);
    }
}
