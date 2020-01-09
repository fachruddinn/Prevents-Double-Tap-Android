package com.hellorudi.testingfitur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class TransactionActivity extends AppCompatActivity implements View.OnClickListener {

    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        findViewById(R.id.back_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // mis-clicking prevention, using threshold of 1000 ms
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();

        switch (view.getId()) {
            case R.id.back_2:
                Intent intent = new Intent(this, DoubleTapActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
