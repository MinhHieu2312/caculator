package com.example.caculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    private EditText txtExpression;
    private TextView txtResult;

    ScriptEngine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        engine = new ScriptEngineManager().getEngineByName("rhino");

        txtExpression = findViewById(R.id.edtExpression);
        txtResult = findViewById(R.id.txtResult);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btnOpenBracket = findViewById(R.id.btnOpenBracket);
        Button btnCloseBracket = findViewById(R.id.btnCloseBracket);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEqual = findViewById(R.id.btnEqual);
        Button btnC = findViewById(R.id.btnC);

        btn0.setOnClickListener(this::onClick);
        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);
        btn3.setOnClickListener(this::onClick);
        btn4.setOnClickListener(this::onClick);
        btn5.setOnClickListener(this::onClick);
        btn6.setOnClickListener(this::onClick);
        btn7.setOnClickListener(this::onClick);
        btn8.setOnClickListener(this::onClick);
        btn9.setOnClickListener(this::onClick);
        btnOpenBracket.setOnClickListener(this::onClick);
        btnCloseBracket.setOnClickListener(this::onClick);
        btnPlus.setOnClickListener(this::onClick);
        btnMinus.setOnClickListener(this::onClick);
        btnMulti.setOnClickListener(this::onClick);
        btnDivide.setOnClickListener(this::onClick);
        btnEqual.setOnClickListener(this::onClick);
        btnC.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                txtExpression.setText(txtExpression.getText().toString() + "0");
                break;

            case R.id.btn1:
                txtExpression.setText(txtExpression.getText().toString() + "1");
                break;

            case R.id.btn2:
                txtExpression.setText(txtExpression.getText().toString() + "2");
                break;

            case R.id.btn3:
                txtExpression.setText(txtExpression.getText().toString() + "3");
                break;

            case R.id.btn4:
                txtExpression.setText(txtExpression.getText().toString() + "4");
                break;

            case R.id.btn5:
                txtExpression.setText(txtExpression.getText().toString() + "5");
                break;

            case R.id.btn6:
                txtExpression.setText(txtExpression.getText().toString() + "6");
                break;

            case R.id.btn7:
                txtExpression.setText(txtExpression.getText().toString() + "7");
                break;

            case R.id.btn8:
                txtExpression.setText(txtExpression.getText().toString() + "8");
                break;

            case R.id.btn9:
                txtExpression.setText(txtExpression.getText().toString() + "9");
                break;

            case R.id.btnOpenBracket:
                txtExpression.setText(txtExpression.getText().toString() + "(");
                break;

            case R.id.btnCloseBracket:
                txtExpression.setText(txtExpression.getText().toString() + ")");
                break;

            case R.id.btnPlus:
                txtExpression.setText(txtExpression.getText().toString() + "+");
                break;

            case R.id.btnMinus:
                txtExpression.setText(txtExpression.getText().toString() + "-");
                break;

            case R.id.btnMulti:
                txtExpression.setText(txtExpression.getText().toString() + "*");
                break;

            case R.id.btnDivide:
                txtExpression.setText(txtExpression.getText().toString() + "/");
                break;

            case R.id.btnC:
                txtExpression.setText("");
                break;

            case R.id.btnEqual:
                handleEvaluate();
                break;
        }
    }

    private void handleEvaluate() {
        String result = "";
        try
        {
            result = engine.eval(txtExpression.getText().toString()).toString();
            txtResult.setText(result);
        } catch (Exception e)
        {
            txtResult.setText("");
            Toast.makeText(this.getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}