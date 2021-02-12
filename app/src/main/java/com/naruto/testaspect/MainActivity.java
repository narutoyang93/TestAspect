package com.naruto.testaspect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.naruto.testaspect.annotation.SingleClick;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);

        reset(null);
    }

    public void reset(View view) {
        updateCount(btn1, 0);
        updateCount(btn2, 0);
    }

    public void onClick1(View view) {
        Button button = (Button) view;
        int count = (int) button.getTag();
        updateCount(button, count+1);
    }

    @SingleClick
    public void onClick2(View view) {
        Button button = (Button) view;
        int count = (int) button.getTag();
        updateCount(button, count+1);
    }

    private void updateCount(Button button, int count) {
        button.setText("已点击" + count + "次");
        button.setTag(count);
    }
}