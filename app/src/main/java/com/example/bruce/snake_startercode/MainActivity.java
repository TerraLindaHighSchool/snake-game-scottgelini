package com.example.bruce.snake_startercode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void beginGame(View view) {
        Intent i = new Intent(view.getContext(), GameActivity.class);
        startActivity(i);
    }

    public void exit(View view) {
        System.exit(1);
    }
}
