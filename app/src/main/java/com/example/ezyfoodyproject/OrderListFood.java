package com.example.ezyfoodyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class OrderListFood extends AppCompatActivity {
    public String AMQuantity = "0", JAPQuantity = "0";
    public String JMQuantity = "0", JALQuantity = "0", DT;
    public String NGQuantity ="0", BQuantity="0", MAQuantity ="0", AGQuantity="0";
    public String LQuantity="0", KGQuantity="0", ORQuantity="0", RBQuantity="0";
    public String id;
    DatabaseHelper myDB;
    public String ia="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        TextView tipe = (TextView) findViewById(R.id.air);
        TextView stock = (TextView) findViewById(R.id.stock);
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
        DT = intent.getStringExtra("drinks");
        ia = intent.getStringExtra("alamat");
        tipe.setText(DT);
        if(DT.equals("Nasi Goreng")){
            Cursor res= myDB.getNG(Integer.parseInt(id));
            StringBuilder b=new StringBuilder();
            while(res.moveToNext()) {
                b.append("Stock : "+res.getString(0));
            }
            stock.setText(String.valueOf(b));
        }else if(DT.equals("Batagor")){
            Cursor res= myDB.getB(Integer.parseInt(id));
            StringBuilder b=new StringBuilder();
            while(res.moveToNext()) {
                b.append("Stock : "+res.getString(0));
            }
            stock.setText(String.valueOf(b));
        }else if(DT.equals("Mie Ayam")){
            Cursor res= myDB.getMA(Integer.parseInt(id));
            StringBuilder b=new StringBuilder();
            while(res.moveToNext()) {
                b.append("Stock : "+res.getString(0));
            }
            stock.setText(String.valueOf(b));
        }else if(DT.equals("Ayam Goreng")){
            Cursor res= myDB.getAG(Integer.parseInt(id));
            StringBuilder b=new StringBuilder();
            while(res.moveToNext()) {
                b.append("Stock : "+res.getString(0));
            }
            stock.setText(String.valueOf(b));
        }
    }

    public void onClickMyOrder(View view){
        Intent intent = new Intent(this, MyOrder.class);
        EditText editText = (EditText)findViewById(R.id.totalJA);
        if(DT.equals("Nasi Goreng")){
            NGQuantity = editText.getText().toString();
        }else if(DT.equals("Batagor")){
            BQuantity = editText.getText().toString();
        }else if(DT.equals("Mie Ayam")){
            MAQuantity = editText.getText().toString();
        }else if(DT.equals("Ayam Goreng")){
            AGQuantity = editText.getText().toString();
        }
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

    public void onClickOrderMore(View view){
        Intent intent = new Intent(this, Food.class);
        EditText editText = (EditText)findViewById(R.id.totalJA);
        if(DT.equals("Nasi Goreng")){
            NGQuantity = editText.getText().toString();
        }else if(DT.equals("Batagor")){
            BQuantity = editText.getText().toString();
        }else if(DT.equals("Mie Ayam")){
            MAQuantity = editText.getText().toString();
        }else if(DT.equals("Ayam Goreng")){
            AGQuantity = editText.getText().toString();
        }
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
