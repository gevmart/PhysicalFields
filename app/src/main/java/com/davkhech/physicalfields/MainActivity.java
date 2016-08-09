package com.davkhech.physicalfields;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gravity = (Button) findViewById(R.id.gravity);
        Button electricity = (Button) findViewById(R.id.electricity);
        Button magnetism = (Button) findViewById(R.id.magnetism);
        Button electromagentism = (Button) findViewById(R.id.electromagnetism);

        MyListener listener = new MyListener();

        gravity.setOnClickListener(listener);
        electricity.setOnClickListener(listener);
        magnetism.setOnClickListener(listener);
        electromagentism.setOnClickListener(listener);

    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, FieldActivity.class);

            switch(v.getId()) {
                case R.id.gravity:
                    intent.putExtra(Constants.FIELD, Constants.GRAVITY_CONST);
                    startActivity(intent);
                    break;
                case R.id.electricity:
                    intent.putExtra(Constants.FIELD, Constants.ELECTRICITY_CONST);
                    startActivity(intent);
                    break;
                case R.id.magnetism:
                    intent.putExtra(Constants.FIELD, Constants.MAGNETISM_CONST);
                    startActivity(intent);
                    break;
                case R.id.electromagnetism:
                    intent.putExtra(Constants.FIELD, Constants.ELECTROMAGNETISM_CONST);
                    startActivity(intent);
                    break;

            }
        }
    }
}
