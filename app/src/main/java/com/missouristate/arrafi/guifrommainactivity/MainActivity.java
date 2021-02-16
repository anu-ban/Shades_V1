package com.missouristate.arrafi.guifrommainactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {
    private ConstraintSet set;
    private ConstraintLayout layout;

    public Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        layout = findViewById(R.id.CL_2);
        layout.setBackgroundColor(Color.parseColor("#c89b6d"));
        set = new ConstraintSet();


        Button button = new Button(this);
        button.setText("PLUM");
        button.setId(View.generateViewId());

        button.setTag("btn1");
        button.setBackgroundColor(Color.parseColor("#ac7d50"));
        button.setOnClickListener(ShadeChangeListener);
        layout.addView(button);
        button.setTextSize(19);
        set.connect(button.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50);
        set.connect(button.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(button.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(button.getId(), 200);
        set.applyTo(layout);

        //Button 2:
        Button button2 = new Button(this);
        button2.setText("BLUE");
        button2.setId(View.generateViewId());
        button2.setTag("btn2");
        button2.setBackgroundColor(Color.parseColor("#ac7d50"));
        button2.setOnClickListener(ShadeChangeListener);
        layout.addView(button2);
        button2.setTextSize(19);
        set.connect(button2.getId(), ConstraintSet.TOP, button.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(button2.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(button2.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(button2.getId(), 200);
        set.applyTo(layout);

        //Button 3:
        Button button3  = new Button(this);
        button3.setText("GOLD");
        button3.setId(View.generateViewId());
        button3.setTag("btn3");
        button3.setBackgroundColor(Color.parseColor("#ac7d50"));
        button3.setOnClickListener(ShadeChangeListener);
        layout.addView(button3);
        button3.setTextSize(19);
        set.connect(button3.getId(), ConstraintSet.TOP, button2.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(button3.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(button3.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(button3.getId(), 200);
        set.applyTo(layout);


    }

    private View.OnClickListener ShadeChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String description = (String) v.getTag();
            // Create TextView programmatically.


            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            textView.setWidth(26);
            textView.setHeight(26);
            //textView.setGravity(Gravity.CENTER);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setBackgroundColor(Color.parseColor("#ac7d50"));
            textView.setId(View.generateViewId());
            textView.setTextSize(20);
            layout.addView(textView);
            //set.connect(textView.getId(),ConstraintSet.TOP,button.getId(),ConstraintSet.BOTTOM,20);
            //set.constrainHeight(textView.getId(), 200);









            switch ((String) v.getTag()) {
                case "btn1":
                    textView.setText(getString(R.string.plum_is));
                    break;
                case "btn2":
                    textView.setText(R.string.blue_is);
                    break;
                case "btn3":
                    textView.setText(R.string.gold_is);
                    break;
            }
            textView.setBackgroundColor(Color.parseColor("#ac7d50"));
            textView.setId(View.generateViewId());

            set.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.CHAIN_SPREAD_INSIDE, ConstraintSet.BOTTOM, 500);
            set.connect(textView.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
            set.connect(textView.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
            set.constrainHeight(textView.getId(), 200);


            set.applyTo(layout);

        }
    };
}

