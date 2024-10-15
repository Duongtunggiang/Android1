package com.example.ontx1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityNew extends AppCompatActivity {
    private EditText editNum1, editNum2;
    private TextView textViewResult;
    private Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casio_layout2);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        textViewResult = findViewById(R.id.textResult);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });
    }
    private void calculate(char operator){
        String num1tr = editNum1.getText().toString();
        String num2tr = editNum2.getText().toString();

        if(TextUtils.isEmpty(num1tr) || TextUtils.isEmpty(num2tr)){
            Toast.makeText(MainActivityNew.this,"Vui lòng nhập đầy đủ số!",Toast.LENGTH_LONG).show();
            return;
        }
        double num1 = Double.parseDouble(num1tr);
        double num2 = Double.parseDouble(num2tr);
        double result = 0;

        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0){
                    result = num1 / num2;
                }else {
                    Toast.makeText(MainActivityNew.this,"Số thứ hai phải khác 0!",Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }
        textViewResult.setText("Kết quả: "+result);

    }
}
