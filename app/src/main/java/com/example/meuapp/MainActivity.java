package com.example.meuapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import kotlin.Suppress;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlite;

    ImageButton buttonSalvar;

    EditText edtText;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Inicializar o banco de dados ou abrir caso o mesmo não exista
        sqlite = openOrCreateDatabase("notas", MODE_PRIVATE, null);

        //Criando tabela notas
        sqlite.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, nota TEXT)");

        //String titulo = "João";
        //sqlite.execSQL("INSERT INTO notas VALUES(1,'"+titulo+"', '')");

        //Inserindo dados no banco de dados
        /* nomeColuna, valor*/
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("titulo", "João");
//        contentValues.put("nota", "7777777777");
        ListView lv = findViewById(R.id.listView);
        buttonSalvar = findViewById(R.id.imageButton2);
        edtText = findViewById(R.id.editTextText);

        //tratamento do botão
        buttonSalvar.setOnClickListener(v ->{
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo", edtText.getText().toString());
            contentValues.put("nota", edtText.getText().toString());
            sqlite.insert("notas", null, contentValues);
            listagem();
        });

        //Para aparecer desde que a atividade começar
        listagem();

    }

    public void listagem(){
        //Recuperar dados do sqlite
        Cursor c =sqlite.rawQuery("SELECT id,id*10,titulo,nota FROM notas", null);
        c.moveToFirst(); //Movimenta o ponteiro do cursor para o primeiro registro recuperado

        ArrayList<Nota> listaNotas = new ArrayList<>();
        while(!c.isAfterLast()){
            @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("id"));
            @SuppressLint("Range") String titulo = c.getString(c.getColumnIndex("titulo"));
            @SuppressLint("Range") String nota = c.getString(c.getColumnIndex("nota"));
            Nota n = new Nota(id,titulo,nota);
            listaNotas.add(n);
            Log.d("SELECT", Integer.toString(id)+","+titulo+","+nota );
            c.moveToNext();
        }

        ArrayList<String> listaTitulos = new ArrayList<>();
        for(Nota nota :listaNotas){
            listaTitulos.add(nota.titulo);
        }
        ListView lv = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaTitulos);
        lv.setAdapter(adapter);
    }
}