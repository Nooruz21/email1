package com.example.beakfrast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn_GO;
    private EditText address;
    private EditText text;
    private EditText clara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_GO = findViewById(R.id.btn_go);
        address = findViewById(R.id.ET1);
        text = findViewById(R.id.ET2);
        clara = findViewById(R.id.ET3);
        btn_GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",address.getText().toString(), null));
                intent.putExtra(Intent.EXTRA_EMAIL, address.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, text.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, clara.getText().toString());
                startActivity(Intent.createChooser(intent, "send"));
            }
        });
    }
}