package com.unicorn.monitor.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * <ul>
 * <li>Author: unicornhe </li>
 * <li>Time: 2018/1/29 15:36</li>
 * <li>Contack: unicorn.luson@gmail.com</li>
 * </ul>
 */

public class MainActivity extends Activity {


    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, BActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER);
        Button button = new Button(this);
        button.setText("跳转");
        button.setOnClickListener(onClick);
        linearLayout.addView(button);
        setContentView(linearLayout);
    }
}
