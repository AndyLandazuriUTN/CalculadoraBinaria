package com.example.calculadorabinaria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentInput = "";
    private String operator = "";
    private String firstOperand = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        Button btn0 = findViewById(R.id.btn0); // Botón "0"
        Button btn1 = findViewById(R.id.btn1); // Botón "1"
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnClear = findViewById(R.id.btnClear);

        // Evento para el botón "0"
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInput += "0";
                tvDisplay.setText(currentInput);
            }
        });

        // Evento para el botón "1"
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInput += "1";
                tvDisplay.setText(currentInput);
            }
        });

        // Evento para el botón "+"
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    firstOperand = currentInput;
                    operator = "+";
                    currentInput = "";
                    tvDisplay.setText("");
                }
            }
        });

        // Evento para el botón "-"
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    firstOperand = currentInput;
                    operator = "-";
                    currentInput = "";
                    tvDisplay.setText("");
                }
            }
        });

        // Evento para el botón "*"
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    firstOperand = currentInput;
                    operator = "*";
                    currentInput = "";
                    tvDisplay.setText("");
                }
            }
        });

        // Evento para el botón "/"
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    firstOperand = currentInput;
                    operator = "/";
                    currentInput = "";
                    tvDisplay.setText("");
                }
            }
        });

        // Evento para el botón "="
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!firstOperand.isEmpty() && !currentInput.isEmpty()) {
                    int result = 0;
                    int operand1 = Integer.parseInt(firstOperand, 2);
                    int operand2 = Integer.parseInt(currentInput, 2);

                    switch (operator) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            if (operand2 != 0) {
                                result = operand1 / operand2;
                            } else {
                                tvDisplay.setText("Error");
                                return;
                            }
                            break;
                    }

                    tvDisplay.setText(Integer.toBinaryString(result));
                    currentInput = Integer.toBinaryString(result);
                    firstOperand = "";
                }
            }
        });

        // Evento para el botón "Clear"
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInput = "";
                firstOperand = "";
                operator = "";
                tvDisplay.setText("0");
            }
        });
    }
}
