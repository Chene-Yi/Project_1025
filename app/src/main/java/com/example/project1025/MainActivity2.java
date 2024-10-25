package com.example.project1025;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget. RadioGroup;


public class MainActivity2 extends AppCompatActivity {

    private EditText set_drink;
    private RadioGroup rg1, rg2;
    private Button btn_send;
    private String sugar = "無糖";
    private String ice_opt = "去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        rg1 = findViewById(R.id.radioGroup); // 連接RadioGroup畫面元件
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton1) {
                sugar = "無糖"; // 將糖度設定為無糖
            } else if (i == R.id.radioButton2) {
                sugar = "少糖"; // 將糖度設定為少糖
            } else if (i == R.id.radioButton3) {
                sugar = "半糖"; // 將糖度設定為半糖
            } else if (i == R.id.radioButton4) {
                sugar = "全糖"; // 將糖度設定為全糖
            }
        });

        rg2 = findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton5) {
                ice_opt = "去冰";
            } else if (i == R.id.radioButton6) {
                ice_opt = "微冰";
            } else if (i == R.id.radioButton7) {
                ice_opt = "少冰";
            } else if (i == R.id.radioButton8) {
                ice_opt = "正常冰";
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", drink);
            b.putString("sugar", sugar);
            b.putString("ice", ice_opt);
            i.putExtras(b);
            setResult(Activity.RESULT_OK, i);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}