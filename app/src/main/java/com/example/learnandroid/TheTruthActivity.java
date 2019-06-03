package com.example.learnandroid;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TheTruthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_truth);

        Button guessYourSay = findViewById(R.id.guessYourSay);
        guessYourSay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText saySomething = findViewById(R.id.saySomething);
                String words = saySomething.getText().toString();
                Intent intent = new Intent(TheTruthActivity.this, YourTruthActivity.class);
                intent.putExtra("YOUR_TRUTH_WORDS", words);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("YOUR_RETURN_WORDS");
                    TextView yourResultWords = findViewById(R.id.yourResultWords);
                    yourResultWords.setText(returnData);
                    break;
                }
            default:
                ;
        }
    }


}
