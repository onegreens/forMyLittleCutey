package com.example.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private static int CLICK_NUM = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button theTruth = findViewById(R.id.theTruth);
        theTruth.setOnClickListener(new View.OnClickListener() {
            @Override //显示跳转
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, TheTruthActivity.class);
                startActivity(intent);
            }

        });
        Button meTrue = findViewById(R.id.meTrue);
        meTrue.setOnClickListener(new View.OnClickListener() {
            @Override//隐式跳转 需要修改AndroidManifest.xml
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                startActivity(intent);
            }
//            @Override //显示跳转
//            public void onClick(View v) {
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
//            }

        });
        Button clickMe = findViewById(R.id.clickMe);
        clickMe.setOnClickListener(new View.OnClickListener() {
            //            @Override
//            public void onClick(View v) {
//                finish();//销毁当前活动
//            }
            @Override
            public void onClick(View v) {
                switch (CLICK_NUM) {
                    case 0:
                        Toast.makeText(FirstActivity.this, R.string.is_useless, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(FirstActivity.this, R.string.is_useless_again, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(FirstActivity.this, R.string.to_next_page, Toast.LENGTH_SHORT).show();

                }
                CLICK_NUM++;

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, R.string.con_not_add, Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, R.string.con_not_remove, Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
