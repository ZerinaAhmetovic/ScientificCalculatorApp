
package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scientificcalculator.R;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView equationView;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.displayView);
        display.setShowSoftInputOnFocus(false);
        equationView = findViewById(R.id.equationView);
    }

    private void updateText(String strToAdd) {
        String displayText = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String ptOne = displayText.substring(0, cursorPos);
        String ptTwo = displayText.substring(cursorPos);

        display.setText(String.format("%s%s%s", ptOne, strToAdd, ptTwo));
        display.setSelection(cursorPos + strToAdd.length());

    }

    public void zeroBTN(View view) {
        updateText(getResources().getString(R.string.zero));
    }

    public void oneBTN(View view) {
        updateText(getResources().getString(R.string.one));
    }

    public void twoBTN(View view) {
        updateText(getResources().getString(R.string.two));
    }

    public void threeBTN(View view) {
        updateText(getResources().getString(R.string.three));
    }

    public void fourBTN(View view) {
        updateText(getResources().getString(R.string.four));
    }

    public void fiveBTN(View view) {
        updateText(getResources().getString(R.string.five));
    }

    public void sixBTN(View view) {
        updateText(getResources().getString(R.string.six));
    }

    public void sevenBTN(View view) {
        updateText(getResources().getString(R.string.seven));
    }

    public void eightBTN(View view) {
        updateText(getResources().getString(R.string.eight));
    }

    public void nineBTN(View view) {
        updateText(getResources().getString(R.string.nine));
    }

    public void clearBTN(View view) {
        display.setText("");
        equationView.setText("");
    }

    public void openParenthesesBTN(View view) {
        updateText(getResources().getString(R.string.openParentheses));
    }

    public void closedParenthesesBTN(View view) {
        updateText(getResources().getString(R.string.closedParentheses));
    }

    public void divideBTN(View view) {
        updateText(getResources().getString(R.string.divide));
    }

    public void addBTN(View view) {
        updateText(getResources().getString(R.string.add));
    }

    public void subtractBTN(View view) {
        updateText(getResources().getString(R.string.subtract));
    }

    public void multiplyBTN(View view) {
        updateText(getResources().getString(R.string.multiply));
    }

    public void pointBTN(View view) {
        updateText(getResources().getString(R.string.point));
    }

    public void equalsBTN(View view) {
        String equation = display.getText().toString();
        equationView.setText(equation);

        equation = equation.replace(getResources().getString(R.string.divide),"/");
        equation = equation.replace(getResources().getString(R.string.multiply),"*");

        Expression exp = new Expression(equation);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (textLen != 0 && cursorPos != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

    public void sinBTN(View view) {
        updateText("sin(");
    }

    public void cosBTN(View view) {
        updateText("cos(");
    }

    public void tanBTN(View view) {
        updateText("tan(");
    }

    public void sinArcBTN(View view) {
        updateText("arcsin(");
    }

    public void cosArcBTN(View view) {
        updateText("arccos(");
    }

    public void tanArcBTN(View view) {
        updateText("arctan(");
    }

    public void logBTN(View view) {
        updateText("log(");
    }

    public void naturalLogBTN(View view) {
        updateText("ln(");
    }

    public void rootBTN(View view) {
        updateText("sqrt(");
    }

    public void eBTN(View view) {
        updateText("e");
    }

    public void piBTN(View view) {
        updateText("pi");
    }

    public void absBTN(View view) {
        updateText("abs(");
    }

    public void primeBTN(View view) {
        updateText("ispr(");
    }

    public void squareBTN(View view) {
        updateText("^(2)");
    }

    public void xOnExponentBTN(View view) {
        updateText("^(");
    }
}
