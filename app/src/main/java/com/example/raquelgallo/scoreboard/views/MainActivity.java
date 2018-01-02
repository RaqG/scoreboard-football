package com.example.raquelgallo.scoreboard.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.raquelgallo.scoreboard.R;
import com.example.raquelgallo.scoreboard.views.ScoreBoardActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.welcome_btn)
    public void startNewActivity(){
        Intent it = new Intent(this, ScoreBoardActivity.class);
        startActivity(it);
    }
}
