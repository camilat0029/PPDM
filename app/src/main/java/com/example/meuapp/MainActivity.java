package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String nomes[] = new String[]{"Camila", "Lara", "Júlia", "Letícia", "Gabriela", "Yasmin", "Sofia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, //contexto
                android.R.layout.simple_list_item_1, // Recurso de layout xml
                android.R.id.text1, //id do textView interno do Layout
                nomes //array de String (dataSource)

        );

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            Intent i = new Intent(getApplicationContext(),ActivityB.class);
            //ACRESCENTAR DADO NA INTENÇÃO
            i.putExtra("nome", nomes[position]); // nome e valor

            startActivity(i);


        });

    }
}