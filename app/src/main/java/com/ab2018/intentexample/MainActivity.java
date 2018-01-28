package com.ab2018.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nameEt, surnameEt;
    Button btnGec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = (EditText) findViewById(R.id.nameEt);
        surnameEt = (EditText) findViewById(R.id.surnameEt);
        btnGec = (Button) findViewById(R.id.btnGec);

        btnGec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Ad", nameEt.getText().toString());
                intent.putExtra("Soyad", surnameEt.getText().toString());
                startActivity(intent);
            }
        });




    }
}
