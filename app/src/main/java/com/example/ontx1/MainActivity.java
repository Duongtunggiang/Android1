package com.example.ontx1;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName,editSoBaoThuc;
    private RadioGroup radioGroupTime;
    private CheckBox  checkBoxLapLai;
    private Spinner spinner;
    private Button btnXoa,btnThem,btnTong;
    private TextView textName,textTime,textLap,textDayOfWeek,textSoLanDat,textViewResult;
    private int soLanDat = 0;
    private int soLanDatTong = 0;
    private int soLanDatSang = 0;
    private int soLanDatChieu = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.may_layout);

        editTextName = findViewById(R.id.editTextName);
        editSoBaoThuc = findViewById(R.id.editTextSoLanDat);
        radioGroupTime = findViewById(R.id.radioGroupTime);
        checkBoxLapLai = findViewById(R.id.checkBox);
        spinner = findViewById(R.id.spinner);
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        btnTong = findViewById(R.id.btnTong);
        textViewResult = findViewById(R.id.textResult);
        radioGroupTime.check(
                R.id.radioButtonSang
        );

        //Thiết lập mặc định cho spinner
        ArrayAdapter<CharSequence>arrayAdapter =ArrayAdapter.createFromResource(
                this, R.array.day_a_week, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        btnThem.setOnClickListener(view -> {
            String tenBaoThuc = editTextName.getText().toString();
            String soLanLap =editSoBaoThuc.getText().toString();

            if(tenBaoThuc.isEmpty() || soLanLap.isEmpty()){
                Toast.makeText(MainActivity.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                return;
            }
            soLanDat ++;

            int selectTime =radioGroupTime.getCheckedRadioButtonId();
            if(selectTime == R.id.radioButtonSang){
                soLanDatSang++;
            }else if(selectTime == R.id.radioButtonChieu){
                soLanDatChieu++;
            }
            editTextName.setText("");
            editSoBaoThuc.setText("");
            radioGroupTime.clearCheck();
            radioGroupTime.check(R.id.radioButtonSang);
            checkBoxLapLai.setChecked(false);
            spinner.setSelection(0);
            editSoBaoThuc.requestFocus();

            textViewResult.setText("Số lần đặt báo thức: "+soLanDat);
        });

        btnXoa.setOnClickListener(view -> {
            editTextName.setText("");
            editSoBaoThuc.setText("");
            radioGroupTime.clearCheck();
            radioGroupTime.check(R.id.radioButtonSang);
            checkBoxLapLai.setChecked(false);
            spinner.setSelection(0);
            editSoBaoThuc.requestFocus();
        });

        btnTong.setOnClickListener(view -> {
            String tongKet ="Tổng số lần đặt là: "+soLanDat+" \n"+
                    "Sáng: "+soLanDatSang+"\n"+
                    "Chiều:"+soLanDatChieu+" \n"+
                    "Số lần lặp: "+(checkBoxLapLai.isChecked()?" Có ":" Không ");
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tổng Kết")
                    .setMessage(tongKet)
                    .setPositiveButton("OK",null).show();
        });

    }
}