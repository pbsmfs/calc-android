package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.math.BigDecimal;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        TextView textView = findViewById(R.id.textView);
        Button b = (Button) view;
        String buttonText = b.getText().toString();
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
            case R.id.btndot:
                sanityCheck();
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

                solve(createNumbers());
                break;
            case R.id.btnneg:
                // do your code
                break;
            default:
                break;
        }
    }

    public void sanityCheck() {
        //TODO
    }

    public ArrayList<Object> createNumbers() {
        TextView textView = findViewById(R.id.textView);
        String temp = textView.getText().toString();
        ArrayList<Integer> digits = new ArrayList<>();
        int intnumber = 0;
//        float div = 0;
//        float doublenumber = 0;
        ArrayList<Object> equation = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != '-' && temp.charAt(i) != '+' && temp.charAt(i) != '*' && temp.charAt(i) != '/' && temp.charAt(i) != '^' && temp.charAt(i) != '.') {
//                    if (temp.charAt(i) == ',') {
//                        div = (float) Math.pow(0.1, i);
//                    }
//                    else {
                        digits.add(Integer.parseInt(String.valueOf(temp.charAt(i))));
                        if (i + 1 == temp.length()) {
                            Integer[] ardigits = digits.toArray(new Integer[0]);
                            for (int k = 0; k < ardigits.length; k++) {
                                intnumber = intnumber * 10 + ardigits[k];
                            }
//                            if (div == 0) {
//                                System.out.println(intnumber);
                                equation.add(intnumber);
                                intnumber = 0;
                                digits.clear();
//                            }
//                            else {
//                                doublenumber = (float) intnumber * div;
//                                System.out.println(doublenumber);
//                                equation.add(doublenumber);
//                                intnumber = 0;
//                                digits.clear();
//                            }
                        }
                    }
//                }

            else {
                Integer[] ardigits = digits.toArray(new Integer[0]);
                for (Integer ardigit : ardigits) {
                    intnumber = intnumber * 10 + ardigit;
                }
//                System.out.println(intnumber);
                equation.add(intnumber);
                intnumber = 0;
                digits.clear();
                if (temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*' ||temp.charAt(i) == '/' || temp.charAt(i) == '^' || temp.charAt(i) == '.') {
                    equation.add(temp.charAt(i));
                }
//                Integer[] ardigits = digits.toArray(new Integer[0]);
//                for (int k = 0; k < ardigits.length; k++) {
//                    intnumber = intnumber * 10 + ardigits[k];
//                }
//                if (div == 0) {
//                    System.out.println(intnumber);
//                    equation.add(intnumber);
//                    intnumber = 0;
//                    digits.clear();
//                }
//                else {
//                    doublenumber = (float) intnumber * div;
//                    System.out.println(doublenumber);
//                    equation.add(doublenumber);
//                    intnumber = 0;
//                    digits.clear();
//
        }
//        System.out.println(equation);
    }
        return equation;
}

@RequiresApi(api = Build.VERSION_CODES.N)
public void solve(ArrayList<Object> numbers) {
        TextView textView = findViewById(R.id.textView);
        System.out.println("eq " + numbers);

        while (numbers.contains('.')) {
            int dot = numbers.indexOf('.');
            double number = ((int) numbers.get(dot-1) + Math.pow(0.1, numbers.get(dot+1).toString().length()) * (int) numbers.get(dot+1));
            numbers.set(dot-1, number);
            numbers.remove(dot);
            numbers.remove(dot);
        }
        System.out.println("dot " + numbers);

        while (numbers.contains('^')) {
            int pow = numbers.indexOf('^');
            BigDecimal number = BigDecimal.valueOf(Math.pow(Double.parseDouble(numbers.get(pow-1).toString()), Double.parseDouble(numbers.get(pow+1).toString()))).setScale(6, 4);
            numbers.set(pow-1, number);
            numbers.remove(pow);
            numbers.remove(pow);
        }
        System.out.println("pow " + numbers);

    while (numbers.contains('*') || numbers.contains('/')) {
        int mult = numbers.indexOf('*');
        int div = numbers.indexOf('/');
        if (div == -1 || (mult < div && mult != -1)) {
            BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numbers.get(mult-1).toString()) * (Double.parseDouble(numbers.get(mult+1).toString()))).setScale(6, 4) ;
            numbers.set(mult-1, number);
            numbers.remove(mult);
            numbers.remove(mult);
        }
        else if (mult > div || mult == -1) {
            BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numbers.get(div-1).toString()) / (Double.parseDouble(numbers.get(div+1).toString()))).setScale(6, 4);
            numbers.set(div-1, number);
            numbers.remove(div);
            numbers.remove(div);
        }
//        BigDecimal number = BigDecimal.valueOf(Math.pow(Double.parseDouble(numbers.get(pow-1).toString()), Double.parseDouble(numbers.get(pow+1).toString()))).setScale(3, 2);
//        numbers.set(pow-1, number);
//        numbers.remove(pow);
//        numbers.remove(pow);
    }
    System.out.println("muldiv " + numbers);

    while (numbers.contains('+') || numbers.contains('-')) {
        int plus = numbers.indexOf('+');
        int minus = numbers.indexOf('-');
        if (plus == -1 || (minus < plus && minus != -1) ) {
            BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numbers.get(minus-1).toString()) - (Double.parseDouble(numbers.get(minus+1).toString()))).setScale(6, 4);
            numbers.set(minus-1, number);
            numbers.remove(minus);
            numbers.remove(minus);
        }
        else if (minus > plus || minus == -1) {
            BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numbers.get(plus-1).toString()) + (Double.parseDouble(numbers.get(plus+1).toString()))).setScale(6, 4);
            numbers.set(plus-1, number);
            numbers.remove(plus);
            numbers.remove(plus);
        }
    }
    System.out.println("minplus " + numbers);
    BigDecimal result = (BigDecimal) numbers.get(0);
    System.out.println(BigDecimal.valueOf(result.intValue()));
    int res = result.intValue();
    if (result.compareTo(BigDecimal.valueOf(res)) == 0) {
        int intresult = result.intValue();
        textView.setText(getString(R.string._text));
        textView.append(String.valueOf(Math.round(intresult)));
    }
    else {
        textView.setText(getString(R.string._text));
        textView.append(String.valueOf((Math.round(result.floatValue()))));
    }

}
}
//    public void createNumber(int count) {
//        ArrayList<Integer> intnumbers = new ArrayList<>();
//        TextView textView = findViewById(R.id.textView);
//        String temp = textView.getText().toString();
//        int number = 0;
//        char[] chtemp = new char[temp.length()];
//        for (int i = 0; i < temp.length(); i++) {
//            chtemp[i] = temp.charAt(i);
//        }
//        System.out.println("chtemp" + Arrays.toString(chtemp));
//        ArrayList<Integer> digits = new ArrayList<>();
//        for (char c : chtemp) {
//            if (c != '-' && c != '+' && c != '*' && c != '/' && c != '%') {
//                digits.add(Integer.parseInt(String.valueOf(c)));
//            } else {
//                for (int k = 0; k < digits.toArray().length; k++) {
//                    number *= 10;
//                    number += digits.get(k);
////                    digits.remove()
//                }
//                intnumbers.add(number);
//                digits.clear();
//                System.out.println("number" + number);
//            }
//        }
//        digits.clear();
//        System.out.println("digits" + digits);
//        System.out.println("intnumbers" + intnumbers);
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

