package com.geektech.java3hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextInputEditText one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListener();

    }

    private void init() {
        btn = findViewById(R.id.btn);
        one = findViewById(R.id.et_email);
        two = findViewById(R.id.et_theme);
        three = findViewById(R.id.et_text);
    }

    private void initListener() {

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!one.getText().toString().isEmpty() && !two.getText().toString().isEmpty() && !three.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{one.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, two.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, three.getText().toString());
                    intent.setData(Uri.parse("mailto:"));
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Zapolni vse edittextu shakal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}


