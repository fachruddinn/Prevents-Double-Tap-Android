package com.hellorudi.testingfitur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class DoubleTapActivity extends AppCompatActivity implements View.OnClickListener {

    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_tap);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnTransaction).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // mis-clicking prevention, using threshold of 1000 ms
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();

        switch (view.getId()) {
            case R.id.btnLogin:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.btnTransaction:
                Intent i = new Intent(this, TransactionActivity.class);
                startActivity(i);
                break;
        }
    }
}
