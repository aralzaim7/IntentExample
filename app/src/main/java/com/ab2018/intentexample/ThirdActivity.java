package com.ab2018.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tvToplam;
    Button btnGeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvToplam = (TextView)findViewById(R.id.toplamTv);

        Intent gelenIntent = getIntent();
        Bundle gelenBundle = gelenIntent.getExtras();
        String say1= gelenBundle.getString("say1");
        String say2= gelenBundle.getString("say2");

        int sonuc = Integer.parseInt (say1)+ Integer.parseInt(say2);
        final String mesaj= say1 + " + " + say2 + " = " + sonuc;
        tvToplam.setText(mesaj);

        btnGeri = (Button) findViewById(R.id.btnGeri);
        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent geriIntent= new Intent();
                geriIntent.putExtra("mesaj", mesaj);
                setResult(RESULT_OK, geriIntent);
                finish();
            }
        });



    }
}
