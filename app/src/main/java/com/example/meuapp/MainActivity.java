package com.example.meuapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;

    TextView textView;

    EditText edmin, edmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button);
        textView=findViewById((R.id.tv));
        edmin=findViewById(R.id.edMin);
        edmax=findViewById(R.id.edMax);

        b.setOnClickListener(v -> {

            String minStr = edmin.getText().toString();
            String maxStr = edmax.getText().toString();

            if(minStr.isEmpty()){
                edmin.setError("Informe um valor Minimo");
                edmin.requestFocus();
                return;
            }
            if(maxStr.isEmpty()){
                edmax.setError("Informe um valor máximo");
                edmax.requestFocus();
                return;
            }

            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            Random random = new Random();
            int r=random.nextInt(min, max);
            textView.setText(Integer.toString(r));

        });

    }
}