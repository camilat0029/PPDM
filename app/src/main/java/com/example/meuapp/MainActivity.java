package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button b;

    EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button);
        editTextMsg=findViewById(R.id.edtMensagem);

        b.setOnClickListener(v -> {

            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            String mensagem=editTextMsg.getText().toString();
            i.putExtra("msg", mensagem);
            startActivity(i);

        });
    }


}