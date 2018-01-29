package com.unicorn.monitor.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * <ul>
 * <li>Author: unicornhe </li>
 * <li>Time: 2018/1/29 11:06</li>
 * <li>Contack: unicorn.luson@gmail.com</li>
 * </ul>
 */

public class BActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER);
        TextView textView = new TextView(this);
        textView.setText("第二个页面");
        linearLayout.addView(textView);
        setContentView(linearLayout);

    }

}
