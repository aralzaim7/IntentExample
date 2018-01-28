package com.ab2018.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView tvSonuc;

    EditText sayi1Et, sayi2Et;
    Button btnGec2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent gelenIntent = getIntent();
        String gelenAd = gelenIntent.getStringExtra("Ad");
        String gelenSoyad = gelenIntent.getStringExtra("Soyad");

        tvSonuc = (TextView) findViewById(R.id.tvAdSoyad);

        tvSonuc.setText("Ad Soyad: " + gelenAd + " " + gelenSoyad);

        sayi1Et = (EditText) findViewById(R.id.sayi1Et);
        sayi2Et = (EditText) findViewById(R.id.sayi2Et);
        btnGec2 = (Button) findViewById(R.id.btnGec2);

        btnGec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gidenIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle bundleGiden = new Bundle();
                bundleGiden.putString("say1", sayi1Et.getText().toString());
                bundleGiden.putString("say2", sayi2Et.getText().toString());
                gidenIntent.putExtras(bundleGiden);

                startActivityForResult(gidenIntent, 1);

            }
        });
    }

        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if(resultCode == RESULT_OK)
            {
                Toast.makeText(getApplicationContext(), data.getStringExtra("mesaj"), Toast.LENGTH_LONG).show();
            }


    }
}
