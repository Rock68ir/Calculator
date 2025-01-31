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
        int cursorPosition = inputEquation.getSelectionStart();
        String enteredText = inputEquation.getText().toString();
        String startToCursor = enteredText.substring(0, cursorPosition);
        String cursorToEnd = enteredText.substring(cursorPosition);

        String finalString = startToCursor + ((Button) view).getText() + cursorToEnd;
        inputEquation.setText(finalString);
        inputEquation.setSelection(cursorPosition+1);
    }
    public void backBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        String enteredText = inputEquation.getText().toString();
        if(!enteredText.isEmpty()) {
            int cursorPosition = inputEquation.getSelectionStart();
            String startToCursor = enteredText.substring(0, cursorPosition-1);
            String cursorToEnd = enteredText.substring(cursorPosition);

            String finalString = startToCursor + cursorToEnd;
            inputEquation.setText(finalString);
            inputEquation.setSelection(cursorPosition-1);
        }
    }

    public void clearBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        inputEquation.setText("");
    }

    public void spaceBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        int cursorPosition = inputEquation.getSelectionStart();
        String enteredText = inputEquation.getText().toString();
        String startToCursor = enteredText.substring(0, cursorPosition);
        String cursorToEnd = enteredText.substring(cursorPosition);

        String finalString = startToCursor + " " + cursorToEnd;
        inputEquation.setText(finalString);
        inputEquation.setSelection(cursorPosition+1);
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

    public void BackPosBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        int cursorPosition = inputEquation.getSelectionStart();
        if(cursorPosition != 0)
            inputEquation.setSelection(cursorPosition-1);
        inputEquation.setPressed(true);
    }

    public void NextPosBtnClicked(View view) {
        EditText inputEquation = findViewById(R.id.inputEquation);
        int cursorPosition = inputEquation.getSelectionStart();
        if(cursorPosition != inputEquation.getText().length())
            inputEquation.setSelection(cursorPosition+1);
        inputEquation.setPressed(true);
    }
}