package com.example.learnandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class YourTruthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_truth);
        Intent intent = getIntent();
        String words = intent.getStringExtra("YOUR_TRUTH_WORDS");
        TextView youWords = findViewById(R.id.youWords);
        youWords.setText(words);

        Button enterAgain = findViewById(R.id.enterAgain);
        enterAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                RadioGroup yourResult = findViewById(R.id.your_result);
                returnIntent.putExtra("YOUR_RETURN_WORDS", "对对对");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //在按下返回键时 向上个页面返回
        Intent returnIntent = new Intent();
        RadioGroup yourResult = findViewById(R.id.your_result);
        returnIntent.putExtra("YOUR_RETURN_WORDS", "对对对");
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
