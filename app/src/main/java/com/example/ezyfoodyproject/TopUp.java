package com.example.ezyfoodyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TopUp extends AppCompatActivity {
    public String AMQuantity = "0", JAPQuantity = "0", JMQuantity = "0", JALQuantity = "0";
    public String NGQuantity ="0", BQuantity="0", MAQuantity ="0", AGQuantity="0";
    public String LQuantity="0", KGQuantity="0", ORQuantity="0", RBQuantity="0";
    public String id;
    public String Saldo="0";
    public String totalTF="0";
    DatabaseHelper myDB;
    int tot=0;
    public String ia="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        Intent intent = getIntent();
        myDB = new DatabaseHelper(this);
        AMQuantity = intent.getStringExtra("airMineral");
        JAPQuantity = intent.getStringExtra("jusApel");
        JMQuantity = intent.getStringExtra("jusMangga");
        JALQuantity = intent.getStringExtra("jusAlpukat");
        NGQuantity = intent.getStringExtra("nasiGoreng");
        BQuantity = intent.getStringExtra("batagor");
        MAQuantity = intent.getStringExtra("mieAyam");
        AGQuantity = intent.getStringExtra("ayamGoreng");
        LQuantity = intent.getStringExtra("lumpia");
        KGQuantity = intent.getStringExtra("kentangGoreng");
        ORQuantity = intent.getStringExtra("onionRing");
        RBQuantity = intent.getStringExtra("rotiBakar");
        id = intent.getStringExtra("id");
        ia = intent.getStringExtra("alamat");
        TextView saldo = (TextView) findViewById(R.id.saldo);
        Cursor res= myDB.getDataTopUp();
        StringBuilder b=new StringBuilder();
        while(res.moveToNext()) {
            b.append(res.getString(0));
        }
        saldo.setText(b);
    }

    public void onClickMainMenu(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", LQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }

    public void onClickTransfer(View view)
    {
        EditText editText = (EditText)findViewById(R.id.totalJA);
        Cursor res= myDB.getDataTopUp();
        StringBuilder b=new StringBuilder();
        while(res.moveToNext()) {
            b.append(res.getString(0));
        }
        totalTF=editText.getText().toString();
        tot=Integer.parseInt(totalTF)+Integer.parseInt(String.valueOf(b));
        if(tot<=2000000)
        {
            boolean tf=myDB.tfsaldo("1", tot);
            Toast.makeText(this, "Top Up Success!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Top Up Maximum Balance 2.000.000!", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this, TopUp.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", LQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
//        EditText editText = (EditText)findViewById(R.id.totalJA);
//        totalTF=editText.getText().toString();
//        if(Integer.parseInt(totalTF)+Integer.parseInt(Saldo)>2000000)
//        {
//            Intent intent = new Intent(this, TopUp.class);
//            intent.putExtra("airMineral", AMQuantity);
//            intent.putExtra("jusApel", JAPQuantity);
//            intent.putExtra("jusMangga", JMQuantity);
//            intent.putExtra("jusAlpukat", JALQuantity);
//            intent.putExtra("nasiGoreng", NGQuantity);
//            intent.putExtra("batagor", BQuantity);
//            intent.putExtra("mieAyam", MAQuantity);
//            intent.putExtra("ayamGoreng", AGQuantity);
//            intent.putExtra("lumpia", LQuantity);
//            intent.putExtra("kentangGoreng", KGQuantity);
//            intent.putExtra("onionRing", ORQuantity);
//            intent.putExtra("rotiBakar", RBQuantity);
//            intent.putExtra("saldo", Saldo);
//            startActivity(intent);
//        }
//        else
//        {
//            tot = Integer.parseInt(totalTF)+Integer.parseInt(Saldo);
//            Saldo = Integer.toString(tot);
//            myDB.insertDataTopUp(tot);
//
//            Intent intent = new Intent(this, TopUp.class);
//            intent.putExtra("airMineral", AMQuantity);
//            intent.putExtra("jusApel", JAPQuantity);
//            intent.putExtra("jusMangga", JMQuantity);
//            intent.putExtra("jusAlpukat", JALQuantity);
//            intent.putExtra("nasiGoreng", NGQuantity);
//            intent.putExtra("batagor", BQuantity);
//            intent.putExtra("mieAyam", MAQuantity);
//            intent.putExtra("ayamGoreng", AGQuantity);
//            intent.putExtra("lumpia", LQuantity);
//            intent.putExtra("kentangGoreng", KGQuantity);
//            intent.putExtra("onionRing", ORQuantity);
//            intent.putExtra("rotiBakar", RBQuantity);
//            intent.putExtra("saldo", Saldo);
//            startActivity(intent);
//        }

    }

}