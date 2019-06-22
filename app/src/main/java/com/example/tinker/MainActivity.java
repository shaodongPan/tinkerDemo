package com.example.tinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinkerPatch.with().fetchPatchUpdate(true);
            }
        });
    }
}
