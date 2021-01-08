package com.example.ezyfoodyproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MyOrder extends AppCompatActivity {
    public String AMQuantity = "0", JAPQuantity = "0", JMQuantity = "0", JALQuantity = "0";
    public String NGQuantity ="0", BQuantity="0", MAQuantity ="0", AGQuantity="0";
    public String LQuantity="0", KGQuantity="0", ORQuantity="0", RBQuantity="0";
    int total = 0;
    int kurang=0;
    int stat=0;
    DatabaseHelper myDB;
    public String id;
    public String ia="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        Intent intent = getIntent();
        myDB = new DatabaseHelper(this);
        Cursor res= myDB.getDataTopUp();
        StringBuilder b=new StringBuilder();
        while(res.moveToNext()) {
            b.append(res.getString(0));
        }
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
        TextView airMinerals = (TextView) findViewById(R.id.AirMin);
        TextView jusApels = (TextView) findViewById(R.id.JusAp);
        TextView jusManggas = (TextView) findViewById(R.id.JusMg);
        TextView jusAlpukats = (TextView) findViewById(R.id.JusAl);
        TextView nasiGoreng = (TextView) findViewById(R.id.NG);
        TextView batagor = (TextView) findViewById(R.id.B);
        TextView mieAyam = (TextView) findViewById(R.id.MA);
        TextView ayamGoreng = (TextView) findViewById(R.id.AG);
        TextView totals = (TextView) findViewById(R.id.textView);
        TextView lumpia = (TextView) findViewById(R.id.L);
        TextView kentangGoreng = (TextView) findViewById(R.id.KG);
        TextView onionRing = (TextView) findViewById(R.id.OR);
        TextView rotiBakar = (TextView) findViewById(R.id.RB);
        Button h1 =(Button) findViewById(R.id.h1);
        Button h2 =(Button) findViewById(R.id.h2);
        Button h3 =(Button) findViewById(R.id.h3);
        Button h4 =(Button) findViewById(R.id.h4);
        Button h5 =(Button) findViewById(R.id.h5);
        Button h6 =(Button) findViewById(R.id.h6);
        Button h7 =(Button) findViewById(R.id.h7);
        Button h8 =(Button) findViewById(R.id.h8);
        Button h9 =(Button) findViewById(R.id.h9);
        Button h10 =(Button) findViewById(R.id.h10);
        Button h11 =(Button) findViewById(R.id.h11);
        Button h12 =(Button) findViewById(R.id.h12);
        if (AMQuantity != null&&!AMQuantity.equals("0")) {
            total = total + Integer.parseInt(AMQuantity)*2500;
            airMinerals.setText("Air Mineral\n" + intent.getStringExtra("airMineral") + "x Rp. 2.500");
            airMinerals.setVisibility(View.VISIBLE);
            h1.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getAM(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(AMQuantity)<0)
            {
                stat=-1;
            }
        }
        if (JAPQuantity != null&&!JAPQuantity.equals("0")) {
            total = total + Integer.parseInt(JAPQuantity)*15000;
            jusApels.setText("Jus Apel\n" + intent.getStringExtra("jusApel") + "x Rp. 15.000");
            jusApels.setVisibility(View.VISIBLE);
            h2.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getJA(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(JAPQuantity)<0)
            {
                stat=-1;
            }
        }
        if (JMQuantity != null&&!JMQuantity.equals("0")) {
            total = total + Integer.parseInt(JMQuantity)*17000;
            jusManggas.setText("Jus Mangga\n" + intent.getStringExtra("jusMangga") + "x Rp. 17.000");
            jusManggas.setVisibility(View.VISIBLE);
            h4.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getJM(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(JMQuantity)<0)
            {
                stat=-1;
            }
        }
        if (JALQuantity != null&&!JALQuantity.equals("0")) {
            total = total + Integer.parseInt(JALQuantity)*20000;
            jusAlpukats.setText("Jus Alpukat\n" + intent.getStringExtra("jusAlpukat") + "x Rp. 20.000");
            jusAlpukats.setVisibility(View.VISIBLE);
            h3.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getJAL(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(JALQuantity)<0)
            {
                stat=-1;
            }
        }
        if (NGQuantity != null&&!NGQuantity.equals("0")) {
            total = total + Integer.parseInt(NGQuantity)*25000;
            nasiGoreng.setText("Nasi Goreng\n" + intent.getStringExtra("nasiGoreng") + "x Rp. 25.000");
            nasiGoreng.setVisibility(View.VISIBLE);
            h5.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getNG(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(NGQuantity)<0)
            {
                stat=-1;
            }
        }
        if (BQuantity != null&&!BQuantity.equals("0")) {
            total = total + Integer.parseInt(BQuantity)*15000;
            batagor.setText("Batagor\n" + intent.getStringExtra("batagor") + "x Rp. 15.000");
            batagor.setVisibility(View.VISIBLE);
            h6.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getB(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(BQuantity)<0)
            {
                stat=-1;
            }
        }
        if (MAQuantity != null&&!MAQuantity.equals("0")) {
            total = total + Integer.parseInt(MAQuantity)*20000;
            mieAyam.setText("Mie Ayam\n" + intent.getStringExtra("mieAyam") + "x Rp. 20.000");
            mieAyam.setVisibility(View.VISIBLE);
            h7.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getMA(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(MAQuantity)<0)
            {
                stat=-1;
            }
        }
        if (AGQuantity != null&&!AGQuantity.equals("0")) {
            total = total + Integer.parseInt(AGQuantity)*17000;
            ayamGoreng.setText("Ayam Goreng\n" + intent.getStringExtra("ayamGoreng") + "x Rp. 17.000");
            ayamGoreng.setVisibility(View.VISIBLE);
            h8.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getAG(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(AGQuantity)<0)
            {
                stat=-1;
            }
        }
        if (LQuantity != null&&!LQuantity.equals("0")) {
            total = total + Integer.parseInt(LQuantity)*2500;
            lumpia.setText("Lumpia\n" + intent.getStringExtra("lumpia") + "x Rp. 2.500");
            lumpia.setVisibility(View.VISIBLE);
            h9.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getL(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(LQuantity)<0)
            {
                stat=-1;
            }
        }
        if (KGQuantity != null&&!KGQuantity.equals("0")) {
            total = total + Integer.parseInt(KGQuantity)*15000;
            kentangGoreng.setText("Kentang Goreng\n" + intent.getStringExtra("kentangGoreng") + "x Rp. 15.000");
            kentangGoreng.setVisibility(View.VISIBLE);
            h10.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getKG(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(KGQuantity)<0)
            {
                stat=-1;
            }
        }
        if (ORQuantity != null&&!ORQuantity.equals("0")) {
            total = total + Integer.parseInt(ORQuantity)*20000;
            onionRing.setText("Onion Ring\n" + intent.getStringExtra("onionRing") + "x Rp. 20.000");
            onionRing.setVisibility(View.VISIBLE);
            h11.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getOR(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(ORQuantity)<0)
            {
                stat=-1;
            }
        }
        if (RBQuantity != null&&!RBQuantity.equals("0")) {
            total = total + Integer.parseInt(RBQuantity)*10000;
            rotiBakar.setText("Roti Bakar\n" + intent.getStringExtra("rotiBakar") + "x Rp. 10.000");
            rotiBakar.setVisibility(View.VISIBLE);
            h12.setVisibility(View.VISIBLE);
            Cursor resAM= myDB.getRB(Integer.parseInt(id));
            resAM.moveToNext();
            if(Integer.parseInt(resAM.getString(0))-Integer.parseInt(RBQuantity)<0)
            {
                stat=-1;
            }
        }
        totals.setText("Rp. " + total);
        kurang=Integer.parseInt(String.valueOf(b))-total;

    }

    public void onClickPayNow(View view)
    {
        if(kurang<0)
        {
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
        }
        else if(stat==-1)
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
            Toast.makeText(this, "Some food are unavailable", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, PayNow.class);
            Cursor res= myDB.getDataTopUp();
            StringBuilder b=new StringBuilder();
            while(res.moveToNext()) {
                b.append(res.getString(0));
            }
            boolean tf=myDB.tfsaldo("1", kurang);
            Toast.makeText(this, "Payment Success!", Toast.LENGTH_LONG).show();
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

    public void onClickDeleteAir(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", "0");
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

    public void onClickDeleteJusAp(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", "0");
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

    public void onClickDeleteJusMg(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", "0");
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
    public void onClickDeleteJusAl(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", "0");
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

    public void onClickDeleteNG(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", "0");
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

    public void onClickDeleteB(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", "0");
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
    public void onClickDeleteMA(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", "0");
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", LQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }
    public void onClickDeleteAG(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", "0");
        intent.putExtra("lumpia", LQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }
    public void onClickDeleteL(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", "0");
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }
    public void onClickDeleteKG(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", KGQuantity);
        intent.putExtra("kentangGoreng", "0");
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }
    public void onClickDeleteOR(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", KGQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", "0");
        intent.putExtra("rotiBakar", RBQuantity);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }
    public void onClickDeleteRB(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        intent.putExtra("airMineral", AMQuantity);
        intent.putExtra("jusApel", JAPQuantity);
        intent.putExtra("jusMangga", JMQuantity);
        intent.putExtra("jusAlpukat", JALQuantity);
        intent.putExtra("nasiGoreng", NGQuantity);
        intent.putExtra("batagor", BQuantity);
        intent.putExtra("mieAyam", MAQuantity);
        intent.putExtra("ayamGoreng", AGQuantity);
        intent.putExtra("lumpia", KGQuantity);
        intent.putExtra("kentangGoreng", KGQuantity);
        intent.putExtra("onionRing", ORQuantity);
        intent.putExtra("rotiBakar", "0");
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }

}
