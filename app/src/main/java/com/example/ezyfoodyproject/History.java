package com.example.ezyfoodyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class History extends AppCompatActivity {
    public String AMQuantity = "0", JAPQuantity = "0", JMQuantity = "0", JALQuantity = "0";
    public String NGQuantity ="0", BQuantity="0", MAQuantity ="0", AGQuantity="0";
    public String LQuantity="0", KGQuantity="0", ORQuantity="0", RBQuantity="0";
    DatabaseHelper myDB;
    public String id;
    public String ia="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        myDB = new DatabaseHelper(this);
        Intent intent = getIntent();
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
        Cursor res = myDB.getHistoryData();
        TextView text = (TextView) findViewById(R.id.text);
        if(res.getCount()==0)
        {
            text.setText("There is no transaction yet\n");
        }
        else
        {
            StringBuilder b=new StringBuilder();
            while(res.moveToNext())
            {
                b.append(res.getString(0)+"\n");
                b.append("Total         : "+res.getInt(1)+"\n");
                b.append("Quantity   : "+res.getInt(2)+"\n");
                b.append("Date          : "+res.getString(3)+"\n");
                b.append("Address     :\n"+res.getString(4)+"\n\n");
            }
            text.setText(b);
        }
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
}