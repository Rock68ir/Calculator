package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    PrefixExpression pre = new PrefixExpression("");
    PostfixExpression pse = new PostfixExpression("");
    InfixExpression ife = new InfixExpression("");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void keyPadBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        inputEquation.append(((Button) view).getText());
    }
    public void backBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        String current = inputEquation.getText().toString();
        if(!current.isEmpty()) {
            inputEquation.setText(current.substring(0, current.length() - 1));
        }
    }

    public void clearBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        inputEquation.setText("");
    }

    public void spaceBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        inputEquation.append(" ");
    }

    @SuppressLint("SetTextI18n")
    public void evalBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        EditText outputEquation = findViewById(R.id.outputEquation);
        String currentExp = inputEquation.getText().toString();
        pre.setExpression(currentExp);
        pse.setExpression(currentExp);
        ife.setExpression(currentExp);
        Toast.makeText(this, pse.getExpression(), Toast.LENGTH_SHORT).show();
        if(pre.isValid())
            outputEquation.setText("Answer : " + pre.evaluate() + "\nType : PreFix Expression\nInfix Equation : " + pre.toInfix());
        else if (pse.isValid())
            outputEquation.setText("Answer : " + pse.evaluate() + "\nType : PostFix Expression\nInfix Equation : " + pse.toInfix());
        else if(ife.isValid())
            outputEquation.setText("Answer : " + ife.evaluate() + "\nType : InFix Expression :\nPostFix Equation : " + ife.infixToPostfix());
        else
            outputEquation.setText(R.string.entered_equation_is_not_valid);
    }
}