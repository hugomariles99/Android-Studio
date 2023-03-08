package com.example.t1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnMa, btnMe, btnP, btnE, btnI, btnC;
    public TextView res, numero1, numero2;

    public float num1 = 0, num2 = 0, cont = 0;
    public int s = 0, r = 0, m = 0, d = 0, a = 0;
    public float help = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);

        btnMa = findViewById(R.id.buttonMas);
        btnMe = findViewById(R.id.buttonMen);
        btnP = findViewById(R.id.buttonPor);
        btnE = findViewById(R.id.buttonDiv);
        btnI = findViewById(R.id.buttonIgu);
        btnC = findViewById(R.id.buttonC);

        res = findViewById(R.id.resultado);
        //numero1 = findViewById(R.id.numero1);
        //numero2 = findViewById(R.id.numero2);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 1;
                    }else{
                        num1 = 1;
                    }
                   //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 1;
                    }else{
                        num2 = 1;
                    }
                    //numero2.setText(num2 + "");
                }
                //btn1.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 2;
                    }else{
                        num1 = 2;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 2;
                    }else{
                        num2 = 2;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 3;
                    }else{
                        num1 = 3;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 3;
                    }else{
                        num2 = 3;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 4;
                    }else{
                        num1 = 4;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 4;
                    }else{
                        num2 = 4;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 5;
                    }else{
                        num1 = 5;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 5;
                    }else{
                        num2 = 5;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 6;
                    }else{
                        num1 = 6;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 6;
                    }else{
                        num2 = 6;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 7;
                    }else{
                        num1 = 7;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 7;
                    }else{
                        num2 = 7;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 8;
                    }else{
                        num1 = 8;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 8;
                    }else{
                        num2 = 8;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 9;
                    }else{
                        num1 = 9;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 9;
                    }else{
                        num2 = 9;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    if(num1 > 0){
                        help = num1 * 10;
                        num1 = help + 0;
                    }else{
                        num1 = 0;
                    }
                    //numero1.setText(num1 + "");
                }else {
                    if(num2 > 0){
                        help = num2 * 10;
                        num2 = help + 0;
                    }else{
                        num2 = 0;
                    }
                    //numero2.setText(num2 + "");
                }
            }
        });


        btnMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    a = 1;
                    s = 1;
                }
            }
        });


        btnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    a = 1;
                    r = 1;
                }
            }
        });


        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    a = 1;
                    m = 1;
                }
            }
        });


        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 0){
                    a = 1;
                    d = 1;
                }
            }
        });

        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == 1){
                    if(s == 1){
                        cont = num1 + num2;
                    }
                    if(r == 1){
                        cont = num1 - num2;
                    }
                    if(m == 1){
                        cont = num1 * num2;
                    }
                    if(d == 1){
                        cont = num1 / num2;
                    }
                    a = 0;
                    s = 0;
                    r = 0;
                    m = 0;
                    d = 0;
                    res.setText(cont + "");
                }else{
                    res.setText("ERROR");
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText("");
                cont = 0;
                num1 = 0;
                num2 = 0;
                help = 0;
                //numero1.setText("");
                //numero2.setText("");
            }
        });
    }
}