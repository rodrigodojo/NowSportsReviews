package com.dojo.nowsportsreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public ImageButton btNews;
    public ImageButton btHome;
    public String minhaUrl = "test_20de5f25bb8d40e6b7f110d393e57c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}