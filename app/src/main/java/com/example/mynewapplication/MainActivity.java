package com.example.mynewapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView TextView;
    private static final char sum = '+';
    private static final char minus = '-';
    private static final char multi = '*';
    private static final char div= '/';

    private char user_symbol;
    private double NUM1 = Double.NaN;
    private double NUM2;
    public static final String TEXT_POLE1 = "TEXT_POLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView TextView = findViewById(R.id.textView);
        outState.putString(TEXT_POLE1, TextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String Text = savedInstanceState.getString(TEXT_POLE1);
        TextView TextView = findViewById(R.id.textView);
        TextView.setText(Text);

    }

    private void initView() {

        TextView = findViewById(R.id.textView);
        initButton0Click();
        initButton1Click();
        initButton2Click();
        initButton3Click();
        initButton4Click();
        initButton5Click();
        initButton6Click();
        initButton7Click();
        initButton8Click();
        initButton9Click();
        initButtonComClick();
        setSymbol ();
        otherButtons();
    }

    private void initButton0Click() {
        Button button_0 = findViewById(R.id.button_0);
        button_0.setOnClickListener(v -> MainActivity.this.setText(TextView.getText() + "0"));
    }

    private void setText(String s) {
        TextView.setText(s);
    }

    private void initButton1Click() {
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(v -> setText1(TextView.getText() + "1"));
    }

    public void setText1(String s) {
        TextView.setText(s);
    }

    private void initButton2Click() {
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(v -> setText2(TextView.getText() + "2"));
    }

    private void setText2(String s) {
        TextView.setText(s);
    }

    private void initButton3Click() {
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(v -> setText3(TextView.getText() + "3"));
    }

    private void setText3(String s) {
        TextView.setText(s);
    }

    private void initButton4Click() {
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(v -> setText4(TextView.getText() + "4"));
    }

    private void setText4(String s) {
        TextView.setText(s);
    }

    private void initButton5Click() {
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(v -> setText5(TextView.getText() + "5"));
    }

    private void setText5(String s) {
        TextView.setText(s);
    }

    private void initButton6Click() {
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(v -> setText6(TextView.getText() + "6"));
    }

    private void setText6(String s) {
        TextView.setText(s);
    }

    private void initButton7Click() {
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(v -> setText7(TextView.getText() + "7"));
    }

    private void setText7(String s) {
        TextView.setText(s);
    }

    private void initButton8Click() {
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(v -> setText8(TextView.getText() + "8"));
    }

    private void setText8(String s) {
        TextView.setText(s);
    }

    private void initButton9Click() {
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(v -> setText9(TextView.getText() + "9"));
    }

    private void setText9(String s) {
        TextView.setText(s);
    }

    private void initButtonComClick() {
        Button comma = findViewById(R.id.button_comma);
        comma.setOnClickListener(v -> setTexCom(TextView.getText() + "."));
    }

    private void setTexCom(String s) {
        TextView.setText(s);
    }

    private void setSymbol (){
        Button plus = findViewById(R. id.button_plus);
        Button bMinus = findViewById(R. id.button_minus);
        Button multiply = findViewById(R. id.button_multiply);
        Button divide = findViewById(R. id.button_divide);
        Button equally = findViewById(R. id.button_equally);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                user_symbol = sum;
                TextView.setText((NUM1) + "+");
                TextView.setText(null);

            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                user_symbol =minus;
                TextView.setText((NUM1) + "-");
                TextView.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                user_symbol = multi;
                TextView.setText((NUM1) + "*");
                TextView.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                user_symbol =div;
                TextView.setText((NUM1) + "/");
                TextView.setText(null);
            }
        });
        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                TextView.setText(TextView.getText().toString() +
                        (NUM2) + " = " + (NUM1));
                NUM1 = Double.NaN;
                user_symbol = '0';
            }
        });

    }

    private void calculation() {
        if(!Double.isNaN(NUM1)) {
            NUM2 = Double.parseDouble(TextView.getText().toString());
            TextView.setText(null);
            if(user_symbol == sum)
                NUM1 = this.NUM1 + NUM2;
            else if(user_symbol == minus)
                NUM1 = this.NUM1 - NUM2;
            else if(user_symbol == multi)
                NUM1 = this.NUM1 * NUM2;
            else if(user_symbol == div)
                NUM1 = this.NUM1 / NUM2;
        }
        else {
            try {
                NUM1 = Double.parseDouble(TextView.getText().toString());
            }
            catch (Exception e){}
        }
    }

    private void otherButtons(){
        Button clear = findViewById(R.id.button_clear);
        Button percent = findViewById(R. id.button_percent);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView.setText(null);
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView.setText("Я пока не умею вычислять %%");
            }
        });

    }
}
